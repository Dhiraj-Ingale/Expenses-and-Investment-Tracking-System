package com.project.expense_tracker.serviceImpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.expense_tracker.entities.Investment;
import com.project.expense_tracker.repositories.InvestmentRepository;
import com.project.expense_tracker.services.InvestmentService;

@Service
@Transactional
public class InvestmentServiceImpl implements InvestmentService {
	
	@Autowired
	private InvestmentRepository investmentRepository;
	
	// Constructor
	public InvestmentServiceImpl(InvestmentRepository investmentRepository) {
		super();
		this.investmentRepository = investmentRepository;
	}
	
	// Function : Get List of All Investments for given user.
	public List<Investment> getAllInvestmentByUser(String username) {
		return investmentRepository.findByUserUsernameOrderByDateDesc(username);
	}
	
	// Function : Get List of Investments by month for given user.
	public List<Investment> getInvestmentByUserByMonth(long userId, int month) {
		return investmentRepository.getInvestmentByUserByMonth(userId, month);
	}
	
	// Function : Get List of Investments by year for given user.
	public List<Investment> getInvestmentByUserByYear(long userId, int year) {
		return investmentRepository.getInvestmentByUserByYear(userId, year);
	}
	
	// Function : Get List of Investments by month and year for given user.
	public List<Investment> getInvestmentByUserByMonthYear(long userId, int month, int year) {
		return investmentRepository.getInvestmentByUserByMonthYear(userId, month, year);
	}
	
	// Function : Get Investment by investmentId for given user.
	public Investment getInvestmentByUserById(long userId, long investmentId) {
		return investmentRepository.getInvestmentByUserById(userId, investmentId);
	}
	
	// Function : Save Investment
	public Investment saveInvestment(Investment investment) {
		return investmentRepository.save(investment);
	}
	
	// Function : Delete Investment by investmentId.
	public void deleteInvestmentById(long investmentId) {
		investmentRepository.deleteById(investmentId);
	}
	
	// Function : Get Sum of Investments of Current Month.
	public double getSum(long userId) {
		return investmentRepository.getSumOfAmountByUser(userId);
	}
	
	// Function : Get Category vs Amount Data for Pie Chart of Current Month.
	public List<Object> getPieGraphData(long userId) {
		return investmentRepository.getPieGraphData(userId);
	}
	
	// Function : Get Month vs Amount Date for Line Chart of selected Year.
	public List<Object> getLineGraphDate(long userId, int year) {
		return investmentRepository.getLineGraphData(userId, year);
	}
	
}
