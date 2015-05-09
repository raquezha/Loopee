package net.nueca.jn.loopee.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import net.nueca.jn.loopee.activities.R;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;

import java.util.List;


public class LProductsAdapter extends RecyclerView.Adapter<LProductsAdapter.ProductViewHolder> {

    // Variables
    private List<Products> products;
    private int itemLayout;
    private Context context;
    private List<Session> sessions;
    ImageLoader imageLoader;

    private String imageUrl;

    // Constructor
    public LProductsAdapter(Context context, List<Products> products, int itemLayout, List<Session> sessions, ImageLoader imageLoader) {
        this.context = context;
        this.products = products;
        this.itemLayout = itemLayout;
        this.sessions = sessions;
        this.imageLoader = imageLoader;
    }

    public LProductsAdapter() {
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {

        final Session session = sessions.get(0);

        Products product = products.get(position);
        holder.product_name.setText(product.getName());
        holder.product_cost.setText("₱" + product.getRetail_price() + "");
        holder.product_count.setText(null);
        holder.thumbnail_products.setDefaultImageResId(R.drawable.ic_picture);
        //holder.thumbnail_products.setErrorImageResId(R.drawable.ic_picture);

        imageUrl = product.getThumbnail_url();

        if(imageUrl != null) {
            //imageLoader.
            holder.thumbnail_products.setImageUrl(product.getThumbnail_url(), imageLoader);
        }
        holder.itemView.setTag(product);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void add(Products product, int position) {
        products.add(position, product);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        products.remove(position);
        notifyItemRemoved(position);
    }

    public Products getItemAt(int position) {
        if (position < products.size())
            return products.get(position);
        return null;

    }


    // View Holder
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        public TextView product_name;
        public TextView product_cost;
        public TextView product_count;
        public NetworkImageView thumbnail_products;

        public ProductViewHolder(View itemView) {
            super(itemView);

            //thumbnail = (ImageView) itemView.findViewById(R.id.lp_image_product);
            thumbnail_products = (NetworkImageView) itemView.findViewById(R.id.lp_image_product);
            product_name = (TextView) itemView.findViewById(R.id.lp_text_product_name);
            product_cost = (TextView) itemView.findViewById(R.id.lp_text_product_cost);
            product_count = (TextView) itemView.findViewById(R.id.lp_text_product_count);
        }
    }
}