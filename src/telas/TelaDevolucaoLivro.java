package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import livro.Emprestimo;
import livro.GerenciaEmprestimo;
import livro.Livro;

@SuppressWarnings("serial")
public class TelaDevolucaoLivro extends JFrame {

	private JPanel contentPane;

	public TelaDevolucaoLivro(TelaPrincipal tp, JFrame telaAnterior, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, Livro livro) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblInformaoDoEmprstimo = new JLabel("Informação do Empréstimo:");
		lblInformaoDoEmprstimo.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblInformaoDoEmprstimo, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 15));
		textArea.setBackground(new Color(238, 238, 238));
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAnterior.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaDevolucaoLivro.class.getResource("/icones/i_cancelar_16.png")));
		panel.add(btnCancelar);

		GerenciaEmprestimo ge = new GerenciaEmprestimo(null, livros, emprestimos, livro);
		
		Emprestimo ep = ge.localizarPorLivro();
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ep.setDataEntrega(LocalDate.now());
				
				ge.devolver();
				
				if(JOptionPane.showConfirmDialog(null, "Devolução Concluida! Deseja realizar outra devolução?", "Concluido", 0) == JOptionPane.YES_OPTION) {
					new TelaSelacaoDevolucao(tp, livros, emprestimos).setVisible(true);
					dispose();
				}else {
					tp.setVisible(true);
					dispose();
				}
			}
		});
		btnDevolver.setIcon(new ImageIcon(TelaDevolucaoLivro.class.getResource("/icones/i_devolucao_16.png")));
		panel.add(btnDevolver);
		
		textArea.setText("\n" + ep.toString());
	}

}
