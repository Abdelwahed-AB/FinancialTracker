package com.abdab.financialtracker.models;

import com.abdab.financialtracker.models.enums.TransactionCategory;
import com.abdab.financialtracker.models.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction extends AbsTransaction{
    public Transaction(Long amount,
                          String name,
                          TransactionType transactionType,
                          TransactionCategory transactionCategory,
                          FinancialAccount account,
                          LocalDate transactionDate) {
        super(amount, name, transactionType, transactionCategory, account, transactionDate);
    }
}
