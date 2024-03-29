package com.ms.ecommerce.eshop.security.entity;

public enum  AuthorityType {

    ROLE_ADMIN("Admin"),
    ROLE_USER("User"),
	ROLE_CLIENT("Client");
    
    
    private String label;

	private AuthorityType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}