package com.livraria.repository;

import javax.persistence.EntityManager;

import com.livraria.model.Compra;

public class CompraRepository extends GenericRepository<Compra, Long> {

	public CompraRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
