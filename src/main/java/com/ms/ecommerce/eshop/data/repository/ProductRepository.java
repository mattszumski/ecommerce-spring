package com.ms.ecommerce.eshop.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.ecommerce.eshop.data.entity.Product;
import com.ms.ecommerce.eshop.data.entity.ProductCategory;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByCategory(ProductCategory productCategory);
	Optional<Product> findByName(String name);
}
