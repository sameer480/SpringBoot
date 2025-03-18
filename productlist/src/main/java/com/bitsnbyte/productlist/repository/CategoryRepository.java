package com.bitsnbyte.productlist.repository;

import com.bitsnbyte.productlist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
 Optional<Category> findByName(String categoryName);
}
