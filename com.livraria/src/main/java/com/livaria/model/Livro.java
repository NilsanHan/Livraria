package com.livaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_LIVRO")
public class Livro {

	private Long id;
	private String titulo;
	private String autor;
	private String editora;
	private String edicao;
	private int paginas;
	private int altura;
	private int largura;
	private double preco;
	private int quantidade;

	public Livro() {
	}

	public Livro(Long id, String titulo, String autor, String editora, String edicao, int paginas, int altura,
			int largura, double preco, int quantidade) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.editora = editora;
		this.edicao = edicao;
		this.paginas = paginas;
		this.altura = altura;
		this.largura = largura;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIVRO_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "LIVRO_TITULO", nullable = false, length = 100)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "LIVRO_AUTOR", nullable = false, length = 100)
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Column(name = "LIVRO_EDITORA", nullable = false, length = 100)
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Column(name = "LIVRO_EDICAO", nullable = false, length = 100)
	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	@Column(name = "LIVRO_PAGINAS", nullable = false, length = 100)
	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Column(name = "LIVRO_ALTURA", nullable = false, length = 100)
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Column(name = "LIVRO_LARGURA", nullable = false, length = 100)
	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	@Column(name = "LIVRO_PRECO", nullable = false, length = 100)
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Column(name = "LIVRO_QUANTIDADE", nullable = false, length = 100)
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", edicao="
				+ edicao + ", paginas=" + paginas + ", altura=" + altura + ", largura=" + largura + ", preco=" + preco
				+ ", quantidade=" + quantidade + "]";
	}

}
