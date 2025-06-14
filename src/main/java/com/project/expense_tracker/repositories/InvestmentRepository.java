package com.project.expense_tracker.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.Investment;

@Repository
public interface InvestmentRepository extends JpaRepository<Investment, Long> {
	
	public List<Investment> findByUserUsernameOrderByDateDesc(String username);
	
	@Query(value="SELECT * FROM investments WHERE user_id = :userId && YEAR(date) = :year ORDER BY YEAR(date) DESC,"
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Investment> getInvestmentByUserByYear(long userId, int year);
	
	@Query(value="SELECT * FROM investments WHERE user_id = :userId && MONTH(date) = :month ORDER BY MONTH(date) DESC,"
			+ "DATE(date) DESC", nativeQuery = true)
	public List<Investment> getInvestmentByUserByMonth(long userId, int month);
	
	@Query(value="SELECT * FROM investments WHERE user_id = :userId && MONTH(date) = :month && YEAR(date) = :year "
			+ "ORDER BY DATE(date) DESC", nativeQuery = true)
	public List<Investment> getInvestmentByUserByMonthYear(long userId, int month, int year);
	
	@Query(value="SELECT * FROM investments WHERE user_id = :userId && investment_id = :investmentId", nativeQuery = true)
	public Investment getInvestmentByUserById(long userId, long investmentId);
	
	@Query(value="SELECT SUM(amount) FROM investments WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) "
			+ "&& YEAR(date) = YEAR(curdate())", nativeQuery = true)
	public double getSumOfAmountByUser(long userId);
	
	@Query(value="SELECT categories.category_name, SUM(investments.amount) FROM investments INNER JOIN categories "
			+ "ON investments.category_id = categories.category_id "
			+ "WHERE user_id = :userId && MONTH(date) = MONTH(curdate()) && YEAR(date) = YEAR(curdate()) "
			+ "GROUP BY categories.category_name", nativeQuery = true)
	public List<Object> getPieGraphData(long userId);
	
	@Query(value="SELECT MONTHNAME(date), SUM(amount) FROM investments WHERE user_id = :userId && YEAR(date) = :year "
			+ "GROUP BY MONTH(date) ORDER BY MONTH(date)", nativeQuery = true)
	public List<Object> getLineGraphData(long userId, int year);

}
