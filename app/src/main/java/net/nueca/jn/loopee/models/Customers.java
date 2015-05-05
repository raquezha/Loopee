package net.nueca.jn.loopee.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "Customers")
public class Customers {

    @DatabaseField(id = true)
    int id;

    @DatabaseField
    String code;

    @DatabaseField
    String alternate_code;

    @DatabaseField
    String first_name;

    @DatabaseField
    String last_name;

    @DatabaseField
    String name;

    @DatabaseField
    String company_name;

    @DatabaseField
    String tin;

    @DatabaseField
    String tax_excempt;

    @DatabaseField
    String street;

    @DatabaseField
    String city;

    @DatabaseField
    String state;

    @DatabaseField
    String zipcode;

    @DatabaseField
    String country;

    @DatabaseField
    String telephone;

    @DatabaseField
    String fax;

    @DatabaseField
    String mobile;

    @DatabaseField
    String email;

    @DatabaseField
    String remark;

    @DatabaseField
    String customer_type;

    @DatabaseField
    String customer_type_name;

    @DatabaseField
    String discount_text;

    @DatabaseField
    String available_points;

    @DatabaseField
    String birthdate;

    @DatabaseField
    String utc_created_at;

    @DatabaseField
    String utc_updated_at;

    @DatabaseField
    String status;

    public Customers(){ }

    public Customers(int id, String code, String alternate_code, String first_name, String last_name, String name, String company_name, String tin, String tax_excempt, String street, String city, String state, String zipcode, String country, String telephone, String fax, String mobile, String email, String remark, String customer_type, String customer_type_name, String discount_text, String available_points, String birthdate, String utc_created_at, String utc_updated_at, String status) {
        this.id = id;
        this.code = code;
        this.alternate_code = alternate_code;
        this.first_name = first_name;
        this.last_name = last_name;
        this.name = name;
        this.company_name = company_name;
        this.tin = tin;
        this.tax_excempt = tax_excempt;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
        this.telephone = telephone;
        this.fax = fax;
        this.mobile = mobile;
        this.email = email;
        this.remark = remark;
        this.customer_type = customer_type;
        this.customer_type_name = customer_type_name;
        this.discount_text = discount_text;
        this.available_points = available_points;
        this.birthdate = birthdate;
        this.utc_created_at = utc_created_at;
        this.utc_updated_at = utc_updated_at;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table_Customers{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", alternate_code='" + alternate_code + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", name='" + name + '\'' +
                ", company_name='" + company_name + '\'' +
                ", tin='" + tin + '\'' +
                ", tax_excempt='" + tax_excempt + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fax='" + fax + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", customer_type='" + customer_type + '\'' +
                ", customer_type_name='" + customer_type_name + '\'' +
                ", discount_text='" + discount_text + '\'' +
                ", available_points='" + available_points + '\'' +
                ", birthdate=" + birthdate +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlternate_code() {
        return alternate_code;
    }

    public void setAlternate_code(String alternate_code) {
        this.alternate_code = alternate_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getTax_excempt() {
        return tax_excempt;
    }

    public void setTax_excempt(String tax_excempt) {
        this.tax_excempt = tax_excempt;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }

    public String getDiscount_text() {
        return discount_text;
    }

    public void setDiscount_text(String discount_text) {
        this.discount_text = discount_text;
    }

    public String getAvailable_points() {
        return available_points;
    }

    public void setAvailable_points(String available_points) {
        this.available_points = available_points;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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
