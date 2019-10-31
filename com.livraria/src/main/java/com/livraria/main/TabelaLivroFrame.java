package com.livraria.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.impl.LivroDAOImpl;
import com.livraria.model.Livro;
import com.livraria.model.TabelaLivroModel;

public class TabelaLivroFrame extends JFrame {

	private static final long serialVersionUID = -352389726581513577L;
	private JPanel contentPane;
	private JTable tabelaLivro;
	private JButton btnIncluir;

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

	private TabelaLivroModel tabelaLivroModel;
	private JButton btnAlterar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(laf.getName())) {
							UIManager.setLookAndFeel(laf.getClassName());
						} else {
							System.out.println();
						}

					}
					TabelaLivroFrame frame = new TabelaLivroFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabelaLivroFrame() {
		initComponents();
		createEvents();
	}

	private void createEvents() {
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroFrame livroFrame = new LivroFrame(new JFrame(), tabelaLivro, tabelaLivroModel, 0, 0);
				livroFrame.setLocationRelativeTo(null);
				livroFrame.setVisible(true);
			}
		});
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tabelaLivro.getSelectedRow() != -1
						&& tabelaLivro.getSelectedRow() < tabelaLivroModel.getRowCount()) {
					int linhaSelecionada = tabelaLivro.getSelectedRowCount();
					System.out.println(linhaSelecionada);
					LivroFrame livroFrame = new LivroFrame(new JFrame(), tabelaLivro, tabelaLivroModel,
							linhaSelecionada, 1);
					livroFrame.setLocationRelativeTo(null);
					livroFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um registro na tabela", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		btnIncluir = new JButton("Incluir");
		btnAlterar = new JButton("Alterar");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(48)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnIncluir)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnAlterar))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1015, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(82, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(98)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
						.addGap(27).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnIncluir).addComponent(btnAlterar))
						.addContainerGap(35, Short.MAX_VALUE)));

		tabelaLivro = new JTable();
		scrollPane.setViewportView(tabelaLivro);
		contentPane.setLayout(gl_contentPane);
		loadDataLivroFromTable();
		setLocationRelativeTo(null);
	}

	public void loadDataLivroFromTable() {

		tabelaLivroModel = new TabelaLivroModel();
		tabelaLivroModel.setListaLivros(listarTodosLivros());
		tabelaLivro.setModel(tabelaLivroModel);

		tabelaLivro.setFillsViewportHeight(true);
		tabelaLivro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tabelaLivroModel.fireTableDataChanged();

//		tabelaLivro.getColumnModel().getColumn(ID).setWidth(11);
//		tabelaLivro.getColumnModel().getColumn(NOME).setWidth(100);
//		tabelaLivro.getColumnModel().getColumn(ENDERECO).setWidth(100);
//		tabelaLivro.getColumnModel().getColumn(BAIRRO).setWidth(50);
//		tabelaLivro.getColumnModel().getColumn(CIDADE).setWidth(100);
//		tabelaLivro.getColumnModel().getColumn(CEP).setWidth(20);
//		tabelaLivro.getColumnModel().getColumn(TELEFONE).setWidth(20);
//		tabelaLivro.getColumnModel().getColumn(NUMERO).setWidth(5);

	}

	public List<Livro> listarTodosLivros() {
		LivroDAO livroService = new LivroDAOImpl();
		return livroService.findALL(new Livro());
	}
}
