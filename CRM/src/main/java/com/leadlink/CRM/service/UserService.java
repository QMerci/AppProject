package com.leadlink.CRM.service;

import com.leadlink.CRM.model.UserModel;
import com.leadlink.CRM.model.UserRole;
import com.leadlink.CRM.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public void register(UserModel user){
        user.setRole(UserRole.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public UserModel findByLogin(String login) {
        return userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(login))
                .findFirst()
                .orElse(null);
    }

}
