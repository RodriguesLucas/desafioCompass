package com.example.demo.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.InsertProductDto;
import com.example.demo.Dto.productDto;
import com.example.demo.Dto.productDtoUpdate;
import com.example.demo.Entity.ProductEntity;
import com.example.demo.Repository.productCustomRepository;
import com.example.demo.Repository.productRepository;
import com.example.demo.exception.RecordNotFoundException;

@Service
public class productService {
	private productRepository productsRepository;
	private productCustomRepository productCustomRepository;

	@Autowired
	public productService(productRepository productsRepository, productCustomRepository productCustomRepository) {
		this.productsRepository = productsRepository;
		this.productCustomRepository = productCustomRepository;
	}

	public Page<productDto> findAll(Pageable pageable) {
		return productsRepository.findAll(pageable).map(productDto::new);
	}

	public productDto findById(Long id) {
		return new productDto(checkAndGetById(id));
	}

	public List<productDto> findByFiltro(String q, BigDecimal min_price, BigDecimal max_price) {
		return productCustomRepository.filtro(q, min_price, max_price)
				.stream()
				.map(productDto::new)
				.collect(Collectors.toList());
	}

	public productDto insert(InsertProductDto insertProductDto) {
		return new productDto(productsRepository.save(setValoresInsert(insertProductDto)));
	}

	@Transactional
	public productDto updateById(Long id, productDtoUpdate productDtoUpdate) {
		ProductEntity productEntity = checkAndGetById(id);
		return new productDto(setValoresUpdate(productEntity, productDtoUpdate));
	}

	public Object deleteById(Long id) {
		checkExistById(id);
		productsRepository.deleteById(id);
		return HttpStatus.OK;
	}
	
	public ProductEntity checkAndGetById(Long id) {
		return productsRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Id: " + id + " não encontrado!"));
	}

	public void checkExistById(Long id) {
		if (!productsRepository.existsById(id))
			throw new RecordNotFoundException("Id: " + id + " não encontrado!");
	}

	public ProductEntity setValoresUpdate(ProductEntity productEntity, productDtoUpdate productDtoUpdate) {
		productEntity.setName(productDtoUpdate.getName());
		productEntity.setPrice(productDtoUpdate.getPrice());
		productEntity.setDescription(productDtoUpdate.getDescription());
		return productEntity;
	}

	public ProductEntity setValoresInsert(InsertProductDto insertProductDto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(insertProductDto.getName());
		productEntity.setPrice(insertProductDto.getPrice());
		productEntity.setDescription(insertProductDto.getDescription());
		return productEntity;
	}
}
