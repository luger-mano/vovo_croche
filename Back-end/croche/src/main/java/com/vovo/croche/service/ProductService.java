package com.vovo.croche.service;


import com.vovo.croche.mappers.product.ProductMapper;
import com.vovo.croche.model.Product;
import com.vovo.croche.model.dto.product.ProductDTO;
import com.vovo.croche.model.dto.product.ProductRequestDTO;
import com.vovo.croche.model.dto.product.ProductResponseDTO;
import com.vovo.croche.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public String saveProduct(ProductRequestDTO dto) {
        try {
            Product product = mapper.productRequestDTOtoProduct(dto);

            if (this.repository.existsById(product.getProductId())) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
            product.setPackaging(dto.getPackaging());

            repository.save(product);

            return "Produto cadastrado!";

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public ProductDTO getAllProducts(int page, int pageSize){
        Page<ProductResponseDTO> products = this.repository.findAll(PageRequest.of(page,
                pageSize,
                Sort.Direction.DESC,
                "creationAt")).map(p -> new ProductResponseDTO(p.getProductId(), p.getName(), p.getDescription(), p.getMaterial(), p.getPackaging(), p.getWeight(), p.getAmount(), p.getValue()));

        return new ProductDTO(products.getContent(), page, pageSize, products.getTotalPages(), products.getTotalElements());
    }

}
