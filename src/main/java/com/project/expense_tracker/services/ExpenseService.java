package com.project.expense_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Expense;

@Service
public interface ExpenseService {
	
	public List<Expense> getAllExpenseByUser(String username);
	
	public List<Expense> getExpenseByUserByYear(long userId, int year);
	
	public List<Expense> getExpenseByUserByMonth(long userId, int month);
	
	public List<Expense> getExpenseByUserByMonthYear(long userId, int month, int year);
	
	public Expense getExpenseByUserById(long userId, long expenseId);
	
	public Expense saveExpense(Expense expense);
	
	public void deleteExpenseById(long expenseId);
	
	public double getSum(long userId);
	
	public List<Object> getPieGraphData(long userId);
	
	public List<Object> getLineGraphDate(long userId, int year);

}
