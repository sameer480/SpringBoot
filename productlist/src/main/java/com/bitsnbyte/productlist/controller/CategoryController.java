package com.bitsnbyte.productlist.controller;

import com.bitsnbyte.productlist.dto.CategoryDTO;
import com.bitsnbyte.productlist.exception.CategoryAlreadyExistsException;
import com.bitsnbyte.productlist.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
@Operation(
        summary = "Get all categories",
        description = "Get all categories from the database"
)
    //get all categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @Operation(
            summary = "Create category",
            description = "Create category in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Category created"
    )
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {

            CategoryDTO savedCategory = categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

        //return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    @Operation(
            summary = "Get category by id",
            description = "Get category by id from the database"
    )

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }
@Operation(
        summary = "Delete category",
        description = "Delete category by id from the database"
)
    //delete category

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
