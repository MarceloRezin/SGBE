package telas;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

import arquivos.Diretorio;
import arquivos.GravaJSON;
import locatario.GerenciaLocatarios;
import locatario.Locatario;
import javax.swing.JTextArea;
import java.awt.Color;

@SuppressWarnings("serial")
public class TelaRemoverLocatario extends JFrame {

	private JPanel contentPane;

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);
	public TelaRemoverLocatario(JFrame telaAnterior, TelaLocalizarLocatario tlc, ArrayList<Locatario> locatarios, Locatario loc) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRemoverLocatrio = new JLabel("Remover Locatário");
		lblRemoverLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblRemoverLocatrio, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 1, 0, 0));
		
		
		JTextArea textArea = new JTextArea("\n" + loc.toString());
		textArea.setBackground(new Color(238, 238, 238));
		textArea.setFont(new Font("Dialog", Font.BOLD, 15));
		textArea.setEditable(false);
		panel.add(textArea);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tlc.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaRemoverLocatario.class.getResource("/icones/i_seta_esq_16.png")));
		panel_3.add(btnVoltar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAnterior.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaRemoverLocatario.class.getResource("/icones/i_cancelar_16.png")));
		panel_3.add(btnCancelar);
		
		JButton btnRemover_1 = new JButton("Remover");
		btnRemover_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este locatário?", "Apagar:", 0) == JOptionPane.YES_OPTION) {
					new GerenciaLocatarios(locatarios).removeLocatario(loc);
					
					threadpool.submit(new GravaJSON<>(locatarios, Diretorio.DIR_LOCATARIOS));
					
					JOptionPane.showMessageDialog(null, "Locatário Removido!", "Concluido", JOptionPane.INFORMATION_MESSAGE);
					telaAnterior.setVisible(true);
					dispose();
				}
			}
		});
		btnRemover_1.setIcon(new ImageIcon(TelaRemoverLocatario.class.getResource("/icones/i_rem_locatario_16.png")));
		panel_3.add(btnRemover_1);
	}

}
