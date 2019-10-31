package com.livraria.service.impl;

import java.util.List;

import com.livraria.dao.CompraDAO;
import com.livraria.dao.impl.CompraDAOImpl;
import com.livraria.model.Compra;
import com.livraria.service.CompraService;

public class CompraServiceImpl implements CompraService {
	
	CompraDAO dao = new CompraDAOImpl();
	

	@Override
	public void inserir(Compra compra) {
		dao.inserir(compra);

	}

	@Override
	public void update(Compra compra) {
       dao.update(compra);
	}

	@Override
	public void remove(Compra compra) {
       dao.remove(compra);
	}

	@Override
	public List<Compra> findALL(Compra compra) {
		return dao.findALL(compra);
	}

	@Override
	public List<Compra> listaCompraPaginacao() {
		return dao.listaCompraPaginacao();
	}

}
