package net.nueca.jn.loopee.database;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import net.nueca.jn.loopee.models.Branches;
import net.nueca.jn.loopee.models.Customers;
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

    private static final Class<?>[] classes = new Class[]{Session.class, Settings.class, Branches.class, Tax_Settings.class, Tax_Rates.class, Users.class, Products.class, Product_Tax_Rates.class, Customers.class};

    public static void main(String[] args) throws IOException, SQLException {
        writeConfigFile("ormlite_config.txt", classes);
    }
}

