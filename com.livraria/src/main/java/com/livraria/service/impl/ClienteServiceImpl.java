package com.livraria.service.impl;

import java.util.List;

import com.livraria.dao.ClienteDAO;
import com.livraria.dao.impl.ClienteDAOImpl;
import com.livraria.model.Cliente;
import com.livraria.service.ClienteService;

public class ClienteServiceImpl implements ClienteService {
	
	ClienteDAO dao = new ClienteDAOImpl();
	

	@Override
	public void inserir(Cliente cliente) {
		dao.inserir(cliente);

	}

	@Override
	public void update(Cliente cliente) {
       dao.update(cliente);
	}

	@Override
	public void remove(Cliente cliente) {
       dao.remove(cliente);
	}

	@Override
	public List<Cliente> findALL(Cliente cliente) {
		return dao.findALL(cliente);
	}

	@Override
	public List<Cliente> listaClientePaginacao() {
		return dao.listaClientePaginacao();
	}

}
