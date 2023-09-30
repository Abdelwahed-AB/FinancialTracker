package com.abdab.financialtracker.services.transactionProcessor;

import com.abdab.financialtracker.models.Transaction;

public interface TransactionProcessorService {
    void applyTransaction(Transaction transaction);
    void unapplyTransaction(Transaction transaction);
    void updateTransaction(Transaction oldTransaction, Transaction newTransaction);
}
