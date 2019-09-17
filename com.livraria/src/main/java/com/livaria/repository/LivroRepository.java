package com.livaria.repository;

import javax.persistence.EntityManager;

import com.livaria.model.Livro;

public class LivroRepository extends GenericRepository<Livro, Long> {

	public LivroRepository(EntityManager entityManager) {
		super(entityManager);
	}

}
