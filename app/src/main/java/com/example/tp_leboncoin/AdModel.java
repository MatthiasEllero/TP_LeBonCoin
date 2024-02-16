package com.example.tp_leboncoin;
import java.util.ArrayList;
import java.util.List;
public class AdModel {
    private static int nextId = 1; // Variable de classe pour suivre le prochain ID disponible

    private int id; // ID unique pour chaque instance
    private String title;
    private String address;
    private int image;

    // Constructor
    public AdModel(String title, String address, int image) {
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
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
    public static ArrayList<AdModel> adList = new ArrayList<>();

    public static void addAd(AdModel ad) {
        adList.add(ad);
    }

    public static void initializeSampleAds() {
        adList.add(new AdModel("Dark Wood", "123 rue de Paris, Paris", R.drawable.wood_dark)); // Assuming 0 as a placeholder for image ID
        adList.add(new AdModel("Ciment Blanc", "45 allée des Fleurs, Nice",R.drawable.ciment_b));
        adList.add(new AdModel("Brick blanche", "9 avenue de la République, Lyon", R.drawable.bric_blanc));
        adList.add(new AdModel("Argile Rouge","19 rue du Trieu de Quesnoy,LEERS",R.drawable.argile_rouge));
        adList.add(new AdModel("Bric Rouge","340, avenue Pierre de Coubertin, Carrières sous Poissy",R.drawable.brick_rouge));
    }
}


