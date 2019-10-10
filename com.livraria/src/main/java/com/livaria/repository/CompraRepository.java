package com.livaria.repository;

import javax.persistence.EntityManager;

import com.livaria.model.Compra;

public class CompraRepository extends GenericRepository<Compra, Long> {

	public CompraRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
