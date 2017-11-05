package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import livro.Emprestimo;
import livro.Livro;

@SuppressWarnings("serial")
public class TelaSelacaoDevolucao extends JFrame {

	private JPanel contentPane;

	public TelaSelacaoDevolucao(TelaPrincipal tp, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 156);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel.add(comboBox);
		comboBox.addItem("Devolver");
		comboBox.addItem("Renovar");
		
		JFrame ta = this;
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex() == 0) {
					new TelaLocalizarLivro(null, tp, ta, "Selecione o livro a ser devolvido", livros, emprestimos, 4).setVisible(true);
					setVisible(false);
				}else if(comboBox.getSelectedIndex() == 1) {
					new TelaLocalizarLivro(null, tp, ta, "Selecione o livro a ser renovado", livros, emprestimos, 5).setVisible(true);
					setVisible(false);
				}
			}
		});
		btnSelecionar.setIcon(new ImageIcon(TelaSelacaoDevolucao.class.getResource("/icones/i_concluir_16.png")));
		panel.add(btnSelecionar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma opção");
		lblSelecioneUmaOpo.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblSelecioneUmaOpo, BorderLayout.NORTH);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaSelacaoDevolucao.class.getResource("/icones/i_seta_esq_16.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tp.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar, BorderLayout.SOUTH);
	}

}
