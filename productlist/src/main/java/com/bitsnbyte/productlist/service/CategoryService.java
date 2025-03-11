package com.bitsnbyte.productlist.service;

import com.bitsnbyte.productlist.dto.CategoryDTO;
import com.bitsnbyte.productlist.entity.Category;
import com.bitsnbyte.productlist.mapper.CategoryMapper;
import com.bitsnbyte.productlist.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    //create category
    private CategoryRepository categoryRepository;
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
       category= categoryRepository.save(category);
      return CategoryMapper.tocategoryDTO(category);
    }
    //get all category
        public List<CategoryDTO> getAllCategories(){
            return categoryRepository.findAll().stream().map(CategoryMapper::tocategoryDTO).toList();
        }
        public CategoryDTO getCategoryById(Long id){
            Category category = categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
            return CategoryMapper.tocategoryDTO(category);
        }
    //delete category
    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
