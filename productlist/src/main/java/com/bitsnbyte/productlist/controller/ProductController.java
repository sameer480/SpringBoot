package com.bitsnbyte.productlist.controller;

import com.bitsnbyte.productlist.dto.ProductDTO;
import com.bitsnbyte.productlist.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Product Controller",
        description = "Product Controller for CRUD operations"
)
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
@Operation(
        summary = "Get all products",
        description = "Get all products from the database"
)
    //get all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
@Operation(
        summary = "Get product by id",
        description = "Get product by id from the database"
)
    //get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(Long id) {
        return productService.getProductById(id);
    }
    @Operation(
            summary = "Delete product",
            description = "Delete product by id from the database"
    )

    //delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }
@Operation(
        summary = "Update product",
        description = "Update product by id from the database"
)
    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }
}
