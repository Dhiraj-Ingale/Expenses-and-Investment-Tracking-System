 package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.services.ExpenseService;
import com.project.expense_tracker.services.IncomeService;
import com.project.expense_tracker.services.InvestmentService;

@CrossOrigin(origins = "*")
@RestController
public class DashboardController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private IncomeService incomeService;
	
	@Autowired
	private InvestmentService investmentService;
	
	@PostMapping("/expenses/sum")
	public ResponseEntity<Double> getSumOfExpenses(@RequestBody User user) throws Exception {
		double sum = expenseService.getSum(user.getUserId());
		return ResponseEntity.ok().body(sum);
	}
	
	@PostMapping("/incomes/sum")
	public ResponseEntity<Double> getSumOfIncomes(@RequestBody User user) throws Exception {
		double sum = incomeService.getSum(user.getUserId());
		return ResponseEntity.ok().body(sum);
	}
	
	@PostMapping("/investments/sum")
	public ResponseEntity<Double> getSumOfInvestments(@RequestBody User user) throws Exception {
		double sum = investmentService.getSum(user.getUserId());
		return ResponseEntity.ok().body(sum);
	}
	
	@PostMapping("/expenses/pie-graph")
	public ResponseEntity<List<Object>> getExpensePieGraph(@RequestBody User user) throws Exception {
		List<Object> pie = expenseService.getPieGraphData(user.getUserId());
		return ResponseEntity.ok().body(pie);
	}
	
	@PostMapping("/incomes/pie-graph")
	public ResponseEntity<List<Object>> getIncomePieGraph(@RequestBody User user) throws Exception {
		List<Object> pie = incomeService.getPieGraphData(user.getUserId());
		return ResponseEntity.ok().body(pie);
	}
	
	@PostMapping("/investments/pie-graph")
	public ResponseEntity<List<Object>> getInvestmentPieGraph(@RequestBody User user) throws Exception {
		List<Object> pie = investmentService.getPieGraphData(user.getUserId());
		return ResponseEntity.ok().body(pie);
	}
	
	@PostMapping("/expenses/line-graph/{year}")
	public ResponseEntity<List<Object>> getExpenseLineGraph(@RequestBody User user, @PathVariable int year) throws Exception {
		List<Object> line = expenseService.getLineGraphDate(user.getUserId(), year);
		return ResponseEntity.ok().body(line);
	}
	
	@PostMapping("/incomes/line-graph/{year}")
	public ResponseEntity<List<Object>> getIncomeLineGraph(@RequestBody User user, @PathVariable int year) throws Exception {
		List<Object> line = incomeService.getLineGraphDate(user.getUserId(), year);
		return ResponseEntity.ok().body(line);
	}
	
	@PostMapping("/investments/line-graph/{year}")
	public ResponseEntity<List<Object>> getInvestmentLineGraph(@RequestBody User user, @PathVariable int year) throws Exception {
		List<Object> line = investmentService.getLineGraphDate(user.getUserId(), year);
		return ResponseEntity.ok().body(line);
	}

}
