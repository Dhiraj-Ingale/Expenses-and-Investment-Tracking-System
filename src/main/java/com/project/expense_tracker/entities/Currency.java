package com.project.expense_tracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies")
public class Currency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "currencyId")
	private long currencyId;
	
	@Column(name = "currencyName")
	private String currencyName;
	
	@Column(name = "currencySymbol")
	private String currencySymbol;

	public long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public Currency() {
		super();
	}

	public Currency(long currencyId, String currencyName, String currencySymbol) {
		super();
		this.currencyId = currencyId;
		this.currencyName = currencyName;
		this.currencySymbol = currencySymbol;
	}

	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", currencyName=" + currencyName + ", currencySymbol="
				+ currencySymbol + "]";
	}

}
