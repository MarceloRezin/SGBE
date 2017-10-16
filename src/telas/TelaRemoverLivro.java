package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import arquivos.Diretorio;
import arquivos.GravaJSON;
import livro.Biblioteca;
import livro.Livro;

@SuppressWarnings("serial")
public class TelaRemoverLivro extends JFrame {

	private JPanel contentPane;

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);
	
	public TelaRemoverLivro(JFrame telaAnterior, TelaLocalizarLivro tll, ArrayList<Livro> livros, Livro liv) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRemoverLivro = new JLabel("Remover Livro");
		lblRemoverLivro.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblRemoverLivro, BorderLayout.NORTH);
		
		JTextArea textArea = new JTextArea("\n" + liv.toString());
		textArea.setEditable(false);
		textArea.setBackground(new Color(238, 238, 238));
		textArea.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaRemoverLivro.class.getResource("/icones/i_seta_esq_16.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tll.setVisible(true);
				dispose();
			}
		});
		panel.add(btnVoltar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAnterior.setVisible(true);
				tll.dispose();
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaRemoverLivro.class.getResource("/icones/i_cancelar_16.png")));
		panel.add(btnCancelar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setIcon(new ImageIcon(TelaRemoverLivro.class.getResource("/icones/i_rem_livro.png")));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este livro?", "Apagar:", 0) == JOptionPane.YES_OPTION) {
					new Biblioteca(livros).removeLivro(liv);
					
					threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
				
					JOptionPane.showMessageDialog(null, "Livro Removido", "Concluido", JOptionPane.INFORMATION_MESSAGE);
					telaAnterior.setVisible(true);
					tll.dispose();
					dispose();
				
				}
			}
		});
		panel.add(btnRemover);
	}

}
