package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Product_Tax_Rates")
public class Product_Tax_Rates {

    public final static String PRODUCT_ID_FIELD_NAME = "user_id";
    public final static String TAX_RATE_ID_FIELD_NAME = "post_id";

    @DatabaseField(generatedId = true)
    int id;

    @DatabaseField(foreign = true, columnName = PRODUCT_ID_FIELD_NAME)
    Products products;

    @DatabaseField(foreign = true, columnName = TAX_RATE_ID_FIELD_NAME)
    Tax_Rates tax_rates;

    public Product_Tax_Rates() {

    }

    public Product_Tax_Rates(Products products, Tax_Rates tax_rates) {
        this.products = products;
        this.tax_rates = tax_rates;
    }

    @Override
    public String toString() {
        return "Product_Tax_Rates{" +
                "id=" + id +
                ", products=" + products +
                ", tax_rates=" + tax_rates +
                '}';
    }


    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Tax_Rates getTax_rates() {
        return tax_rates;
    }

    public void setTax_rates(Tax_Rates tax_rates) {
        this.tax_rates = tax_rates;
    }
}
