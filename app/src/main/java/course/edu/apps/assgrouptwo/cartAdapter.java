package course.edu.apps.assgrouptwo;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import models.Item;
import java.util.*;
import static models.Item.items;


public class cartAdapter
        extends RecyclerView.Adapter<cartAdapter.ViewHolder> {

    Item item = new Item();
    private String[] names;
    private int[] imageIds;
    private int[] prices;
    private boolean ordered;


    public cartAdapter(String[] names, int[] imageIds, int[] prices, boolean ordered){
        this.names = names;
        this.imageIds = imageIds;
        this.prices = prices;
        this.ordered= ordered;
        this.ordered=true;
    }


    @Override
    public cartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new cartAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;


        for(int i = 0; i< items.length ; i++){
            if(items[i].getImageID()==imageIds[position]){
                item = items[i];
            }
        }

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), item.getImageID());
        imageView.setImageDrawable(dr);
//        item.setImageID(item.getImageID());

        TextView txtName = (TextView)cardView.findViewById(R.id.txtName);
        txtName.setText( item.getName());
//        item.setName(names[position]);

        TextView txtPrice = (TextView)cardView.findViewById(R.id.txtPrice);
        txtPrice.setText("Price : "+prices[position] +" $");


        Item finalItem = item;
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }

    int totalPrice = 0;
    private int CalculateTotal(List<Item> items) {
        boolean y = item.isOrdered();
        if (y == true) {
            for (int i = 0; i < items.size(); i++) {
                totalPrice += items.get(i).getPrice();
            }
        }
        return totalPrice;
    }

    private double totalwithtax(Item item){
        double total =0;
        total = totalPrice * (14/100);
        return total;
    }

}
