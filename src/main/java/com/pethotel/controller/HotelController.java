package com.pethotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethotel.entity.Hotel;
import com.pethotel.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepository hotelRepository;
	
	@GetMapping("")
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
}
