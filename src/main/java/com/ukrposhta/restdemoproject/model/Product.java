package com.ukrposhta.restdemoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String description;
    private String category;
    private Double price;
    @OneToOne
    @JoinColumn(name = "discount_id")
    private Discount discount;
}
