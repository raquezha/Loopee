package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Product_Branch_Prices")
public class Product_Branch_Prices {
    public final static String PRODUCT_ID_FIELD_NAME = "product_id";
    public final static String BRANCH_PRICES_ID_FIELD_NAME = "branch_prices_id";

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(foreign = true, columnName = PRODUCT_ID_FIELD_NAME)
    Products products;

    @DatabaseField(foreign = true, columnName = BRANCH_PRICES_ID_FIELD_NAME)
    Branch_Prices branch_prices;

    public Product_Branch_Prices() {
    }

    public Product_Branch_Prices(Products products, Branch_Prices branch_prices) {
        this.products = products;
        this.branch_prices = branch_prices;
    }

    @Override
    public String toString() {
        return "Product_Branch_Prices{" +
                "id=" + id +
                ", products=" + products +
                ", branch_prices=" + branch_prices +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Branch_Prices getBranch_prices() {
        return branch_prices;
    }

    public void setBranch_prices(Branch_Prices branch_prices) {
        this.branch_prices = branch_prices;
    }
}
