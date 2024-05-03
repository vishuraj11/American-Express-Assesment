package com.codedecode.restaurantlisting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.codedecode.restaurantlisting.dto.RestaurantDto;
import com.codedecode.restaurantlisting.entity.Restaurant;

@Mapper
public interface RestaurentMapper {
	
	RestaurentMapper INSTENCE = Mappers.getMapper(RestaurentMapper.class);
	
	Restaurant mapRestaurantDtoToRestaurent(RestaurantDto restaurantDto);
	
	RestaurantDto mapRestaurantToReataurentDto(Restaurant restaurant);
}
