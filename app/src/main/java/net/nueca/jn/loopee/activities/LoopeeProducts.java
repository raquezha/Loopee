package net.nueca.jn.loopee.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import net.nueca.jn.loopee.adapters.LProductsAdapter;
import net.nueca.jn.loopee.database.DatabaseManager;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;

import java.util.List;

public class LoopeeProducts extends ActionBarActivity {

    private RecyclerView pRecyclerView;
    private RecyclerView.LayoutManager pLayoutManager;
    private LProductsAdapter pAdapter;

    private String userTOKEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loopee_products);

        List<Session> sessions = DatabaseManager.getInstance().getAllSession();

        Intent intent = getIntent();
        userTOKEN = intent.getStringExtra("Token");

        pRecyclerView = (RecyclerView) findViewById(R.id.lp_recyclerview);
        pLayoutManager = new LinearLayoutManager(this);
        pAdapter = new LProductsAdapter(this, createMockList(), R.layout.loopee_item_product, sessions);

        pRecyclerView.setHasFixedSize(true);
        pRecyclerView.setItemAnimator(new DefaultItemAnimator());
        pRecyclerView.setLayoutManager(pLayoutManager);
        pRecyclerView.setAdapter(pAdapter);


        pRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, pRecyclerView,
            new ClickListener() {
            @Override
            public void onClick(View v, int position) {
                Products p = (Products) v.getTag();

                //Log.i("d", "position: " + position + "name: " + p.getName());
                startActivity(new Intent(v.getContext(),SelectProductDialog.class));
            }

            @Override
            public void onLongClick(View v, int position) {
            }
        }));
    }

    public static interface ClickListener{
        public void onClick(View v, int position);
        public void onLongClick(View v, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector detector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView pRecyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    //Log.d("JN", "onSingleTap" + e);
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {

                    View child = pRecyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, pRecyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && detector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }
    }

    private List<Products> createMockList() {


        return DatabaseManager.getInstance().getAllProducts();
    }
}
