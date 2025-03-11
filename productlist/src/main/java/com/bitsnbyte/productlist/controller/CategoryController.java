package com.bitsnbyte.productlist.controller;

import com.bitsnbyte.productlist.dto.CategoryDTO;
import com.bitsnbyte.productlist.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
@PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){
    return categoryService.createCategory(categoryDTO);

}
}
