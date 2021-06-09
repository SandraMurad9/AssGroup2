package course.edu.apps.assgrouptwo;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import models.Item;

import static models.Item.items;


public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>  {

    private String[] names;
    private int[] imageIds;
    private int[] prices;
    private double[] ratings;
    private Context mContext;

    public CaptionedImagesAdapter(Context context , String[] names, int[] imageIds, int[] prices, double[] ratings){
        this.names = names;
        this.imageIds = imageIds;
        this.prices = prices;
        this.ratings = ratings;
        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        Item item = new Item();

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

        TextView txtRating = (TextView)cardView.findViewById(R.id.txtRating);
        txtRating.setText("Rating : "+ratings[position] +" /5.0");
//        item.setPrice(prices[position]);
//
//        TextView manufacturingCountry = (TextView)cardView.findViewById(R.id.manufacturingCountry);
//        manufacturingCountry.setText(""+captions[position]);
//        item.setManufacturingCountry(captions[position]);
//
//        TextView quantity = (TextView)cardView.findViewById(R.id.quantity);
//        quantity.setText(""+captions[position]);
//        item.setQuantity(Integer.parseInt(captions[position]));


        Item finalItem = item;
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mContext,MainActivity2.class);
                intent.putExtra("DATA", finalItem);
                mContext.startActivity(intent);

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
}