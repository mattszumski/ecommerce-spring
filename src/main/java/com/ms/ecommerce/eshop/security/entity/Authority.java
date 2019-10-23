package com.ms.ecommerce.eshop.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authority")
public class Authority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="authority")
	private AuthorityType name;
	
	public Authority() {}

	public Authority(AuthorityType name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AuthorityType getName() {
		return name;
	}

	public void setName(AuthorityType name) {
		this.name = name;
	}
}
