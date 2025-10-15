package com.vovo.croche.model.dto.product;

import com.vovo.croche.enums.Material;
import com.vovo.croche.enums.Packaging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private Long productId;
    private String name;
    private String description;
    private Material material;
    private Packaging packaging;
    private Double weight;
    private int amount;
    private double value;

    public ProductResponseDTO(Long productId, String name, String description, Material material, Packaging packaging, Double weight, int amount, double value) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.material = material;
        this.packaging = packaging;
        this.weight = weight;
        this.amount = amount;
        this.value = value;
    }

    public ProductResponseDTO() {
    }
}
