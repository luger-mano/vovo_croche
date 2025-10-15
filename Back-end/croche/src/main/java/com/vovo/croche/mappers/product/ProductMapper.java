package com.vovo.croche.mappers.product;

import com.vovo.croche.model.Product;
import com.vovo.croche.model.dto.product.ProductRequestDTO;
import com.vovo.croche.model.dto.product.ProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productRequestDTOtoProduct(ProductRequestDTO dto);
    ProductResponseDTO productToProductResponseDTO(Product product);

}
