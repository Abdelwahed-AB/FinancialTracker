package com.abdab.financialtracker.services.transactionProcessor;

import com.abdab.financialtracker.models.FinancialAccount;
import com.abdab.financialtracker.models.Transaction;
import com.abdab.financialtracker.repositories.FinancialAccountRepository;
import com.abdab.financialtracker.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class TransactionProcessorServiceImpl implements TransactionProcessorService {

    private TransactionRepository transactionRepository;
    private FinancialAccountRepository financialAccountRepository;

    @Override
    public void applyTransaction(Transaction transaction) {
        FinancialAccount financialAccount = transaction.getAccount();

        switch (transaction.getTransactionType()){
            case Income :
                financialAccount.setCurrent_amount(
                        financialAccount.getCurrent_amount() + transaction.getAmount());
                break;
            case Payment:
                financialAccount.setCurrent_amount(
                        financialAccount.getCurrent_amount() - transaction.getAmount());
                break;
        }

        financialAccountRepository.save(financialAccount);
    }

    @Override
    public void unapplyTransaction(Transaction transaction) {
        FinancialAccount financialAccount = transaction.getAccount();

        switch (transaction.getTransactionType()){
            case Income :
                financialAccount.setCurrent_amount(
                        financialAccount.getCurrent_amount() - transaction.getAmount());
                break;
            case Payment:
                financialAccount.setCurrent_amount(
                        financialAccount.getCurrent_amount() + transaction.getAmount());
                break;
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
