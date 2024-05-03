package com.codedecode.restaurantlisting.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;
import com.codedecode.restaurantlisting.mapper.RestaurentMapper;
import com.codedecode.restaurantlisting.repo.RestaurentRepo;

@Service
public class RestaurentService {

	@Autowired
	private RestaurentRepo restaurentRepo;

	public List<RestaurantDto> findAllRestaurent() {
		// TODO Auto-generated method stub
		List<Restaurant> restaurents = restaurentRepo.findAll(); 
		List<RestaurantDto> resultList = restaurents.stream()
		.map(res->RestaurentMapper.INSTENCE.mapRestaurantToReataurentDto(res))
		.collect(Collectors.toList());
		return resultList;
	}

	public RestaurantDto addRestaurentInDb(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		Restaurant saveRestaurent =  restaurentRepo.save(RestaurentMapper.INSTENCE.mapRestaurantDtoToRestaurent(restaurantDto));
		
		return RestaurentMapper.INSTENCE.mapRestaurantToReataurentDto(saveRestaurent);
	}

	public ResponseEntity<RestaurantDto> getRestaurentById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Restaurant> restaurent = restaurentRepo.findById(id);
		if(restaurent.isPresent()) {
			RestaurantDto resturontDto = RestaurentMapper.INSTENCE.mapRestaurantToReataurentDto(restaurent.get());
			return new ResponseEntity<>(resturontDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}

	public ResponseEntity<RestaurantDto> updateResturentById(int id, RestaurantDto restaurantDto) {
		Optional<Restaurant> restaurent = restaurentRepo.findById(id);
		if(restaurent.isPresent()) {
			RestaurantDto resturontDtolocal = RestaurentMapper.INSTENCE.mapRestaurantToReataurentDto(restaurent.get());
			resturontDtolocal.setAddress(restaurantDto.getAddress());
			resturontDtolocal.setRestaurentDescription(restaurantDto.getRestaurentDescription());
			return new ResponseEntity<>(RestaurentMapper.INSTENCE.mapRestaurantToReataurentDto(restaurentRepo.save(RestaurentMapper.INSTENCE.mapRestaurantDtoToRestaurent(resturontDtolocal)) ), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}	
}
