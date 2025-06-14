package com.project.expense_tracker.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.Currency;
import com.project.expense_tracker.repositories.CurrencyRepository;
import com.project.expense_tracker.services.CurrencyService;

@Service
@Transactional
public class CurrencyServiceImpl implements CurrencyService {
	
	@Autowired
	private CurrencyRepository currencyRepository;
	
	// Constructor
	public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
		super();
		this.currencyRepository = currencyRepository;
	}
	
	// Function: get the currency list.
	public List<Currency> getAllCurrency() {
		return currencyRepository.findAll();
	}

}
