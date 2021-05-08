package com.userapi.user.controller;

import com.userapi.user.dto.MessageResponseDTO;
import com.userapi.user.entities.Address;
import com.userapi.user.entities.User;
import com.userapi.user.exception.UserNotFoundException;
import com.userapi.user.service.AddressService;
import com.userapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid User user) {
        return userService.createUser(user);
    }

    @PostMapping("/{id}/address")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAddress(
        @RequestBody @Valid Address address,
        @PathVariable Long id
    ) throws UserNotFoundException  {
        User user = userService.findById(id);
        return addressService.createAddress(user, address);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) throws UserNotFoundException {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
