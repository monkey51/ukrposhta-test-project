package com.ukrposhta.restdemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductWithQuantityDto {
        private Long id;
        private String productName;
        private String description;
        private String category;
        private Double price;
        private Float discount;
        private Long quantity;
    }