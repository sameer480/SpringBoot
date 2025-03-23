package com.bitsnbyte.productlist.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;
@Schema(
        name = "Category",
        description = "Category Data Transfer Object"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> product;
}
