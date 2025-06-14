package com.project.expense_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.ModeOfPayment;

@Service
public interface ModeOfPaymentService {
	
	public List<ModeOfPayment> getAllModeOfPayment();

}
