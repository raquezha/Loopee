package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Tax_Settings")
public class Tax_Settings {

    @DatabaseField(generatedId = true, allowGeneratedIdInsert=true)
    int id;

    Boolean compute_tax;

    @DatabaseField
    Boolean tax_inclusive;

    public Tax_Settings(){

    }

    public Tax_Settings(int id, Boolean compute_tax, Boolean tax_inclusive) {
        this.id = id;
        this.compute_tax = compute_tax;
        this.tax_inclusive = tax_inclusive;
    }

    @Override
    public String toString() {
        return "Tax_Settings{" +
                "id=" + id +
                ", compute_tax=" + compute_tax +
                ", tax_inclusive=" + tax_inclusive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getCompute_tax() {
        return compute_tax;
    }

    public void setCompute_tax(Boolean compute_tax) {
        this.compute_tax = compute_tax;
    }

    public Boolean getTax_inclusive() {
        return tax_inclusive;
    }

    public void setTax_inclusive(Boolean tax_inclusive) {
        this.tax_inclusive = tax_inclusive;
    }
}
