package com.vovo.croche.controller;


import com.vovo.croche.model.dto.address.AddressCepRequestDTO;
import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
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
}
