package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "Session")
public class Session {

    public final static String SESSION_EMAIL_FIELD_NAME = "email";
    public final static String SESSION_ACCOUNT_ID_FIELD_NAME = "account_id";
    public final static String SESSION_PASSWORD_FIELD_NAME = "password";
    public final static String SESSION_URL_FIELD_NAME = "url";
    public final static String SESSION_NAME_FIELD_NAME = "name";
    public final static String SESSION_TOKEN_FIELD_NAME = "token";
    public final static String SESSION_PRODUCT_PAGE_FIELD_NAME = "product_page";
    public final static String SESSION_PRODUCT_COUNT_FIELD_NAME = "product_count";
    public final static String SESSION_BRANCHES_COUNT_FIELD_NAME = "branches_count";
    public final static String SESSION_BRANCHES_PAGE_FIELD_NAME = "branches_page";
    public final static String SESSION_CUSTOMERS_COUNT_FIELD_NAME = "customers_count";
    public final static String SESSION_CUSTOMERS_PAGE_FIELD_NAME = "customers_page";
    public final static String SESSION_USER_COUNT_FIELD_NAME = "user_count";
    public final static String SESSION_SETTINGS_COUNT_FIELD_NAME = "settings_count";
    public final static String SESSION_ROLE_CODE_FIELD_NAME = "role_code";
    public final static String SESSION_ROLE_ID_FIELD_NAME = "role_id";
    public final static String SESSION_UTC_UPDATED_AT_FIELD_NAME = "utc_updated_at";
    public final static String SESSION_UTC_CREATED_AT_FIELD_NAME = "utc_created_at";
    public final static String SESSION_HOME_BRANCH_ID_FIELD_NAME = "home_branch_id";
    public final static String SESSION_STATUS_FIELD_NAME = "status";

    @DatabaseField(id = true, columnName = SESSION_EMAIL_FIELD_NAME)
    String email;

    @DatabaseField(columnName = SESSION_ACCOUNT_ID_FIELD_NAME)
    String account_id;

    @DatabaseField(columnName = SESSION_PASSWORD_FIELD_NAME)
    String password;

    @DatabaseField(columnName = SESSION_URL_FIELD_NAME)
    String url;

    @DatabaseField(columnName = SESSION_TOKEN_FIELD_NAME)
    String token;

    @DatabaseField(columnName = SESSION_PRODUCT_PAGE_FIELD_NAME)
    int productPage;

    @DatabaseField(columnName = SESSION_PRODUCT_COUNT_FIELD_NAME)
    int product_count;

    @DatabaseField(columnName = SESSION_BRANCHES_COUNT_FIELD_NAME)
    int branches_count;

    @DatabaseField(columnName = SESSION_BRANCHES_PAGE_FIELD_NAME)
    int branches_page;

    @DatabaseField(columnName = SESSION_CUSTOMERS_COUNT_FIELD_NAME)
    int customers_count;

    @DatabaseField(columnName = SESSION_CUSTOMERS_PAGE_FIELD_NAME)
    int customers_page;

    @DatabaseField(columnName = SESSION_USER_COUNT_FIELD_NAME)
    int user_Count;

    @DatabaseField(columnName = SESSION_SETTINGS_COUNT_FIELD_NAME)
    int settings_count;

    @DatabaseField(columnName = SESSION_ROLE_CODE_FIELD_NAME)
    String role_code;

    @DatabaseField(columnName = SESSION_ROLE_ID_FIELD_NAME)
    String role_id;

    @DatabaseField(columnName = SESSION_NAME_FIELD_NAME)
    String name;

    @DatabaseField(columnName = SESSION_UTC_CREATED_AT_FIELD_NAME)
    Date utc_created_at;

    @DatabaseField(columnName = SESSION_UTC_UPDATED_AT_FIELD_NAME)
    Date utc_updated_at;

    @DatabaseField(columnName = SESSION_HOME_BRANCH_ID_FIELD_NAME)
    int home_branch_id;

    @DatabaseField(columnName = SESSION_STATUS_FIELD_NAME)
    String status;

    public Session(){

    }

    public Session(String account_id, String email, String password) {
        this.account_id = account_id;
        this.email = email;
        this.password = password;
    }

    public Session(String email, String account_id, String password, String url, String token, int productPage, int product_count, int branches_count, int branches_page, int customers_count, int customers_page, int user_Count, String role_code, String role_id, Date utc_created_at, Date utc_updated_at, int home_branch_id, String status, int settings_count) {
        this.email = email;
        this.account_id = account_id;
        this.password = password;
        this.url = url;
        this.token = token;
        this.productPage = productPage;
        this.product_count = product_count;
        this.branches_count = branches_count;
        this.branches_page = branches_page;
        this.customers_count = customers_count;
        this.customers_page = customers_page;
        this.user_Count = user_Count;
        this.role_code = role_code;
        this.role_id = role_id;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
        this.home_branch_id = home_branch_id;
        this.status = status;
        this.settings_count = settings_count;
    }

    @Override
    public String toString() {
        return "Session{" +
                "email='" + email + '\'' +
                ", account_id='" + account_id + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                ", productPage=" + productPage +
                ", product_count=" + product_count +
                ", branches_count=" + branches_count +
                ", branches_page=" + branches_page +
                ", customers_count=" + customers_count +
                ", customers_page=" + customers_page +
                ", user_Count=" + user_Count +
                ", settings_count=" + settings_count +
                ", role_code='" + role_code + '\'' +
                ", role_id='" + role_id + '\'' +
                ", name='" + name + '\'' +
                ", utc_created_at=" + utc_created_at +
                ", utc_updated_at=" + utc_updated_at +
                ", home_branch_id=" + home_branch_id +
                ", status='" + status + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getProductPage() {
        return productPage;
    }

    public void setProductPage(int productPage) {
        this.productPage = productPage;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getBranches_count() {
        return branches_count;
    }

    public void setBranches_count(int branches_count) {
        this.branches_count = branches_count;
    }

    public int getBranches_page() {
        return branches_page;
    }

    public void setBranches_page(int branches_page) {
        this.branches_page = branches_page;
    }

    public int getCustomers_count() {
        return customers_count;
    }

    public void setCustomers_count(int customers_count) {
        this.customers_count = customers_count;
    }

    public int getCustomers_page() {
        return customers_page;
    }

    public void setCustomers_page(int customers_page) {
        this.customers_page = customers_page;
    }

    public int getUser_Count() {
        return user_Count;
    }

    public int getSettings_count(){
        return settings_count;
    }

    public void setUser_Count(int user_Count) {
        this.user_Count = user_Count;
    }

    public void setSettings_count(int settings_count){
        this.settings_count = settings_count;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public Date getUtc_created_at() {
        return utc_created_at;
    }

    public void setUtc_created_at(Date utc_created_at) {
        this.utc_created_at = utc_created_at;
    }

    public Date getUtc_updated_at() {
        return utc_updated_at;
    }

    public void setUtc_updated_at(Date utc_updated_at) {
        this.utc_updated_at = utc_updated_at;
    }

    public int getHome_branch_id() {
        return home_branch_id;
    }

    public void setHome_branch_id(int home_branch_id) {
        this.home_branch_id = home_branch_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}