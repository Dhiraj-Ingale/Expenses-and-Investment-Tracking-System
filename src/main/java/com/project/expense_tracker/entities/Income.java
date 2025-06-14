package com.project.expense_tracker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "incomes")
public class Income {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "incomeId")
	private long incomeId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date = new Date();
	
	@NotNull(message="This field is mandatory.")
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category = new Category(1, "Other", "Income");
	
	@NotNull(message="This field is mandatory.")
	@Column(name = "amount")
	private double amount;
	
	@NotNull(message="This field is mandatory.")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(long incomeId) {
		this.incomeId = incomeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Income() {
		super();
	}

	public Income(long incomeId, Date date, @NotBlank(message = "This field is mandatory.") Category category,
			@NotBlank(message = "This field is mandatory.") double amount,
			@NotBlank(message = "This field is mandatory.") User user) {
		super();
		this.incomeId = incomeId;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", date=" + date + ", category=" + category + ", amount=" + amount
				+ ", user=" + user + "]";
	}
	
}
