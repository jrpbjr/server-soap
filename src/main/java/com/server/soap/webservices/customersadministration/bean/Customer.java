package com.server.soap.webservices.customersadministration.bean;

import java.math.BigInteger;

public class Customer {
    private BigInteger id;
    private String name;
    private String phone;
    private String email;

    public Customer(BigInteger id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return String.format("Customer [id=%s, name=%s, phone=%s, email=%s]", id, name, phone, email);
    }
}
