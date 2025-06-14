package com.project.expense_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Currency;

@Service
public interface CurrencyService {
	
	public List<Currency> getAllCurrency();

}
