package com.livaria.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.livaria.model.Compra;
import com.livaria.repository.CompraRepository;

public class CompraService extends ConexaoBancoService {
	
	private CompraRepository compraRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public CompraService() {
		compraRepository = new CompraRepository(getEntityManager());
	}
	
		
	public Integer salvarCompra(Compra compra) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			compraRepository.save(compra);
			transacao.commit();
		}catch (Throwable e) {
			e.printStackTrace();
	        if (transacao.isActive()) {
	        	transacao.rollback();
	        	close();
	        }
			return ERRO_INCLUSAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	

	public Integer alterarCompra(Compra compra) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			compraRepository.update(compra);
			transacao.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if (transacao.isActive()) {
				transacao.rollback();
				close();
			}
			return ERRO_ALTERACAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	
	public Integer excluirCompra(Compra compra) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			Compra compraRemovido = consultarCompra(compra.getId());
			transacao.begin();
			compraRepository.remove(compraRemovido);
			transacao.commit();
		} catch(Throwable e) {
			e.printStackTrace();
			if (transacao.isActive()) {
				transacao.rollback();
				close();
			}
			return ERRO_EXCLUSAO;
		} finally {
			close();
		}
		return SUCESSO_TRANSACAO;
	}
	
	
	public Compra consultarCompra(Long id) {
		return compraRepository.findById(id);
	}
	
	
	public List<Compra> listarTodosCompras(){
		return compraRepository.findAll(Compra.class);
	}

}
