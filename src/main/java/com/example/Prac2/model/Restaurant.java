package com.example.Prac2.model;

import jakarta.persistence.*;

@Entity
@Table(name="restaurant_info")
public class Restaurant {

    @Id
    @Column(name = "restaurant_id") // Have to use underscore naming due to issue in Hibernate 5 & naming rule not working.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int restaurantId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "avg_rating")
    private int avgRating;

    public Restaurant() {
    }

    public Restaurant(Integer restaurantId, String restaurantName, String foodType, int avgRating) {
        //this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.foodType = foodType;
        this.avgRating = avgRating;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    /*public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }*/

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(int avgRating) {
        this.avgRating = avgRating;
    }
}
