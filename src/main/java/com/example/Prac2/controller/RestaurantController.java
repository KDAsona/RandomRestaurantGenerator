package com.example.Prac2.controller;

import com.example.Prac2.model.Restaurant;
import com.example.Prac2.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Our controller layer.
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("{restaurantID}")
    public Restaurant getRestaurantDetails(@PathVariable("restaurantID") String vendorId) {
        return restaurantService.getRestaurant(vendorId);
    }

    @PostMapping
    public String createRestaurantDetails(@RequestBody Restaurant restaurant) {
        restaurantService.createRestaurant(restaurant);
        return "Cloud Vendor Created Successfully.";
    }

    @PutMapping
    public String updateRestaurantDetails(@RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(restaurant);
        return "Cloud Vendor Updated Successfully.";
    }

    @DeleteMapping("{restaurantID}") // This means in our case, we need to append /restaurantID to the URL when sending the request.
    public String deleteRestaurantDetails(@PathVariable("restaurantID") String restaurantID) {
        restaurantService.deleteRestaurant(restaurantID);
        return "Cloud Vendor Deleted Successfully.";
    }

    @GetMapping
    public List<Restaurant> getAllRestaurantDetails() {
        return restaurantService.getAllRestaurants();
    }

    // GET all types of restaurants stored here in the database.
    @GetMapping("/allTypes")
    public List<String> getAllFoodTypes() {
        System.out.println("Get All Food Types is called.");
        return restaurantService.getAllFoodTypes();
    }

    // GET all restaurants that serves a certain type of food.
    // URL example: localhost:8080/restaurant/type?foodType=Chinese
    @GetMapping("/type")
    public List<Restaurant> getRestaurantsByType(@RequestParam String foodType) {
        System.out.println("getRestaurantsByType is called.");
        return restaurantService.getRestaurantsByType(foodType);
    }

    // GET the restaurant with the highest rating for a specific type.
    // URL example: localhost:8080/restaurant/best/type?foodType=Chinese
    // Use + to replace space character in param value.
    @GetMapping("/best/type")
    public Restaurant getBestByType(@RequestParam String foodType) {
        return restaurantService.getBestByType(foodType);
    }

    // GET the restaurant with highest rating among all.
    // URL example: localhost:8080/restaurant/best/overall

    @GetMapping("/best/overall")
    public Restaurant getBestOverall() {
        return restaurantService.getBestOverall();
    }
}
