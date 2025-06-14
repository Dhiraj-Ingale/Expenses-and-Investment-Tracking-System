package com.project.expense_tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.expense_tracker.entities.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
