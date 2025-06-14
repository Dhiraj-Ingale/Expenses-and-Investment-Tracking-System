package com.project.expense_tracker.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.Income;
import com.project.expense_tracker.repositories.IncomeRepository;
import com.project.expense_tracker.services.IncomeService;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService{
	
	@Autowired
	private IncomeRepository incomeRepository;

	// Constructor
	public IncomeServiceImpl(IncomeRepository incomeRepository) {
		super();
		this.incomeRepository = incomeRepository;
	}
	
	// Function : Get List of All Incomes for given user.
	public List<Income> getAllIncomeByUser(String username) {
		return incomeRepository.findByUserUsernameOrderByDateDesc(username);
	}
	
	// Function : Get List of Incomes by month for given user.
	public List<Income> getIncomeByUserByMonth(long userId, int month) {
		return incomeRepository.getIncomeByUserByMonth(userId, month);
	}
	
	// Function : Get List of Incomes by year for given user.
	public List<Income> getIncomeByUserByYear(long userId, int year) {
		return incomeRepository.getIncomeByUserByYear(userId, year);
	}
	
	// Function : Get List of Incomes by month and year for given user.
	public List<Income> getIncomeByUserByMonthYear(long userId, int month, int year) {
		return incomeRepository.getIncomeByUserByMonthYear(userId, month, year);
	}
	
	// Function : Get Income by incomeId for given user.
	public Income getIncomeByUserById(long userId, long incomeId) {
		return incomeRepository.getIncomeByUserById(userId, incomeId);
	}
	
	// Function : Save Income
	public Income saveIncome(Income income) {
		return incomeRepository.save(income);
	}
	
	// Function : Delete Income by incomeId.
	public void deleteIncomeById(long incomeId) {
		incomeRepository.deleteById(incomeId);
	}
	
	// Function : Get Sum of Incomes of Current Month.
	public double getSum(long userId) {
		return incomeRepository.getSumOfAmountByUser(userId);	
	}
	
	// Function : Get Category vs Amount Data for Pie Chart of Current Month.
	public List<Object> getPieGraphData(long userId) {
		return incomeRepository.getPieGraphData(userId);
	}
	
	// Function : Get Month vs Amount Date for Line Chart of selected Year.
	public List<Object> getLineGraphDate(long userId, int year) {
		return incomeRepository.getLineGraphData(userId, year);
	}

}
