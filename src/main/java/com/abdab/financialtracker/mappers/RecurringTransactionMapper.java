package com.abdab.financialtracker.mappers;

import com.abdab.financialtracker.dto.transactionDto.TransactionCreationDTO;
import com.abdab.financialtracker.models.FinancialAccount;
import com.abdab.financialtracker.models.RecurringTransaction;

import java.time.LocalDate;

public class RecurringTransactionMapper {

    public RecurringTransaction transactionDtoToRecurringTransaction(TransactionCreationDTO dto, FinancialAccount account){
        return (RecurringTransaction) RecurringTransaction.builder()
                .account(account)
                .transactionCategory(dto.getTransactionCategory())
                .transactionDate(LocalDate.now())
                .transactionType(dto.getTransactionType())
                .amount(dto.getAmount())
                .name(dto.getName())
                .build();
    }

    public TransactionCreationDTO recurringTransactionToTransactionDto(RecurringTransaction rTransaction){
        return TransactionCreationDTO.builder()
                .accountId(rTransaction.getAccount().getId())
                .amount(rTransaction.getAmount())
                .name(rTransaction.getName())
                .transactionCategory(rTransaction.getTransactionCategory())
                .transactionType(rTransaction.getTransactionType())
                .transactionDate(rTransaction.getTransactionDate())
                .build();
    }
}
