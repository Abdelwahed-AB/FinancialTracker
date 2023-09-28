package com.abdab.financialtracker.models;

import com.abdab.financialtracker.models.enums.TransactionCategory;
import com.abdab.financialtracker.models.enums.TransactionType;
import jakarta.annotation.Nullable;
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
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    @Column(updatable = false)
    private Long id;
    private Long amount;
    private Boolean monthly;
    private String name;

    private TransactionType transactionType;
    private TransactionCategory transactionCategory;
    private LocalDate transactionDate;

    @ManyToOne
    private FinancialAccount account;

    public Transaction(Long amount,
                       Boolean monthly,
                       String name,
                       TransactionType transactionType,
                       TransactionCategory transactionCategory,
                       FinancialAccount account,
                       LocalDate transactionDate) {
        this.amount = amount;
        this.monthly = monthly;
        this.name = name;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.account = account;
        this.transactionDate = transactionDate;
    }
}
