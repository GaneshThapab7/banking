package com.banking.Model;

import javax.persistence.*;

@Entity
@Table(name = "loan_approver")
public class Loan_Approver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int approval_number_1,approval_number_2,approval_number_3,approval_number_4,approval_number_5,approval_number_6,approval_number_7;
    private String approval_code_1,approval_code_2,approval_code_3,approval_code_4,approval_code_5,approval_code_6,approval_code_7;
    private String approval_position_1,approval_position_2,approval_position_3,approval_position_4,approval_position_5,approval_position_6,approval_position_7;

    public Loan_Approver(int id, int approval_number_1, int approval_number_2, int approval_number_3, int approval_number_4, int approval_number_5, int approval_number_6, int approval_number_7, String approval_code_1, String approval_code_2, String approval_code_3, String approval_code_4, String approval_code_5, String approval_code_6, String approval_code_7, String approval_position_1, String approval_position_2, String approval_position_3, String approval_position_4, String approval_position_5, String approval_position_6, String approval_position_7) {
        this.id = id;
        this.approval_number_1 = approval_number_1;
        this.approval_number_2 = approval_number_2;
        this.approval_number_3 = approval_number_3;
        this.approval_number_4 = approval_number_4;
        this.approval_number_5 = approval_number_5;
        this.approval_number_6 = approval_number_6;
        this.approval_number_7 = approval_number_7;
        this.approval_code_1 = approval_code_1;
        this.approval_code_2 = approval_code_2;
        this.approval_code_3 = approval_code_3;
        this.approval_code_4 = approval_code_4;
        this.approval_code_5 = approval_code_5;
        this.approval_code_6 = approval_code_6;
        this.approval_code_7 = approval_code_7;
        this.approval_position_1 = approval_position_1;
        this.approval_position_2 = approval_position_2;
        this.approval_position_3 = approval_position_3;
        this.approval_position_4 = approval_position_4;
        this.approval_position_5 = approval_position_5;
        this.approval_position_6 = approval_position_6;
        this.approval_position_7 = approval_position_7;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApproval_number_1() {
        return approval_number_1;
    }

    public void setApproval_number_1(int approval_number_1) {
        this.approval_number_1 = approval_number_1;
    }

    public int getApproval_number_2() {
        return approval_number_2;
    }

    public void setApproval_number_2(int approval_number_2) {
        this.approval_number_2 = approval_number_2;
    }

    public int getApproval_number_3() {
        return approval_number_3;
    }

    public void setApproval_number_3(int approval_number_3) {
        this.approval_number_3 = approval_number_3;
    }

    public int getApproval_number_4() {
        return approval_number_4;
    }

    public void setApproval_number_4(int approval_number_4) {
        this.approval_number_4 = approval_number_4;
    }

    public int getApproval_number_5() {
        return approval_number_5;
    }

    public void setApproval_number_5(int approval_number_5) {
        this.approval_number_5 = approval_number_5;
    }

    public int getApproval_number_6() {
        return approval_number_6;
    }

    public void setApproval_number_6(int approval_number_6) {
        this.approval_number_6 = approval_number_6;
    }

    public int getApproval_number_7() {
        return approval_number_7;
    }

    public void setApproval_number_7(int approval_number_7) {
        this.approval_number_7 = approval_number_7;
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

    public String getApproval_position_1() {
        return approval_position_1;
    }

    public void setApproval_position_1(String approval_position_1) {
        this.approval_position_1 = approval_position_1;
    }

    public String getApproval_position_2() {
        return approval_position_2;
    }

    public void setApproval_position_2(String approval_position_2) {
        this.approval_position_2 = approval_position_2;
    }

    public String getApproval_position_3() {
        return approval_position_3;
    }

    public void setApproval_position_3(String approval_position_3) {
        this.approval_position_3 = approval_position_3;
    }

    public String getApproval_position_4() {
        return approval_position_4;
    }

    public void setApproval_position_4(String approval_position_4) {
        this.approval_position_4 = approval_position_4;
    }

    public String getApproval_position_5() {
        return approval_position_5;
    }

    public void setApproval_position_5(String approval_position_5) {
        this.approval_position_5 = approval_position_5;
    }

    public String getApproval_position_6() {
        return approval_position_6;
    }

    public void setApproval_position_6(String approval_position_6) {
        this.approval_position_6 = approval_position_6;
    }

    public String getApproval_position_7() {
        return approval_position_7;
    }

    public void setApproval_position_7(String approval_position_7) {
        this.approval_position_7 = approval_position_7;
    }
}
