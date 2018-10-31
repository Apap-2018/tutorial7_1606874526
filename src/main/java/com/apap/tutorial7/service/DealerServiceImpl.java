package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tutorial7.model.DealerModel;
import com.apap.tutorial7.repository.DealerDb;

/**
 * DealerServiceImpl
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {
	@Autowired
	private DealerDb dealerDb;
	
	@Override
	public Optional<DealerModel> getDealerDetailById(Long id) {
		return dealerDb.findById(id);
	}
	
	@Override
	public DealerModel addDealer(DealerModel dealer) {
		return dealerDb.save(dealer);
		
	}
	
	// delete
	@Override
	public void deleteDealer(Long dealerIdd) {
		dealerDb.deleteById(dealerIdd);
	}

	// view all dealer
	@Override
	public List<DealerModel> viewAllDealer() {
		return dealerDb.findAll();
	}

	@Override
	public void updateDealer(long id, DealerModel dealer) {
		// TODO Auto-generated method stub
		DealerModel dealerCurr = dealerDb.findById(id).get();
		dealerCurr.setAlamat(dealer.getAlamat());
		dealerCurr.setNoTelp(dealer.getNoTelp());
		
	}

}