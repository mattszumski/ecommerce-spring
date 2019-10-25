package com.ms.ecommerce.eshop.data.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @Column(name = "id", length = 50)
    private String id;
 
    @Column(name = "amount", nullable = false)
    private double amount;
    
    @Column(name = "order_Num", nullable = false)
    private int orderNum;
    
    @Column(name = "order_Date", nullable = false)
    private ZonedDateTime orderDate;
 
    @Column(name = "customer_Name", nullable = false)
    private String customerName;
 
    @Column(name = "customer_Address", nullable = false)
    private String customerAddress;
 
    @Column(name = "customer_Email", nullable = false)
    private String customerEmail;
 
    @Column(name = "customer_Phone", nullable = false)
    private String customerPhone;
    
    public Order() {
    }

	public Order(String id, double amount, int orderNum, ZonedDateTime orderDate, String customerName,
			String customerAddress, String customerEmail, String customerPhone) {
		this.id = id;
		this.amount = amount;
		this.orderNum = orderNum;
		this.orderDate = orderDate;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public ZonedDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(ZonedDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
}
