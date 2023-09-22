package com.abdab.financialtracker.repositories;

import com.abdab.financialtracker.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
