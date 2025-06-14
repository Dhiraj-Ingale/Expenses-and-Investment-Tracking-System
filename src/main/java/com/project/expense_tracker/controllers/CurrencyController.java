package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.Currency;
import com.project.expense_tracker.services.CurrencyService;

@CrossOrigin(origins = "*")
@RestController
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyService;
	
	@GetMapping("/currencies")
	public List<Currency> getCurrencies() {
		return currencyService.getAllCurrency();
	}

}
