package com.livraria.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.livraria.dao.CompraDAO;
import com.livraria.model.Compra;

public class CompraDAOImpl extends GenericDAOImpl<Compra, Integer> implements CompraDAO, Serializable {


	private static final long serialVersionUID = 5012053774615583956L;

	
	@Override
	public List<Compra> listaCompraPaginacao() {
	    System.out.println(" listando entidade com paginacao "); 
		return null;
	}

}
