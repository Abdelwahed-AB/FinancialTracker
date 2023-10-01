package com.abdab.financialtracker.repositories;

import com.abdab.financialtracker.models.RecurringTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RecurringTransactionRepository extends JpaRepository<RecurringTransaction, Long> {
    //TODO ADD QUERY TO FIND BY DAY AND MONTH ONLY
    List<RecurringTransaction> findByTransactionDate(LocalDate date);
}
