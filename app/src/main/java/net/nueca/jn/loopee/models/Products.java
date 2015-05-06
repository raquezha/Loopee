package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Products")
public class Products {

    public final static String PRODUCT_ID_FIELD_NAME = "id";
    public final static String PRODUCT_NAME_FIELD_NAME = "name";
    public final static String PRODUCT_STOCK_NO_FIELD_NAME = "stock_no";
    public final static String PRODUCT_COST_FIELD_NAME = "cost";
    public final static String PRODUCT_RETAIL_PRICE_FIELD_NAME = "retail_price";
    public final static String PRODUCT_WHOLESALE_PRICE_FIELD_NAME = "wholesale_price";
    public final static String PRODUCT_DESCRIPTION_FIELD_NAME = "product_description";
    public final static String PRODUCT_ALLOW_DECIMAL_QUANTITIES_FIELD_NAME = "allow_decimal_quantities";
    public final static String PRODUCT_DISABLE_DISCOUNT_FIELD_NAME = "disable_discount";
    public final static String PRODUCT_DISABLE_INVENTORY_FIELD_NAME = "inventory";
    public final static String PRODUCT_ENABLE_FIELD_NAME = "enable";
    public final static String PRODUCT_TAX_EXCEMPT_FIELD_NAME = "tax_excempt";
    public final static String PRODUCT_TAG_LIST_FIELD_NAME = "tag_list";
    public final static String PRODUCT_BARCODE_LIST_FIELD_NAME = "barcode_list";
    public final static String PRODUCT_THUMBNAIL_URL_FIELD_NAME = "thumbnail_url";
    public final static String PRODUCT_UTC_CREATED_AT_FIELD_NAME = "utc_created_at";
    public final static String PRODUCT_UTC_UPDATED_AT_FIELD_NAME = "utc_updated_at";
    public final static String PRODUCT_STATUS_FIELD_NAME = "status";

    @DatabaseField(id = true, columnName = PRODUCT_ID_FIELD_NAME)
    int id;

    @DatabaseField(columnName = PRODUCT_NAME_FIELD_NAME)
    String name;

    @DatabaseField(columnName = PRODUCT_STOCK_NO_FIELD_NAME)
    String stock_no;

    @DatabaseField(columnName = PRODUCT_COST_FIELD_NAME)
    double cost;

    @DatabaseField(columnName = PRODUCT_RETAIL_PRICE_FIELD_NAME)
    double retail_price;

    @DatabaseField(columnName = PRODUCT_WHOLESALE_PRICE_FIELD_NAME)
    double wholesale_price;

    @DatabaseField(columnName = PRODUCT_DESCRIPTION_FIELD_NAME)
    String description;

    @DatabaseField(columnName = PRODUCT_ALLOW_DECIMAL_QUANTITIES_FIELD_NAME)
    Boolean allow_decimal_quantities;

    @DatabaseField(columnName = PRODUCT_DISABLE_DISCOUNT_FIELD_NAME)
    Boolean disable_discount;

    @DatabaseField(columnName = PRODUCT_DISABLE_INVENTORY_FIELD_NAME)
    Boolean disable_inventory;

    @DatabaseField(columnName = PRODUCT_ENABLE_FIELD_NAME)
    Boolean enable_open_price;

    @DatabaseField(columnName = PRODUCT_TAX_EXCEMPT_FIELD_NAME)
    Boolean tax_exempt;

    @DatabaseField(columnName = PRODUCT_TAG_LIST_FIELD_NAME)
    String tag_list;

    @DatabaseField(columnName = PRODUCT_BARCODE_LIST_FIELD_NAME)
    String barcode_list;

    @DatabaseField(columnName = PRODUCT_THUMBNAIL_URL_FIELD_NAME)
    String thumbnail_url;

    @DatabaseField(columnName = PRODUCT_UTC_CREATED_AT_FIELD_NAME)
    String utc_created_at;

    @DatabaseField(columnName = PRODUCT_UTC_UPDATED_AT_FIELD_NAME)
    String utc_updated_at;

    @DatabaseField(columnName = PRODUCT_STATUS_FIELD_NAME)
    String status;

    public Products() {
    }

    public Products(int id, String name, double cost, double retail_price) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.retail_price = retail_price;
    }

    public Products(int id, String name, String stock_no, double cost, double retail_price, double wholesale_price, String description, Boolean allow_decimal_quantities, Boolean disable_discount, Boolean disable_inventory, Boolean enable_open_price, Boolean tax_exempt, String tag_list, String barcode_list, String thumbnail_url, String utc_created_at, String utc_updated_at, String status) {
        this.id = id;
        this.name = name;
        this.stock_no = stock_no;
        this.cost = cost;
        this.retail_price = retail_price;
        this.wholesale_price = wholesale_price;
        this.description = description;
        this.allow_decimal_quantities = allow_decimal_quantities;
        this.disable_discount = disable_discount;
        this.disable_inventory = disable_inventory;
        this.enable_open_price = enable_open_price;
        this.tax_exempt = tax_exempt;
        this.tag_list = tag_list;
        this.barcode_list = barcode_list;
        this.thumbnail_url = thumbnail_url;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock_no='" + stock_no + '\'' +
                ", cost=" + cost +
                ", retail_price=" + retail_price +
                ", wholesale_price=" + wholesale_price +
                ", description='" + description + '\'' +
                ", allow_decimal_quantities=" + allow_decimal_quantities +
                ", disable_discount=" + disable_discount +
                ", disable_inventory=" + disable_inventory +
                ", enable_open_price=" + enable_open_price +
                ", tax_exempt=" + tax_exempt +
                ", tag_list='" + tag_list + '\'' +
                ", barcode_list='" + barcode_list + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", utc_created_at='" + utc_created_at + '\'' +
                ", utc_updated_at='" + utc_updated_at + '\'' +
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

    public String getStock_no() {
        return stock_no;
    }

    public void setStock_no(String stock_no) {
        this.stock_no = stock_no;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(double retail_price) {
        this.retail_price = retail_price;
    }

    public double getWholesale_price() {
        return wholesale_price;
    }

    public void setWholesale_price(double wholesale_price) {
        this.wholesale_price = wholesale_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isAllow_decimal_quantities() {
        return allow_decimal_quantities;
    }

    public void setAllow_decimal_quantities(Boolean allow_decimal_quantities) {
        this.allow_decimal_quantities = allow_decimal_quantities;
    }

    public Boolean isDisable_discount() {
        return disable_discount;
    }

    public void setDisable_discount(Boolean disable_discount) {
        this.disable_discount = disable_discount;
    }

    public Boolean isDisable_inventory() {
        return disable_inventory;
    }

    public void setDisable_inventory(Boolean disable_inventory) {
        this.disable_inventory = disable_inventory;
    }

    public Boolean isEnable_open_price() {
        return enable_open_price;
    }

    public void setEnable_open_price(Boolean enable_open_price) {
        this.enable_open_price = enable_open_price;
    }

    public Boolean isTax_exempt() {
        return tax_exempt;
    }

    public void setTax_exempt(Boolean tax_exempt) {
        this.tax_exempt = tax_exempt;
    }

    public String getTag_list() {
        return tag_list;
    }

    public void setTag_list(String tag_list) {
        this.tag_list = tag_list;
    }

    public String getBarcode_list() {
        return barcode_list;
    }

    public void setBarcode_list(String barcode_list) {
        this.barcode_list = barcode_list;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
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