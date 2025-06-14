package com.project.expense_tracker.serviceImpls;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Category;
import com.project.expense_tracker.repositories.CategoryRepository;
import com.project.expense_tracker.services.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Constructor
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	// Function: get the categories list.
	public List<Category> getCategory(String categoryType) {
		return categoryRepository.findByCategoryType(categoryType);
	}

}
