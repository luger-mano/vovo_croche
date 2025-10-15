package com.vovo.croche.model.dto.product;

import com.vovo.croche.enums.Material;
import com.vovo.croche.enums.Packaging;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {

    private String name;
    private String description;
    private Material material;
    private Packaging packaging;
    private Double weight;
    private int amount;
    private double value;
}
