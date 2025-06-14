package com.project.expense_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
	
	public List<Income> findByUserUsernameOrderByDateDesc(String username);
	
	@Query(value="SELECT * FROM incomes WHERE user_id = :userId && YEAR(date) = :year ORDER BY YEAR(date) DESC,"
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Income> getIncomeByUserByYear(long userId, int year);
	
	@Query(value="SELECT * FROM incomes WHERE user_id = :userId && MONTH(date) = :month ORDER BY MONTH(date) DESC,"
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Income> getIncomeByUserByMonth(long userId, int month);
	
	@Query(value="SELECT * FROM incomes WHERE user_id = :userId && MONTH(date) = :month && YEAR(date) = :year "
			+ "ORDER BY DATE(date) DESC", nativeQuery = true)
	public List<Income> getIncomeByUserByMonthYear(long userId, int month, int year);
	
	@Query(value="SELECT * FROM incomes WHERE user_id = :userId && income_id = :incomeId", nativeQuery = true)
	public Income getIncomeByUserById(long userId, long incomeId);
	
	@Query(value="SELECT SUM(amount) FROM incomes WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) "
			+ "&& YEAR(date) = YEAR(curdate())", nativeQuery = true)
	public double getSumOfAmountByUser(long userId);
	
	@Query(value="SELECT categories.category_name, SUM(incomes.amount) FROM incomes INNER JOIN categories "
			+ "ON incomes.category_id = categories.category_id "
			+ "WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) && YEAR(date) = YEAR(curdate()) "
			+ "GROUP BY categories.category_name", nativeQuery = true)
	public List<Object> getPieGraphData(long userId);
	
	@Query(value="SELECT MONTHNAME(date), SUM(amount) FROM incomes WHERE user_id = :userId && YEAR(date) = :year "
			+ "GROUP BY MONTH(date) ORDER BY MONTH(date)", nativeQuery = true)
	public List<Object> getLineGraphData(long userId, int year);

}
