package com.vovo.croche.service;

import com.vovo.croche.mappers.address.AddressMapper;
import com.vovo.croche.model.Address;
import com.vovo.croche.model.User;
import com.vovo.croche.model.dto.address.AddressCepRequestDTO;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.repository.AddressRepository;
import com.vovo.croche.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
public class UserRegistrationService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public UserRegistrationService(UserRepository userRepository, AddressRepository addressRepository, AddressService addressService, AddressMapper addressMapper) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @Transactional
    public String saveAddressOfUser(UUID id, AddressCepRequestDTO dto) {
        try {
            User user = this.userRepository.findById(id).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND));

            AddressResponseDTO addressResponse = addressService.searchAddressByCep(dto);
            Address addressMapp = addressMapper.addressResponseDtoToAddress(addressResponse);

            Address addressOpp = addressRepository.findByUserId(user.getId()).orElse(new Address());
            addressOpp.setUser(user);
            addressOpp.setCep(addressMapp.getCep());
            addressOpp.setComplemento(addressMapp.getComplemento());
            addressOpp.setEstado(addressMapp.getEstado());
            addressOpp.setBairro(addressMapp.getBairro());
            addressOpp.setUf(addressMapp.getUf());
            addressOpp.setLogradouro(addressMapp.getLogradouro());
            addressOpp.setLocalidade(addressMapp.getLocalidade());
            addressOpp.setDdd(addressMapp.getDdd());
            addressOpp.setIbge(addressMapp.getIbge());
            addressOpp.setGia(addressMapp.getGia());
            addressOpp.setRegiao(addressMapp.getRegiao());
            addressOpp.setSiafi(addressMapp.getSiafi());
            this.addressRepository.save(addressOpp);

            return "Endereço salvo!";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
