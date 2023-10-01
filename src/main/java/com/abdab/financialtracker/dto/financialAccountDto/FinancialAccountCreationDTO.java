package com.abdab.financialtracker.dto.financialAccountDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialAccountCreationDTO {
    @NotNull
    private Long ownerId;
    @NotNull
    @Min(0)
    private Long base_amount;
    @NotBlank
    private String name;
    @NotBlank
    private String currency;
}
