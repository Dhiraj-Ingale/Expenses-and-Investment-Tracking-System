package com.project.expense_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
	
	public List<Expense> findByUserUsernameOrderByDateDesc(String username);
	
	@Query(value="SELECT * FROM expenses WHERE user_id = :userId && MONTH(date) = :month ORDER BY YEAR(date) DESC, "
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Expense> getExpenseByUserByMonth(long userId, int month);
	
	@Query(value="SELECT * FROM expenses WHERE user_id = :userId && YEAR(date) = :year ORDER BY MONTH(date) DESC,"
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Expense> getExpenseByUserByYear(long userId, int year);
	
	@Query(value="SELECT * FROM expenses WHERE user_id = :userId && MONTH(date) = :month && YEAR(date) = :year "
			+ "ORDER BY DATE(date) DESC", nativeQuery = true)
	public List<Expense> getExpenseByUserByMonthYear(long userId, int month, int year);
	
	@Query(value="SELECT * FROM expenses WHERE user_id = :userId && expense_id = :expenseId", nativeQuery = true)
	public Expense getExpenseByUserById(long userId, long expenseId);
	
	@Query(value="SELECT SUM(amount) FROM expenses WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) "
			+ "&& YEAR(date) = YEAR(curdate())", nativeQuery = true)
	public double getSumOfAmountByUser(long userId);
	
	@Query(value="SELECT categories.category_name, SUM(expenses.amount) FROM expenses INNER JOIN categories "
			+ "ON expenses.category_id = categories.category_id "
			+ "WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) && YEAR(date) = YEAR(curdate()) "
			+ "GROUP BY categories.category_id", nativeQuery = true)
	public List<Object> getPieGraphData(long userId);
	
	@Query(value="SELECT MONTHNAME(date), SUM(amount) FROM expenses WHERE user_id = :userId && YEAR(date) = :year "
			+ "GROUP BY MONTH(date) ORDER BY MONTH(date)", nativeQuery = true)
	public List<Object> getLineGraphData(long userId, int year);

}
