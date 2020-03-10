package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "loan_customers")
public class Loan_Customer {
    @Id

    private String  customer_code;

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

    @NotNull
    private String contact_1;

    private String contact_2;

    private String citizenship_no;
    private String citizenship_file; // path of file that contain location on citizenship picture.
    private String occupation; // example - student, public sector, private sectors etc.
    private double tentative_yearly_income;
    private Boolean existing_customer;
    private double principal_amount; // asking loan amount;
    private int loan_duration; // in years
    private double emi_amount; // payments in installment;
    private double applicable_interest;
    private double risk_percentage;
    @NotNull
    private String date_of_birth;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_code",nullable = false)
    private Loan_Setup loan_setup;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_code",nullable = true)
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Loan_customer_nominee", joinColumns = @JoinColumn(name = "customer_code"), inverseJoinColumns = @JoinColumn(name = "relative_code"))
    private List<Relative_Nominee> nominees;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(name = "Loan_customer_documents", joinColumns = @JoinColumn(name = "customer_code"), inverseJoinColumns = @JoinColumn(name = "id"))
    private List<Document> documents;



    // Empty Constructor
    public Loan_Customer() {
    }

    //Parameterized Constructor

    public Loan_Customer(String customer_code, @NotNull String first_name, String middle_name, @NotNull String last_name, @NotNull String gender, @NotNull String p_address, @NotNull String p_district, @NotNull String p_country, @NotNull String t_address, @NotNull String t_district, @NotNull String t_country, @NotNull String contact_1, String contact_2, String citizenship_no, String citizenship_file, String occupation, double tentative_yearly_income, Boolean existing_customer, double principal_amount, int loan_duration, double emi_amount, double applicable_interest, double risk_percentage, @NotNull String date_of_birth, Loan_Setup loan_setup, Customer customer, List<Relative_Nominee> nominees, List<Document> documents) {
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
        this.contact_1 = contact_1;
        this.contact_2 = contact_2;
        this.citizenship_no = citizenship_no;
        this.citizenship_file = citizenship_file;
        this.occupation = occupation;
        this.tentative_yearly_income = tentative_yearly_income;
        this.existing_customer = existing_customer;
        this.principal_amount = principal_amount;
        this.loan_duration = loan_duration;
        this.emi_amount = emi_amount;
        this.applicable_interest = applicable_interest;
        this.risk_percentage = risk_percentage;
        this.date_of_birth = date_of_birth;
        this.loan_setup = loan_setup;
        this.customer = customer;
        this.nominees = nominees;
        this.documents = documents;
    }


    // Getter and Setter


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

    public Boolean getExisting_customer() {
        return existing_customer;
    }

    public void setExisting_customer(Boolean existing_customer) {
        this.existing_customer = existing_customer;
    }

    public double getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(double principal_amount) {
        this.principal_amount = principal_amount;
    }

    public int getLoan_duration() {
        return loan_duration;
    }

    public void setLoan_duration(int loan_duration) {
        this.loan_duration = loan_duration;
    }

    public double getEmi_amount() {
        return emi_amount;
    }

    public void setEmi_amount(double emi_amount) {
        this.emi_amount = emi_amount;
    }

    public double getApplicable_interest() {
        return applicable_interest;
    }

    public void setApplicable_interest(double applicable_interest) {
        this.applicable_interest = applicable_interest;
    }

    public double getRisk_percentage() {
        return risk_percentage;
    }

    public void setRisk_percentage(double risk_percentage) {
        this.risk_percentage = risk_percentage;
    }

    public Loan_Setup getLoan_setup() {
        return loan_setup;
    }

    public void setLoan_setup(Loan_Setup loan_setup) {
        this.loan_setup = loan_setup;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Relative_Nominee> getNominees() {
        return nominees;
    }

    public void setNominees(List<Relative_Nominee> nominees) {
        this.nominees = nominees;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }
}
