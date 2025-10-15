package com.vovo.croche.model.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private List<ProductResponseDTO> products;
    private int page;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    public ProductDTO(List<ProductResponseDTO> products, int page, int pageSize, int totalPages, long totalElements) {
        this.products = products;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public ProductDTO() {
    }
}
