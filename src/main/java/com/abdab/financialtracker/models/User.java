package com.abdab.financialtracker.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String username;
    private String email;
    private String password;
    private LocalDate joinDate;

    private Boolean locked;
    private Boolean enabled;

    public User(String username, String email, String password, LocalDate joinDate, Boolean locked, Boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.locked = locked;
        this.enabled = enabled;
    }
}
