package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "accounts")

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="book_generator", sequenceName = "book_seq", allocationSize=2010056700)
    private int account_no;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_code_1",nullable = false)
    private Customer customer1;


    @NotNull
    private String signature_1;

    private String endorsement;

    private Boolean on_loan;
    private double amount;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_type",nullable = true)
    private Loan_Setup loan_setup;

    private double loan_rate;
    private double emi; // emi
    private int completed_installment;
    private double principal_amount;
    private double total_interest;
    private Date loan_pay_Date;

    // Empty Constructor
    public Account() {
    }

    // Parameterized Constructor

    public Account(int account_no, Customer customer1, @NotNull String signature_1, String endorsement, Boolean on_loan, double amount, Loan_Setup loan_setup, double loan_rate, double emi, int completed_installment, double principal_amount, double total_interest, Date loan_pay_Date) {
        this.account_no = account_no;
        this.customer1 = customer1;
        this.signature_1 = signature_1;
        this.endorsement = endorsement;
        this.on_loan = on_loan;
        this.amount = amount;
        this.loan_setup = loan_setup;
        this.loan_rate = loan_rate;
        this.emi = emi;
        this.completed_installment = completed_installment;
        this.principal_amount = principal_amount;
        this.total_interest = total_interest;
        this.loan_pay_Date = loan_pay_Date;
    }


    // Getter and Setter


    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public Customer getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer customer1) {
        this.customer1 = customer1;
    }

    public String getSignature_1() {
        return signature_1;
    }

    public void setSignature_1(String signature_1) {
        this.signature_1 = signature_1;
    }

    public String getEndorsement() {
        return endorsement;
    }

    public void setEndorsement(String endorsement) {
        this.endorsement = endorsement;
    }

    public Boolean getOn_loan() {
        return on_loan;
    }

    public void setOn_loan(Boolean on_loan) {
        this.on_loan = on_loan;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Loan_Setup getLoan_setup() {
        return loan_setup;
    }

    public void setLoan_setup(Loan_Setup loan_setup) {
        this.loan_setup = loan_setup;
    }

    public double getLoan_rate() {
        return loan_rate;
    }

    public void setLoan_rate(double loan_rate) {
        this.loan_rate = loan_rate;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public int getCompleted_installment() {
        return completed_installment;
    }

    public void setCompleted_installment(int completed_installment) {
        this.completed_installment = completed_installment;
    }

    public double getPrincipal_amount() {
        return principal_amount;
    }

    public void setPrincipal_amount(double principal_amount) {
        this.principal_amount = principal_amount;
    }

    public double getTotal_interest() {
        return total_interest;
    }

    public void setTotal_interest(double total_interest) {
        this.total_interest = total_interest;
    }

    public Date getLoan_pay_Date() {
        return loan_pay_Date;
    }

    public void setLoan_pay_Date(Date loan_pay_Date) {
        this.loan_pay_Date = loan_pay_Date;
    }
}
