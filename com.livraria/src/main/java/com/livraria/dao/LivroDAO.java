package com.livraria.dao;

import java.util.List;

import com.livraria.model.Livro;

public interface LivroDAO extends GenericDAO<Livro, Integer> {

	
	public List<Livro> listaLivroPaginacao();
	
	
}
