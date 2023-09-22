package com.abdab.financialtracker.services.user;

import com.abdab.financialtracker.dto.userDto.UserRegistrationDTO;
import com.abdab.financialtracker.dto.userDto.UserUpdateDTO;
import com.abdab.financialtracker.models.User;

public interface UserService {
    User registerUser(UserRegistrationDTO user);
    User updateUser(Long id, UserUpdateDTO user);
    User getUserByEmail(String email);
    User getUserById(Long id);
    void deleteUser(Long id);
}
