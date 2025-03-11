package com.bitsnbyte.productlist.repository;

import com.bitsnbyte.productlist.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
