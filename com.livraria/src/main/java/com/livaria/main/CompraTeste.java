package com.livaria.main;

import com.livaria.model.Cliente;
import com.livaria.model.Compra;
import com.livaria.model.Livro;
import com.livaria.service.CompraService;

public class CompraTeste {
	
	public static void main(String[] args) {
		

		
		Livro livro = new Livro();
		livro.setId(new Long(100));
		livro.setTitulo("melhor livro");
		
		Cliente cliente = new Cliente();
		cliente.setId(new Long(100));
		cliente.setNome("lucas");
		
		
		CompraService cs =  new CompraService();
		Compra compra = new Compra();
		
		compra.setCliente(cliente);
		compra.setLivro(livro);
		
		cs.salvarCompra(compra);
		
	}

}
