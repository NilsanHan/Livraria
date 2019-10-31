package com.livraria.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.livraria.dao.ClienteDAO;
import com.livraria.model.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO, Serializable {


	private static final long serialVersionUID = 5012053774615583956L;

	
	@Override
	public List<Cliente> listaClientePaginacao() {
	    System.out.println(" listando entidade com paginacao "); 
		return null;
	}

}
