package net.nueca.jn.loopee.database;

import android.content.Context;
import android.database.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
import net.nueca.jn.loopee.models.Product_Branch_Prices;
import net.nueca.jn.loopee.models.Product_Tax_Rates;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Settings;
import net.nueca.jn.loopee.models.Tax_Rates;
import net.nueca.jn.loopee.models.Tax_Settings;
import net.nueca.jn.loopee.models.Users;

import java.util.List;

public class DatabaseManager extends OrmLiteBaseActivity<DatabaseHelper> {

    static private DatabaseManager instance;
    private DatabaseHelper helper;

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

    public void addProduct(Products product) {
        getHelper().getProductRuntimeExceptionDao().create(product);
    }

    public void addSession(Session session) {
        getHelper().getSessionRuntimeException().create(session);
    }

    public void addUser(Users user) {
        getHelper().getUsersRuntimeExceptionDao().create(user);
    }

    public void addSettings(Settings settings){
        getHelper().getSettingsRuntimeExceptionDao().create(settings);
    }

    public void addBranches(Branches branches){
        getHelper().getBranchesRunTimeExceptionDao().create(branches);
    }

    public void addTax_Settings(Tax_Settings tax_settings){
        getHelper().getTaxSettingsRuntimeExceptionDao().create(tax_settings);
    }

    public void addTax_Rates(Tax_Rates tax_rates){
        getHelper().getTaxRatesRuntimeExceptionDao().create(tax_rates);
    }

    public void addCustomers(Customers customers){
        getHelper().getCustomersRuntimeExceptionDao().create(customers);
    }

    public void addProductTax_Rates(Product_Tax_Rates product_tax_rates){
        getHelper().getRuntimeProductTaxRateExceptionDao().create(product_tax_rates);
    }

    public void addProductBranch_Prices(Product_Branch_Prices product_branch_prices){
        getHelper().getProductBranch_PricesRuntimeExceptionDao().create(product_branch_prices);
    }
    public Tax_Rates newTax_Rates(){
        Tax_Rates tax_rates = new Tax_Rates();
        getHelper().getTaxRatesRuntimeExceptionDao().create(tax_rates);

        return tax_rates;
    }

    public void updateTax_Rates(Tax_Rates tax_rates){
        getHelper().getTaxRatesRuntimeExceptionDao().update(tax_rates);
    }

    public List<Product_Tax_Rates> getAllProductTaxRates(){
        List<Product_Tax_Rates> product_tax_rates = null;

        try {
            product_tax_rates = getHelper().getRuntimeProductTaxRateExceptionDao().queryForAll();
        } catch (Exception e){
            e.printStackTrace();
        }

        return product_tax_rates;
    }


    public List<Session> getAllSession() {
        List<Session> session = null;
        try {
            session = getHelper().getSessionRuntimeException().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    public Tax_Rates queryTax_RatesWithId(int id){

        Tax_Rates tax_rates = getHelper().getTaxRatesRuntimeExceptionDao().queryForId(id);

        return tax_rates;
    }

    public Products queryProductsWithId(int id){
        Products products = getHelper().getProductRuntimeExceptionDao().queryForId(id);

        return products;
    }
    public List<Products> getAllProducts() {

        List<Products> products;

        products = getHelper().getProductRuntimeExceptionDao().queryForAll();

        return products;
    }

    public List<Customers> getAllCustomers(){
        List<Customers> customers = null;
        try {
            customers = getHelper().getCustomersRuntimeExceptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  customers;
    }

    public List<Tax_Settings> getAllTax_Settings(){
        List<Tax_Settings> tax_settings = null;
        try {
            tax_settings = getHelper().getTaxSettingsRuntimeExceptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  tax_settings;
    }

    public List<Tax_Rates> getAllTax_Rates(){
        List<Tax_Rates> tax_rates = null;
        try {
            tax_rates = getHelper().getTaxRatesRuntimeExceptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tax_rates;
    }
    public List<Branches> getAllBranches(){
        List<Branches> branches = null;

        try{
            branches = getHelper().getBranchesRunTimeExceptionDao().queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return branches;
    }

    public List<Users> getAllUsers(){
        List<Users> users = null;

        try{
            users = getHelper().getUsersRuntimeExceptionDao().queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    public List<Settings> getAllSettings(){
        List<Settings> settings = null;

        try{
            settings = getHelper().getSettingsRuntimeExceptionDao().queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return settings;
    }

    public void deleteTableContents(RuntimeExceptionDao Dao, DeleteBuilder deleteBuilder) {

        // Delete entire rows;
        try {
            Dao.delete(deleteBuilder.prepare());

        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }

    }
}
