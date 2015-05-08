package net.nueca.jn.loopee.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import net.nueca.jn.loopee.models.Branch_Prices;
import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
import net.nueca.jn.loopee.models.Product_Branch_Prices;
import net.nueca.jn.loopee.models.Product_Tax_Rates;
import net.nueca.jn.loopee.models.Products;
import net.nueca.jn.loopee.models.Session;
import net.nueca.jn.loopee.models.Settings;
import net.nueca.jn.loopee.models.Tax_Rates;
import net.nueca.jn.loopee.models.Tax_Settings;
import net.nueca.jn.loopee.models.Users;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseConfigUtility extends OrmLiteConfigUtil{

    private static final Class<?>[] classes = new Class[]{
            Session.class,
            Settings.class,
            Branches.class,
            Tax_Settings.class,
            Tax_Rates.class,
            Branch_Prices.class,
            Users.class,
            Products.class,
            Customers.class,
            Product_Tax_Rates.class,
            Product_Branch_Prices.class};

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt", classes);
    }
}

