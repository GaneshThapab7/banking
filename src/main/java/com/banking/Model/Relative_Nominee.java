package com.banking.Model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "relatives_nominees")

public class Relative_Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int relative_code;

    @NotNull
    private String first_name;

    private String middle_name;

    @NotNull
    private String last_name;

    @NotNull
    private String relation;


    //Empty Constructor

    public Relative_Nominee() {
    }

    public Relative_Nominee(int relative_code, @NotNull String first_name, String middle_name, @NotNull String last_name, @NotNull String relation) {
        this.relative_code = relative_code;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.relation = relation;
//        this.relative_type = relative_type;
    }

    public int getRelative_code() {
        return relative_code;
    }

    public void setRelative_code(int relative_code) {
        this.relative_code = relative_code;
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

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }


    @Override
    public String toString() {
        return "Relative_Nominee{" +
                "relative_code=" + relative_code +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", relation='" + relation + '\'' +
                '}';
    }
}



