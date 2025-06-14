package com.project.expense_tracker.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.Expense;
import com.project.expense_tracker.repositories.ExpenseRepository;
import com.project.expense_tracker.services.ExpenseService;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	// Constructor
	public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}
	
	// Function : Get List of All Expenses for given user.
	public List<Expense> getAllExpenseByUser(String username) {
		return expenseRepository.findByUserUsernameOrderByDateDesc(username);
	}
	
	// Function : Get List of Expenses by month for given user.
	public List<Expense> getExpenseByUserByMonth(long userId, int month) {
		return expenseRepository.getExpenseByUserByMonth(userId, month);
	}
	
	// Function : Get List of Expenses by year for given user.
	public List<Expense> getExpenseByUserByYear(long userId, int year) {
		return expenseRepository.getExpenseByUserByYear(userId, year);
	}
	
	// Function : Get List of Expenses by month and year for given user.
	public List<Expense> getExpenseByUserByMonthYear(long userId, int month, int year) {
		return expenseRepository.getExpenseByUserByMonthYear(userId, month, year);
	}
	
	// Function : Get Expense by expenseId for given user.
	public Expense getExpenseByUserById(long userId, long expenseId) {
		return expenseRepository.getExpenseByUserById(userId, expenseId);
	}
	
	// Function : Save Expense 
	public Expense saveExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	// Function : Delete Expense by expenseId.
	public void deleteExpenseById(long expenseId) {
		expenseRepository.deleteById(expenseId);
	}
	
	// Function : Get Sum of Expenses of Current Month.
	public double getSum(long userId) {
		return expenseRepository.getSumOfAmountByUser(userId);
	}
	
	// Function : Get Category vs Amount Data for Pie Chart of Current Month.
	public List<Object> getPieGraphData(long userId) {
		return expenseRepository.getPieGraphData(userId);
	}
	
	// Function : Get Month vs Amount Date for Line Chart of selected Year.
	public List<Object> getLineGraphDate(long userId, int year) {
		return expenseRepository.getLineGraphData(userId, year);
	}

}
