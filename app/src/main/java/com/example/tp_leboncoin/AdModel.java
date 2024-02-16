package com.example.tp_leboncoin;
import java.util.ArrayList;
import java.util.List;
public class AdModel {
    private static int nextId = 1; // Variable de classe pour suivre le prochain ID disponible

    private String title;
    private String address;
    private String image;

    // Constructor
    public AdModel(String title, String address, String image) {
        this.title = title;
        this.address = address;
        this.image = image;
    }

    // Getters (y compris pour l'ID) et Setters (sauf pour l'ID car il ne devrait pas être modifié après création)


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
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", image=" + image +
                '}';


    }
}


