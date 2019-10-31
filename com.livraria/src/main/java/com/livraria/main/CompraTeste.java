package com.livraria.main;

import com.livraria.dao.CompraDAO;
import com.livraria.dao.impl.CompraDAOImpl;
import com.livraria.model.Cliente;
import com.livraria.model.Compra;
import com.livraria.model.Livro;

public class CompraTeste {
	
	public static void main(String[] args) {
		

		
		Livro livro = new Livro();
		livro.setId(new Long(100));
		livro.setTitulo("melhor livro");
		
		Cliente cliente = new Cliente();
		cliente.setId(new Long(150));
		cliente.setNome("lucas");
		
		
		CompraDAO cs = new CompraDAOImpl();
		Compra compra = new Compra();
		
		compra.setCliente(cliente);
		compra.setLivro(livro);
		
		cs.inserir(compra);
		
	}

}
