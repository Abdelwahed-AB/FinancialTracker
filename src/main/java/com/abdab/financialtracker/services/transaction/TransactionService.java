package com.abdab.financialtracker.services.transaction;

import com.abdab.financialtracker.dto.transactionDto.TransactionCreationDTO;
import com.abdab.financialtracker.dto.transactionDto.TransactionUpdateDTO;
import com.abdab.financialtracker.models.Transaction;

public interface TransactionService {
    Transaction createTransaction(TransactionCreationDTO transaction);
    Transaction getTransactionById(Long id);
    Transaction updateTransaction(Long id, TransactionUpdateDTO transaction);
    void deleteTransactions(Long id);
}
