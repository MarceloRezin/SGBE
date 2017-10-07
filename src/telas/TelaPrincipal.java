package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				try {
                    UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
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
		
		JButton btnEmprestimo = new JButton("Empréstimo");
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaEmprestimo te = new TelaEmprestimo();
				te.setVisible(true);
				dispose();
			}
		});
		btnEmprestimo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_emprestimo_32.png")));
		panel.add(btnEmprestimo);
		
		JButton btnDevolucao = new JButton("Devolução");
		btnDevolucao.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_devolcao_32.png")));
		panel.add(btnDevolucao);
		
		JButton btnBuscarLivro = new JButton("Buscar Livro");
		btnBuscarLivro.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_buscar_livro_32.png")));
		panel.add(btnBuscarLivro);
		
		JButton btnGerLivros = new JButton("Ger. Livros");
		btnGerLivros.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_ger_livro_32.png")));
		panel.add(btnGerLivros);
		
		JButton btnGerLocatarios = new JButton("Ger. Locatarios");
		btnGerLocatarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaGerenciarLocatario tgl = new TelaGerenciarLocatario();
				tgl.setVisible(true);
				dispose();
				
			}
		});
		btnGerLocatarios.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_ger_locatario_32.png")));
		panel.add(btnGerLocatarios);
		
		JButton btnAtrasos = new JButton("Atrasos");
		btnAtrasos.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/i_atraso_32.png")));
		panel.add(btnAtrasos);
		
		JLabel l1 = new JLabel("Bem vindo ao SGBE!");
		l1.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(l1, BorderLayout.NORTH);
	}

}
