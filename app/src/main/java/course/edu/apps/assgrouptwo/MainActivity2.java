package course.edu.apps.assgrouptwo;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import models.Item;
import models.order;


public class MainActivity2 extends AppCompatActivity {

    Item item = new Item();
    Spinner availableColorsSpinner;
    Spinner availableSizesSpinner;
    NumberPicker quantityPicker ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra("DATA");

        TextView txtName = findViewById(R.id.txtName);
        txtName.setText(item.getName());

        ImageView image = findViewById(R.id.image);
        Drawable res = getResources().getDrawable(item.getImageID());
        image.setImageDrawable(res);

        TextView txtPrice = findViewById(R.id.txtPrice);
        txtPrice.setText(txtPrice.getText() + "" + item.getPrice() + " $");

        TextView manufacturingCountry = findViewById(R.id.manufacturingCountry);
        manufacturingCountry.setText(manufacturingCountry.getText() + "" + item.getManufacturingCountry());

        TextView quantity = findViewById(R.id.availableQuantity);
        quantity.setText("" + item.getAvailableQuantity() + " Pieces Available");


        populateAvailableColorsSpinner();
        populateAvailableSizesSpinner();

        quantityPicker = (NumberPicker)findViewById(R.id.quantityPicker);
        quantityPicker.setMinValue(1);

        quantityPicker.setMaxValue(item.getAvailableQuantity());

        quantityPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                System.out.println(newVal);
                System.out.println(item.getAvailableQuantity()-newVal);

            }
        });


    }

    private void populateAvailableColorsSpinner() {
        availableColorsSpinner = findViewById(R.id.availableColors);
        ArrayList<String> availableColors = new ArrayList<>();
        availableColors.add("Available Colors");
        for (int i = 0; i < item.getAvailableColors().length; i++) {
            availableColors.add(item.getAvailableColors()[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, availableColors);
        availableColorsSpinner.setAdapter(adapter);
    }

    private void populateAvailableSizesSpinner() {
        availableSizesSpinner = findViewById(R.id.availableSizes);

        ArrayList<String> availableSizes = new ArrayList<>();
        availableSizes.add("Available Sizes");
        for (int i = 0; i < item.getAvailableSizes().length; i++) {
            availableSizes.add("" + item.getAvailableSizes()[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, availableSizes);
        availableSizesSpinner.setAdapter(adapter);
    }

    public void backOnClick(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void addOnClick(View view) {
        String selectedColor = availableColorsSpinner.getSelectedItem().toString();
        String selectedSize = availableSizesSpinner.getSelectedItem().toString();
        int size = Integer.parseInt(selectedSize);
        int quantity = quantityPicker.getValue();

        System.out.println(selectedColor);
        System.out.println(size);
        System.out.println(quantity);

        order.orders.add(new order(item,selectedColor,size,quantity));

        Intent intent = new Intent(this,MainActivity3.class);
        intent.putExtra("DATA2", new order (item,selectedColor,size,quantity));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.shopping_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.items:
                Intent intent = new Intent(this,MainActivity3.class);
//                intent.putExtra("DATA2", orders);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}