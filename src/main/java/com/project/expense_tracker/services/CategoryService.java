package com.project.expense_tracker.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.expense_tracker.entities.Category;

@Service
@Transactional
public interface CategoryService {
	
	public List<Category> getCategory(String categoryType);

}
