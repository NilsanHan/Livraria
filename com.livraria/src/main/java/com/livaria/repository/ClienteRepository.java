package com.livaria.repository;

import javax.persistence.EntityManager;

import com.livaria.model.Cliente;

public class ClienteRepository extends GenericRepository<Cliente, Long> {

	public ClienteRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
