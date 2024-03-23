package com.example.Prac2.service.impl;

import com.example.Prac2.model.Restaurant;
import com.example.Prac2.repository.RestaurantRepository;
import com.example.Prac2.service.RestaurantService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public String createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant); // Let the repo handle save/insert op.
        return "Success";
    }

    @Override
    public String updateRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant); // Let the repo handle update op. (magic trick?)
        return "Success";
    }

    @Override
    public String deleteRestaurant(String cloudVendorId) {
        restaurantRepository.deleteById(cloudVendorId);
        //restaurantRepository.deleteByName()
        return "Success";
    }

    @Override
    public Restaurant getRestaurant(String cloudVendorId) {
        return restaurantRepository.findById(cloudVendorId).get(); // Return a retrieved cloud vendor object.
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantsByType(String type) {
        return restaurantRepository.findByType(type);
    }

    @Override
    public Restaurant getBestByType(String type) {
        int pageSize = 1; // for the top result
        int pageNumber = 0; // start from the first page
        Pageable limit = PageRequest.of(pageNumber, pageSize);

        return restaurantRepository.findBestByType(type, limit).get(0);
    }

    @Override
    public Restaurant getBestOverall() {
        int pageSize = 1; // for the top result
        int pageNumber = 0; // start from the first page
        Pageable limit = PageRequest.of(pageNumber, pageSize);
        return restaurantRepository.findBestOverall(limit).get(0);
    }

    @Override
    public List<String> getAllFoodTypes() {
        return restaurantRepository.findAllFoodTypes();
    }
}
