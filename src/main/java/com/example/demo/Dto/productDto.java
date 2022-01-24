package com.example.demo.Dto;

import java.math.BigDecimal;


import com.example.demo.Entity.ProductEntity;


public class productDto {
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	
	public productDto() {
	}

	public productDto(Long id, String name, String description, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public productDto(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.name = productEntity.getName();
		this.description = productEntity.getDescription();
		this.price = productEntity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
