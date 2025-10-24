package com.vovo.croche.service;

import com.vovo.croche.mappers.address.AddressMapper;
import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.address.AddressCepRequestDTO;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class UserRegistrationService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public UserRegistrationService(UserService userService, UserRepository userRepository, AddressService addressService, AddressMapper addressMapper) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

//    @Transactional
//    public AddressResponseDTO saveAddressOfUser(UUID id, AddressCepRequestDTO dto) {
//        User user = this.userRepository.findById(id).orElseThrow(() ->
//                new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        AddressResponseDTO addressResponse = addressService.searchAddressByCep(dto);
//
//        user.setAddress(addressMap);
//
//        return addressMap.
//    }

}
