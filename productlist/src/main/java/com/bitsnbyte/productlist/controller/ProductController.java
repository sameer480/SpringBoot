package com.bitsnbyte.productlist.controller;

import com.bitsnbyte.productlist.dto.ProductDTO;
import com.bitsnbyte.productlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //get all products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    //get product by id
    @GetMapping("/{id}")
    public ProductDTO getProductById(Long id) {
        return productService.getProductById(id);
    }

    //delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(Long id) {
        productService.deleteProduct(id);
    }

    //update product
    @PutMapping("/{id}")
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }
}
