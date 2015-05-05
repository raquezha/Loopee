package net.nueca.jn.loopee.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import net.nueca.jn.loopee.activities.R;
import net.nueca.jn.loopee.controllers.RequestManager;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LProductsAdapter extends RecyclerView.Adapter<LProductsAdapter.ProductViewHolder> {

    // Variables
    private List<Products> products;
    private int itemLayout;
    private Context context;
    private List<Session> sessions;

    // Constructor
    public LProductsAdapter(Context context, List<Products> products, int itemLayout,  List<Session> sessions) {
        this.context = context;
        this.products = products;
        this.itemLayout = itemLayout;
        this.sessions = sessions;
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
        holder.thumbnail.setImageResource(R.drawable.ic_picture);

        // Load image here

        Log.i("thumbnails_url", product.getThumbnail_url());

        ImageRequest request = new ImageRequest(product.getThumbnail_url(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                if (bitmap != null) {

                    Bitmap bMapScaled = Bitmap.createScaledBitmap(bitmap, 200, 150, true);
                    holder.thumbnail.setImageBitmap(bMapScaled);


                }
            }
        }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", session.getToken(), "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };
        RequestManager.getInstance().doRequest().addToRequestQueue(request);

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


        public ProductViewHolder(View itemView) {
            super(itemView);

            thumbnail = (ImageView) itemView.findViewById(R.id.lp_image_product);
            product_name = (TextView) itemView.findViewById(R.id.lp_text_product_name);
            product_cost = (TextView) itemView.findViewById(R.id.lp_text_product_cost);
            product_count = (TextView) itemView.findViewById(R.id.lp_text_product_count);
        }
    }
}