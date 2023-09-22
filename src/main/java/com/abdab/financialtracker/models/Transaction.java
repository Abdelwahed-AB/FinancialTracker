package com.abdab.financialtracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_sequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_sequence")
    private Long id;
    private Long amount;

    @ManyToOne
    private FinancialAccount account;

    public Transaction(Long amount, FinancialAccount account) {
        this.amount = amount;
        this.account = account;
    }
}
