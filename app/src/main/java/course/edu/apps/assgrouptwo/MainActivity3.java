package course.edu.apps.assgrouptwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import java.util.List;

import models.order;


public class MainActivity3 extends AppCompatActivity {

    order order = new order ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        System.out.println(order.getOrders());

        RecyclerView recycler = findViewById(R.id.shoppingcart_recycler);

        String[] names = new String[order.getOrders().size()];
        int[] ids = new int[order.getOrders().size()];
        int[] prices = new int[order.getOrders().size()];
        String [] colors = new String [order.getOrders().size()];
        int [] sizes = new int [order.getOrders().size()];
        int [] quantities = new int [order.getOrders().size()];

        for(int i = 0; i<names.length;i++){
            names[i] = order.getOrders().get(i).getItem().getName();
            ids[i] = order.getOrders().get(i).getItem().getImageID();
            prices[i] = order.getOrders().get(i).getItem().getPrice();
            colors [i] = order.getOrders().get(i).getChosenColor();
            sizes[i] = order.getOrders().get(i).getChosenSize();
            quantities[i]=order.getOrders().get(i).getChosenQuantity();

        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        CaptionedImagesAdapter2 adapter = new CaptionedImagesAdapter2(this,names, ids,prices,colors,quantities,sizes);
        recycler.setAdapter(adapter);


    }


    public void check_OnClick(View view) {


        String[] names = new String[order.getOrders().size()];
        int[] prices = new int[order.getOrders().size()];
        int [] quantities = new int [order.getOrders().size()];

        for(int i = 0; i<names.length;i++){
            names[i] = order.getOrders().get(i).getItem().getName();
            prices[i] = order.getOrders().get(i).getItem().getPrice();
            quantities[i]=order.getOrders().get(i).getChosenQuantity();
            order.CalculateTotal();
            order.tax();
            order.totalwithtax();
        }
        double total = order.CalculateTotal();
        double Tax = order.tax();
        double TotalWithTax = order.totalwithtax();

        System.out.println("order " + order.getOrders().toString());


        Intent intent = new Intent(this,MainActivity4.class);


        intent.putExtra("Total", total);
        intent.putExtra("Tax", Tax);
        intent.putExtra("TotalWithTax", TotalWithTax);
        intent.putExtra("DATA2",order.getOrders().toString());

            startActivity(intent);
            InputMethodManager mgr =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(view.getWindowToken(),0);

    }


    public void backOnClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mainpage_menu,menu);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.items:
//                Intent intent = new Intent(this,MainActivity.class);
////                intent.putExtra("DATA2", orders);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return true;
    }
}