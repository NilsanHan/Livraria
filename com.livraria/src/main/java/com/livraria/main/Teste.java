package com.livraria.main;

import java.util.List;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.impl.LivroDAOImpl;
import com.livraria.model.Livro;

public class Teste {

	public static void main(String[] args) {
		Livro livro = new Livro();

		//livro.setId(Long.valueOf(21));
		livro.setTitulo("mostrando");
		livro.setAutor("autor");
		livro.setEdicao("edicao");

		LivroDAO livroService = new LivroDAOImpl();

		livroService.inserir(livro);

//		service.remove(livro);

//		List<Livro> listaLivro= service.findALL(livro);
//		
//		 while(!listaLivro.isEmpty()){
//	            System.out.println(listaLivro.remove(0));
//	        }

//		service.listaLivroPaginacao();

//		service.update(livro);

	}

}
