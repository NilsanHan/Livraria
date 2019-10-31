package com.livraria.service.impl;

import java.util.List;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.impl.LivroDAOImpl;
import com.livraria.model.Livro;
import com.livraria.service.LivroService;

public class LivroServiceImpl implements LivroService {
	
	LivroDAO dao = new LivroDAOImpl();
	

	@Override
	public void inserir(Livro livro) {
		dao.inserir(livro);

	}

	@Override
	public void update(Livro livro) {
       dao.update(livro);
	}

	@Override
	public void remove(Livro livro) {
       dao.remove(livro);
	}

	@Override
	public List<Livro> findALL(Livro livro) {
		return dao.findALL(livro);
	}

	@Override
	public List<Livro> listaLivroPaginacao() {
		return dao.listaLivroPaginacao();
	}

}
