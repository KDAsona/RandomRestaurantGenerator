package com.example.Prac2.service;

import com.example.Prac2.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public String createRestaurant(Restaurant restaurant);
    public String updateRestaurant(Restaurant restaurant);
    public String deleteRestaurant(String cloudVendorId);
    public Restaurant getRestaurant(String cloudVendorId);
    public List<Restaurant> getAllRestaurants(); // Fetch all data available, no arg needed.
    public List<Restaurant> getRestaurantsByType(String type);
    public Restaurant getBestByType(String type);
    public Restaurant getBestOverall();
    public List<String> getAllFoodTypes();
}
