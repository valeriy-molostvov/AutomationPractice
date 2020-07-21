package utils;

import lombok.Builder;


@Builder(toBuilder = true)
public class BuilderRegistration {
    public String gender;
    private String first_name;
    private String last_name;
    private String password;
    private int day;
    private int month;
    private String year;
    private String address;
    private String city;
    private String state;
    private String zip_code;
    private String country;
    private String additional_information;
    private String mobile_phone;
    private String address_alias;
    public BuilderRegistration(String gender, String first_name, String last_name, String password, int day, int month, String year, String address, String city, String state, String zip_code, String country, String additional_information, String mobile_phone, String address_alias) {
        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.country = country;
        this.additional_information = additional_information;
        this.mobile_phone = mobile_phone;
        this.address_alias = address_alias;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getAddress_alias() {
        return address_alias;
    }

    public void setAddress_alias(String address_alias) {
        this.address_alias = address_alias;
    }
}


//        BuilderRegistration.builder()
//        .gender("Ms.")
//        .first_name("Hell")
//        .last_name("Yeah")
//        .password("11111")
//        .day(20)
//        .month(3)
//        .year("1996")
//        .address("Hello kitty street, 19")
//        .city("Miami")
//        .state("Florida")
//        .zip_code("12345")
//        .country("United States")
//        .additional_information("Hate women clothes")
//        .mobile_phone("99129045")
//        .address_alias("Miami Beach")
//        .build()