package com.abdab.financialtracker.services.financialAccount;

import com.abdab.financialtracker.dto.financialAccountDto.FinancialAccountCreationDTO;
import com.abdab.financialtracker.dto.financialAccountDto.FinancialAccountUpdateDTO;
import com.abdab.financialtracker.models.FinancialAccount;
import com.abdab.financialtracker.models.User;
import com.abdab.financialtracker.repositories.FinancialAccountRepository;
import com.abdab.financialtracker.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FinancialAccountServiceImpl implements FinancialAccountService {
    private FinancialAccountRepository financialAccountRepository;
    private UserService userService;

    @Override
    public FinancialAccount createAccount(FinancialAccountCreationDTO account) {
        User user = userService.getUserById(account.getOwnerId());
        FinancialAccount financialAccount = new FinancialAccount(
                account.getBase_amount(),
                account.getName(),
                account.getCurrency(),
                user
        );

        return financialAccountRepository.save(financialAccount);
    }

    @Override
    public FinancialAccount updateAccount(Long id, FinancialAccountUpdateDTO account) {
        return null;
    }

    @Override
    public FinancialAccount getAccountById(Long id) {
        Optional<FinancialAccount> financialAccount = financialAccountRepository.findById(id);
        if(financialAccount.isEmpty())
            throw new RuntimeException("Financial account with id: " + id + " not found."); //TODO custom exceptions

        return financialAccount.get();
    }

    @Override
    public void deleteAccount(Long id) {
        FinancialAccount account = getAccountById(id);
        financialAccountRepository.deleteById(id);
    }
}
