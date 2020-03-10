package com.banking.Model;

import javax.persistence.*;


@Entity
@Table(name = "loans")

public class Loan {
    @Id

    private String loan_code;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_code",nullable = false)
    private Loan_Customer loan_customer;

    private Boolean approved_1;
    private Boolean approved_2;
    private Boolean approved_3;
    private Boolean approved_4;
    private Boolean approved_5;
    private Boolean approved_6;
    private Boolean approved_7;
    private String approval_code_1,approval_code_2,approval_code_3,approval_code_4,approval_code_5,approval_code_6,approval_code_7;


    // empty Constructor

    public Loan() {

    }

    // Parameterized Constructor

    public Loan(String loan_code, Loan_Customer loan_customer, Boolean approved_1, Boolean approved_2, Boolean approved_3, Boolean approved_4, Boolean approved_5, Boolean approved_6, Boolean approved_7, String approval_code_1, String approval_code_2, String approval_code_3, String approval_code_4, String approval_code_5, String approval_code_6, String approval_code_7) {
        this.loan_code = loan_code;
        this.loan_customer = loan_customer;
        this.approved_1 = approved_1;
        this.approved_2 = approved_2;
        this.approved_3 = approved_3;
        this.approved_4 = approved_4;
        this.approved_5 = approved_5;
        this.approved_6 = approved_6;
        this.approved_7 = approved_7;
        this.approval_code_1 = approval_code_1;

        this.approval_code_2 = approval_code_2;
        this.approval_code_3 = approval_code_3;
        this.approval_code_4 = approval_code_4;
        this.approval_code_5 = approval_code_5;
        this.approval_code_6 = approval_code_6;
        this.approval_code_7 = approval_code_7;
    }


    //Getter and Setter


    public String getLoan_code() {
        return loan_code;
    }

    public void setLoan_code(String loan_code) {
        this.loan_code = loan_code;
    }

    public Loan_Customer getLoan_customer() {
        return loan_customer;
    }

    public void setLoan_customer(Loan_Customer loan_customer) {
        this.loan_customer = loan_customer;
    }

    public Boolean getApproved_1() {
        return approved_1;
    }

    public void setApproved_1(Boolean approved_1) {
        this.approved_1 = approved_1;
    }

    public Boolean getApproved_2() {
        return approved_2;
    }

    public void setApproved_2(Boolean approved_2) {
        this.approved_2 = approved_2;
    }

    public Boolean getApproved_3() {
        return approved_3;
    }

    public void setApproved_3(Boolean approved_3) {
        this.approved_3 = approved_3;
    }

    public Boolean getApproved_4() {
        return approved_4;
    }

    public void setApproved_4(Boolean approved_4) {
        this.approved_4 = approved_4;
    }

    public Boolean getApproved_5() {
        return approved_5;
    }

    public void setApproved_5(Boolean approved_5) {
        this.approved_5 = approved_5;
    }

    public Boolean getApproved_6() {
        return approved_6;
    }

    public void setApproved_6(Boolean approved_6) {
        this.approved_6 = approved_6;
    }

    public Boolean getApproved_7() {
        return approved_7;
    }

    public void setApproved_7(Boolean approved_7) {
        this.approved_7 = approved_7;
    }

    public String getApproval_code_1() {
        return approval_code_1;
    }

    public void setApproval_code_1(String approval_code_1) {
        this.approval_code_1 = approval_code_1;
    }

    public String getApproval_code_2() {
        return approval_code_2;
    }

    public void setApproval_code_2(String approval_code_2) {
        this.approval_code_2 = approval_code_2;
    }

    public String getApproval_code_3() {
        return approval_code_3;
    }

    public void setApproval_code_3(String approval_code_3) {
        this.approval_code_3 = approval_code_3;
    }

    public String getApproval_code_4() {
        return approval_code_4;
    }

    public void setApproval_code_4(String approval_code_4) {
        this.approval_code_4 = approval_code_4;
    }

    public String getApproval_code_5() {
        return approval_code_5;
    }

    public void setApproval_code_5(String approval_code_5) {
        this.approval_code_5 = approval_code_5;
    }

    public String getApproval_code_6() {
        return approval_code_6;
    }

    public void setApproval_code_6(String approval_code_6) {
        this.approval_code_6 = approval_code_6;
    }

    public String getApproval_code_7() {
        return approval_code_7;
    }

    public void setApproval_code_7(String approval_code_7) {
        this.approval_code_7 = approval_code_7;
    }
}
