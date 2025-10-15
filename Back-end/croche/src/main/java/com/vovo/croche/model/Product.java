package com.vovo.croche.model;


import com.vovo.croche.enums.Material;
import com.vovo.croche.enums.Packaging;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "TABLE_PRODUCTS")
@Getter
@Setter
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(unique = true)
    private String name;
    private String description;
    @Enumerated(EnumType.STRING)
    private Material material;
    @Enumerated(EnumType.STRING)
    private Packaging packaging;
    private double weight;
    private int amount;
    private double value;
    @CreationTimestamp
    private Instant creationAt;

}
