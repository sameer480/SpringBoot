package com.bitsnbyte.productlist.controller;

import com.bitsnbyte.productlist.dto.ProductDTO;
import com.bitsnbyte.productlist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        public List<ProductDTO> getAllProducts() {
            return productService.getAllProducts();
        }
        //get product by id
        public ProductDTO getProductById(Long id) {
            return productService.getProductById(id);
        }
        //delete product
        public void deleteProduct(Long id) {
            productService.deleteProduct(id);
        }
    }
