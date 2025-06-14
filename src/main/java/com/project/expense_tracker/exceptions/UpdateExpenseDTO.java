package com.project.expense_tracker.exceptions;

import com.project.expense_tracker.entities.Expense;
import com.project.expense_tracker.entities.User;

public class UpdateExpenseDTO {
	
	private User u;
	
	private Expense e;

	public User getUser() {
		return u;
	}

	public void setUser(User user) {
		this.u = user;
	}

	public Expense getExpense() {
		return e;
	}

	public void setExpense(Expense expense) {
		this.e = expense;
	}

	public UpdateExpenseDTO(User u, Expense e) {
		super();
		this.u = u;
		this.e = e;
	}

	@Override
	public String toString() {
		return "UpdateExpenseDTO [user=" + u + ", expense=" + e + "]";
	}

}
