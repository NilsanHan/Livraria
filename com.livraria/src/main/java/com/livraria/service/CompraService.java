package com.livraria.service;

import java.util.List;

import com.livraria.model.Compra;

public interface CompraService {
	
	public void inserir(Compra compra);
	public void update(Compra compra);
	public void remove(Compra compra);
	public List <Compra> findALL(Compra compra);
	public List<Compra> listaCompraPaginacao();
	

}
