package com.bitsnbyte.productlist.mapper;

import com.bitsnbyte.productlist.dto.CategoryDTO;
import com.bitsnbyte.productlist.entity.Category;
import com.bitsnbyte.productlist.entity.Product;

public class CategoryMapper {
    public static CategoryDTO tocategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProduct(category.getProducts().stream().map(ProductMapper::toproductDTO).toList());
        return categoryDTO;

    }

    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }
}
