package com.ukrposhta.restdemoproject.dtoconvertor;

import com.ukrposhta.restdemoproject.dto.ProductDto;
import com.ukrposhta.restdemoproject.model.Discount;
import com.ukrposhta.restdemoproject.model.Product;

public class ProductDtoConvertor {
    public static ProductDto convertToDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getDescription(),
                product.getCategory(),
                product.getPrice(),

                product.getDiscount()==null?null:product.getDiscount().getDiscount()
        );
    }

    public static Product convertToEntity(ProductDto productDto, Discount discount){
        Product product =  new Product();
                product.setId(productDto.getId());
                product.setProductName(productDto.getProductName());
                product.setDescription(productDto.getDescription());
                product.setCategory(productDto.getCategory());
                product.setPrice(productDto.getPrice());
                product.setDiscount(discount);

                return product;
    }
}
