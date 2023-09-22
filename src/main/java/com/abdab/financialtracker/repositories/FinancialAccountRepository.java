package com.abdab.financialtracker.repositories;

import com.abdab.financialtracker.models.FinancialAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialAccountRepository extends JpaRepository<FinancialAccount, Long> {
}
