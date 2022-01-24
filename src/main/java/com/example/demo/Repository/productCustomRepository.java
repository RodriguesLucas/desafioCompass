package com.example.demo.Repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.ProductEntity;

@Repository
public class productCustomRepository {
	private final EntityManager entityManager;

	public productCustomRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<ProductEntity> filtro(String q, BigDecimal min_price, BigDecimal max_price) {
			String query = "select P from ProductEntity as P ";
			String condicao = "where";
			if (min_price != null && max_price != null) {
				query += condicao + " P.price Between :min_price AND :max_price";
				condicao = "AND";
			} else if (min_price != null && max_price == null) {
				query += condicao + " P.price >= :min_price";
				condicao = "AND";
			} else if (min_price == null && max_price != null) {
				query += condicao + " P.price <= :max_price";
				condicao = "AND";
			} else if (!q.isEmpty()) {
				query += condicao + " P.name LIKE :q OR P.description LIKE :q";
			}
			var aux = entityManager.createQuery(query, ProductEntity.class);
			if (min_price != null && max_price != null) {
				aux.setParameter("min_price", min_price);
				aux.setParameter("max_price", max_price);
			} else if (min_price != null && max_price == null)
				aux.setParameter("min_price", min_price);
	
			else if (min_price == null && max_price != null)
				aux.setParameter("max_price", max_price);
	
			else if (!q.isEmpty()) {
				aux.setParameter("q", q);
				aux.setParameter("q", q);
			}
			return aux.getResultList();
	}
}
