package course.edu.apps.assgrouptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Collections;

import models.order;


public class MainActivity4 extends AppCompatActivity {
    ArrayAdapter<String> itemsAdapter;


    ListView result;
    TextView total;
    TextView taxtotal;
    TextView tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        total = findViewById(R.id.total);
        tax = findViewById(R.id.tax);
        taxtotal = findViewById(R.id.taxtotal);
        result = findViewById(R.id.result);

        result.setAdapter(null);
        itemsAdapter = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1,
                Collections.singletonList(order.getOrders().toString()));
        result.setAdapter(itemsAdapter);


        NumberFormat nm = NumberFormat.getNumberInstance();
        Intent intent= getIntent();
        Double Total = intent.getDoubleExtra("Total", 0);
        total.setText(nm.format(Total));

        Double Tax = intent.getDoubleExtra("Tax", 0);
        tax.setText(nm.format(Tax));

        Double TaxTotal = intent.getDoubleExtra("TotalWithTax", 0);
        taxtotal.setText(nm.format (TaxTotal));









    }


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