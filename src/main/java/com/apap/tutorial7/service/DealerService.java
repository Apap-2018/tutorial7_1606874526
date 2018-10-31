package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.DealerModel;

/**
 * DealerService
 */
public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	DealerModel addDealer(DealerModel dealer);
	// delete
	void deleteDealer(Long dealerIdd);
	// view all
	List<DealerModel> viewAllDealer();

	void updateDealer(long id, DealerModel dealer);
}