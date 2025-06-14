package com.project.expense_tracker.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private long categoryId;
	
	@NotBlank(message="This field is mandatory.")
	@Column(name = "categoryName")
	private String categoryName;
	
	@NotBlank(message="This field is mandatory.")
	@Column(name = "categoryType")
	private String categoryType;
	
	
	/* Getter and Setters */
	
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	/* No Argument Constructor */
	
	public Category() {
		super();
	}
	
	/* All Argument Constructor */

	public Category(long categoryId, @NotBlank(message = "This field is mandatory.") String categoryName,
			@NotBlank(message = "This field is mandatory.") String categoryType) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
	}
	
	/* To-String Method */

	@Override
	public String toString() {
		return "Categories [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + "]";
	}

}
