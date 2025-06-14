package com.project.expense_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query(value="SELECT * FROM categories WHERE category_type = :categoryType", nativeQuery = true)
	public List<Category> findByCategoryType(String categoryType);

}
