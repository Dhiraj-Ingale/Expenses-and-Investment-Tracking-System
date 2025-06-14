package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.Expense;
import com.project.expense_tracker.entities.User;
import com.project.expense_tracker.exceptions.UpdateExpenseDTO;
import com.project.expense_tracker.services.ExpenseService;

@CrossOrigin(origins = "*")
@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public ResponseEntity<String> getExpenses() {
		return ResponseEntity.ok().body("Hello");
	}
	
	@PostMapping("/expenses/all")
	public ResponseEntity<List<Expense>> getExpenses(@RequestBody User user) {
		System.out.println(user);
		return ResponseEntity.ok().body(expenseService.getAllExpenseByUser(user.getUsername()));
	}
	
	@PostMapping("/expenses-month/{month}")
	public ResponseEntity<List<Expense>> getExpensesByMonth(@RequestBody User user, @PathVariable("month") int month) {
		System.out.println(month);
		List<Expense> expenses = expenseService.getExpenseByUserByMonth(user.getUserId(), month);
		return ResponseEntity.ok().body(expenses);
	}
	
	@PostMapping("/expenses-year/{year}")
	public ResponseEntity<List<Expense>> getExpensesByYear(@RequestBody User user, @PathVariable("year") int year) {
		System.out.println(year);
		List<Expense> expenses = expenseService.getExpenseByUserByYear(user.getUserId(), year);
		return ResponseEntity.ok().body(expenses);
	}
	
	@PostMapping("/expenses/{month}/{year}")
	public ResponseEntity<List<Expense>> getExpensesByMonthYear(@RequestBody User user, @PathVariable("month") int month, @PathVariable("year") int year) {
		System.out.println(month + ',' + year);
		List<Expense> expenses = expenseService.getExpenseByUserByMonthYear(user.getUserId(), month, year);
		return ResponseEntity.ok().body(expenses);
	}
	
	@PostMapping("/expenses/{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@RequestBody User user, @PathVariable("expenseId") long expenseId) throws Exception {
		Expense expense = expenseService.getExpenseByUserById(user.getUserId(), expenseId);
		return ResponseEntity.ok().body(expense);
	}
	
	@PostMapping("/expenses")
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) throws Exception {
		System.out.println(expense);
		Expense exp = expenseService.saveExpense(expense);
		return ResponseEntity.ok().body(exp);
	}
	
	@PutMapping("/expenses/{expenseId}")
	public ResponseEntity<Expense> updateExpense(@PathVariable("expenseId") long expenseId, @RequestBody UpdateExpenseDTO obj) throws Exception {
		System.out.println(obj.toString());
		User user = (User) obj.getUser();
		Expense expense = (Expense) obj.getExpense();
		Expense exp = expenseService.getExpenseByUserById(user.getUserId(), expenseId);
		System.out.println(exp.toString());
		exp.setAmount(expense.getAmount());
		exp.setCategory(expense.getCategory());
		exp.setDate(expense.getDate());
		exp.setDescription(expense.getDescription());
		exp.setModeOfPayment(expense.getModeOfPayment());
		exp.setUser(expense.getUser());
		System.out.println(exp.toString());
		expenseService.saveExpense(exp);
		return ResponseEntity.ok().body(exp);
	}
	
	@DeleteMapping("/expenses/{expenseid}")
	public ResponseEntity<?> deleteExpense(@PathVariable("expenseId") long expenseId) {
		expenseService.deleteExpenseById(expenseId);
		return ResponseEntity.ok().build();
	}

}
