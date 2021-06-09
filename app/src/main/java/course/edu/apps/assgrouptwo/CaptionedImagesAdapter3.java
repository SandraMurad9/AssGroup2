package course.edu.apps.assgrouptwo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import models.order;


public class CaptionedImagesAdapter3
        extends RecyclerView.Adapter<CaptionedImagesAdapter3.ViewHolder>  {

    private String[] names;
    private int[] imageIds;
    private int[] prices;
    private int[] quantities;



    public CaptionedImagesAdapter3( String[] names, int[] imageIds,int[] prices,  int[] quantities) {
        this.names = names;
        this.imageIds = imageIds;
        this.prices = prices;

        this.quantities = quantities;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.summary,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        order order = new order ();

        for(int i = 0; i< order.getOrders().size() ; i++){
            if(order.getOrders().get(i).getItem().getImageID()==imageIds[position]){
                order = order.getOrders().get(i);
            }
        }

        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), order.getItem().getImageID());
        imageView.setImageDrawable(dr);

        TextView txtName = (TextView)cardView.findViewById(R.id.txtName);
        txtName.setText( order.getItem().getName());

        TextView txtPrice = (TextView)cardView.findViewById(R.id.txtPrice);
        txtPrice.setText( "Price : "+order.getItem().getPrice());


        TextView txtQuantity = (TextView)cardView.findViewById(R.id.txtQuantity);
        txtQuantity.setText("Quantity : "+quantities[position] );
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