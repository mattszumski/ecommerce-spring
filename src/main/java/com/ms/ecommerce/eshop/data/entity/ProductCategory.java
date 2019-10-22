package com.ms.ecommerce.eshop.data.entity;

public enum ProductCategory {
	PCGame("PC Game"),
	ConsoleGame("Console Game"),
	Book("Book"),
	Movie("Movie");
	
	
	private String label;

	private ProductCategory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}	
	
}
