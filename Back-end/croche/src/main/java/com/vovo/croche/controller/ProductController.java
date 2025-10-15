package com.vovo.croche.controller;


import com.vovo.croche.model.dto.product.ProductDTO;
import com.vovo.croche.model.dto.product.ProductRequestDTO;
import com.vovo.croche.model.dto.product.ProductResponseDTO;
import com.vovo.croche.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<String> registerProduct(@RequestBody ProductRequestDTO dto){
        String productSave = this.service.saveProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSave);
    }

    @GetMapping
    public ResponseEntity<ProductDTO> getAllProducts(@RequestParam(value = "page", defaultValue = "0") int page,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize){
        ProductDTO products = service.getAllProducts(page, pageSize);
        return ResponseEntity.ok(products);
    }


}
