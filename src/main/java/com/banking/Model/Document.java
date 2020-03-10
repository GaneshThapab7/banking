package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "documents")

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_code",nullable = true)
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_customer_code",nullable = true)
    private Loan_Customer loan_customer;

    private String picture; // path of the file is to be stored.
    private String Remarks;
    private String doc_package_code;

    // Empty Constructor
    public Document() {
    }

    // Parameterized Constructor


    public Document(int id, Customer customer, Loan_Customer loan_customer, String picture, String remarks, String doc_package_code) {
        this.id = id;
        this.customer = customer;
        this.loan_customer = loan_customer;
        this.picture = picture;
        Remarks = remarks;
        this.doc_package_code = doc_package_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public String getDoc_package_code() {
        return doc_package_code;
    }

    public void setDoc_package_code(String doc_package_code) {
        this.doc_package_code = doc_package_code;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Loan_Customer getLoan_customer() {
        return loan_customer;
    }

    public void setLoan_customer(Loan_Customer loan_customer) {
        this.loan_customer = loan_customer;
    }
}
