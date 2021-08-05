package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.model.Product;
import com.bookstore.service.ProductCatalogService;

@RestController
@RequestMapping(value = "/api")
public class ProductCatalogController {

	@Autowired
	private ProductCatalogService productCatalogService;

	@GetMapping("/products")
	public List<Product> productList() {
		return productCatalogService.fetchProuctDetails();
	}

	/** Finding specific product with Id */
	@GetMapping("/products/{id}")
	public Product findProductById(@PathVariable Integer id) {
		return productCatalogService.findProductById(id);
	}
	
}
