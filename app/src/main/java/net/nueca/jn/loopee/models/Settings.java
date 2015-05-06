package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Settings")
public class Settings {

    public final static String SETTINGS_ID_FIELD_NAME = "id";
    public final static String SETTINGS_NAME_FIELD_NAME = "name";
    public final static String SETTINGS_VALUE_FIELD_NAME = "value";

    @DatabaseField(generatedId = true, columnName = SETTINGS_ID_FIELD_NAME)
    int id;

    @DatabaseField(columnName = SETTINGS_NAME_FIELD_NAME)
    String name;

    @DatabaseField(columnName = SETTINGS_VALUE_FIELD_NAME)
    String value;

    public Settings(){}

    public Settings(int id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
