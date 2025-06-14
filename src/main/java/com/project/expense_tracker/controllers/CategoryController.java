package com.project.expense_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.expense_tracker.entities.Category;
import com.project.expense_tracker.services.CategoryService;

@CrossOrigin(origins = "*")
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/categories")
	public List<Category> getCategories(@RequestBody Category category) {
		System.out.println(category.getCategoryType());
		return categoryService.getCategory(category.getCategoryType());
	}
	
	@GetMapping("/categories/{categoryType}")
	public List<Category> getCategory(@PathVariable String categoryType) {
		System.out.println(categoryType);
		return categoryService.getCategory(categoryType);
	}
	
}
