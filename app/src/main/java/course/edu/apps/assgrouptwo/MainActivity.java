package course.edu.apps.assgrouptwo;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import static models.Item.items;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.sport_recycler);

        String[] names = new String[items.length];
        int[] ids = new int[items.length];
        int [] prices = new int [items.length];
        double [] ratings = new double [items.length];

        for(int i = 0; i<names.length;i++){
            names[i] = items[i].getName();
            ids[i] = items[i].getImageID();
            prices[i] = items[i].getPrice();
            ratings[i] = items[i].getRating();
        }
        recycler.setLayoutManager(new GridLayoutManager(this,2));
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(this,names, ids,prices,ratings);
        recycler.setAdapter(adapter);
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
                Intent intent = new Intent(this, MainActivity3.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}