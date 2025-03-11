package com.bitsnbyte.productlist.mapper;

import com.bitsnbyte.productlist.dto.ProductDTO;
import com.bitsnbyte.productlist.entity.Category;
import com.bitsnbyte.productlist.entity.Product;

public class ProductMapper {
    //to product dto
    public static ProductDTO toproductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
    //dto to entity
    public static Product toProductEntity(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }

}
