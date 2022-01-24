package com.example.demo.Dto;


import java.math.BigDecimal;

import com.example.demo.Entity.ProductEntity;

public class productDtoUpdate {
	private String name;
	private String description;
	private BigDecimal price;
	
	public productDtoUpdate() {
	}

	public productDtoUpdate(Long id, String name, String description, BigDecimal price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public productDtoUpdate(ProductEntity productEntity) {
		this.name = productEntity.getName();
		this.description = productEntity.getDescription();
		this.price = productEntity.getPrice();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
