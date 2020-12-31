package com.ukrposhta.restdemoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String productName;
    private String description;
    private String category;
    private Double price;
    private Float discount;
}
