package com.ms.ecommerce.eshop.data.entity;

public enum ShippingMethod {
	Electronic("Shipping through e-mail."),
	Physical("Physical product will be sent via selected shipping method.");
	
	private String label;
	
	private  ShippingMethod (String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
