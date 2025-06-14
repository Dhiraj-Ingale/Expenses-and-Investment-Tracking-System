package com.project.expense_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Investment;

@Service
public interface InvestmentService {
	
	public List<Investment> getAllInvestmentByUser(String username);
	
	public List<Investment> getInvestmentByUserByYear(long userId, int year);
	
	public List<Investment> getInvestmentByUserByMonth(long userId, int month);
	
	public List<Investment> getInvestmentByUserByMonthYear(long userId, int month, int year);
	
	public Investment getInvestmentByUserById(long userId, long investmentId);
	
	public Investment saveInvestment(Investment investment);
	
	public void deleteInvestmentById(long investmentId);
	
	public double getSum(long userId);
	
	public List<Object> getPieGraphData(long userId);
	
	public List<Object> getLineGraphDate(long userId, int year);

}
