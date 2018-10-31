package com.apap.tutorial7.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.apap.tutorial7.model.*;
import com.apap.tutorial7.rest.Setting;
import com.apap.tutorial7.service.*;

/**
 * CarController
 */
@RestController
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;
	
	
	// NO 1 UPDATE SUDAH
	@PutMapping(value = "/{carIdu}")
	private String updateCar(
			@PathVariable (value = "carIdu") Long carIdu,
			@RequestParam(required = true, name = "carBrandu") String carBrandu,
			@RequestParam("carTypeu") String carTypeu,
			@RequestParam("carPriceu") Long carPriceu,
			@RequestParam("carAmountu") Integer carAmountu,
			@RequestParam("dealerIdu") Long dealerIdu) {
		CarModel car = carService.getCarById(carIdu);
		if (car.equals(null)) {
			return "Couldn't find the car";
		}
		car.setBrand(carBrandu);
		car.setType(carTypeu);
		car.setPrice(carPriceu);
		car.setAmount(carAmountu);
		carService.updateCar(carIdu, carBrandu, carTypeu, carPriceu, carAmountu);
		return "car update success";
	}
	
	// NO 2 BELUM
	@PostMapping()
	private CarModel addCarSubmit (@RequestBody CarModel car) {
		return carService.addCar(car);
	}
		
	// NO 3 GET CAR SUDAH
	@GetMapping(value = "/{carId}")
	private CarModel getCar(@PathVariable ("carId") long carId, Model model) {
		return carService.getCarById(carId);
	}
	
	// NO 4 GET ALL CAR SUDAH
	@GetMapping()
	private List<CarModel> viewAllCar(Model model ) {
		List<CarModel> listCar = carService.getAllCar();
		return listCar;
	}

	// NO 5 DELETE CAR SUDAH
	@DeleteMapping(value = "/{carId}")
	private String deleteCar(@PathVariable("carId") long id, Model model) {
		CarModel car = carService.getCarById(id);
		carService.deleteCar(car);
		return "car has been deleted";
	}
}
