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
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TelaGerenciarLocatario extends JFrame {

	private JPanel contentPane;

	public TelaGerenciarLocatario(ArrayList<Locatario> locatarios, TelaPrincipal tp) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 10, 10));
		
		TelaGerenciarLocatario tgl = this;
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setIcon(new ImageIcon(TelaGerenciarLocatario.class.getResource("/icones/i_add_locatario_16.png")));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaAdicionarLocatario tal = new TelaAdicionarLocatario(tgl, null,"Adicionar Usuário", locatarios, null);
				tal.setVisible(true);
				setVisible(false);
			}
		});
		panel.add(btnAdicionar);
		
		JFrame frame = this;
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLocatario(null, frame, "Selecione o usuário a ser removido", locatarios, 0).setVisible(true);
				setVisible(false);
			}
		});
		btnRemover.setIcon(new ImageIcon(TelaGerenciarLocatario.class.getResource("/icones/i_rem_locatario_16.png")));
		panel.add(btnRemover);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLocatario(null, frame, "Selecione o usuário a ser editado", locatarios, 2).setVisible(true);
				setVisible(false);
			}
		});
		btnEditar.setIcon(new ImageIcon(TelaGerenciarLocatario.class.getResource("/icones/i_edit_locatario_16.png")));
		panel.add(btnEditar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLocatario(null, frame, "Selecione o usuário a ser consultado", locatarios, 1).setVisible(true);
				setVisible(false);
			}
		});
		btnConsultar.setIcon(new ImageIcon(TelaGerenciarLocatario.class.getResource("/icones/i_locatario_16.png")));
		panel.add(btnConsultar);
		
		JLabel lblGerenciamentoDeLocatrios = new JLabel("Gerenciamento de Usuários");
		lblGerenciamentoDeLocatrios.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblGerenciamentoDeLocatrios, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(TelaGerenciarLocatario.class.getResource("/icones/i_seta_esq_16.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tp.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnVoltar);
	}

}
