package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.ModeOfPayment;
import com.project.expense_tracker.services.ModeOfPaymentService;

@CrossOrigin(origins = "*")
@RestController
public class ModeOfPaymentController {
	
	@Autowired
	private ModeOfPaymentService modeOfPaymentService;
	
	@GetMapping("/modeofpayments")
	public List<ModeOfPayment> getModeOfPayments() {
		return modeOfPaymentService.getAllModeOfPayment();
	}

}
