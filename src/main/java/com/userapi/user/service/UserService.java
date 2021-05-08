package com.userapi.user.service;

import com.userapi.user.dto.MessageResponseDTO;
import com.userapi.user.entities.User;
import com.userapi.user.exception.UserNotFoundException;
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
        return createMessageResponse(savedUser.getId());
    }

    public User findById(Long id) throws UserNotFoundException {
        return verifyIfExists(id);
    }

    public List<User> findAll() {
        List<User> result = repository.findAll();
        return result.stream().map(User::new).collect(Collectors.toList());
    }

    private User verifyIfExists(Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    private MessageResponseDTO createMessageResponse(Long id) {
        return new MessageResponseDTO("Created User with ID " + id);
    }
}
