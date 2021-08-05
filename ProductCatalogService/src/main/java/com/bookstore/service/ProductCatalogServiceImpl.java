package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.entity.*;
import com.bookstore.model.Product;
import com.bookstore.repository.ProductCatalogRepo;

@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	@Autowired
	private ProductCatalogRepo productCatalogRepository;

	@Autowired
	private ModelMapper ModelMapper;
	
	/**show all available products in database*/
	@Override
	public List<Product> fetchProuctDetails() {
		TypeToken<List<Product>> productsListType = new TypeToken<List<Product>>() {};
		return ModelMapper.map(productCatalogRepository.findAll(), productsListType.getType());
	}

	/**find specified products with id  */
	@Override
	public Product findProductById(Integer id) {
		Optional<ProductEntity> productOptional = productCatalogRepository.findById(id);
		return ModelMapper.map(productOptional.get(), Product.class);
	}

}
