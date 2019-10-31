package com.livraria.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.livraria.dao.LivroDAO;
import com.livraria.model.Livro;

public class LivroDAOImpl extends GenericDAOImpl<Livro, Integer> implements LivroDAO, Serializable {


	private static final long serialVersionUID = 5012053774615583956L;

	
	@Override
	public List<Livro> listaLivroPaginacao() {
	    System.out.println(" listando entidade com paginacao "); 
		return null;
	}

}
