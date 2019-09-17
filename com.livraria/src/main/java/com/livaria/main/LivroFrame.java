package com.livaria.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.livaria.model.Livro;
import com.livaria.model.TabelaLivroModel;
import com.livaria.service.LivroService;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class LivroFrame extends JFrame {

	private static final long serialVersionUID = -7666904947797883899L;

	private JTable tabelaLivro;
	private TabelaLivroModel tabelaLivroModel;
	private int linhaSelecionada;
	private int acao;
	private JTextField codigoTextField;
	private JTextField tituloTextField;
	private JButton btnSalvar;
	private JLabel lblAutor;
	private JLabel lblEditora;
	private JLabel lblEdio;
	private JLabel lblPginas;
	private JLabel lblAltura;
	private JLabel lblLargura;
	private JLabel lblPreo;
	private JLabel lblQuantidade;
	private JTextField autortextField;
	private JTextField quantidadetextField;
	private JTextField precotextField;
	private JTextField larguratextField;
	private JTextField alturatextField;
	private JTextField paginastextField;
	private JTextField edicaotextField;
	private JTextField editoratextField;
	private JButton btnExcluir;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					for (LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
//						if ("Nimbus".equals(laf.getName())) {
//							UIManager.setLookAndFeel(laf.getClassName());
//						} else {
//							System.out.println();
//						}
//
//					}
//					LivroFrame frame = new LivroFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public LivroFrame() {

	}

	public LivroFrame(JFrame frame, JTable tabelaLivro, TabelaLivroModel tabelaLivroModel, int linhaSelecionada,
			int acao) {
		this.tabelaLivro = tabelaLivro;
		this.tabelaLivroModel = tabelaLivroModel;
		this.linhaSelecionada = linhaSelecionada;
		this.acao = acao;

		initComponents();

		createEvents();

		configurarAcao();

	}

	private void createEvents() {
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				LivroService livroService = new LivroService();
				Livro livro = pegarDadosLivroFromTela();
				System.out.println(livro);
				if (livro.getId() == null) {
					livroService.salvarLivro(livro);
				} else {
					livroService.alterarLivro(livro);
				}
				limparDadosDigitacao();
			}
		});
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroService livroService = new LivroService();
				Livro livro = pegarDadosLivroFromTela();
				if (livro.getId()!=null) {
					livroService.excluirLivro(livro);
				}
				limparDadosDigitacao();
			}
		});

	}

	protected Livro pegarDadosLivroFromTela() {
		Livro livro = new Livro();

		if ((!codigoTextField.getText().isEmpty()) && !(codigoTextField.getText() == null)) {
			livro.setId(Long.valueOf(codigoTextField.getText()));
		}

		livro.setTitulo(tituloTextField.getText());
		livro.setAutor(autortextField.getText());
		livro.setEditora(editoratextField.getText());
		livro.setEdicao(edicaotextField.getText());
		livro.setPaginas(Integer.parseInt(paginastextField.getText()));
		livro.setAltura(Integer.parseInt(alturatextField.getText()));
		livro.setLargura(Integer.parseInt(larguratextField.getText()));
		livro.setPreco(Double.parseDouble(precotextField.getText()));
		livro.setQuantidade(Integer.parseInt(quantidadetextField.getText()));

		return livro;
	}

	protected void pegarDadosLivroFromTabela() {

		Livro livro = getTabelaLivroModel().getLivro(getLinhaSelecionada());

		codigoTextField.setText(String.valueOf(livro.getId()));
		tituloTextField.setText(livro.getTitulo());
		autortextField.setText(livro.getAutor());
		editoratextField.setText(livro.getEditora());
		edicaotextField.setText(livro.getEdicao());
		paginastextField.setText(livro.getPaginas() + "");
		alturatextField.setText(livro.getAltura() + "");
		larguratextField.setText(livro.getLargura() + "");
		precotextField.setText(livro.getPreco() + "");
		quantidadetextField.setText(livro.getQuantidade() + "");

	}

	protected void limparDadosDigitacao() {

//		  codigoTextField.setText(""); nomeTextField.setText("");
//		  bairroTextField.setText(""); enderecoTextField.setText("");
//		  cepTextField.setText(""); cidadeTextField.setText("");
//		  numeroTextField.setText(""); telefoneTextField.setText("");

	}

	protected boolean verificarDigitacao(JTextField campo) {
		boolean toReturn = true;
		if ((campo.getText().isEmpty() || campo.getText() == null)) {
			toReturn = false;
		}
		return toReturn;
	}

	protected void consultarDadosLivro(Long id) {
		LivroService livroService = new LivroService();
		Livro livro = livroService.consultarLivro(id);
		pegarDadosLivroFromTabela();
	}

	protected void configurarAcao() {

		if (getAcao() == 0) { // incluir
			btnExcluir.setEnabled(false);
		} else if (getAcao() == 1) { // alterar
			btnExcluir.setEnabled(true);
			pegarDadosLivroFromTabela();
		} else { // excluir
			pegarDadosLivroFromTabela();
			btnSalvar.setEnabled(false);
		}

	}

	private void initComponents() {
		setTitle("Cadastro Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 994, 616);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblId = new JLabel("Id: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		getContentPane().add(lblId, gbc_lblId);

		codigoTextField = new JTextField();
		GridBagConstraints gbc_codigoTextField = new GridBagConstraints();
		gbc_codigoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_codigoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_codigoTextField.gridx = 2;
		gbc_codigoTextField.gridy = 1;
		getContentPane().add(codigoTextField, gbc_codigoTextField);
		codigoTextField.setColumns(10);

		JLabel lblTtulo = new JLabel("Título: ");
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.anchor = GridBagConstraints.EAST;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 1;
		gbc_lblTtulo.gridy = 2;
		getContentPane().add(lblTtulo, gbc_lblTtulo);

		tituloTextField = new JTextField();
		GridBagConstraints gbc_tituloTextField = new GridBagConstraints();
		gbc_tituloTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tituloTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tituloTextField.gridx = 2;
		gbc_tituloTextField.gridy = 2;
		getContentPane().add(tituloTextField, gbc_tituloTextField);
		tituloTextField.setColumns(10);

		lblAutor = new JLabel("Autor:");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.EAST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 1;
		gbc_lblAutor.gridy = 3;
		getContentPane().add(lblAutor, gbc_lblAutor);

		autortextField = new JTextField();
		GridBagConstraints gbc_autortextField = new GridBagConstraints();
		gbc_autortextField.insets = new Insets(0, 0, 5, 5);
		gbc_autortextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_autortextField.gridx = 2;
		gbc_autortextField.gridy = 3;
		getContentPane().add(autortextField, gbc_autortextField);
		autortextField.setColumns(10);

		lblEditora = new JLabel("Editora:");
		GridBagConstraints gbc_lblEditora = new GridBagConstraints();
		gbc_lblEditora.anchor = GridBagConstraints.EAST;
		gbc_lblEditora.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditora.gridx = 1;
		gbc_lblEditora.gridy = 4;
		getContentPane().add(lblEditora, gbc_lblEditora);

		editoratextField = new JTextField();
		GridBagConstraints gbc_editoratextField = new GridBagConstraints();
		gbc_editoratextField.insets = new Insets(0, 0, 5, 5);
		gbc_editoratextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_editoratextField.gridx = 2;
		gbc_editoratextField.gridy = 4;
		getContentPane().add(editoratextField, gbc_editoratextField);
		editoratextField.setColumns(10);

		lblEdio = new JLabel("Edição");
		GridBagConstraints gbc_lblEdio = new GridBagConstraints();
		gbc_lblEdio.anchor = GridBagConstraints.EAST;
		gbc_lblEdio.insets = new Insets(0, 0, 5, 5);
		gbc_lblEdio.gridx = 1;
		gbc_lblEdio.gridy = 5;
		getContentPane().add(lblEdio, gbc_lblEdio);

		edicaotextField = new JTextField();
		GridBagConstraints gbc_edicaotextField = new GridBagConstraints();
		gbc_edicaotextField.insets = new Insets(0, 0, 5, 5);
		gbc_edicaotextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_edicaotextField.gridx = 2;
		gbc_edicaotextField.gridy = 5;
		getContentPane().add(edicaotextField, gbc_edicaotextField);
		edicaotextField.setColumns(10);

		lblPginas = new JLabel("Páginas");
		GridBagConstraints gbc_lblPginas = new GridBagConstraints();
		gbc_lblPginas.anchor = GridBagConstraints.EAST;
		gbc_lblPginas.insets = new Insets(0, 0, 5, 5);
		gbc_lblPginas.gridx = 1;
		gbc_lblPginas.gridy = 6;
		getContentPane().add(lblPginas, gbc_lblPginas);

		paginastextField = new JTextField();
		GridBagConstraints gbc_paginastextField = new GridBagConstraints();
		gbc_paginastextField.insets = new Insets(0, 0, 5, 5);
		gbc_paginastextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_paginastextField.gridx = 2;
		gbc_paginastextField.gridy = 6;
		getContentPane().add(paginastextField, gbc_paginastextField);
		paginastextField.setColumns(10);

		lblAltura = new JLabel("Altura:");
		GridBagConstraints gbc_lblAltura = new GridBagConstraints();
		gbc_lblAltura.anchor = GridBagConstraints.EAST;
		gbc_lblAltura.insets = new Insets(0, 0, 5, 5);
		gbc_lblAltura.gridx = 1;
		gbc_lblAltura.gridy = 7;
		getContentPane().add(lblAltura, gbc_lblAltura);

		alturatextField = new JTextField();
		GridBagConstraints gbc_alturatextField = new GridBagConstraints();
		gbc_alturatextField.insets = new Insets(0, 0, 5, 5);
		gbc_alturatextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_alturatextField.gridx = 2;
		gbc_alturatextField.gridy = 7;
		getContentPane().add(alturatextField, gbc_alturatextField);
		alturatextField.setColumns(10);

		lblLargura = new JLabel("Largura:");
		GridBagConstraints gbc_lblLargura = new GridBagConstraints();
		gbc_lblLargura.anchor = GridBagConstraints.EAST;
		gbc_lblLargura.insets = new Insets(0, 0, 5, 5);
		gbc_lblLargura.gridx = 1;
		gbc_lblLargura.gridy = 8;
		getContentPane().add(lblLargura, gbc_lblLargura);

		larguratextField = new JTextField();
		GridBagConstraints gbc_larguratextField = new GridBagConstraints();
		gbc_larguratextField.insets = new Insets(0, 0, 5, 5);
		gbc_larguratextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_larguratextField.gridx = 2;
		gbc_larguratextField.gridy = 8;
		getContentPane().add(larguratextField, gbc_larguratextField);
		larguratextField.setColumns(10);

		lblPreo = new JLabel("Preço");
		GridBagConstraints gbc_lblPreo = new GridBagConstraints();
		gbc_lblPreo.anchor = GridBagConstraints.EAST;
		gbc_lblPreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPreo.gridx = 1;
		gbc_lblPreo.gridy = 9;
		getContentPane().add(lblPreo, gbc_lblPreo);

		precotextField = new JTextField();
		GridBagConstraints gbc_precotextField = new GridBagConstraints();
		gbc_precotextField.insets = new Insets(0, 0, 5, 5);
		gbc_precotextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_precotextField.gridx = 2;
		gbc_precotextField.gridy = 9;
		getContentPane().add(precotextField, gbc_precotextField);
		precotextField.setColumns(10);

		lblQuantidade = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.anchor = GridBagConstraints.EAST;
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantidade.gridx = 1;
		gbc_lblQuantidade.gridy = 10;
		getContentPane().add(lblQuantidade, gbc_lblQuantidade);

		quantidadetextField = new JTextField();
		GridBagConstraints gbc_quantidadetextField = new GridBagConstraints();
		gbc_quantidadetextField.insets = new Insets(0, 0, 5, 5);
		gbc_quantidadetextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_quantidadetextField.gridx = 2;
		gbc_quantidadetextField.gridy = 10;
		getContentPane().add(quantidadetextField, gbc_quantidadetextField);
		quantidadetextField.setColumns(10);

		btnSalvar = new JButton("Salvar");
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.anchor = GridBagConstraints.SOUTH;
		gbc_btnSalvar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalvar.gridx = 2;
		gbc_btnSalvar.gridy = 12;
		getContentPane().add(btnSalvar, gbc_btnSalvar);

		btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 5, 5);
		gbc_btnExcluir.gridx = 3;
		gbc_btnExcluir.gridy = 12;
		getContentPane().add(btnExcluir, gbc_btnExcluir);

	}

	public JTable getTabelaLivro() {
		return tabelaLivro;
	}

	public void setTabelaLivro(JTable tabelaLivro) {
		this.tabelaLivro = tabelaLivro;
	}

	public TabelaLivroModel getTabelaLivroModel() {
		return tabelaLivroModel;
	}

	public void setTabelaLivroModel(TabelaLivroModel tabelaLivroModel) {
		this.tabelaLivroModel = tabelaLivroModel;
	}

	public int getLinhaSelecionada() {
		return linhaSelecionada;
	}

	public void setLinhaSelecionada(int linhaSelecionada) {
		this.linhaSelecionada = linhaSelecionada;
	}

	public int getAcao() {
		return acao;
	}

	public void setAcao(int acao) {
		this.acao = acao;
	}

}
