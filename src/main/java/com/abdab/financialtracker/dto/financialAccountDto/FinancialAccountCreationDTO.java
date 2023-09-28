package com.abdab.financialtracker.dto.financialAccountDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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
