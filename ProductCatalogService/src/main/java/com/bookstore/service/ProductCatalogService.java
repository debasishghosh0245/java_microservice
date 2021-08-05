package com.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstore.model.Product;

@Service
public interface ProductCatalogService {
	
	List<Product> fetchProuctDetails();
	Product findProductById(Integer id);
}
