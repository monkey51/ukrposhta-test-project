package com.ukrposhta.restdemoproject.dtoconvertor;

import com.ukrposhta.restdemoproject.dto.ProductDto;
import com.ukrposhta.restdemoproject.dto.ProductWithQuantityDto;
import com.ukrposhta.restdemoproject.model.Discount;
import com.ukrposhta.restdemoproject.model.Product;

public class ProductWithQuantityDtoConvertor {
    public static ProductWithQuantityDto convertToDto(Product product, Long quantity){
        return new ProductWithQuantityDto(
                product.getId(),
                product.getProductName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),
                product.getDiscount()==null?null:product.getDiscount().getDiscount(),
                quantity
        );
    }
}
