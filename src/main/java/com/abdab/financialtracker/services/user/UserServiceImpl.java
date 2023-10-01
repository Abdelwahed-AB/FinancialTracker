package com.abdab.financialtracker.services.user;

import com.abdab.financialtracker.dto.userDto.UserRegistrationDTO;
import com.abdab.financialtracker.dto.userDto.UserUpdateDTO;
import com.abdab.financialtracker.models.User;
import com.abdab.financialtracker.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User registerUser(UserRegistrationDTO user) {
        Optional<User> emailCheck = userRepository.findByEmail(user.getEmail());
        if(emailCheck.isEmpty()){
            User newUser = new User(user.getUsername(),
                                    user.getEmail(),
                                    user.getPassword(),
                                    LocalDate.now());
            return userRepository.save(newUser);
        }

        //TODO: Switch to custom exception
        throw new RuntimeException("Email : " + user.getEmail() +" is Already taken.");
    }

    @Override
    public User updateUser(Long id, UserUpdateDTO user) {
        User userToUpdate = getUserById(id);
        userToUpdate.setUsername(user.getUsername());
        return userRepository.save(userToUpdate);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty())
            throw new RuntimeException("User with email: " + email + " not found.");
        return user.get();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new RuntimeException("User with id: " + id + " not found.");

        return user.get();
    }

    @Override
    public void deleteUser(Long id) {
        getUserById(id);
        userRepository.deleteById(id);
    }
}
