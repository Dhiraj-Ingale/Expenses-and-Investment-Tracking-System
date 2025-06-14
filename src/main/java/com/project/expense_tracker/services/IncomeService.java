package com.project.expense_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Income;

@Service
public interface IncomeService {
	
	public List<Income> getAllIncomeByUser(String username);
	
	public List<Income> getIncomeByUserByYear(long userId, int year);
	
	public List<Income> getIncomeByUserByMonth(long userId, int month);
	
	public List<Income> getIncomeByUserByMonthYear(long userId, int month, int year);
	
	public Income getIncomeByUserById(long userId, long incomeId);
	
	public Income saveIncome(Income income);
	
	public void deleteIncomeById(long incomeid);
	
	public double getSum(long userId);
	
	public List<Object> getPieGraphData(long userId);
	
	public List<Object> getLineGraphDate(long userId, int year);

}
