package com.codedecode.restaurantlisting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.service.RestaurentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class RestaurentController {

	@Autowired
	private RestaurentService restaurentService;
	
	@GetMapping("/fetchAllRestaurent")
	public ResponseEntity<List<RestaurantDto>> fetchAllRestaurent(){
		List<RestaurantDto> allResturent = restaurentService.findAllRestaurent();
		return new ResponseEntity<>(allResturent, HttpStatus.OK);
	}
	
	@PostMapping("/addRestaurent")
	public ResponseEntity<RestaurantDto> saveRestaurent(@RequestBody RestaurantDto restaurantDto){
		
		RestaurantDto restaurentAdded = restaurentService.addRestaurentInDb(restaurantDto);
		return new ResponseEntity<>(restaurentAdded,HttpStatus.CREATED);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<RestaurantDto> findRestaurentById(@PathVariable Integer id){
		
		return restaurentService.getRestaurentById(id);
	}
	
	@PutMapping("updaterestaurent/{id}")
	public ResponseEntity<RestaurantDto> updateResturentById(@PathVariable int id, @RequestBody RestaurantDto restaurantDto) {
		
		return restaurentService.updateResturentById(id,restaurantDto);
	}
	
	
	
}
