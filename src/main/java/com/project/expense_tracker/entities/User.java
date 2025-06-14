package com.project.expense_tracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	@NotBlank(message="This field is mandatory.")
	@Column(name = "name")
	private String name;
	
	@NotBlank(message="This field is mandatory.")
	@Column(name = "username")
	private String username;
	
	@Size(min=4, message="must be greater than or equal to 4")
	@Column(name = "password")
	private String password;
	
	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobno")
	private String mobno;
	
	@NotNull(message="This field is mandatory.")
	@OneToOne
	@JoinColumn(name = "currencyId")
	private Currency currency;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public User() {
		super();
	}

	public User(long userId, @NotBlank(message = "This field is mandatory.") String name,
			@NotBlank(message = "This field is mandatory.") String username,
			@Size(min = 4, message = "must be greater than or equal to 4") String password, @Email String email,
			String mobno, @NotBlank(message = "This field is mandatory.") Currency currency) {
		super();
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobno = mobno;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", mobno=" + mobno + ", currency=" + currency + "]";
	}

}
