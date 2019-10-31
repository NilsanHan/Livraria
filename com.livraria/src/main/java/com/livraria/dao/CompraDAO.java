package com.livraria.dao;

import java.util.List;

import com.livraria.model.Compra;

public interface CompraDAO extends GenericDAO<Compra, Integer> {

	
	public List<Compra> listaCompraPaginacao();
	
	
}
