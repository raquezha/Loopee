package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Branch_Prices")
public class Branch_Prices {
    public final static String BRANCH_PRICE_ID_FIELD_NAME = "id";
    public final static String BRANCH_PRICE_RETAIL_PRICE_FIELD_NAME = "retail_price";
    public final static String BRANCH_PRICE_WHOLESALE_PRICE_FIELD_NAME = "wholesale_price";
    public final static String BRANCH_PRICE_UTC_CREATED_AT_FIELD_NAME = "utc_created_at";
    public final static String BRANCH_PRICE_UTC_UPDATED_AT_FIELD_NAME = "utc_updated_at";

    @DatabaseField(id = true, columnName = BRANCH_PRICE_ID_FIELD_NAME)
    int branch_id;

    @DatabaseField(columnName = BRANCH_PRICE_RETAIL_PRICE_FIELD_NAME)
    Double retail_price;

    @DatabaseField(columnName = BRANCH_PRICE_WHOLESALE_PRICE_FIELD_NAME)
    Double wholesale_price;

    @DatabaseField(columnName = BRANCH_PRICE_UTC_CREATED_AT_FIELD_NAME)
    String utc_created_at;

    @DatabaseField(columnName = BRANCH_PRICE_UTC_UPDATED_AT_FIELD_NAME)
    String utc_updated_at;


    public Branch_Prices(){}


    public Branch_Prices(int branch_id, Double retail_price, Double wholesale_price, String utc_created_at, String utc_updated_at) {
        this.branch_id = branch_id;
        this.retail_price = retail_price;
        this.wholesale_price = wholesale_price;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
    }


    @Override
    public String toString() {
        return "Branch_Prices{" +
                "branch_id=" + branch_id +
                ", retail_price=" + retail_price +
                ", wholesale_price=" + wholesale_price +
                ", utc_created_at=" + utc_created_at +
                ", utc_updated_at=" + utc_updated_at +
                '}';
    }


    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public Double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(Double retail_price) {
        this.retail_price = retail_price;
    }

    public Double getWholesale_price() {
        return wholesale_price;
    }

    public void setWholesale_price(Double wholesale_price) {
        this.wholesale_price = wholesale_price;
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

}
