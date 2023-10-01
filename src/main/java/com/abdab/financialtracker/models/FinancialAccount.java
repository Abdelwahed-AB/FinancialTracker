package com.abdab.financialtracker.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialAccount {
    @Id
    @SequenceGenerator(name = "account_sequence", sequenceName = "account_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    @Column(updatable = false)
    private Long id;
    @Column(updatable = false)
    private Long base_amount;
    private Long current_amount;
    private String name;
    private String currency;

    @ManyToOne
    private User owner;

    public FinancialAccount(Long base_amount, String name, String currency, User owner) {
        this.base_amount = base_amount;
        this.current_amount = base_amount;
        this.name = name;
        this.currency = currency;
        this.owner = owner;
    }
}
