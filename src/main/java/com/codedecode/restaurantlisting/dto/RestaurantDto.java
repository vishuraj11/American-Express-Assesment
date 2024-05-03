package com.codedecode.restaurantlisting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestaurantDto {
	private int id;
	private String name;
	private String address;
	private String restaurentDescription;
}
