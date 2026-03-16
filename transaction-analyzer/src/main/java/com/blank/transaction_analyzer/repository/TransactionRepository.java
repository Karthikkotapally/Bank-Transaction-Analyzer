package com.blank.transaction_analyzer.repository;

import com.blank.transaction_analyzer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}