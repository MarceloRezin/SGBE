package telas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import livro.Livro;

@SuppressWarnings("serial")
public class TelaGerenciarLivro extends JFrame {

	private JPanel contentPane;

	public TelaGerenciarLivro(ArrayList<Livro> livros, TelaPrincipal tp) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		TelaGerenciarLivro tgl = this;
		
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(TelaGerenciarLivro.class.getResource("/icones/i_add_livro.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaAdicionarLivro(tgl, null, livros, "Adicionar Livro", null).setVisible(true);
				
				setVisible(false);
			}
		}); 
		panel.add(btnAdicionar);
		
		JFrame frame = this;
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setIcon(new ImageIcon(TelaGerenciarLivro.class.getResource("/icones/i_rem_livro.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLivro(frame, "Selecione o livro a ser removido", livros, 0).setVisible(true);
				setVisible(false);
				
			}
		});

		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLivro(frame, "Selecione o livro a ser editado", livros, 2).setVisible(true);
				setVisible(false);
			}
		});
		btnEditar.setIcon(new ImageIcon(TelaGerenciarLivro.class.getResource("/icones/i_edit_livro_16.png")));
		
		panel.add(btnEditar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setIcon(new ImageIcon(TelaGerenciarLivro.class.getResource("/icones/i_consul_livro_16.png")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLivro(frame, "Selecione o livro a ser consultado", livros, 1).setVisible(true);
				setVisible(false);
				
			}
		});

		panel.add(btnConsultar);
		
		JLabel lblGerenciamentoDeLivros = new JLabel("Gerenciamento de Livros");
		lblGerenciamentoDeLivros.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblGerenciamentoDeLivros, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaGerenciarLivro.class.getResource("/icones/i_seta_esq_16.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnVoltar);
	}

}
