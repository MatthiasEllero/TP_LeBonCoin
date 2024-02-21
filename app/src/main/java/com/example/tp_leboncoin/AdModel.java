package com.example.tp_leboncoin;

import java.util.ArrayList;
import java.util.List;

public class AdModel {
    private static int nextId = 1; // Variable de classe pour suivre le prochain ID disponible

    private String title;
    private String address;
    private String phone; // Nouveau champ téléphone
    private String image;

    // Constructor
    public AdModel(String title, String address, String phone, String image) {
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.image = image;
    }

    // Getters et Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // toString Method
    @Override
    public String toString() {
        return "AdModel{" +
                "title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
