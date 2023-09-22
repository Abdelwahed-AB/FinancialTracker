package com.abdab.financialtracker.services.financialAccount;

import com.abdab.financialtracker.dto.financialAccountDto.FinancialAccountCreationDTO;
import com.abdab.financialtracker.dto.financialAccountDto.FinancialAccountUpdateDTO;
import com.abdab.financialtracker.models.FinancialAccount;

public interface FinancialAccountService {
    FinancialAccount createAccount(FinancialAccountCreationDTO account);
    FinancialAccount updateAccount(Long id, FinancialAccountUpdateDTO account);
    FinancialAccount getAccountById(Long id);
    void deleteAccount(Long id);
}
