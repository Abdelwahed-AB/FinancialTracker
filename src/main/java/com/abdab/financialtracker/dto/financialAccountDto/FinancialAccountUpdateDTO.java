package com.abdab.financialtracker.dto.financialAccountDto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FinancialAccountUpdateDTO {
    @NotNull
    @Size(min=3)
    private String name;
    @NotNull
    @Size(min=1)
    private String currency;
}
