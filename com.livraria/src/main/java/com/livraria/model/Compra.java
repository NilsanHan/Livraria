package com.livraria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_COMPRA")
public class Compra {

	private Long id;
	private Livro livro;
	private Cliente cliente;
	private Date data;
	// private Date dataCompra;
//	private List<Livro> livros;

	public Compra() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPRA_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Livro.class)
	@JoinColumn(name = "LIVRO_ID", referencedColumnName = "LIVRO_ID", foreignKey = @ForeignKey(name = "FK_LIVRO_LIVRO"), nullable = false, columnDefinition = "BIGINT(20)")
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Cliente.class)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CLIENTE_ID", foreignKey = @ForeignKey(name = "FK_CLIENTE_CLIENTE"), nullable = false, columnDefinition = "BIGINT(20)")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

//	@OneToOne(fetch = FetchType.LAZY, targetEntity = Livro.class)
//	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "CIENTE_ID", foreignKey = @ForeignKey(name = "FK_CLIENTE_CLIENTE"), nullable = false, columnDefinition = "BIGINT(20)")
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}

}
