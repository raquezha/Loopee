package net.nueca.jn.loopee.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import net.nueca.jn.loopee.activities.R;
import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
import net.nueca.jn.loopee.models.Product_Tax_Rates;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Settings;
import net.nueca.jn.loopee.models.Tax_Rates;
import net.nueca.jn.loopee.models.Tax_Settings;
import net.nueca.jn.loopee.models.Users;

import java.sql.SQLException;
import java.util.List;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    // Database Info
    private static final String DATABASE_NAME = "loopee.sqlite";
    private static final int DATABASE_VERSION = 1;
    // Context
    private Context context;
    // DAO
    private Dao<Session, String> sessionDAO = null;
    private Dao<Settings,Integer> settingsDAO = null;
    private Dao<Branches, Integer> branchesDAO = null;
    private Dao<Tax_Rates,Integer> taxRatesDAO = null;
    private Dao<Users,Integer> usersDAO = null;
    private Dao<Products,Integer> productsDAO = null;
    private Dao<Product_Tax_Rates, Integer> productTax_RatesDAO = null;
    private Dao<Customers, Integer> customersDAO = null;
    private Dao<Tax_Settings, Integer> tax_settingsDAO = null;

    // Queries for Prepared Products Tax Rates
    private PreparedQuery<Tax_Rates> tax_ratesForProductQuery = null;
    private PreparedQuery<Products> productsForTax_RatesQuery = null;

    // RuntimeExceptionDAO
    private RuntimeExceptionDao sessionRuntimeDao = null;
    private RuntimeExceptionDao settingsRuntimeDao = null;
    private RuntimeExceptionDao branchesRuntimeDao = null;
    private RuntimeExceptionDao taxRatesDAORuntimeDao = null;
    private RuntimeExceptionDao usersRuntimeDao = null;
    private RuntimeExceptionDao productsRuntimeDao = null;
    private RuntimeExceptionDao productTax_RatesRuntimeDAO = null;
    private RuntimeExceptionDao customersRuntimeDao = null;
    private RuntimeExceptionDao taxSettingsRuntimeDao = null;

    // Constructor
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
        this.context = context;

    }

    // This just creates the tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, Settings.class);
            TableUtils.createTable(connectionSource, Branches.class);
            TableUtils.createTable(connectionSource, Tax_Settings.class);
            TableUtils.createTable(connectionSource, Tax_Rates.class);
            TableUtils.createTable(connectionSource, Users.class);
            TableUtils.createTable(connectionSource, Products.class);
            TableUtils.createTable(connectionSource, Customers.class);
            TableUtils.createTable(connectionSource, Session.class);
            TableUtils.createTable(connectionSource, Product_Tax_Rates.class);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // Drop the table then recreate again
    @Override
    public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            // Drop the Table
            TableUtils.dropTable(connectionSource, Session.class, true);
            TableUtils.dropTable(connectionSource, Settings.class, true);
            TableUtils.dropTable(connectionSource, Branches.class, true);
            TableUtils.dropTable(connectionSource, Tax_Rates.class, true);
            TableUtils.dropTable(connectionSource, Tax_Settings.class, true);
            TableUtils.dropTable(connectionSource, Users.class, true);
            TableUtils.dropTable(connectionSource, Products.class, true);
            TableUtils.dropTable(connectionSource, Customers.class, true);
            TableUtils.dropTable(connectionSource, Product_Tax_Rates.class, true);

            // Create it again by calling onCreate
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Session Dao
    public Dao<Session, String> getSessionDao() throws SQLException{

        if (sessionDAO == null){
            sessionDAO = getDao(Session.class);
        }

        return sessionDAO;
    }

    // Session RuntimeExcemptionDao
    public RuntimeExceptionDao<Session, String> getSessionRuntimeExcemption(){
        if(sessionRuntimeDao == null){
            sessionRuntimeDao = getRuntimeExceptionDao(Session.class);
        }

        return sessionRuntimeDao;
    }


    // Settings Dao
    public Dao<Settings, Integer> getSettingsDAO() throws SQLException {

        if(settingsDAO == null){
            settingsDAO= getDao(Settings.class);
        }

        return settingsDAO;
    }

    // Settings RunTimeExcemptionDao
    public RuntimeExceptionDao<Settings, Integer> getSettingsRuntimeExcemptionDao(){
        if(settingsRuntimeDao == null){
            settingsRuntimeDao = getRuntimeExceptionDao(Settings.class);
        }

        return  settingsRuntimeDao;
    }

    // Branches
    public Dao<Branches, Integer> getBranchesDAO() throws SQLException {
        if(branchesDAO == null){
            branchesDAO = getDao(Branches.class);
        }

        return branchesDAO;
    }

    // Branches RuntimeExcemptionDao
    public RuntimeExceptionDao<Branches, Integer> getBranchesRunTimeExcemptionDao() {
        if(branchesRuntimeDao == null) {
            branchesRuntimeDao = getRuntimeExceptionDao(Branches.class);
        }

        return branchesRuntimeDao;
    }

    // Tax Settings Dao
    public Dao<Tax_Settings, Integer> getTaxSettingsDAO() throws SQLException {

        if(tax_settingsDAO == null){
            tax_settingsDAO = getDao(Tax_Settings.class);
        }

        return tax_settingsDAO;
    }

    // Tax Settings RuntimeDao
    public RuntimeExceptionDao<Tax_Settings, Integer> getTaxSettingsRuntimeExcemptionDao(){
        if(taxSettingsRuntimeDao== null){
            taxSettingsRuntimeDao = getRuntimeExceptionDao(Tax_Settings.class);
        }

        return taxSettingsRuntimeDao;
    }

    // Tax Rates Dao
    public Dao<Tax_Rates, Integer> getTaxRatesDAO() throws SQLException {

        if(taxRatesDAO == null){
            taxRatesDAO = getDao(Tax_Rates.class);
        }

        return taxRatesDAO;
    }

    // Tax Rates RuntimeDao
    public RuntimeExceptionDao<Tax_Rates, Integer> getTaxRatesRuntimeExcemptionDao(){
        if(taxRatesDAORuntimeDao == null){
            taxRatesDAORuntimeDao = getRuntimeExceptionDao(Tax_Rates.class);
        }

        return taxRatesDAORuntimeDao;
    }

    // Users Dao
    public Dao<Users, Integer> getUsersDAO() throws SQLException {
        if(usersDAO== null){
            usersDAO = getDao(Users.class);
        }
        return usersDAO;
    }

    // Users RuntimeExcemptionDao
    public RuntimeExceptionDao<Users, Integer> getUsersRuntimeExcemptionDao(){
        if(usersRuntimeDao == null){
            usersRuntimeDao = getRuntimeExceptionDao(Users.class);
        }

        return usersRuntimeDao;
    }

    // Products Dao
    public Dao<Products, Integer> getProductsDAO() throws SQLException {

        if(productsDAO == null){
            productsDAO = getDao(Products.class);
        }

        return productsDAO;
    }

    // Products RuntimeExcemptionDao
    public RuntimeExceptionDao<Products, Integer> getProductRuntimeExcemptionDao(){
        if(productsRuntimeDao == null){
            productsRuntimeDao = getRuntimeExceptionDao(Products.class);
        }

        return productsRuntimeDao;
    }

    // Products Tax Rates Dao
    public Dao<Product_Tax_Rates, Integer> getProductTax_RatesDAO() throws SQLException {
        if(productTax_RatesDAO == null){
            productTax_RatesDAO = getDao(Product_Tax_Rates.class);
        }

        return productTax_RatesDAO;
    }

    // Products Tax Rates Run Time Excemption Dao
    public RuntimeExceptionDao<Product_Tax_Rates, Integer> getRuntimeProductTaxRateExcemptionDao(){
        if(productTax_RatesRuntimeDAO == null) {
            productTax_RatesRuntimeDAO = getRuntimeExceptionDao(Product_Tax_Rates.class);
        }

        return productTax_RatesRuntimeDAO;
    }


    // Customers Dao
    public Dao<Customers, Integer> getCustomersDAO() throws SQLException {
        if(customersDAO == null){
            customersDAO = getDao(Customers.class);
        }

        return customersDAO;
    }

    // Customers RuntimeExcemptionDao
    public RuntimeExceptionDao<Customers, Integer> getCustomersRuntimeExcemptionDao(){
        if(customersRuntimeDao == null){
            customersRuntimeDao = getRuntimeExceptionDao(Customers.class);
        }

        return customersRuntimeDao;
    }

    /*
	 * Convenience methods to build and run our prepared queries.
	 */
    private List<Tax_Rates> lookupTax_RatesForProducts(Products products) throws SQLException {
        if (tax_ratesForProductQuery == null) {
            tax_ratesForProductQuery = makeTaxRatesForUserProducts();
        }
        tax_ratesForProductQuery.setArgumentHolderValue(0, products);
        return productsRuntimeDao.query(tax_ratesForProductQuery);
    }

    private List<Products> lookupUsersForPost(Tax_Rates tax_rates) throws SQLException {
        if (productsForTax_RatesQuery == null) {
            productsForTax_RatesQuery = makeProductsForTaxRatesQuery();
        }
        productsForTax_RatesQuery.setArgumentHolderValue(0, tax_rates);
        return taxRatesDAORuntimeDao.query(productsForTax_RatesQuery);
    }

    /**
     * Build our query for Tax Rates objects that match a Product.
     */
    private PreparedQuery<Tax_Rates> makeTaxRatesForUserProducts() throws SQLException {
        // build our inner query for ProductTax_Rates objects
        QueryBuilder<Product_Tax_Rates, Integer> productTax_RateQb = productTax_RatesRuntimeDAO.queryBuilder();

        // just select the tax_rate-id field
        productTax_RateQb.selectColumns(Product_Tax_Rates.TAX_RATE_ID_FIELD_NAME);

        SelectArg userSelectArg = new SelectArg();

        // you could also just pass in user1 here
        productTax_RateQb.where().eq(Product_Tax_Rates.PRODUCT_ID_FIELD_NAME, userSelectArg);

        // build our outer query for Tax Rates objects
        QueryBuilder<Tax_Rates, Integer> postQb = taxRatesDAORuntimeDao.queryBuilder();

        // where the id matches in the post-id from the inner query
        postQb.where().in(Products.PRODUCT_ID_FIELD_NAME, productTax_RateQb);
        return postQb.prepare();
    }

    /**
     * Build our query for Product objects that match a Tax Rates
     */

    private PreparedQuery<Products> makeProductsForTaxRatesQuery() throws SQLException {

        QueryBuilder<Product_Tax_Rates, Integer> productTax_RateQb = productTax_RatesRuntimeDAO.queryBuilder();

        // this time selecting for the product-id field
        productTax_RateQb.selectColumns(Product_Tax_Rates.PRODUCT_ID_FIELD_NAME);

        SelectArg postSelectArg = new SelectArg();

        productTax_RateQb.where().eq(Product_Tax_Rates.TAX_RATE_ID_FIELD_NAME, postSelectArg);

        // build our outer query
        QueryBuilder<Products, Integer> userQb = productTax_RatesRuntimeDAO.queryBuilder();

        // where the product-id matches the inner query's tax_rates-id field
        userQb.where().in(Tax_Rates.TAX_RATE_ID_FIELD_NAME, productTax_RateQb);
        return userQb.prepare();
    }

}



