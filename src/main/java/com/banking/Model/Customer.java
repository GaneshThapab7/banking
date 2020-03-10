package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "customers")

public class Customer {
    @Id
    private String customer_code;

    @NotNull
    private String first_name;

    private String middle_name;

    @NotNull
    private String last_name;
    @NotNull
    private String gender;
    @NotNull
    private String p_address; // permanent address
    @NotNull
    private String p_district; // district of permanent address
    @NotNull
    private String p_country; // country of permanent address
    @NotNull
    private String t_address; // temporary address
    @NotNull
    private String t_district; // district of temporary address
    @NotNull
    private String t_country; // country of temporary address

    private String photo ; // path or location of photo file is to be stored.
    @NotNull
    private String contact_1;

    private String contact_2;

    private String citizenship_no;
    private String citizenship_file; // path of file that contain location on citizenship picture.
    private String occupation; // example - student, public sector, private sectors etc.
    private double tentative_yearly_income;
    private Boolean archived;
    @NotNull
    private String date_of_birth;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_relatives", joinColumns = @JoinColumn(name = "customer_code"), inverseJoinColumns = @JoinColumn(name = "relative_code"))
    private List<Relative_Nominee> relatives;

    // Empty Constructor
    public Customer() {
    }

    // Parameterized Constructor

    public Customer(String customer_code, @NotNull String first_name, String middle_name, @NotNull String last_name, @NotNull String gender, @NotNull String p_address, @NotNull String p_district, @NotNull String p_country, @NotNull String t_address, @NotNull String t_district, @NotNull String t_country, @NotNull String photo, @NotNull String contact_1, String contact_2, String citizenship_no, String citizenship_file, String occupation, double tentative_yearly_income, Boolean archived, @NotNull String date_of_birth, List<Relative_Nominee> relatives) {
        this.customer_code = customer_code;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.p_address = p_address;
        this.p_district = p_district;
        this.p_country = p_country;
        this.t_address = t_address;
        this.t_district = t_district;
        this.t_country = t_country;
        this.photo = photo;
        this.contact_1 = contact_1;
        this.contact_2 = contact_2;
        this.citizenship_no = citizenship_no;
        this.citizenship_file = citizenship_file;
        this.occupation = occupation;
        this.tentative_yearly_income = tentative_yearly_income;
        this.archived = archived;
        this.date_of_birth = date_of_birth;
        this.relatives = relatives;
    }


    //Getter and Setter


    public String getCustomer_code() {
        return customer_code;
    }

    public void setCustomer_code(String customer_code) {
        this.customer_code = customer_code;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_district() {
        return p_district;
    }

    public void setP_district(String p_district) {
        this.p_district = p_district;
    }

    public String getP_country() {
        return p_country;
    }

    public void setP_country(String p_country) {
        this.p_country = p_country;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_district() {
        return t_district;
    }

    public void setT_district(String t_district) {
        this.t_district = t_district;
    }

    public String getT_country() {
        return t_country;
    }

    public void setT_country(String t_country) {
        this.t_country = t_country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContact_1() {
        return contact_1;
    }

    public void setContact_1(String contact_1) {
        this.contact_1 = contact_1;
    }

    public String getContact_2() {
        return contact_2;
    }

    public void setContact_2(String contact_2) {
        this.contact_2 = contact_2;
    }

    public String getCitizenship_no() {
        return citizenship_no;
    }

    public void setCitizenship_no(String citizenship_no) {
        this.citizenship_no = citizenship_no;
    }

    public String getCitizenship_file() {
        return citizenship_file;
    }

    public void setCitizenship_file(String citizenship_file) {
        this.citizenship_file = citizenship_file;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getTentative_yearly_income() {
        return tentative_yearly_income;
    }

    public void setTentative_yearly_income(double tentative_yearly_income) {
        this.tentative_yearly_income = tentative_yearly_income;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<Relative_Nominee> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Relative_Nominee> relatives) {
        this.relatives = relatives;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
