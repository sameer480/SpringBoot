package com.bitsnbyte.productlist.service;

import com.bitsnbyte.productlist.dto.ProductDTO;
import com.bitsnbyte.productlist.entity.Category;
import com.bitsnbyte.productlist.entity.Product;
import com.bitsnbyte.productlist.mapper.ProductMapper;
import com.bitsnbyte.productlist.repository.CategoryRepository;
import com.bitsnbyte.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toproductDTO(product);
    }

    //get all products
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toproductDTO).toList();
    }

    //get product by id
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toproductDTO(product);
    }

    //delete product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    //update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        product = productRepository.save(product);
        return ProductMapper.toproductDTO(product);
    }

}
