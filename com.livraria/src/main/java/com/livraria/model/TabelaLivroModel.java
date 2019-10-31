package com.livraria.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaLivroModel extends AbstractTableModel {

	private static final long serialVersionUID = 6893553424676264421L;

	private final String colunas[] = { "Id", "Titulo", "Autor", "Editora", "Edicao", "Paginas", "Altura", "Largura",
			"Preço", "Quantidade" };

	private List<Livro> listaLivros;

	private static final int ID = 0;
	private static final int TITULO = 1;
	private static final int AUTOR = 2;
	private static final int EDITORA = 3;
	private static final int EDICAO = 4;
	private static final int PAGINAS = 5;
	private static final int ALTURA = 6;
	private static final int LARGURA = 7;
	private static final int PRECO = 8;
	private static final int QUANTIDADE = 9;

	public TabelaLivroModel() {
		listaLivros = new ArrayList<Livro>();
	}

	public Livro getLivro(int linhaIndex) {
		return this.getListaLivros().get(linhaIndex - 1);
	}

	public void addLivro(Livro livro) {
		this.getListaLivros().add(livro);
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
	}

	public void updateLivro(Livro livro, int linhaIndex) {
		this.getListaLivros().set(linhaIndex, livro);
		fireTableRowsUpdated(linhaIndex, linhaIndex);
	}

	public void removeLivro(int linhaIndex) {
		this.getListaLivros().remove(linhaIndex);
		fireTableRowsDeleted(linhaIndex, linhaIndex);
	}

	public void removeTodosLivros() {
		this.getListaLivros().clear();
	}

	@Override
	public String getColumnName(int nomeColuna) {
		return this.colunas[nomeColuna];
	}

	@Override
	public int getColumnCount() {
		return this.getColunas().length;
	}

	@Override
	public int getRowCount() {
		return this.getListaLivros().size();
	}

	@Override
	public Object getValueAt(int linhaIndex, int colunaIndex) {

		Livro livro = this.getListaLivros().get(linhaIndex);

		switch (colunaIndex) {
		case ID:
			return livro.getId();
		case TITULO:
			return livro.getTitulo();
		case AUTOR:
			return livro.getAutor();
		case EDITORA:
			return livro.getEditora();
		case EDICAO:
			return livro.getEdicao();
		case PAGINAS:
			return livro.getPaginas();
		case ALTURA:
			return livro.getAltura();
		case LARGURA:
			return livro.getLargura();
		case PRECO:
			return livro.getPreco();
		case QUANTIDADE:
			return livro.getQuantidade();
		default:
			return livro;

		}
	}

	@Override
	public Class<?> getColumnClass(int colunaIndex) {
		switch (colunaIndex) {
		case ID:
			return Long.class;
		case TITULO:
			return String.class;
		case AUTOR:
			return String.class;
		case EDITORA:
			return String.class;
		case EDICAO:
			return String.class;
		case PAGINAS:
			return String.class;
		case ALTURA:
			return String.class;
		case LARGURA:
			return String.class;
		case PRECO:
			return String.class;
		case QUANTIDADE:
			return String.class;
		}
		return null;
	}

	public String[] getColunas() {
		return colunas;
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public static int getTitulo() {
		return TITULO;
	}

	public static int getAutor() {
		return AUTOR;
	}

	public static int getEditora() {
		return EDITORA;
	}

	public static int getEdicao() {
		return EDICAO;
	}

	public static int getPaginas() {
		return PAGINAS;
	}

	public static int getAltura() {
		return ALTURA;
	}

	public static int getLargura() {
		return LARGURA;
	}

	public static int getPreco() {
		return PRECO;
	}

	public static int getQuantidade() {
		return QUANTIDADE;
	}

}