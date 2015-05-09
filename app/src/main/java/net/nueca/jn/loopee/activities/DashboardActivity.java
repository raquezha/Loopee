package net.nueca.jn.loopee.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import net.nueca.jn.loopee.controllers.RequestManager;
import net.nueca.jn.loopee.database.DatabaseManager;
import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
import net.nueca.jn.loopee.models.Product_Tax_Rates;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Settings;
import net.nueca.jn.loopee.models.Tax_Rates;
import net.nueca.jn.loopee.models.Tax_Settings;
import net.nueca.jn.loopee.models.Users;

import java.util.List;
import java.util.Locale;

public class DashboardActivity extends Activity implements View.OnClickListener {

    Button button_begin, button_unlink_device;
    TextView textUser, textStore, textBranch, textCountry, textProducts, textSubmitted, textUnsubmitted;
    List<Settings> settingsList;
    List<Session> sessionsList;
    List<Products> productsList;

    String strUser, strStore, strBranch, strCountry, strSubmitted, strUnsubmitted;
    int strProducts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseManager.init(this);


        // if user is not signed in, finish current activity
        // and launch login screen
        if (!isUserSignedIn()) {
            finish();
            startLoginActivity();
            return;
        } else {
            // do initialization
            setContentView(R.layout.loopee_begin);

            //initialize
            init();


        }

    }

    private void init() {

        button_begin = (Button) findViewById(R.id.begin_button);
        button_unlink_device = (Button) findViewById(R.id.unlink_button);

        button_begin.setOnClickListener(this);
        button_unlink_device.setOnClickListener(this);

        textUser = (TextView) findViewById(R.id.loopee_begin_user_input);
        textStore = (TextView) findViewById(R.id.loopee_begin_store_input);
        textBranch = (TextView) findViewById(R.id.loopee_begin_branch_input);
        textCountry = (TextView) findViewById(R.id.loopee_begin_country_input);
        textProducts = (TextView) findViewById(R.id.loopee_begin_products_input);

        textSubmitted = (TextView) findViewById(R.id.loopee_begin_submitted_input);
        textUnsubmitted = (TextView) findViewById(R.id.loopee_begin_unsubmitted_input);

        settingsList = DatabaseManager.getInstance().getAllSettings();
        sessionsList = DatabaseManager.getInstance().getAllSession();


        Session session = sessionsList.get(0);
        strUser = session.getName();

        productsList = DatabaseManager.getInstance().getAllProducts();

        if (productsList.size() == 0) {
            strProducts = 0;
        } else {
            strProducts = productsList.size();
        }

        for (Settings settings : settingsList) {

            String name = settings.getName();
            String branch_name = "branch_name";
            String country = "country";
            String receipt_header = "receipt_header";



            if (name.equals(branch_name)) {
                strBranch = settings.getValue();
            }

            if (name.equals(receipt_header)) {
                String tempStoreString = settings.getValue();
                String[] tokens = tempStoreString.split("<[^>]*>");

                strStore = tokens[1];
            }

            if (name.equals(country)) {

                Locale l = new Locale("", settings.getValue());
                System.out.println();
                strCountry = l.getDisplayCountry();
            }
        }


        // Change TextViews
        SetUserInformation();

    }

    private void SetUserInformation() {

        // set the user
        textUser.setText(strUser);

        // set the store name
        textStore.setText(strStore);

        // set the branch name
        textBranch.setText(strBranch);

        // set the country
        textCountry.setText(strCountry);

        // set the products
        textProducts.setText(String.valueOf(strProducts));

        // set the submitted
        textSubmitted.setText("0");

        // set the unsubmitted
        textUnsubmitted.setText("0");


    }

    // retrieve user from database
    public boolean isUserSignedIn() {

        try {
            // Get the session from database
            List<Session> session = DatabaseManager.getInstance().getAllSession();

            // We don't have a user open Login Activity
            if (session.size() == 0) {
                return false;
            }

        } catch (Exception e) {
            Log.i("exception", e.toString());
        }

        // We have a user signed in start dashboard
        return true;
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {

            case R.id.begin_button:
                Intent intent = new Intent(this, LoopeeProducts.class);
                startActivity(intent);
                break;

            case R.id.unlink_button:

                try {
                    // Get the Dao (In my case its RuntimeExcemptionDao)
                    RuntimeExceptionDao<Users, Integer> usersDao = DatabaseManager.getInstance().getHelper().getUsersRuntimeExceptionDao();
                    RuntimeExceptionDao<Session, String> sessionDao = DatabaseManager.getInstance().getHelper().getSessionRuntimeException();
                    RuntimeExceptionDao<Settings, Integer> settingsDao = DatabaseManager.getInstance().getHelper().getSettingsRuntimeExceptionDao();
                    RuntimeExceptionDao<Branches, Integer> branchesDao = DatabaseManager.getInstance().getHelper().getBranchesRunTimeExceptionDao();
                    RuntimeExceptionDao<Tax_Settings, Integer> tax_settingsDao = DatabaseManager.getInstance().getHelper().getTaxSettingsRuntimeExceptionDao();
                    RuntimeExceptionDao<Tax_Rates, Integer> tax_ratesDao = DatabaseManager.getInstance().getHelper().getTaxRatesRuntimeExceptionDao();
                    RuntimeExceptionDao<Products, Integer> productsDao = DatabaseManager.getInstance().getHelper().getProductRuntimeExceptionDao();
                    RuntimeExceptionDao<Customers, Integer> customersDao = DatabaseManager.getInstance().getHelper().getCustomersRuntimeExceptionDao();

                    // Get the Deleted Builder of DAO
                    DeleteBuilder<Users, Integer> usersDeleteBuilder = usersDao.deleteBuilder();
                    DeleteBuilder<Session, String> sessionDeleteBuilder = sessionDao.deleteBuilder();
                    DeleteBuilder<Settings, Integer> settingsDeleteBuilder = settingsDao.deleteBuilder();
                    DeleteBuilder<Branches, Integer> branchesDeleteBuilder = branchesDao.deleteBuilder();
                    DeleteBuilder<Tax_Settings, Integer> tax_settingsDeleteBuilder = tax_settingsDao.deleteBuilder();
                    DeleteBuilder<Tax_Rates, Integer> taxRatesDeleteBuilder = tax_ratesDao.deleteBuilder();
                    DeleteBuilder<Products, Integer> productsDeleteBuilder = productsDao.deleteBuilder();
                    DeleteBuilder<Customers, Integer> customersDeleteBuilder = customersDao.deleteBuilder();

                    // Clear the table data
                    DatabaseManager.getInstance().deleteTableContents(usersDao, usersDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(sessionDao, sessionDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(settingsDao, settingsDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(branchesDao, branchesDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(tax_settingsDao, tax_settingsDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(tax_ratesDao, taxRatesDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(productsDao, productsDeleteBuilder);
                    DatabaseManager.getInstance().deleteTableContents(customersDao, customersDeleteBuilder);


                    // clear the cache
                    RequestManager.getInstance().doRequest().clearCache();

                    finish();
                    startLoginActivity();
                    break;
                } catch (Exception e) {
                    Log.i("error", e.toString());
                }

            default:
                break;
        }


    }

    private void Logs() {

        List<Customers> customers = DatabaseManager.getInstance().getAllCustomers();
        Log.i("customer size: ", String.valueOf(customers.size()));

        List<Products> product = DatabaseManager.getInstance().getAllProducts();
        Log.i("products size: ", String.valueOf(product.size()));

        List<Product_Tax_Rates> product_tax_rates = DatabaseManager.getInstance().getAllProductTaxRates();
        Log.i("producttaxratessize: ", String.valueOf(product_tax_rates.size()));

        List<Tax_Settings> tax_settings = DatabaseManager.getInstance().getAllTax_Settings();
        Log.i("tax_settings size: ", String.valueOf(tax_settings.size()));

        List<Tax_Rates> tax_rates = DatabaseManager.getInstance().getAllTax_Rates();
        Log.i("tax_rates size: ", String.valueOf(tax_rates.size()));

        List<Session> sessions = DatabaseManager.getInstance().getAllSession();
        Log.i("sessions size: ", String.valueOf(sessions.size()));

        List<Branches> branches = DatabaseManager.getInstance().getAllBranches();
        Log.i("branches size: ", String.valueOf(branches.size()));

        List<Users> users = DatabaseManager.getInstance().getAllUsers();
        Log.i("users size: ", String.valueOf(users.size()));

        List<Settings> settings = DatabaseManager.getInstance().getAllSettings();
        Log.i("settings size: ", String.valueOf(settings.size()));
    }
}
