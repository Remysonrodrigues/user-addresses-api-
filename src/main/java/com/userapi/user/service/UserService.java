package com.userapi.user.service;

import com.userapi.user.dto.MessageResponseDTO;
import com.userapi.user.entities.User;
import com.userapi.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public MessageResponseDTO createUser(User user) {
        User savedUser = repository.save(user);
        return createMessageResponse(savedUser.getId(), "Created User with ID ");
    }

    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result.stream().map(User::new).collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return new MessageResponseDTO(message + id);
    }
}
