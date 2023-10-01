package com.abdab.financialtracker.services.transaction;

import com.abdab.financialtracker.dto.transactionDto.TransactionCreationDTO;
import com.abdab.financialtracker.dto.transactionDto.TransactionUpdateDTO;
import com.abdab.financialtracker.models.FinancialAccount;
import com.abdab.financialtracker.models.Transaction;
import com.abdab.financialtracker.repositories.TransactionRepository;
import com.abdab.financialtracker.services.transactionProcessor.TransactionProcessorService;
import com.abdab.financialtracker.services.financialAccount.FinancialAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final FinancialAccountService financialAccountService;
    private final TransactionProcessorService transactionProcessorService;

    @Override
    @Transactional
    public Transaction createTransaction(TransactionCreationDTO transaction) {
        FinancialAccount financialAccount = financialAccountService.getAccountById(transaction.getAccountId());
        Transaction newTransaction = new Transaction(
                transaction.getAmount(),
                transaction.getName(),
                transaction.getTransactionType(),
                transaction.getTransactionCategory(),
                financialAccount,
                transaction.getTransactionDate()
        );

        transactionProcessorService.applyTransaction(newTransaction);
        return transactionRepository.save(newTransaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if(transaction.isEmpty())
            throw new RuntimeException("Transaction with id: " + id + " not found.");

        return transaction.get();
    }

    @Override
    @Transactional
    public Transaction updateTransaction(Long id, TransactionUpdateDTO transaction) {
        Transaction transactionToUpdate = getTransactionById(id);
        transactionToUpdate.setAccount(
                financialAccountService.getAccountById(transaction.getAccountId())
        );
        transactionToUpdate.setAmount(transaction.getAmount());
        transactionToUpdate.setName(transaction.getName());
        transactionToUpdate.setTransactionType(transaction.getTransactionType());
        transactionToUpdate.setTransactionCategory(transaction.getTransactionCategory());
        transactionToUpdate.setTransactionDate(transaction.getTransactionDate());

        transactionProcessorService.updateTransaction(getTransactionById(id), transactionToUpdate);
        return transactionRepository.save(transactionToUpdate);
    }

    @Override
    @Transactional
    public void deleteTransactions(Long id) {
        Transaction transaction = getTransactionById(id);
        transactionProcessorService.unapplyTransaction(transaction);
        transactionRepository.delete(transaction);
    }
}
