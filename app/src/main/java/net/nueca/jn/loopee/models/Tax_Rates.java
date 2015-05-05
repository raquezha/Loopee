package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Tax_Rates")
public class Tax_Rates {

    @DatabaseField(id = true)
    int id;

    @DatabaseField
    String branch_id;

    @DatabaseField
    String name;

    @DatabaseField
    Double value;

    @DatabaseField
    int tax_rate_type;

    @DatabaseField
    String status;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "product_id", canBeNull = true)
    private Products product;

    public Tax_Rates(){ }

    public Tax_Rates(int id, String branch_id, String name, Double value, int tax_rate_type, String status) {
        this.id = id;
        this.branch_id = branch_id;
        this.name = name;
        this.value = value;
        this.tax_rate_type = tax_rate_type;
        this.status = status;
    }

    public Tax_Rates(int id, String branch_id, String name, Double value, int tax_rate_type, String status, Products product) {
        this.id = id;
        this.branch_id = branch_id;
        this.name = name;
        this.value = value;
        this.tax_rate_type = tax_rate_type;
        this.status = status;
        this.product = product;
    }

    @Override
    public String toString() {
        return "Tax_Rates{" +
                "status='" + status + '\'' +
                ", id=" + id +
                ", branch_id='" + branch_id + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", tax_rate_type=" + tax_rate_type +
                ", product=" + product +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getTax_rate_type() {
        return tax_rate_type;
    }

    public void setTax_rate_type(int tax_rate_type) {
        this.tax_rate_type = tax_rate_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
