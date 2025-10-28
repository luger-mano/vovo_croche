package com.vovo.croche.controller;


import com.vovo.croche.model.dto.address.AddressCepRequestDTO;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.service.AddressService;
import com.vovo.croche.service.UserRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    private final AddressService service;
    private final UserRegistrationService userRegistrationService;
    public AddressController(AddressService service, UserRegistrationService userRegistrationService) {
        this.service = service;
        this.userRegistrationService = userRegistrationService;
    }

    @GetMapping("/search-by-address")
    public ResponseEntity<List<AddressResponseDTO>> searchForCepsThroughTheStreets(@RequestBody AddressRequestDTO dto) {

        List<AddressResponseDTO> address = service.searchForCepsThroughTheStreets(dto);
        return ResponseEntity.ok(address);
    }

    @GetMapping("/search-cep")
    public ResponseEntity<AddressResponseDTO> getAddressByCep(@RequestBody AddressCepRequestDTO dto) throws IOException, InterruptedException {
        return ResponseEntity.ok(service.searchAddressByCep(dto));
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<String> saveOrUpdateAddressOfUser(@PathVariable("id") UUID id,
                                                    @RequestBody AddressCepRequestDTO dto){
        String response = this.userRegistrationService.saveAddressOfUser(id, dto);
        return ResponseEntity.ok(response);
    }
}
