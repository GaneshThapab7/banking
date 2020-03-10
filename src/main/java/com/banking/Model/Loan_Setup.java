package com.banking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "loan_setup")


public class Loan_Setup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;
    private String loan_type;
    private double from_rate;
    private double to_rate;
    private double actual_rate;

    // Empty Constructor
    public Loan_Setup() {
    }

    // Parameterized Constructor
    public Loan_Setup(int code, String loan_type, double from_rate, double to_rate, double actual_rate) {
        this.code = code;
        this.loan_type = loan_type;
        this.from_rate = from_rate;
        this.to_rate = to_rate;
        this.actual_rate = actual_rate;
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
        this.loan_type = loan_type;
    }

    public double getFrom_rate() {
        return from_rate;
    }

    public void setFrom_rate(double from_rate) {
        this.from_rate = from_rate;
    }

    public double getTo_rate() {
        return to_rate;
    }

    public void setTo_rate(double to_rate) {
        this.to_rate = to_rate;
    }

    public double getActual_rate() {
        return actual_rate;
    }

    public void setActual_rate(double actual_rate) {
        this.actual_rate = actual_rate;
    }
}

