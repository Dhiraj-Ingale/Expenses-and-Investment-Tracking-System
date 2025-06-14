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
@Table(name = "expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "expenseId")
	private long expenseId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date = new Date();
	
	@NotNull(message="This field is mandatory.")
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category = new Category(1, "Other", "Expense");
	
	@OneToOne
	@JoinColumn(name = "mopId")
	private ModeOfPayment modeOfPayment = new ModeOfPayment(1,"Cash");
	
	@NotNull(message="This field is mandatory.")
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "description")
	private String description = "";
	
	@NotNull(message="This field is mandatory.")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
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

	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Expense() {
		super();
	}

	public Expense(long expenseId, Date date, @NotBlank(message = "This field is mandatory.") Category category,
			ModeOfPayment modeOfPayment, @NotBlank(message = "This field is mandatory.") double amount,
			String description, @NotBlank(message = "This field is mandatory.") User user) {
		super();
		this.expenseId = expenseId;
		this.date = date;
		this.category = category;
		this.modeOfPayment = modeOfPayment;
		this.amount = amount;
		this.description = description;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", date=" + date + ", category=" + category + ", modeOfPayment="
				+ modeOfPayment + ", amount=" + amount + ", description=" + description + ", user=" + user + "]";
	}

}
