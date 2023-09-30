package com.abdab.financialtracker.dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserUpdateDTO {
    @NotNull
    @Size(min = 5)
    private String username;
}
