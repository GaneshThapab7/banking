package com.banking.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.TrueFalseType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    private String transaction_code;
    private double credit_debit; // enter amount for credit and debit
    private String trans_type; // normal or loan transaction

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "account_transactions", joinColumns = @JoinColumn(name = "transaction_code"), inverseJoinColumns = @JoinColumn(name = ""))
    private List<Account> accounts;

    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp trans_datetime;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "branch_code",nullable = false)
    private Branches branches;
    @Column(name = "PrimaryFormation", nullable = true)
    private String remarks;

    //Empty Constructor


    public Transaction() {
    }

    // Parameterized Constructor

    public Transaction(String transaction_code, double credit_debit, String trans_type, List<Account> accounts, Timestamp trans_datetime, Branches branches, String remarks) {
        this.transaction_code = transaction_code;
        this.credit_debit = credit_debit;
        this.trans_type = trans_type;
        this.accounts = accounts;
        this.trans_datetime = trans_datetime;
        this.branches = branches;
        this.remarks = remarks;
    }

    //Getter and Setter

    public String getTransaction_code() {
        return transaction_code;
    }

    public void setTransaction_code(String transaction_code) {
        this.transaction_code = transaction_code;
    }

    public double getCredit_debit() {
        return credit_debit;
    }

    public void setCredit_debit(double credit_debit) {
        this.credit_debit = credit_debit;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Timestamp getTrans_datetime() {
        return trans_datetime;
    }

    public void setTrans_datetime(Timestamp trans_datetime) {
        this.trans_datetime = trans_datetime;
    }

    public Branches getBranches() {
        return branches;
    }

    public void setBranches(Branches branches) {
        this.branches = branches;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
