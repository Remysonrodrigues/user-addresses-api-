package com.userapi.user.service;

import com.userapi.user.dto.MessageResponseDTO;
import com.userapi.user.entities.Address;
import com.userapi.user.entities.User;
import com.userapi.user.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public MessageResponseDTO createAddress(User user, Address address) {
        address.setUser(user);
        Address savedAddress = repository.save(address);
        return createMessageResponse(savedAddress.getId());
    }

    private MessageResponseDTO createMessageResponse(Long id) {
        return new MessageResponseDTO("Created Address with ID " + id);
    }
}
