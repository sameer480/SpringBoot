package com.bitsnbyte.productlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductListApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductListApplication.class, args);
		MyApp myComponent=context.getBean(MyApp.class);
		myComponent.run();

	}
}
