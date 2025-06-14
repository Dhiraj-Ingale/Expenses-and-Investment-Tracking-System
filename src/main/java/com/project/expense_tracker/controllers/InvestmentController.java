package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.Investment;
import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.services.InvestmentService;

@CrossOrigin(origins = "*")
@RestController
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@PostMapping("/investments/all")
	public ResponseEntity<List<Investment>> getInvestments(@RequestBody User user) {
		return ResponseEntity.ok().body(investmentService.getAllInvestmentByUser(user.getUsername()));
	}
	
	@PostMapping("/investments-month/{month}")
	public ResponseEntity<List<Investment>> getInvestmentsByMonth(@RequestBody User user, @PathVariable("month") int month) {
		List<Investment> investments = investmentService.getInvestmentByUserByMonth(user.getUserId(), month);
		return ResponseEntity.ok().body(investments);
	}
	
	@PostMapping("/investments-year/{year}")
	public ResponseEntity<List<Investment>> getInvestmentsByYear(@RequestBody User user, @PathVariable("year") int year) {
		List<Investment> investments = investmentService.getInvestmentByUserByYear(user.getUserId(), year);
		return ResponseEntity.ok().body(investments);
	}
	
	@PostMapping("/investments/{month}/{year}")
	public ResponseEntity<List<Investment>> getInvestmentsByMonthYear(@RequestBody User user, @PathVariable("month") int month, @PathVariable("year") int year) {
		List<Investment> investments = investmentService.getInvestmentByUserByMonthYear(user.getUserId(), month, year);
		return ResponseEntity.ok().body(investments);
	}
	
	@PostMapping("/investments/{investmentId}")
	public ResponseEntity<Investment> getInvestmentsById(@RequestBody User user, @PathVariable("investmentId") long investmentId) throws Exception {
		Investment investment = investmentService.getInvestmentByUserById(user.getUserId(), investmentId);
		return ResponseEntity.ok().body(investment);
	}
	
	@PostMapping("/investments")
	public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) throws Exception {
		Investment invest = investmentService.saveInvestment(investment);
		return ResponseEntity.ok().body(invest);
	}
	
	@PutMapping("/investments/{investmentId}")
	public ResponseEntity<Investment> updateInvestment(@PathVariable("investmentId") long investmentId, @RequestBody List<Object> obj) throws Exception {
		User user = (User) obj.get(0);
		Investment investment = (Investment) obj.get(1);
		Investment invest = investmentService.getInvestmentByUserById(user.getUserId(), investmentId);
		invest.setAmount(investment.getAmount());
		invest.setCategory(investment.getCategory());
		invest.setDate(investment.getDate());
		invest.setDescription(investment.getDescription());
		invest.setInterestRate(investment.getInterestRate());
		invest.setInvestmentPeriod(investment.getInvestmentPeriod());
		investmentService.saveInvestment(invest);
		return ResponseEntity.ok().body(invest);
	}
	
	@DeleteMapping("/investments/{investmentId}") 
	public ResponseEntity<?> deleteInvestment(@PathVariable("investmentId") long investmentId) {
		investmentService.deleteInvestmentById(investmentId);
		return ResponseEntity.ok().build();
	}
	
}
