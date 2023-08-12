package com.divalirio.service;


import com.divalirio.model.User;
import com.divalirio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;

    public User create(User user) {

        String passwordEncoded = encoder.encode(user.getPassword());

        user.setPassword(passwordEncoded);

        return repository.save(user);
    }
}
