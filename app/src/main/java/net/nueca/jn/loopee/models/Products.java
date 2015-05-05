package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;

@DatabaseTable(tableName = "Products")
public class Products {

    @DatabaseField(id = true)
    int id;

    @DatabaseField
    String name;

    @DatabaseField
    String stock_no;

    @DatabaseField
    double cost;

    @DatabaseField
    double retail_price;

    @DatabaseField
    double wholesale_price;

    @DatabaseField
    String description;

    @DatabaseField
    Boolean allow_decimal_quantities;

    @DatabaseField
    Boolean disable_discount;

    @DatabaseField
    Boolean disable_inventory;

    @DatabaseField
    Boolean enable_open_price;

    @DatabaseField
    Boolean tax_exempt;

    @DatabaseField
    String tag_list;

    @DatabaseField
    String barcode_list;

    @DatabaseField
    String thumbnail_url;

    @DatabaseField
    String branch_prices;

    @ForeignCollectionField(eager = false)
    Collection<Tax_Rates> product_tax_rates;

    @DatabaseField
    String utc_created_at;

    @DatabaseField
    String utc_updated_at;

    @DatabaseField
    String status;

    public Products() { }

    public Products(int id, String name, double cost, double retail_price) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.retail_price = retail_price;
    }

    public Products(int id, String name, String stock_no, double cost, double retail_price, double wholesale_price, String description, Boolean allow_decimal_quantities, Boolean disable_discount, Boolean disable_inventory, Boolean enable_open_price, Boolean tax_exempt, String tag_list, String barcode_list, String thumbnail_url, String branch_prices, String utc_created_at, String utc_updated_at, String status) {
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
        this.branch_prices = branch_prices;
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
                ", branch_prices='" + branch_prices + '\'' +
                ", product_tax_rates=" + product_tax_rates +
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

    public String getBranch_prices() {
        return branch_prices;
    }

    public void setBranch_prices(String branch_prices) {
        this.branch_prices = branch_prices;
    }

    public Collection<Tax_Rates> getProduct_tax_rates() {
        return product_tax_rates;
    }

    public void setProduct_tax_rates(Collection<Tax_Rates> product_tax_rates) {
        this.product_tax_rates = product_tax_rates;
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