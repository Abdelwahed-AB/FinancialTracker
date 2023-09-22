package com.abdab.financialtracker.repositories;

import com.abdab.financialtracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
