package com.livraria.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	
	public void inserir(T entity);
	public void update(T entity);
	public void remove(T entity);
	public List<T> findALL(T entity );
	
	
	
}
