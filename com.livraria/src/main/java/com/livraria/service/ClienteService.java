package com.livraria.service;

import java.util.List;

import com.livraria.model.Cliente;

public interface ClienteService {
	
	public void inserir(Cliente cliente);
	public void update(Cliente cliente);
	public void remove(Cliente cliente);
	public List <Cliente> findALL(Cliente cliente);
	public List<Cliente> listaClientePaginacao();
	

}
