package com.apap.tutorial7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.CarModel;
import com.apap.tutorial7.repository.CarDb;

/**
 * CarServiceImpl
 */
@Service
@Transactional
public class CarServiceImpl implements CarService{
	@Autowired
	private CarDb carDb;
	
	@Override
	public CarModel addCar(CarModel car) {
		return carDb.save(car);
	}

	// delete
	@Override
	public void deleteCar(CarModel car) {
		// TODO Auto-generated method stub
		carDb.delete(car);
	}
	
	// update
	@Override
	public void updateCar(Long carIdu, String carBrandu, String carTypeu, Long carPriceu, Integer carAmountu) {
		carDb.getOne(carIdu).setBrand(carBrandu);
		carDb.getOne(carIdu).setType(carTypeu);
		carDb.getOne(carIdu).setPrice(carPriceu);
		carDb.getOne(carIdu).setAmount(carAmountu);		
	}

	@Override
	public List<CarModel> getAllCar() {
		// TODO Auto-generated method stub
		return carDb.findAll();
	}

	@Override
	public CarModel getCarById(long carId) {
		// TODO Auto-generated method stub
		return carDb.findById(carId).get();
	}
	
	
	
}