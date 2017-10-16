package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import livro.Livro;

@SuppressWarnings("serial")
public class TelaConsultarLivro extends JFrame {

	private JPanel contentPane;

	public TelaConsultarLivro(JFrame telaAnterior, TelaLocalizarLivro tll, Livro liv) {
super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblInforamaoDoLocatrio = new JLabel("Inforamação do Livro");
		lblInforamaoDoLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblInforamaoDoLocatrio, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea("\n" + liv.toString());
		textArea.setBackground(new Color(238, 238, 238));
		textArea.setFont(new Font("Dialog", Font.BOLD, 15));
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tll.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaConsultarLocatario.class.getResource("/icones/i_seta_esq_16.png")));
		panel.add(btnVoltar);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAnterior.setVisible(true);
				tll.dispose();
				dispose();
			}
		});
		btnOk.setIcon(new ImageIcon(TelaConsultarLocatario.class.getResource("/icones/i_concluir_16.png")));
		panel.add(btnOk);
	}

}
