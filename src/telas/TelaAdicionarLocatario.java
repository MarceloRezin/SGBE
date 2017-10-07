package telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaAdicionarLocatario extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoData;
	private JTextField campoEndereco;
	private JTextField campoReferencia;
	private JTextField campoSerie;
	private JTextField campoPai;
	private JTextField campoMãe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdicionarLocatario frame = new TelaAdicionarLocatario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAdicionarLocatario() {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAdicionarLocatrio = new JLabel("Adicionar Locatário");
		lblAdicionarLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblAdicionarLocatrio, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Informações de Registro"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(14, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome Completo:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
		panel.add(lblNome);
		
		campoNome = new JTextField();
		panel.add(campoNome);
		campoNome.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JLabel lAvisoNome = new JLabel("");
		panel.add(lAvisoNome);
		
		JLabel lblSrie = new JLabel("Série:");
		panel.add(lblSrie);
		
		campoSerie = new JTextField();
		panel.add(campoSerie);
		campoSerie.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		JLabel lAvisoSerie = new JLabel("");
		panel.add(lAvisoSerie);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		panel.add(lblDataDeNascimento);
		
		campoData = new JTextField();
		panel.add(campoData);
		campoData.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JLabel lAvisoData = new JLabel("");
		panel.add(lAvisoData);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		panel.add(lblEndereo);
		
		campoEndereco = new JTextField();
		panel.add(campoEndereco);
		campoEndereco.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JLabel lAvisoEndereco = new JLabel("");
		panel.add(lAvisoEndereco);
		
		JLabel lblReferncia = new JLabel("Referência:");
		panel.add(lblReferncia);
		
		campoReferencia = new JTextField();
		panel.add(campoReferencia);
		campoReferencia.setColumns(10);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		JLabel lAvisoReferencia = new JLabel("");
		panel.add(lAvisoReferencia);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		panel.add(lblNomeDoPai);
		
		campoPai = new JTextField();
		panel.add(campoPai);
		campoPai.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_5);
		
		JLabel lAvisoPai = new JLabel("");
		panel.add(lAvisoPai);
		
		JLabel lblNomeDaMe = new JLabel("Nome da Mãe:");
		panel.add(lblNomeDaMe);
		
		campoMãe = new JTextField();
		panel.add(campoMãe);
		campoMãe.setColumns(10);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);
		
		JLabel lAvisoMae = new JLabel("");
		panel.add(lAvisoMae);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaGerenciarLocatario tgl = new TelaGerenciarLocatario();
				tgl.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaAdicionarLocatario.class.getResource("/icones/i_cancelar_16.png")));
		panel_1.add(btnCancelar);
		
		JButton btnLimparTudo = new JButton("Limpar Tudo");
		panel_1.add(btnLimparTudo);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setIcon(new ImageIcon(TelaAdicionarLocatario.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
	}

}
