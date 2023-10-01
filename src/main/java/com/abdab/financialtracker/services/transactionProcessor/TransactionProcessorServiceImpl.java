package com.abdab.financialtracker.services.transactionProcessor;

import com.abdab.financialtracker.models.FinancialAccount;
import com.abdab.financialtracker.models.Transaction;
import com.abdab.financialtracker.repositories.FinancialAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionProcessorServiceImpl implements TransactionProcessorService {

    private final FinancialAccountRepository financialAccountRepository;

    @Override
    public void applyTransaction(Transaction transaction) {
        FinancialAccount financialAccount = transaction.getAccount();

        switch (transaction.getTransactionType()){
            case Income -> financialAccount.setCurrent_amount(
                                financialAccount.getCurrent_amount() + transaction.getAmount());
            case Payment -> financialAccount.setCurrent_amount(
                                financialAccount.getCurrent_amount() - transaction.getAmount());
        }

        financialAccountRepository.save(financialAccount);
    }

    @Override
    public void unapplyTransaction(Transaction transaction) {
        FinancialAccount financialAccount = transaction.getAccount();

        switch (transaction.getTransactionType()){
            case Income ->  financialAccount.setCurrent_amount(
                                financialAccount.getCurrent_amount() - transaction.getAmount());
            case Payment -> financialAccount.setCurrent_amount(
                                financialAccount.getCurrent_amount() + transaction.getAmount());
        }

        financialAccountRepository.save(financialAccount);
    }

    @Override
    @Transactional
    public void updateTransaction(Transaction oldTransaction, Transaction newTransaction) {
        unapplyTransaction(oldTransaction);
        applyTransaction(newTransaction);
    }
}
