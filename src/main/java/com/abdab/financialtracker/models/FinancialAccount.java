package com.abdab.financialtracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FinancialAccount {
    @Id
    @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    private Long id;
    private Long amount;
    private String currency;

    @ManyToOne
    private User owner;

    public FinancialAccount(User owner, Long amount, String currency) {
        this.owner = owner;
        this.amount = amount;
        this.currency = currency;
    }
}
