package com.codedecode.restaurantlisting.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.restaurantlisting.entity.Restaurant;

@Repository
public interface RestaurentRepo extends JpaRepository<Restaurant, Integer>{

}
