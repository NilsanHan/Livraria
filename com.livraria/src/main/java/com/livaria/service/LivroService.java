package com.livaria.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.livaria.main.LivroFrame;
import com.livaria.model.Livro;
import com.livaria.repository.LivroRepository;

public class LivroService extends ConexaoBancoService {
	
	private LivroRepository livroRepository;
	
	private static Integer ERRO_INCLUSAO = 1;
	private static Integer ERRO_ALTERACAO = 2;
	private static Integer ERRO_EXCLUSAO = 3;
	private static Integer SUCESSO_TRANSACAO = 0;
	
	public LivroService() {
		livroRepository = new LivroRepository(getEntityManager());
	}
	
		
	public Integer salvarLivro(Livro livro) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			livroRepository.save(livro);
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
	

	public Integer alterarLivro(Livro livro) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			transacao.begin();
			livroRepository.update(livro);
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
	
	public Integer excluirLivro(Livro livro) {
		EntityTransaction transacao = this.getEntityManager().getTransaction();
		try {
			Livro livroRemovido = consultarLivro(livro.getId());
			transacao.begin();
			livroRepository.remove(livroRemovido);
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
	
	
	public Livro consultarLivro(Long id) {
		return livroRepository.findById(id);
	}
	
	
	public List<Livro> listarTodosLivros(){
		return livroRepository.findAll(Livro.class);
	}

}
