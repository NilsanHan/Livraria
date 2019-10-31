package com.livraria.repository;

import javax.persistence.EntityManager;

import com.livraria.model.Cliente;

public class ClienteRepository extends GenericRepository<Cliente, Long> {

	public ClienteRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
