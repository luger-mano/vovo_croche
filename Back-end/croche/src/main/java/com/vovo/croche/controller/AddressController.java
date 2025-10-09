package com.vovo.croche.controller;


import com.vovo.croche.model.dto.address.AddressRequestDTO;
import com.vovo.croche.model.dto.address.AddressResponseDTO;
import com.vovo.croche.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping("/search-by-address")
    public ResponseEntity<List<AddressResponseDTO>> searchForCepsThroughTheStreets(@RequestBody AddressRequestDTO dto) throws IOException, InterruptedException {

        List<AddressResponseDTO> address = service.searchForCepsThroughTheStreets(dto);

        return ResponseEntity.ok(address);
    }
}
