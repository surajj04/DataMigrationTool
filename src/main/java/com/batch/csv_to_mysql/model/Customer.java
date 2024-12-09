package com.batch.csv_to_mysql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    private String customerid;
    @Transient
    private String firstname;
    @Transient
    private String lastname;
    private String name;
    private String company;
    private String city;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String customerid, String firstname, String lastname, String name, String company, String city, String phone, String email) {
        this.customerid = customerid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.name = name;
        this.company = company;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
