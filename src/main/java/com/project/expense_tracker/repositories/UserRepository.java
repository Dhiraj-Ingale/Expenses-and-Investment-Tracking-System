package com.project.expense_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value="SELECT * FROM user WHERE user_id = :userId", nativeQuery = true)
	public User getById(long userId);
	
	public User findByUsername(String username);

}
