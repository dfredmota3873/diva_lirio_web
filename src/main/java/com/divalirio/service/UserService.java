package com.divalirio.service;


import com.divalirio.exception.EntityNotFoundException;
import com.divalirio.model.User;
import com.divalirio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService extends BaseService{

    private final UserRepository repository;

    public User create(User user) {
        return repository.save(user);
    }

    public User findById(UUID uuid){
        return repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException(getMessage("user.notfound")));
    }

    public List<User> findAll(){
        return  repository.findAll();
    }

    public void deleteById(UUID uuid){
        repository.deleteById(uuid);
    }
}
