package com.example.tp_leboncoin;
import java.util.ArrayList;
import java.util.List;
public class AdModel {
    private static int nextId = 1; // Variable de classe pour suivre le prochain ID disponible

    private int id; // ID unique pour chaque instance
    private String title;
    private String address;
    private String image;

    // Constructor
    public AdModel(String title, String address, String image) {
        this.id = nextId++; // Attribuer l'ID actuel puis incrémente pour le prochain
        this.title = title;
        this.address = address;
        this.image = image;
    }

    // Getters (y compris pour l'ID) et Setters (sauf pour l'ID car il ne devrait pas être modifié après création)
    public int getId() {
        return id;
    }

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
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", image=" + image +
                '}';


    }
}

// Static list to manage AdModel instances
class AdListManager {
    private static ArrayList<AdModel> adList = new ArrayList<>();

    public static void addAd(AdModel ad) {
        adList.add(ad);
    }

    public static List<AdModel> adList() {
        if (adList.isEmpty()) {
            initializeSampleAds(); // Initialise les annonces si la liste est vide
        }
        return new ArrayList<>(adList); // Retourne une copie de la liste avec toutes les données
    }

    private static void initializeSampleAds() {
        adList.add(new AdModel("Dark Wood", "123 rue de Paris, Paris", "drawable/argile_rouge.jpg"));
        adList.add(new AdModel("Ciment Blanc", "45 allée des Fleurs, Nice", "drawable/bric_blanc.jpg"));
        adList.add(new AdModel("Brick blanche", "9 avenue de la République, Lyon", "drawable/brique_rouge.jpg"));
        adList.add(new AdModel("Brick Rouge", "9 avenue de la nation, Montpellier", "drawable/ciment_b.jpg"));
        adList.add(new AdModel("Argile Rouge", "9 avenue de la liberté, Lille", "drawable/wood_dark.jpg"));
    }
}


