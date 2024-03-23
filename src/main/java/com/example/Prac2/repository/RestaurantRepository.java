package com.example.Prac2.repository;

import com.example.Prac2.model.Restaurant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


// Repository layer.
// Separation of business & db layers.
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    /*
        Notes:
        1. For object name selected, use entity name in Java code, not the Table name in mySQL
        2. Same applied for column. In this case, foodType, not food_type.
     */
    @Query("SELECT e FROM Restaurant e WHERE e.foodType = :type")
    List<Restaurant> findByType(@Param("type") String type);

    @Query("SELECT r FROM Restaurant r WHERE r.foodType = :type ORDER BY r.avgRating DESC")
    List<Restaurant> findBestByType(@Param("type") String type, Pageable limit);

    @Query("SELECT r FROM Restaurant r ORDER BY r.avgRating DESC")
    List<Restaurant> findBestOverall(Pageable limit);

    @Query("SELECT DISTINCT r.foodType FROM Restaurant r")
    List<String> findAllFoodTypes();
}
