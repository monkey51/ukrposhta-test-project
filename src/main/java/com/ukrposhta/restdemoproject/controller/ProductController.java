package com.ukrposhta.restdemoproject.controller;

import com.ukrposhta.restdemoproject.dto.ProductDto;
import com.ukrposhta.restdemoproject.dtoconvertor.ProductDtoConvertor;
import com.ukrposhta.restdemoproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/list")
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductDto> getProducts(@RequestParam(value = "category", required = false ) String category){
        if (category==null){
            return productService.findAllProducts().stream().map(ProductDtoConvertor::convertToDto).collect(Collectors.toList());
        }
         return productService.findAllProductsByCategoryName(category).stream().map(ProductDtoConvertor::convertToDto).collect(Collectors.toList());
    }

}
