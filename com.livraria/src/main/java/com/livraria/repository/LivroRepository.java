package com.livraria.repository;

import javax.persistence.EntityManager;

import com.livraria.model.Livro;

public class LivroRepository extends GenericRepository<Livro, Long> {

	public LivroRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
