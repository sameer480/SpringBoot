package com.bitsnbyte.productlist;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@OpenAPIDefinition(
		info = @Info(
				title = "Product API",
				version = "1.0",
				description = "Documentation Product API v1.0",
				contact= @Contact(
						name = "Sameer Jawed",
						email = "sameerjawed05@gmail.com"
		)
),externalDocs = @ExternalDocumentation(
		description = "Product API",
		url = "example.com"
)
)
@SpringBootApplication
public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);


	}
}
