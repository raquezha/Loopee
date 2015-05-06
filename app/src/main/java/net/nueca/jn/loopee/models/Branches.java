package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Branch")
public class Branches {

    public final static String BRANCH_ID_FIELD_NAME = "id";
    public final static String BRANCH_NAME_FIELD_NAME = "name";
    public final static String BRANCH_STREET_FIELD_NAME = "street";
    public final static String BRANCH_CITY_FIELD_NAME = "city";
    public final static String BRANCH_STATE_FIELD_NAME = "state";
    public final static String BRANCH_COUNTRY_FIELD_NAME = "country";
    public final static String BRANCH_ZIP_FIELD_NAME = "zip";
    public final static String BRANCH_TIN_FIELD_NAME = "tin";
    public final static String BRANCH_SITE_TYPE_FIELD_NAME = "site_type";
    public final static String BRANCH_SUBSCRIPTION_TYPE_FIELD_NAME = "subscription_type";
    public final static String BRANCH_UTC_CREATED_AT_FIELD_NAME = "created_at";
    public final static String BRANCH_UTC_UPDATED_AT_FIELD_NAME = "updated_at";
    public final static String BRANCH_STATUS_TYPE_FIELD_NAME = "status";

    @DatabaseField(id = true, columnName = BRANCH_ID_FIELD_NAME)
    int id;

    @DatabaseField(columnName = BRANCH_NAME_FIELD_NAME)
    String name;

    @DatabaseField(columnName = BRANCH_STREET_FIELD_NAME)
    String street;

    @DatabaseField(columnName = BRANCH_CITY_FIELD_NAME)
    String city;

    @DatabaseField(columnName = BRANCH_STATE_FIELD_NAME)
    String state;

    @DatabaseField(columnName = BRANCH_COUNTRY_FIELD_NAME)
    String country;

    @DatabaseField(columnName = BRANCH_ZIP_FIELD_NAME)
    String zipcode;

    @DatabaseField(columnName = BRANCH_TIN_FIELD_NAME)
    String tin;

    @DatabaseField(columnName = BRANCH_SITE_TYPE_FIELD_NAME)
    String site_type;

    @DatabaseField(columnName = BRANCH_SUBSCRIPTION_TYPE_FIELD_NAME)
    int subscription_type;

    @DatabaseField(columnName = BRANCH_UTC_CREATED_AT_FIELD_NAME)
    String utc_created_at;

    @DatabaseField(columnName = BRANCH_UTC_UPDATED_AT_FIELD_NAME)
    String utc_updated_at;

    @DatabaseField(columnName = BRANCH_STATUS_TYPE_FIELD_NAME)
    String status;

    public Branches(){ }

    public Branches(int id, String name, String street, String city, String state, String country, String zipcode, String tin, String site_type, int subscription_type, String utc_created_at, String utc_updated_at, String status) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.tin = tin;
        this.site_type = site_type;
        this.subscription_type = subscription_type;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table_Branches{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", tin='" + tin + '\'' +
                ", site_type='" + site_type + '\'' +
                ", subscription_type=" + subscription_type +
                ", utc_created_at=" + utc_created_at +
                ", utc_updated_at=" + utc_updated_at +
                ", status='" + status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getSite_type() {
        return site_type;
    }

    public void setSite_type(String site_type) {
        this.site_type = site_type;
    }

    public int getSubscription_type() {
        return subscription_type;
    }

    public void setSubscription_type(int subscription_type) {
        this.subscription_type = subscription_type;
    }
    public String getUtc_created_at() {
        return utc_created_at;
    }

    public void setUtc_created_at(String utc_created_at) {
        this.utc_created_at = utc_created_at;
    }

    public String getUtc_updated_at() {
        return utc_updated_at;
    }

    public void setUtc_updated_at(String utc_updated_at) {
        this.utc_updated_at = utc_updated_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
