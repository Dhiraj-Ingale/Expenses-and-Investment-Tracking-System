package com.project.expense_tracker.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.ModeOfPayment;
import com.project.expense_tracker.repositories.ModeOfPaymentRepository;
import com.project.expense_tracker.services.ModeOfPaymentService;

@Service
@Transactional
public class ModeOfPaymentServiceImpl implements ModeOfPaymentService {
	
	@Autowired
	private ModeOfPaymentRepository modeOfPaymentRepository;

	// Constructor
	public ModeOfPaymentServiceImpl(ModeOfPaymentRepository modeOfPaymentRepository) {
		super();
		this.modeOfPaymentRepository = modeOfPaymentRepository;
	}
	
	// Function: get the mode of payment list.
	public List<ModeOfPayment> getAllModeOfPayment() {
		return modeOfPaymentRepository.findAll(); 
	}

}
