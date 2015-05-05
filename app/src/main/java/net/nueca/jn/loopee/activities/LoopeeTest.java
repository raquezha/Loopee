package net.nueca.jn.loopee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.github.leonardoxh.customfont.FontUtils;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import net.nueca.jn.loopee.database.DatabaseHelper;
import net.nueca.jn.loopee.database.DatabaseManager;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoopeeTest extends ActionBarActivity implements View.OnClickListener {

    private static final String URL_API = "http://www.imonggo.com/system/api_url?account_id=";

    private String userURL;
    private String userTOKEN;
    private String userURL2;
    private String productCount;
    private String branchesCount;
    private String customerCount;

    private TextView text_account_id, text_email, text_password, text_url, text_token, text_branches_count;
    private Button get_url, get_token, go_to_products, get_products, get_settings, get_branches,
                   get_tax, get_user, get_customers, unlink_device;



    private ArrayList<Products> ListProducts = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseManager.init(this);

        setContentView(R.layout.loopee_test);

        text_account_id = (TextView) findViewById(R.id.loopee_account_id);
        text_email = (TextView) findViewById(R.id.loopee_email);
        text_password = (TextView) findViewById(R.id.loopee_password);
        text_url = (TextView) findViewById(R.id.url);
        text_token = (TextView) findViewById(R.id.token);
        text_branches_count = (TextView) findViewById(R.id.branches_count);

        text_account_id.setText("carolflower");
        text_email.setText("carol@me.com");
        text_password.setText("carolflower");

        FontUtils.applyFont(this, text_account_id, "Caviar");
        FontUtils.applyFont(this, text_email, "Roboto");
        FontUtils.applyFont(this, text_password, "RobotoCondensed");


        get_url = (Button) findViewById(R.id.loopee_button_get_url);
        get_token = (Button) findViewById(R.id.loopee_button_get_token);
        go_to_products = (Button) findViewById(R.id.loopee_button_products);
        get_products = (Button) findViewById(R.id.loopee_button_get_products);
        get_settings = (Button) findViewById(R.id.loopee_button_get_settings);
        get_branches = (Button) findViewById(R.id.loopee_button_get_branches);
        get_tax = (Button) findViewById(R.id.loopee_button_get_tax_settings);
        get_user = (Button) findViewById(R.id.loopee_button_get_users);
        get_customers = (Button) findViewById(R.id.loopee_button_get_customers);

        unlink_device = (Button) findViewById(R.id.loopee_button_unlink_device);

        get_products.setVisibility(View.INVISIBLE);
        //go_to_products.setVisibility(View.INVISIBLE);
        get_token.setVisibility(View.INVISIBLE);
        get_settings.setVisibility(View.INVISIBLE);
        get_branches.setVisibility(View.INVISIBLE);
        get_tax.setVisibility(View.INVISIBLE);
        get_user.setVisibility(View.INVISIBLE);
        get_customers.setVisibility(View.INVISIBLE);


        get_products.setOnClickListener(this);
        go_to_products.setOnClickListener(this);
        get_url.setOnClickListener(this);
        get_token.setOnClickListener(this);
        get_settings.setOnClickListener(this);
        get_branches.setOnClickListener(this);
        get_tax.setOnClickListener(this);
        get_user.setOnClickListener(this);
        get_customers.setOnClickListener(this);
        unlink_device.setOnClickListener(this);
        // doTestProducts();



    }

    private void doTestProducts() {
        DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<Products, Integer> productsDAO = dbHelper.getProductRuntimeExcemptionDao();

        List<Products> products1 = productsDAO.queryForEq("id", 1);

        Log.i("request", products1.toString());

        OpenHelperManager.releaseHelper();
    }

    private void getURL(final String URLs) {
        StringRequest req = new StringRequest(URLs, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                VolleyLog.v("Response:%n %s", response);
                Log.i("request", response);

                userURL = response;
                userURL2 = userURL.replace("https://", "");
                text_url.setText(userURL);

                get_token.setVisibility(View.VISIBLE);

                Toast.makeText(getBaseContext(), "Success! \n" + "URL: " + userURL, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Log.i("request", error.toString());

                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }


    private void getToken(final String URLs) {
        JsonObjectRequest req = new JsonObjectRequest(URLs, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            VolleyLog.v("Response:%n %s", response.toString(4));
                            userTOKEN = response.get("api_token").toString();
                            text_token.setText(userTOKEN);
                            get_settings.setVisibility(View.VISIBLE);

                            Toast.makeText(getBaseContext(), "Success! \n" + "Token: " + userTOKEN, Toast.LENGTH_SHORT).show();

                            Log.i("request", response.toString());
                        } catch (JSONException e) {
                            Log.i("request", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());

                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getProductCount(String productCountURL) {
        JsonObjectRequest req = new JsonObjectRequest(productCountURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                            productCount = response.get("count").toString();

                            Double pCount = Double.parseDouble(productCount);

                            int page = (int) Math.ceil(pCount / 50);

                            Toast.makeText(getBaseContext(), "Success! \n" + "Product Count: " + String.valueOf(productCount) + ", Page: " + String.valueOf(page), Toast.LENGTH_SHORT).show();

                            String urlStart = "https://" + userTOKEN + ":x@" + userURL2 + "/api/products.json?after=&page=";
                            String urlEnd = "&active_only=1";

                            for (int i = 1; i <= page; i++) {
                                getProducts(urlStart + i + urlEnd);
                            }



                        } catch (JSONException e) {
                            Log.i("request", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };


        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getProducts(String URLs) {
        JsonArrayRequest req = new JsonArrayRequest(URLs, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    VolleyLog.v("Response:%n %s", jsonArray.toString(4));
                    Log.i("productsCOUNT", productCount);

                    for (int i = 0; i < Integer.parseInt(productCount); i++) {
                        // loop through the Array of  products
                        JSONObject productList = jsonArray.getJSONObject(i);

/*
                        Log.i("loopee_products" + i, "--------------start of item "+i+"--------------");

                        Log.i("loopee_products" + i, "id:                        " + productList.getString("id"));
                        Log.i("loopee_products" + i, "name:                      " + productList.getString("name"));
                        Log.i("loopee_products" + i, "stock no:                  " + productList.getString("stock_no"));
                        Log.i("loopee_products" + i, "cost:                      " + productList.getString("cost"));
                        Log.i("loopee_products" + i, "retail price:              " + productList.getString("retail_price"));
                        Log.i("loopee_products" + i, "description:               " + productList.getString("description"));
                        Log.i("loopee_products" + i, "allow decimal quantities:  " + productList.getString("allow_decimal_quantities"));
                        Log.i("loopee_products" + i, "disable discount:          " + productList.getString("disable_discount"));
                        Log.i("loopee_products" + i, "disable inventory:         " + productList.getString("disable_inventory"));
                        Log.i("loopee_products" + i, "enable open price:         " + productList.getString("enable_open_price"));
                        Log.i("loopee_products" + i, "tax exempt:                " + productList.getString("tax_exempt"));
                        Log.i("loopee_products" + i, "tag list:                  " + productList.getString("tag_list"));
                        Log.i("loopee_products" + i, "barcode list:              " + productList.getString("barcode_list"));
                        Log.i("loopee_products" + i, "thumbnail url:             " + productList.getString("thumbnail_url"));
*/

                        Log.i("loopee_products" + i, "thumbnail url:             " + productList.getString("thumbnail_url"));
                        String thumbnail = productList.getString("thumbnail_url");


                        String[] separated = thumbnail.split("/");
                        String thumbnal_url = separated[3];


                        String image_products_url ="https://"+userTOKEN+":x@" + userURL2 + "/api/products/" + thumbnal_url + " .jpg?size=large";

                        //Get the image

/*
                        ImageRequest request = new ImageRequest(image_products_url, new Response.Listener<Bitmap>() {
                            public Bitmap bitmapImage;

                            @Override
                            public void onResponse(Bitmap bitmap) {
                                if (bitmap != null) {
                                    this.bitmapImage = bitmapImage;
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

                                String creds = String.format("%s:%s", userTOKEN , "x");
                                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                                headers.put("Authorization", auth);

                                return headers;
                            }
                        };
                        LoopeeController.getInstance().addToRequestQueue(request);*/


                        // Get the JSONArray Tax Rates from Product JSONObject
                        JSONArray taxRateArray = productList.getJSONArray("tax_rates");

                        // put products to list
                        Products products = new Products(
                                productList.getInt("id"),
                                productList.getString("name"),
                                productList.getString("stock_no"),
                                productList.getDouble("cost"),
                                productList.getDouble("retail_price"),

                                0, // wholesale price

                                productList.getString("description"),
                                productList.getBoolean("allow_decimal_quantities"),
                                productList.getBoolean("disable_discount"),
                                productList.getBoolean("disable_inventory"),
                                productList.getBoolean("enable_open_price"),
                                productList.getBoolean("tax_exempt"),
                                productList.getString("tag_list"),
                                productList.getString("barcode_list"),
                                image_products_url,

                                "", // branch rates


                                productList.getString("utc_created_at"),
                                productList.getString("utc_updated_at"),
                                productList.getString("status")
                                );

                        // Add products to ArrayList
                        ListProducts.add(products);

                        DatabaseManager.getInstance().addProduct(products);

                        // if the Array has content
                        if (taxRateArray.length() != 0) {
                            for (int x = 0; x < taxRateArray.length(); x++) {

                                // Get the JSONObject tax
                                JSONObject taxRateList = taxRateArray.getJSONObject(x);

                                // To get the data use taxRateList. get ***
                                Log.i("loopee_tax_rate" + i, "--------------start of taxrates " + i + "------------");
                                Log.i("loopee_tax_rate" + i, "id:                        " + taxRateList.getString("id"));
                                Log.i("loopee_tax_rate" + i, "id:                        " + taxRateList.getString("branch_id"));
                                Log.i("loopee_tax_rate" + i, "id:                        " + taxRateList.getString("utc_created_at"));
                                Log.i("loopee_tax_rate" + i, "id:                        " + taxRateList.getString("utc_updated_at"));
                                Log.i("loopee_tax_rate" + i, "--------------end of taxrates " + i + "--------------");
                                Log.i("loopee_tax_rate" + i, " ");
                            }
                        }

                        // BRANCH PRICES
                        JSONArray branchPriceArray = productList.getJSONArray("branch_prices");

                        if (branchPriceArray.length() != 0) {
                            for (int x = 0; x < branchPriceArray.length(); x++) {

                                JSONObject branchPriceList = branchPriceArray.getJSONObject(x);
                                Log.i("loopee_branchprice" + i, "--------------start of branch prices " + i + "------------");
                                Log.i("loopee_branchprice" + i, "branch_id:                 " + branchPriceList.getString("branch_id"));
                                Log.i("loopee_branchprice" + i, "retail_price               " + branchPriceList.getString("retail_price"));
                                Log.i("loopee_branchprice" + i, "utc_created_at:            " + branchPriceList.getString("utc_created_at"));
                                Log.i("loopee_branchprice" + i, "utc_updated_at:            " + branchPriceList.getString("utc_updated_at"));
                                Log.i("loopee_branchprice" + i, "--------------end of item " + i + "--------------");
                            }
                        }

                        Log.i("loopee_products" + i, "utc created at:            "+ productList.getString("utc_created_at"));
                        Log.i("loopee_products" + i, "utc updated at:            "+ productList.getString("utc_updated_at"));
                        Log.i("loopee_products" + i, "status:                    "+ productList.getString("status"));


                        Log.i("loopee_products" + i, "--------------end of item "+i+"--------------");

                        /*
                        DatabaseManager.getInstance().addProduct(new Products(
                                p.getInt("id"),
                                p.getString("name"),
                                p.getString("stock_no"),
                                p.getDouble("cost"),
                                p.getDouble("retail_price"),
                                p.getString("description"),
                                p.getBoolean("allow_decimal_quantities"),
                                p.getBoolean("disable_discount"),
                                p.getBoolean("disable_inventory"),
                                p.getBoolean("enable_open_price"),
                                p.getBoolean("tax_excempt"),
                                p.getString("tag_list"),
                                p.getString("barcode_list"),
                                p.getString("thumbnail_url"),
                                p.getString("branch_prices"),
                                p.getString("status")
                                ));
                        */
                    }
                    get_customers.setVisibility(View.VISIBLE);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getSettings(String url) {
        JsonArrayRequest settingsRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        try {
                            if (jsonArray.length() != 0) {
                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject settingsList = jsonArray.getJSONObject(i);

                                    Log.i("settings" + i, "--------------------------");
                                    Log.i("settings" + i, settingsList.toString());
                                }
                            }
                            get_branches.setVisibility(View.VISIBLE);

                            Toast.makeText(getBaseContext(), "Successfully get the Settings", Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Response: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };
        LoopeeController.getInstance().addToRequestQueue(settingsRequest);
    }

    private void getBranchesCount(String branchesCountURL) {
        JsonObjectRequest req = new JsonObjectRequest(branchesCountURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                            branchesCount = response.get("count").toString();
                            text_branches_count.setText(branchesCount);

                            Double bCount = Double.parseDouble(branchesCount);

                            int page = (int) Math.ceil(bCount / 50);

                            Toast.makeText(getBaseContext(), "Success! \n" + "Branches Count: " + String.valueOf(branchesCount) + ", Page: " + String.valueOf(page), Toast.LENGTH_LONG).show();

                            String urlStart = "https://" + userTOKEN + ":x@" + userURL2 + "/api/branches.json?after=&page=";

                            for (int i = 1; i <= page; i++) {
                                getBranches(urlStart + i);
                            }
                        } catch (JSONException e) {
                            Log.i("request", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };


        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getBranches(String branchesURL) {

        JsonArrayRequest req = new JsonArrayRequest(branchesURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try {
                    VolleyLog.v("Response:%n %s", jsonArray.toString(4));
                    Log.i("branches", jsonArray.toString());

                    Toast.makeText(getBaseContext(), "Successfully retrieve branches.", Toast.LENGTH_SHORT).show();
                    get_tax.setVisibility(View.VISIBLE);

                    for (int i = 0; i < Integer.parseInt(branchesCount); i++) {

                        // loop through the Array of  products
                        JSONObject branchList = jsonArray.getJSONObject(i);

                        if (branchList.length() != 0) {
                            Log.i("loopee_branches" + i, "--------------end of item " + i + "--------------");
                            Log.i("loopee_branches" + i, "id:                        " + branchList.getString("id"));
                            Log.i("loopee_branches" + i, "name:                      " + branchList.getString("name"));
                            Log.i("loopee_branches" + i, "street:                    " + branchList.getString("street"));
                            Log.i("loopee_branches" + i, "city:                      " + branchList.getString("city"));
                            Log.i("loopee_branches" + i, "state:                     " + branchList.getString("state"));
                            Log.i("loopee_branches" + i, "country:                   " + branchList.getString("country"));
                            Log.i("loopee_branches" + i, "zipcode:                   " + branchList.getString("zipcode"));
                            Log.i("loopee_branches" + i, "tin:                       " + branchList.getString("tin"));
                            Log.i("loopee_branches" + i, "site_type        :         " + branchList.getString("site_type"));
                            Log.i("loopee_branches" + i, "subscription_type:         " + branchList.getString("subscription_type"));
                            Log.i("loopee_branches" + i, "utc created at:            " + branchList.getString("utc_created_at"));
                            Log.i("loopee_branches" + i, "utc updated at:            " + branchList.getString("utc_updated_at"));
                            Log.i("loopee_branches" + i, "status:                    " + branchList.getString("status"));
                            Log.i("loopee_branches" + i, "--------------end of item " + i + "--------------");




                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getTaxSettings(String taxSettingsURL) {


        JsonObjectRequest taxRateRequest = new JsonObjectRequest(taxSettingsURL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject taxSettingsObject) {
                        Toast.makeText(getBaseContext(), "Successfully retrieve Tax Settings.", Toast.LENGTH_SHORT).show();
                        try {
                            Log.i("taxSettings", taxSettingsObject.toString());

                                Log.i("tax_settings", "------------start------------");
                                Log.i("tax_settings", "tax_inclusive: " + taxSettingsObject.getString("tax_inclusive"));
                                Log.i("tax_settings", "compute_tax:   " + taxSettingsObject.getString("compute_tax"));

                                // Get the JSONArray Tax Rates from Product JSONObject
                                JSONArray taxRateArray = taxSettingsObject.getJSONArray("tax_rates");

                                // if the Array has content
                                if (taxRateArray.length() != 0) {
                                    for (int x = 0; x < taxRateArray.length(); x++) {
                                        JSONObject taxRate = taxRateArray.getJSONObject(x);

                                        Log.i("tax_rates", "------------TAX RATES------------");
                                        Log.i("tax_rates", "branch_id:     " + taxRate.getString("branch_id"));
                                        Log.i("tax_rates", "value:         " + taxRate.getString("value"));
                                        Log.i("tax_rates", "name:          " + taxRate.getString("name"));
                                        Log.i("tax_rates", "status:        " + taxRate.getString("status"));
                                        Log.i("tax_rates", "id:            " + taxRate.getString("id"));
                                        Log.i("tax_rates", "tax rate type: " + taxRate.getString("tax_rate_type"));
                                        Log.i("tax_rates", "------------TAX RATES------------");
                                    }
                                }

                                Log.i("tax_settings", "-------------end-------------");

                                get_user.setVisibility(View.VISIBLE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Log.i("error", error.getMessage());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(taxRateRequest);
    }

    private void getUsers(String userURL){
        JsonArrayRequest req = new JsonArrayRequest(userURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray userJsonArray) {
                try {
                    Toast.makeText(getBaseContext(), "Success!, " +  "User Count: " + userJsonArray.length(), Toast.LENGTH_SHORT).show();

                    VolleyLog.v("Response:%n %s", userJsonArray.toString(4));
                    get_products.setVisibility(View.VISIBLE);
                    for (int i = 0; i < userJsonArray.length(); i++) {

                        // loop through the Array of  products
                        JSONObject userList = userJsonArray.getJSONObject(i);

                        if (userList.length() != 0) {
                            Log.i("loopee_users" + i, "---------start of item " + i + "---------");
                            Log.i("loopee_users" + i, "id:             " + userList.getString("id"));
                            Log.i("loopee_users" + i, "name:           " + userList.getString("name"));
                            Log.i("loopee_users" + i, "home_branch_id: " + userList.getString("home_branch_id"));
                            Log.i("loopee_users" + i, "email:          " + userList.getString("email"));
                            Log.i("loopee_users" + i, "role_code:      " + userList.getString("role_code"));
                            Log.i("loopee_users" + i, "utc created at: " + userList.getString("utc_created_at"));
                            Log.i("loopee_users" + i, "utc updated at: " + userList.getString("utc_updated_at"));
                            Log.i("loopee_users" + i, "status:         " + userList.getString("status"));
                            Log.i("loopee_users" + i, "---------end of item " + i + "---------");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getCustomersCount(String customercountURL) {
        JsonObjectRequest req = new JsonObjectRequest(customercountURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                            customerCount = response.get("count").toString();

                            Double pCount = Double.parseDouble(productCount);

                            int page = (int) Math.ceil(pCount / 50);

                            Toast.makeText(getBaseContext(), "Success! \n" + "Product Count: " + String.valueOf(customerCount) + ", Page: " + String.valueOf(page), Toast.LENGTH_SHORT).show();

                            String urlStart = "https://" + userTOKEN + ":x@" + userURL2 + "/api/customers.json?after=&page=";
                            String urlEnd = "&active_only=1";

                            for (int i = 1; i <= page; i++) {
                                getCustomers(urlStart + i + urlEnd);
                            }

                            //Toast.makeText(getBaseContext(), productCount,Toast.LENGTH_SHORT).show();

                        } catch (JSONException e) {
                            Log.i("request", e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Log.i("Error: ", error.getMessage());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };


        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    private void getCustomers(String customersURL){
        JsonArrayRequest req = new JsonArrayRequest(customersURL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray jsonArray) {
                //Log.i("request", jsonArray.toString());
                try {
                    VolleyLog.v("Response:%n %s", jsonArray.toString(4));


                    Log.i("productsCOUNT", productCount);

                    Toast.makeText(getBaseContext(), "Succesfully retrieve customer datas.", Toast.LENGTH_SHORT).show();

                    for (int i = 0; i < Integer.parseInt(productCount); i++) {

                        // loop through the Array of  products
                        JSONObject productList = jsonArray.getJSONObject(i);

                        Log.i("loopee_customers" + i, "--------------start of item "+i+"--------------");

                        Log.i("loopee_customers" + i, "id:                        " + productList.getString("id"));
                        Log.i("loopee_customers" + i, "code:                      " + productList.getString("code"));
                        Log.i("loopee_customers" + i, "alternate_code:            " + productList.getString("alternate_code"));
                        Log.i("loopee_customers" + i, "first_name:                " + productList.getString("first_name"));
                        Log.i("loopee_customers" + i, "last_name:                 " + productList.getString("last_name"));
                        Log.i("loopee_customers" + i, "name:                      " + productList.getString("name"));
                        Log.i("loopee_customers" + i, "company_name:              " + productList.getString("company_name"));
                        Log.i("loopee_customers" + i, "tin:                       " + productList.getString("tin"));
                        Log.i("loopee_customers" + i, "tax_exempt:                " + productList.getString("tax_exempt"));
                        Log.i("loopee_customers" + i, "street:                    " + productList.getString("street"));
                        Log.i("loopee_customers" + i, "city:                      " + productList.getString("city"));
                        Log.i("loopee_customers" + i, "state:                     " + productList.getString("state"));
                        Log.i("loopee_customers" + i, "zipcode:                   " + productList.getString("zipcode"));
                        Log.i("loopee_customers" + i, "country:                   " + productList.getString("country"));
                        Log.i("loopee_customers" + i, "telephone:                 " + productList.getString("telephone"));
                        Log.i("loopee_customers" + i, "fax:                       " + productList.getString("fax"));
                        Log.i("loopee_customers" + i, "mobile:                    " + productList.getString("mobile"));
                        Log.i("loopee_customers" + i, "email:                     " + productList.getString("email"));
                        Log.i("loopee_customers" + i, "remark:                    " + productList.getString("remark"));
                        Log.i("loopee_customers" + i, "customer_type_id:          " + productList.getString("customer_type_id"));
                        Log.i("loopee_customers" + i, "customer_type_name:        " + productList.getString("customer_type_name"));
                        Log.i("loopee_customers" + i, "discount_text:             " + productList.getString("discount_text"));
                        Log.i("loopee_customers" + i, "available_points:          " + productList.getString("available_points"));
                        Log.i("loopee_customers" + i, "birthdate:                 " + productList.getString("birthdate"));
                        Log.i("loopee_customers" + i, "utc created at:            " + productList.getString("utc_created_at"));
                        Log.i("loopee_customers" + i, "utc updated at:            " + productList.getString("utc_updated_at"));
                        Log.i("loopee_customers" + i, "status:                    " + productList.getString("status"));


                        Log.i("loopee_customers" + i, "--------------end of item "+i+"--------------");

                        go_to_products.setVisibility(View.VISIBLE);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.toString());
                Log.i("Error: ", error.getMessage());
                Toast.makeText(getBaseContext(), "Failed, " +  error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();

                String creds = String.format("%s:%s", userTOKEN, "x");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                headers.put("Authorization", auth);

                return headers;
            }
        };

        // add the request object to the queue to be executed
        LoopeeController.getInstance().addToRequestQueue(req);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loopee_button_get_url:
                final String u_URL = URL_API + text_account_id.getText();
                getURL(u_URL);
                break;
            case R.id.loopee_button_get_token:
                String t_URL = userURL + "/api/tokens.json?" + "email=" + text_email.getText() + "&password=" + text_password.getText();
                getToken(t_URL);
                break;
            case R.id.loopee_button_get_settings:
                String settingsURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/settings.json";
                getSettings(settingsURL);
                break;
            case R.id.loopee_button_get_branches:
                String branchesURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/branches.json";
                String getBranchesCount = "?q=count";
                getBranchesCount(branchesURL + getBranchesCount);
                break;

            case R.id.loopee_button_get_tax_settings:
                String tax_settingsURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/tax_settings.json";

                getTaxSettings(tax_settingsURL);
                break;

            case R.id.loopee_button_get_users:
                String tax_usersURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/users.json";

                getUsers(tax_usersURL);
                break;
            case R.id.loopee_button_get_products:
                String productsURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/products.json";
                String getProductCount = "?q=count&active_only=1";

                getProductCount(productsURL + getProductCount);
                break;
            case R.id.loopee_button_get_customers:
                String customersURL = "https://" + userTOKEN + ":x@" + userURL2 + "/api/customers.json?q=count";

                getCustomersCount(customersURL);
                break;
            case R.id.loopee_button_products:
                Intent intent = new Intent(this, LoopeeProducts.class);
                intent.putExtra("Token", userTOKEN);

                startActivity(intent);
                break;
            case R.id.loopee_button_unlink_device:


                // Get the Dao (In my case its RuntimeExcemptionDao)
                RuntimeExceptionDao<Products, Integer> productsDao = DatabaseManager.getInstance().getHelper().getProductRuntimeExcemptionDao();
                RuntimeExceptionDao<Session, String> sessionDao = DatabaseManager.getInstance().getHelper().getSessionRuntimeExcemption();
                RuntimeExceptionDao<Users, Integer> usersDao = DatabaseManager.getInstance().getHelper().getUsersRuntimeExcemptionDao();

                // Get the Deleted Builder of Products
                DeleteBuilder<Products, Integer> productsDeleteBuilder = productsDao.deleteBuilder();
                    DeleteBuilder<Session, String> sessionDeleteBuilder = sessionDao.deleteBuilder();
                DeleteBuilder<Users, Integer> usersDeleteBuilder = usersDao.deleteBuilder();

                DatabaseManager.getInstance().deleteTableContents(productsDao, productsDeleteBuilder);
                DatabaseManager.getInstance().deleteTableContents(sessionDao, sessionDeleteBuilder);
                DatabaseManager.getInstance().deleteTableContents(usersDao, usersDeleteBuilder);

                text_url.setText("");
                text_token.setText("");
                text_branches_count.setText("");

                get_token.setVisibility(View.INVISIBLE);
                get_settings.setVisibility(View.INVISIBLE);
                get_branches.setVisibility(View.INVISIBLE);
                get_tax.setVisibility(View.INVISIBLE);
                get_user.setVisibility(View.INVISIBLE);
                get_products.setVisibility(View.INVISIBLE);
                get_customers.setVisibility(View.INVISIBLE);
                go_to_products.setVisibility(View.INVISIBLE);

                break;
            default:
                break;
        }
    }
}
