package com.livraria.dao;

import java.util.List;

import com.livraria.model.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente, Integer> {

	
	public List<Cliente> listaClientePaginacao();
	
	
}
