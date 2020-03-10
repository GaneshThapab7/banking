package com.banking.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tellers")
public class Teller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String teller_code;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "branch_code",nullable = false)
    private  Branches branches;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "emp_code",nullable=true,unique = true)
    private users users;

    private String full_name;


    private String from_date;

    private String to_date;

    public Teller() {
    }

    public Teller(int id, @NotNull String teller_code, Branches branches, users users, String full_name, String from_date, String to_date) {
        this.id = id;
        this.teller_code = teller_code;
        this.branches = branches;
        this.users = users;
        this.full_name = full_name;
        this.from_date = from_date;
        this.to_date = to_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeller_code() {
        return teller_code;
    }

    public void setTeller_code(String teller_code) {
        this.teller_code = teller_code;
    }

    public Branches getBranches() {
        return branches;
    }

    public void setBranches(Branches branches) {
        this.branches = branches;
    }

    public users getUsers() {
        return users;
    }

    public void setUsers(users users) {
        this.users = users;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }
}
