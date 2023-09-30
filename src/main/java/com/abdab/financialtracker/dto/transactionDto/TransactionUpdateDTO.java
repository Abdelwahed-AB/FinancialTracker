package com.abdab.financialtracker.dto.transactionDto;

import com.abdab.financialtracker.models.enums.TransactionCategory;
import com.abdab.financialtracker.models.enums.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionUpdateDTO {
    @NotNull
    private Long accountId;
    @NotNull
    @Min(0)
    private Long amount;
    @NotNull
    private Boolean monthly;
    @NotBlank
    private String name;
    @NotNull
    private TransactionType transactionType;
    @NotNull
    private TransactionCategory transactionCategory;
    @NotNull
    private LocalDate transactionDate;
}
