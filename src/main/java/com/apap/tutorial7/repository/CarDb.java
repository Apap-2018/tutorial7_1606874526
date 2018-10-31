package com.apap.tutorial7.repository;

import java.awt.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial7.model.CarModel;

/**
 * CarDb
 */
@Repository
public interface CarDb extends JpaRepository<CarModel, Long> {
	Optional<CarModel> findByType(String type);
}