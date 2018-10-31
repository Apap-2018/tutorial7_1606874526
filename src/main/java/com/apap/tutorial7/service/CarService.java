package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.CarModel;

/**
 * CarService
 */
public interface CarService {
	CarModel addCar(CarModel car);
	// delete
	void deleteCar(CarModel car);
	//update
	void updateCar(Long carIdu, String carBrandu, String carTypeu, Long carPriceu, Integer carAmountu);
	List<CarModel> getAllCar();
	CarModel getCarById(long carId);
	
}