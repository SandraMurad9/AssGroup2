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


import java.util.List;

import models.order;

public class CaptionedImagesAdapter2
        extends RecyclerView.Adapter<CaptionedImagesAdapter2.ViewHolder>  {

    private String[] names;
    private int[] imageIds;
    private int[] prices;
    String [] colors;
    private int[] sizes;
    private int[] quantities;
    private Context mContext;


    public CaptionedImagesAdapter2( Context mContext,String[] names, int[] imageIds,int[] prices, String[] colors, int[] quantities, int[] sizes) {
        this.names = names;
        this.imageIds = imageIds;
        this.prices = prices;
        this.colors = colors;
        this.quantities = quantities;
        this.sizes = sizes;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_card,
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

        TextView txtColor = (TextView)cardView.findViewById(R.id.txtColor);
        txtColor.setText("Color : "+colors[position] );

        TextView txtSize = (TextView)cardView.findViewById(R.id.txtSize);
        txtSize.setText("Size : "+sizes[position] );

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