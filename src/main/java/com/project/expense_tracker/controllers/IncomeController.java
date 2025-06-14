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

import com.project.expense_tracker.entities.Income;
import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.services.IncomeService;

@CrossOrigin(origins = "*")
@RestController
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@PostMapping("/incomes/all")
	public ResponseEntity<List<Income>> getIncomes(@RequestBody User user) {
		return ResponseEntity.ok().body(incomeService.getAllIncomeByUser(user.getUsername()));
	}
	
	@PostMapping("/incomes-month/{month}")
	public ResponseEntity<List<Income>> getIncomesByMonth(@RequestBody User user, @PathVariable("month") int month) {
		List<Income> incomes = incomeService.getIncomeByUserByMonth(user.getUserId(), month);
		return ResponseEntity.ok().body(incomes);
	}
	
	@PostMapping("/incomes-year/{year}")
	public ResponseEntity<List<Income>> getIncomesByYear(@RequestBody User user, @PathVariable("year") int year) {
		List<Income> incomes = incomeService.getIncomeByUserByYear(user.getUserId(), year);
		return ResponseEntity.ok().body(incomes);
	}
	
	@PostMapping("/incomes/{month}/{year}")
	public ResponseEntity<List<Income>> getIncomesByMonthYear(@RequestBody User user, @PathVariable("month") int month, @PathVariable("year") int year) {
		List<Income> incomes = incomeService.getIncomeByUserByMonthYear(user.getUserId(), month, year);
		return ResponseEntity.ok().body(incomes);
	}
	
	@PostMapping("/incomes/{incomeId}")
	public ResponseEntity<Income> getIncomeById(@RequestBody User user, @PathVariable("incomeId") long incomeId) throws Exception {
		Income income = incomeService.getIncomeByUserById(user.getUserId(), incomeId);
		return ResponseEntity.ok().body(income); 
	}
	
	@PostMapping("/incomes")
	public ResponseEntity<Income> createIncome(@RequestBody Income income) throws Exception {
		Income in = incomeService.saveIncome(income);
		return ResponseEntity.ok().body(in);
	}
	
	@PutMapping("/incomes/{incomeId}")
	public ResponseEntity<Income> updateIncome(@PathVariable("incomeId") long incomeId, @RequestBody List<Object> obj) throws Exception {
		User user = (User) obj.get(0);
		Income income = (Income) obj.get(1);
		Income in = incomeService.getIncomeByUserById(user.getUserId(), incomeId);
		in.setAmount(income.getAmount());
		in.setCategory(income.getCategory());
		in.setDate(income.getDate());
		incomeService.saveIncome(in);
		return ResponseEntity.ok().body(in);
	}
	
	@DeleteMapping("/incomes/{incomeId}")
	public ResponseEntity<?> deleteIncome(@PathVariable("incomeId") long incomeId) {
		incomeService.deleteIncomeById(incomeId);
		return ResponseEntity.ok().build();
	}

}
