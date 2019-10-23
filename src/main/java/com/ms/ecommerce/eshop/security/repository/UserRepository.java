package com.ms.ecommerce.eshop.security.repository;

import org.springframework.data.repository.CrudRepository;

import com.ms.ecommerce.eshop.security.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	public User findByUsername(String username);
}
