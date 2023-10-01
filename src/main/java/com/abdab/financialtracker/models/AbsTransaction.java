package com.abdab.financialtracker.models;

import com.abdab.financialtracker.models.enums.TransactionCategory;
import com.abdab.financialtracker.models.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public abstract class AbsTransaction {
    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    @Column(updatable = false)
    private Long id;
    private Long amount;
    private String name;

    private TransactionType transactionType;
    private TransactionCategory transactionCategory;
    private LocalDate transactionDate;

    @ManyToOne
    private FinancialAccount account;

    public AbsTransaction(Long amount,
                       String name,
                       TransactionType transactionType,
                       TransactionCategory transactionCategory,
                       FinancialAccount account,
                       LocalDate transactionDate) {
        this.amount = amount;
        this.name = name;
        this.transactionType = transactionType;
        this.transactionCategory = transactionCategory;
        this.account = account;
        this.transactionDate = transactionDate;
    }
}
