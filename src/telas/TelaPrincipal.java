package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import livro.Emprestimo;
import livro.Livro;
import locatario.Locatario;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	
	public TelaPrincipal(ArrayList<Locatario> locatarios, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, ArrayList<Emprestimo> atrasos) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 3, 10, 10));
		
		panel.setBorder(BorderFactory.createLineBorder(new Color(0)));
		
		TelaPrincipal tp = this;
		
		JButton btnEmprestimo = new JButton("Empréstimo");
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEmprestimo te = new TelaEmprestimo(tp, emprestimos, locatarios, livros);
				te.setVisible(true);
				dispose();
			}
		});
		btnEmprestimo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_emprestimo_32.png")));
		panel.add(btnEmprestimo);
		
		JButton btnDevolucao = new JButton("Devolução");
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaSelacaoDevolucao(tp, livros, emprestimos).setVisible(true);
				setVisible(false);
			}
		});
		btnDevolucao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_devolcao_32.png")));
		panel.add(btnDevolucao);
		
		
		JButton btnGerLivros = new JButton("Ger. Livros");
		btnGerLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaGerenciarLivro(livros, tp).setVisible(true);
				setVisible(false);
			}
		});
		btnGerLivros.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_ger_livro_32.png")));
		panel.add(btnGerLivros);
		
		JButton btnGerLocatarios = new JButton("Cadastros");
		btnGerLocatarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaGerenciarLocatario tgl = new TelaGerenciarLocatario(locatarios, tp);
				tgl.setVisible(true);
				setVisible(false);
				
			}
		});
		btnGerLocatarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_ger_locatario_32.png")));
		panel.add(btnGerLocatarios);
		
		JButton btnAtrasos = new JButton("Atrasos");
		btnAtrasos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_atraso_32.png")));
		panel.add(btnAtrasos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_cancelar_32.png")));
		panel.add(btnSair);
		
		JLabel l1 = new JLabel("Bem vindo ao SGBE!");
		l1.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(l1, BorderLayout.NORTH);
	}

}
