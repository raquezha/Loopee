package net.nueca.jn.loopee.database;

import android.content.Context;
import android.database.SQLException;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Settings;
import net.nueca.jn.loopee.models.Tax_Rates;
import net.nueca.jn.loopee.models.Tax_Settings;
import net.nueca.jn.loopee.models.Users;

import java.util.List;

public class DatabaseManager extends OrmLiteBaseActivity<DatabaseHelper> {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null == instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;

    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    public DatabaseHelper getHelper() {
        return helper;
    }

    public void addProduct(Products product) {
        getHelper().getProductRuntimeExcemptionDao().create(product);
    }

    public void addSession(Session session) {
        getHelper().getSessionRuntimeExcemption().create(session);
    }

    public void addUser(Users user) {
        getHelper().getUsersRuntimeExcemptionDao().create(user);
    }

    public void addSettings(Settings settings){
        getHelper().getSettingsRuntimeExcemptionDao().create(settings);
    }

    public void addBranches(Branches branches){
        getHelper().getBranchesRunTimeExcemptionDao().create(branches);
    }

    public void addTax_Settings(Tax_Settings tax_settings){
        getHelper().getTaxSettingsRuntimeExcemptionDao().create(tax_settings);
    }

    public void addTax_Rates(Tax_Rates tax_rates){
        getHelper().getTaxRatesRuntimeExcemptionDao().create(tax_rates);
    }

    public void addCustomers(Customers customers){
        getHelper().getCustomersRuntimeExcemptionDao().create(customers);
    }

    public Tax_Rates newTax_Rates(){
        Tax_Rates tax_rates = new Tax_Rates();
        getHelper().getTaxRatesRuntimeExcemptionDao().create(tax_rates);

        return tax_rates;
    }

    public void updateTax_Rates(Tax_Rates tax_rates){
        getHelper().getTaxRatesRuntimeExcemptionDao().update(tax_rates);
    }

    public void assignProductsEmptyForeignCollection(Products products){
        getHelper().getProductRuntimeExcemptionDao().assignEmptyForeignCollection(products, "product_tax_rates");
    }

    public void addProductsForeignCollection(Products products, Tax_Rates tax_rates){
        products.getProduct_tax_rates().add(tax_rates);
    }

    public List<Session> getAllSession() {
        List<Session> session = null;
        try {
            session = getHelper().getSessionRuntimeExcemption().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    public Tax_Rates queryTax_RatesWithId(int id){

        Tax_Rates tax_rates = getHelper().getTaxRatesRuntimeExcemptionDao().queryForId(id);

        return tax_rates;
    }

    public Products queryProductsWithId(int id){
        Products products = getHelper().getProductRuntimeExcemptionDao().queryForId(id);

        return products;
    }
    public List<Products> getAllProducts() {

        List<Products> products;

        products = getHelper().getProductRuntimeExcemptionDao().queryForAll();

        return products;
    }

    public List<Customers> getAllCustomers(){
        List<Customers> customers = null;
        try {
            customers = getHelper().getCustomersRuntimeExcemptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  customers;
    }

    public List<Tax_Settings> getAllTax_Settings(){
        List<Tax_Settings> tax_settings = null;
        try {
            tax_settings = getHelper().getTaxSettingsRuntimeExcemptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  tax_settings;
    }

    public List<Tax_Rates> getAllTax_Rates(){
        List<Tax_Rates> tax_rates = null;
        try {
            tax_rates = getHelper().getTaxRatesRuntimeExcemptionDao().queryForAll();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tax_rates;
    }
    public List<Branches> getAllBranches(){
        List<Branches> branches = null;

        try{
            branches = getHelper().getBranchesRunTimeExcemptionDao().queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return branches;
    }

    public List<Users> getAllUsers(){
        List<Users> users = null;

        try{
            users = getHelper().getUsersRuntimeExcemptionDao().queryForAll();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return users;
    }

    public List<Settings> getAllSettings(){
        List<Settings> settings = null;

        try{
            settings = getHelper().getSettingsRuntimeExcemptionDao().queryForAll();
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
