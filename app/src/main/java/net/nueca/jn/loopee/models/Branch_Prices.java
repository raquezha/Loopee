package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "BranchPrices")
public class Branch_Prices {

    @DatabaseField(id = true)
    int branch_id;

    @DatabaseField
    Double retail_price;

    @DatabaseField
    Double wholesale_price;

    @DatabaseField
    Date utc_created_at;

    @DatabaseField
    Date utc_updated_at;

    @DatabaseField
    String status;


}
