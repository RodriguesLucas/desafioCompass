package com.example.demo.Controller;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.productDtoUpdate;
import com.example.demo.Dto.InsertProductDto;
import com.example.demo.Dto.productDto;
import com.example.demo.Service.productService;

@RestController
@RequestMapping("/products")
public class productController {
	private productService productsService;

	@Autowired
	public productController(productService productsService) {
		this.productsService = productsService;
	}

	@GetMapping()
	public ResponseEntity<Page<productDto>> findAll(@PageableDefault(size = 5) Pageable pageable) {
		System.out.println(pageable.getPageNumber());
		return ResponseEntity.ok(productsService.findAll(pageable));
	}

	@GetMapping("/")
	public ResponseEntity<productDto> findById(@RequestParam Long id) {
		return ResponseEntity.ok(productsService.findById(id));
	}

	@GetMapping("/search")
	public ResponseEntity<List<productDto>> findByFiltro(@RequestParam(required = false, name = "q") String q,
			@RequestParam(required = false, name = "min_price") BigDecimal min_price,
			@RequestParam(required = false, name = "max_price") BigDecimal max_price) {
		return ResponseEntity.ok(productsService.findByFiltro(q, min_price, max_price));
	}

	@PostMapping
	public ResponseEntity<productDto> insert(@RequestBody InsertProductDto insertProductDto) {
		return ResponseEntity.ok(productsService.insert(insertProductDto));
	}

	@Transactional
	@PutMapping("/")
	public ResponseEntity<productDto> updateById(@RequestParam Long id,
			@RequestBody productDtoUpdate productDtoUpdate) {
		return ResponseEntity.ok(productsService.updateById(id, productDtoUpdate));
	}

	@DeleteMapping("/")
	public ResponseEntity<?> deleteById(@RequestParam Long id) {
		return ResponseEntity.ok(productsService.deleteById(id));
	}
}
