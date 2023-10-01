package com.abdab.financialtracker.dto.transactionDto;

import com.abdab.financialtracker.models.enums.TransactionCategory;
import com.abdab.financialtracker.models.enums.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
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
