package com.drivehub.models;

import java.util.List;
import java.util.ArrayList;

public class Car {
    private String carID;
    private String brand;
    private String model;
    private String plateNumber;
    private List<String> photos;
    private double price;
    private CarOwner owner;
    private int imageResId; // φωτογραφία drawable
    private List<Review> reviews = new ArrayList<>();

    public Car(String carID, String brand, String model, String plateNumber,
               List<String> photos, double price, CarOwner owner, int imageResId) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.plateNumber = plateNumber;
        this.photos = photos;
        this.price = price;
        this.owner = owner;
        this.imageResId = imageResId;
    }

    private boolean isHidden = false;

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }


    public boolean isAvailable(String startDate, String endDate) {
        return true; // placeholder logic
    }

    public void updateInfo(Car newData) {
        this.brand = newData.brand;
        this.model = newData.model;
        this.price = newData.price;
        this.photos = newData.photos;
        this.imageResId = newData.imageResId;
    }

    public void addReview(Review review) {
        if (review != null && !isInappropriate(review.getComment())) {
            this.reviews.add(review);
        }
    }

    private boolean isInappropriate(String comment) {
        String[] bannedWords = {"βλάκας", "άχρηστο", "κακο", "ψεύτης"};
        comment = comment.toLowerCase();
        for (String bad : bannedWords) {
            if (comment.contains(bad)) return true;
        }
        return false;
    }

    // Getters
    public String getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public double getPrice() {
        return price;
    }

    public CarOwner getOwner() {
        return owner;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
