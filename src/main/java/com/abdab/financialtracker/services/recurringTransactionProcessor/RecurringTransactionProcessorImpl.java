package com.abdab.financialtracker.services.recurringTransactionProcessor;

import com.abdab.financialtracker.dto.transactionDto.TransactionCreationDTO;
import com.abdab.financialtracker.mappers.RecurringTransactionMapper;
import com.abdab.financialtracker.models.RecurringTransaction;
import com.abdab.financialtracker.repositories.RecurringTransactionRepository;
import com.abdab.financialtracker.services.transaction.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecurringTransactionProcessorImpl implements RecurringTransactionProcessor {

    private final RecurringTransactionRepository recurringTransactionRepository;
    private final TransactionService transactionService;
    private final RecurringTransactionMapper recurringTransactionMapper;

    @Override
    @Scheduled(cron = "0 0 * * *")
    public void generateTransactions() {
        List<RecurringTransaction> transactions = recurringTransactionRepository.findByTransactionDate(LocalDate.now());
        for (RecurringTransaction t: transactions) {
            TransactionCreationDTO transactionDto = recurringTransactionMapper.recurringTransactionToTransactionDto(t);
            transactionService.createTransaction(transactionDto);
        }
    }
}
