package com.banking.Model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")

public class users {
    @Id
    public String emp_code;

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

    private String photo ; // path or location of photo file is to be stored.
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String contact_1;

    private String contact_2;

    private String role;

    @NotNull
    private String position; // Only for non-teller users
    @NotNull
    private String department; // example loan or non-loan
    private String date_of_birth;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "branch_user", joinColumns = @JoinColumn(name = "emp_code"), inverseJoinColumns = @JoinColumn(name = "branch_code"))
    private List<Branches> work_station;

    private Boolean archived;

    // Empty Constructor
    public users() {
    }

    // Parameterized Constructor


    public users(String emp_code, @NotNull String first_name, String middle_name, @NotNull String last_name, @NotNull String gender, @NotNull String p_address, @NotNull String p_district, @NotNull String p_country, @NotNull String t_address, @NotNull String t_district, @NotNull String t_country, String photo, @NotNull String username, @NotNull String password, @NotNull String contact_1, String contact_2, String role, @NotNull String position, @NotNull String department, String date_of_birth, List<Branches> work_station, Boolean archived) {
        this.emp_code = emp_code;
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
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.contact_1 = contact_1;
        this.contact_2 = contact_2;
        this.role = role;
        this.position = position;
        this.department = department;
        this.date_of_birth = date_of_birth;
        this.work_station = work_station;
        this.archived = archived;
    }

    public String getEmp_code() {
        return emp_code;
    }

    public void setEmp_code(String emp_code) {
        this.emp_code = emp_code;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<Branches> getWork_station() {
        return work_station;
    }

    public void setWork_station(List<Branches> work_station) {
        this.work_station = work_station;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

}
