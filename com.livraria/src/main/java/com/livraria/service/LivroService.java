package com.livraria.service;

import java.util.List;

import com.livraria.model.Livro;

public interface LivroService {
	
	public void inserir(Livro livro);
	public void update(Livro livro);
	public void remove(Livro livro);
	public List <Livro> findALL(Livro livro);
	public List<Livro> listaLivroPaginacao();
	

}
