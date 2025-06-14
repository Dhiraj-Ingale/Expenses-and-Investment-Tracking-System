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
@Table(name = "investments")
public class Investment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "investmentId")
	private long investmentId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date = new Date();
	
	@NotNull(message="This field is mandatory.")
	@OneToOne
	@JoinColumn(name = "categoryId")
	private Category category = new Category(1, "Other", "Expense");
	
	@NotNull(message="This field is mandatory.")
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "interestRate")
	private float interestRate;
	
	@Column(name = "investmentPeriod")
	private float investmentPeriod;
	
	@Column(name = "description")
	private String description = "";
	
	@NotNull(message="This field is mandatory.")
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public long getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(long investmentId) {
		this.investmentId = investmentId;
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

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public float getInvestmentPeriod() {
		return investmentPeriod;
	}

	public void setInvestmentPeriod(float investmentPeriod) {
		this.investmentPeriod = investmentPeriod;
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

	public Investment() {
		super();
	}

	public Investment(long investmentId, Date date, @NotBlank(message = "This field is mandatory.") Category category,
			@NotBlank(message = "This field is mandatory.") double amount, float interestRate, float investmentPeriod,
			String description, @NotBlank(message = "This field is mandatory.") User user) {
		super();
		this.investmentId = investmentId;
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.interestRate = interestRate;
		this.investmentPeriod = investmentPeriod;
		this.description = description;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Investment [investmentId=" + investmentId + ", date=" + date + ", category=" + category + ", amount="
				+ amount + ", interestRate=" + interestRate + ", investmentPeriod=" + investmentPeriod
				+ ", description=" + description + ", user=" + user + "]";
	}
	
}
