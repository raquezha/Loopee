package net.nueca.jn.loopee.controllers;


import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;

import com.android.volley.AuthFailureError;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import net.nueca.jn.loopee.database.DatabaseManager;
import net.nueca.jn.loopee.helpers.DiskLruImageCache;
import net.nueca.jn.loopee.models.Session;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestProxy {

    /**
     * Log or request TAG
     */
    public static final String TAG = "VolleyPatterns";

    /**
     * Global request queue for Volley
     */
    private RequestQueue mRequestQueue;


    /**
     * A ImageLoader
     */
    private ImageLoader mImageLoader;

    private static String token;

    // Default maximum disk usage in bytes
    private static final int DEFAULT_DISK_USAGE_BYTES = 25 * 1024 * 1024;

    // Default cache folder name
    private static final String DEFAULT_CACHE_DIR = "photos";

    private static int DISK_IMAGECACHE_SIZE = 1024 * 1024 * 10;

    private static Bitmap.CompressFormat DISK_IMAGECACHE_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;

    private static int DISK_IMAGECACHE_QUALITY = 100;

    private static Context context;

    private DiskLruImageCache diskLruImageCache;

    // package access constructor
    RequestProxy(Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());
        this.context = context.getApplicationContext();
    }

    public void clearCache(){
        diskLruImageCache.clearCache();
    }


    // Most code copied from "Volley.newRequestQueue(..)", we only changed cache directory
    public static RequestQueue newRequestQueue() {
        // define cache folder
        File rootCache = context.getExternalCacheDir();

        if (rootCache == null) {
            rootCache = context.getCacheDir();
        }

        File cacheDir = new File(rootCache, DEFAULT_CACHE_DIR);
        cacheDir.mkdirs();

        HttpStack stack = new HurlStack();
        Network network = new BasicNetwork(stack);
        DiskBasedCache diskBasedCache = new DiskBasedCache(cacheDir, DEFAULT_DISK_USAGE_BYTES);
        RequestQueue queue = new RequestQueue(diskBasedCache, network);
        queue.start();

        return queue;
    }

    public ImageLoader getImageLoader() {


        List<Session> sessionsList = DatabaseManager.getInstance().getAllSession();

        Session session = sessionsList.get(0);

        token = session.getToken();

        if (mImageLoader == null) {

            diskLruImageCache =  new DiskLruImageCache(context, context.getPackageCodePath(),
                    DISK_IMAGECACHE_SIZE, DISK_IMAGECACHE_COMPRESS_FORMAT,
                    DISK_IMAGECACHE_QUALITY);


            mImageLoader = new ImageLoader(newRequestQueue(),
                   diskLruImageCache){
                @Override
                protected Request makeImageRequest(String url, int maxwidth, int maxheight, final String cachekey) {

                    return new ImageRequest(url, new Response.Listener<Bitmap>() {

                        @Override
                        public void onResponse(Bitmap bitmap) {
                            if(bitmap != null ) {

                                Bitmap bMapScaled = Bitmap.createScaledBitmap(bitmap, 200, 150, true);

                                onGetImageSuccess(cachekey, bMapScaled);
                            }
                        }
                    }, 0, 0, null,
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError volleyError) {
                                    onGetImageError(cachekey, volleyError);
                                }
                            }) {
                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> headers = new HashMap<>();

                            String creds = String.format("%s:%s", token, "x");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            headers.put("Authorization", auth);

                            return headers;
                        }
                    };
                }
            };
        }
        return mImageLoader;
    }

    public RequestQueue getRequestQueue(){
        return this.mRequestQueue;
    }

    /**
     * Adds the specified request to the global queue, if tag is specified
     * then it is used else Default TAG is used.
     *
     * @param req
     * @param tag
     */

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        mRequestQueue.add(req);
    }


    /**
     * Adds the specified request to the global queue using the Default TAG.
     *
     * @param req
     */
    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        req.setTag(TAG);

        mRequestQueue.add(req);
    }


    /**
     * Cancels all pending requests by the specified TAG, it is important
     * to specify a TAG so that the pending/ongoing requests can be cancelled.
     *
     * @param tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public void login() {

    }


    public void weather() {
        // weather request
    }
}