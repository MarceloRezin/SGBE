package telas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import locatario.Locatario;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaGerenciarLocatario extends JFrame {

	private JPanel contentPane;
	

	public TelaGerenciarLocatario(ArrayList<Locatario> locatarios, TelaPrincipal tp) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		TelaGerenciarLocatario tgl = this;
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaAdicionarLocatario tal = new TelaAdicionarLocatario(locatarios, tgl);
				tal.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		panel.add(btnEditar);
		
		JButton btnConsultar = new JButton("Consultar");
		panel.add(btnConsultar);
		
		JLabel lblGerenciamentoDeLocatrios = new JLabel("Gerenciamento de Locatários");
		lblGerenciamentoDeLocatrios.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblGerenciamentoDeLocatrios, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnVoltar);
	}

}
