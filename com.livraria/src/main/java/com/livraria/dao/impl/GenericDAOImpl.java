package com.livraria.dao.impl;

import java.awt.HeadlessException;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.livraria.dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("livraria");

	@Override
	public void inserir(T entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		try {

			transacao.begin();
			em.persist(entity);
			transacao.commit();
			JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar " + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}

		System.out.println(" entidade inserida com sucesso " + entity);

	}

	@Override
	public void update(T entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		try {
			transacao.begin();
			em.merge(entity);
			transacao.commit();
			JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
			transacao.rollback();
		} finally {
			em.close();
		}

		System.out.println(" entidade alterada com sucesso " + entity);

	}

	@Override
	public void remove(T entity) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		Object t = null;
		try {
//			t = em.find(entity.getClass().getName(), 2);
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Removido com Sucesso");
		} catch (HeadlessException e) {
			JOptionPane.showMessageDialog(null, "Erro ao remover " + e);
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
//		System.out.println(" entidade removida com sucesso " + id);

	}

	@Override
	public List<T> findALL(T entity) {

		List<T> listaTodos = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction transacao = em.getTransaction();
		try {

			listaTodos = em.createQuery("from " + entity.getClass().getName() + " o").getResultList();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
		} finally {
			em.close();
		}

		return listaTodos;
	}

}
