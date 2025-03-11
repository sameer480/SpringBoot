package com.bitsnbyte.productlist.service;

import com.bitsnbyte.productlist.dto.CategoryDTO;
import com.bitsnbyte.productlist.entity.Category;
import com.bitsnbyte.productlist.mapper.CategoryMapper;
import com.bitsnbyte.productlist.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    //create category
    private CategoryRepository categoryRepository;
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category= categoryRepository.save(category);
      return CategoryMapper.tocategoryDTO(category);
    }
    //get all category

    //delete category

}
