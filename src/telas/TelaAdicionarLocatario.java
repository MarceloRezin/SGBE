package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import arquivos.Diretorio;
import arquivos.GravaJSON;
import locatario.GerenciaLocatarios;
import locatario.Locatario;

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
	
	private JLabel lAvisoNome;
	private JLabel lAvisoSerie;
	private JLabel lAvisoData;
	private JLabel lAvisoEndereco;
	private JLabel lAvisoReferencia;
	private JLabel lAvisoPai;
	private JLabel lAvisoMae;
	

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);
	
	public TelaAdicionarLocatario(JFrame telaAnterior, TelaLocalizarLocatario tll, String msg, ArrayList<Locatario> locatarios, Locatario loc) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAdicionarLocatrio = new JLabel(msg);
		lblAdicionarLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblAdicionarLocatrio, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Informações de Registro"));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(14, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome Completo:");
		lblNome.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNome);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoNome);
		campoNome.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		lAvisoNome = new JLabel("");
		lAvisoNome.setVerticalAlignment(SwingConstants.TOP);
		lAvisoNome.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoNome);
		
		JLabel lblSrie = new JLabel("Série:");
		panel.add(lblSrie);
		
		campoSerie = new JTextField();
		campoSerie.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoSerie);
		campoSerie.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		lAvisoSerie = new JLabel("");
		lAvisoSerie.setVerticalAlignment(SwingConstants.TOP);
		lAvisoSerie.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoSerie);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		panel.add(lblDataDeNascimento);
		
		campoData = new JTextField();
		campoData.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoData);
		campoData.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		lAvisoData = new JLabel("");
		lAvisoData.setVerticalAlignment(SwingConstants.TOP);
		lAvisoData.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoData);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		panel.add(lblEndereo);
		
		campoEndereco = new JTextField();
		campoEndereco.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoEndereco);
		campoEndereco.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		lAvisoEndereco = new JLabel("");
		lAvisoEndereco.setVerticalAlignment(SwingConstants.TOP);
		lAvisoEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoEndereco);
		
		JLabel lblReferncia = new JLabel("Referência:");
		panel.add(lblReferncia);
		
		campoReferencia = new JTextField();
		campoReferencia.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoReferencia);
		campoReferencia.setColumns(10);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		lAvisoReferencia = new JLabel("");
		lAvisoReferencia.setVerticalAlignment(SwingConstants.TOP);
		lAvisoReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoReferencia);
		
		JLabel lblNomeDoPai = new JLabel("Nome do Pai:");
		panel.add(lblNomeDoPai);
		
		campoPai = new JTextField();
		campoPai.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoPai);
		campoPai.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_5);
		
		lAvisoPai = new JLabel("");
		lAvisoPai.setVerticalAlignment(SwingConstants.TOP);
		lAvisoPai.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoPai);
		
		JLabel lblNomeDaMe = new JLabel("Nome da Mãe:");
		panel.add(lblNomeDaMe);
		
		campoMãe = new JTextField();
		campoMãe.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoMãe);
		campoMãe.setColumns(10);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);
		
		lAvisoMae = new JLabel("");
		lAvisoMae.setVerticalAlignment(SwingConstants.TOP);
		lAvisoMae.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lAvisoMae);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(loc == null) {
					telaAnterior.setVisible(true);
				}else {
					tll.setVisible(true);
				}
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaAdicionarLocatario.class.getResource("/icones/i_cancelar_16.png")));
		panel_1.add(btnCancelar);
		
		
		if(loc != null) {
			campoData.setText(loc.getDataNascimento());
			campoEndereco.setText(loc.getEndereco());
			campoMãe.setText(loc.getNomeMae());
			campoNome.setText(loc.getNomeCompleto());
			campoNome.setEnabled(false);
			campoPai.setText(loc.getNomePai());
			campoReferencia.setText(loc.getReferencia());
			campoSerie.setText(loc.getSerie());
		}
		
		ArrayList<JLabel> avisos = new ArrayList<>();
		avisos.add(lAvisoEndereco);
		avisos.add(lAvisoData);
		avisos.add(lAvisoMae);
		avisos.add(lAvisoNome);
		avisos.add(lAvisoPai);
		avisos.add(lAvisoReferencia);
		avisos.add(lAvisoSerie);
		
		JButton btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.setIcon(new ImageIcon(TelaAdicionarLocatario.class.getResource("/icones/i_borracha_16.png")));
		btnLimparTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				campoData.setText("");
				campoEndereco.setText("");
				campoMãe.setText("");
				if(loc == null) {
					campoNome.setText("");
				}
				campoPai.setText("");
				campoReferencia.setText("");
				campoSerie.setText("");
				
				for (JLabel aviso : avisos) {
					aviso.setText("");
				}
			}
		});
		panel_1.add(btnLimparTudo);	
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (JLabel aviso : avisos) {
					aviso.setText("");
				}
				
				if(verificaCampos()) {
					
					Locatario locatario = new Locatario(campoNome.getText(), campoData.getText(), campoEndereco.getText(), campoReferencia.getText(), campoSerie.getText(), campoPai.getText(), campoMãe.getText());
					
					boolean resul = true;
					String msg = "adicionado";
					
					
					if(loc == null) {
						resul = new GerenciaLocatarios(locatarios).addLocatario(locatario);
					}else {
						new GerenciaLocatarios(locatarios).editaLocatario(locatario);
						msg = "editado";
					}
						
					if(resul) {
						threadpool.submit(new GravaJSON<>(locatarios, Diretorio.DIR_LOCATARIOS));
						
						JOptionPane.showMessageDialog(null, "Usuário " + msg + "!", "Concluido", JOptionPane.INFORMATION_MESSAGE);
						telaAnterior.setVisible(true);	
						
						dispose();
					}else {		
						lAvisoNome.setText("Já existe um usuário com esse nome!");
					}
				}
				
			}
		});
		btnConcluir.setIcon(new ImageIcon(TelaAdicionarLocatario.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
		
		getRootPane().setDefaultButton(btnConcluir);
	}
	
	private boolean verificaCampos() {
		
		if(campoNome.getText().trim().isEmpty()) {
			lAvisoNome.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoSerie.getText().trim().isEmpty()) {
			lAvisoSerie.setText("O campo acima está vazio!");
			
			return false;
		}else if(!campoData.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			lAvisoData.setText("A data deve ser DD/MM/AAAA");
			
			return false;
		}else if(campoEndereco.getText().trim().isEmpty()) {
			lAvisoEndereco.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoReferencia.getText().trim().isEmpty()) {
			lAvisoReferencia.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoPai.getText().trim().isEmpty()) {
			lAvisoPai.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoMãe.getText().trim().isEmpty()) {
			lAvisoMae.setText("O campo acima está vazio!");
			
			return false;
		}
		
		return true;
	}

}
