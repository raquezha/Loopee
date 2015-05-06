package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Users")
public class Users {

    public final static String USERS_ID_FIELD_NAME = "id";
    public final static String USERS_EMAIL_FIELD_NAME = "email";
    public final static String USERS_NAME_FIELD_NAME = "name";
    public final static String USERS_HOME_BRANCH_FIELD_NAME = "home_branch";
    public final static String USERS_ROLE_CODE_FIELD_NAME = "role_code";
    public final static String USERS_UTC_CREATED_AT_FIELD_NAME = "utc_created_at";
    public final static String USERS_UTC_UPDATED_AT_FIELD_NAME = "utc_updated_at";
    public final static String USERS_STATUS_FIELD_NAME = "status";

    @DatabaseField(id = true, columnName = USERS_ID_FIELD_NAME)
    int id;

    @DatabaseField(columnName = USERS_EMAIL_FIELD_NAME)
    String email;

    @DatabaseField(columnName = USERS_NAME_FIELD_NAME)
    String name;

    @DatabaseField(columnName = USERS_HOME_BRANCH_FIELD_NAME)
    int home_branch_id;

    @DatabaseField(columnName = USERS_ROLE_CODE_FIELD_NAME)
    String role_code;

    @DatabaseField(columnName = USERS_UTC_CREATED_AT_FIELD_NAME)
    String utc_created_at;

    @DatabaseField(columnName = USERS_UTC_UPDATED_AT_FIELD_NAME)
    String utc_updated_at;

    @DatabaseField(columnName = USERS_STATUS_FIELD_NAME)
    String status;

    public Users(){ }

    public Users(String email, int id, String name, int home_branch_id, String role_code, String utc_created_at, String utc_updated_at, String status) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.home_branch_id = home_branch_id;
        this.role_code = role_code;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table_Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", home_branch_id=" + home_branch_id +
                ", email='" + email + '\'' +
                ", role_code='" + role_code + '\'' +
                ", utc_created_at=" + utc_created_at +
                ", utc_updated_at=" + utc_updated_at +
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

    public int getHome_branch_id() {
        return home_branch_id;
    }

    public void setHome_branch_id(int home_branch_id) {
        this.home_branch_id = home_branch_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
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
