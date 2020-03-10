package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "branches")
public class Branches {
    @Id
    private String branch_code; // primary key

    @NotNull
    private String branch_name; // mostly address name
    @NotNull
    private String branch_address;
    @NotNull
    private String branch_district;

    private double loan_limit;

    private boolean archived;



    // Empty Constructor
    public Branches() {
    }

    // Parameterized Constructor

    public Branches(String branch_code, @NotNull String branch_name, @NotNull String branch_address, @NotNull String branch_district, double loan_limit, boolean archived) {
        this.branch_code = branch_code;
        this.branch_name = branch_name;
        this.branch_address = branch_address;
        this.branch_district = branch_district;
        this.loan_limit = loan_limit;
        this.archived = archived;
    }


    // Getters and Setters


    public String getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(String branch_code) {
        this.branch_code = branch_code;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_address() {
        return branch_address;
    }

    public void setBranch_address(String branch_address) {
        this.branch_address = branch_address;
    }

    public String getBranch_district() {
        return branch_district;
    }

    public void setBranch_district(String branch_district) {
        this.branch_district = branch_district;
    }

    public double getLoan_limit() {
        return loan_limit;
    }

    public void setLoan_limit(double loan_limit) {
        this.loan_limit = loan_limit;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }
}
