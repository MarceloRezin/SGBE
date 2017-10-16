package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.Box;
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
import livro.Livro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class TelaAdicionarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField campoNumero;
	private JLabel avisoNumero;
	private JTextField campoTitulo;
	private JLabel avisoTitulo;
	private JTextField campoAutor;
	private JLabel avisoAutor;
	private JTextField campoLocalização;
	private JLabel avisoLocalizacao;
	
	private int numero;

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(1);
	
	public TelaAdicionarLivro(JFrame telaAnterior, TelaLocalizarLivro tll, ArrayList<Livro> livros, String msg, Livro liv) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAdicionarLivro = new JLabel(msg);
		lblAdicionarLivro.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblAdicionarLivro, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 2, 0, 0));
		panel.setBorder(BorderFactory.createTitledBorder("Informações de Registro"));
		
		JLabel lblNmeroDeRegistro = new JLabel("Número de Registro:");
		lblNmeroDeRegistro.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNmeroDeRegistro);
		
		campoNumero = new JTextField();
		campoNumero.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoNumero.setAlignmentY(1.0f);
		panel.add(campoNumero);
		campoNumero.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		avisoNumero = new JLabel("");
		avisoNumero.setVerticalAlignment(SwingConstants.TOP);
		avisoNumero.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(avisoNumero);
		
		JLabel lblTtulo = new JLabel("Título:");
		panel.add(lblTtulo);
		
		campoTitulo = new JTextField();
		campoTitulo.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoTitulo);
		campoTitulo.setColumns(10);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		avisoTitulo = new JLabel("");
		avisoTitulo.setVerticalAlignment(SwingConstants.TOP);
		avisoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(avisoTitulo);
		
		JLabel lblAutor = new JLabel("Autor:");
		panel.add(lblAutor);
		
		campoAutor = new JTextField();
		campoAutor.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoAutor);
		campoAutor.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		avisoAutor = new JLabel("");
		avisoAutor.setHorizontalAlignment(SwingConstants.CENTER);
		avisoAutor.setVerticalAlignment(SwingConstants.TOP);
		panel.add(avisoAutor);
		
		JLabel lblLocalizao = new JLabel("Localização:");
		panel.add(lblLocalizao);
		
		campoLocalização = new JTextField();
		campoLocalização.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(campoLocalização);
		campoLocalização.setColumns(10);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		avisoLocalizacao = new JLabel("");
		avisoLocalizacao.setVerticalAlignment(SwingConstants.TOP);
		avisoLocalizacao.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(avisoLocalizacao);
		
		if(liv != null) {
			campoNumero.setText("" + liv.getNumeroRegistro());
			campoNumero.setEnabled(false);
			campoTitulo.setText(liv.getTitulo());
			campoAutor.setText(liv.getAutor());
			campoLocalização.setText(liv.getLocalizacao());
		}
		
		ArrayList<JLabel> avisos = new ArrayList<>();
		avisos.add(avisoNumero);
		avisos.add(avisoAutor);
		avisos.add(avisoLocalizacao);
		avisos.add(avisoTitulo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(TelaAdicionarLivro.class.getResource("/icones/i_cancelar_16.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(liv == null) {
					telaAnterior.setVisible(true);
				}else {
					tll.setVisible(true);
				}
				
				dispose();
			}
		});
		panel_1.add(btnCancelar);
		
		JButton btnLimparTudo = new JButton("Limpar Tudo");
		btnLimparTudo.setIcon(new ImageIcon(TelaAdicionarLivro.class.getResource("/icones/i_borracha_16.png")));
		btnLimparTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(liv == null) {
					campoNumero.setText("");
				}
				campoTitulo.setText("");
				campoAutor.setText("");
				campoLocalização.setText("");
				
				for (JLabel aviso : avisos) {
					aviso.setText("");
				}
			}
		});
		panel_1.add(btnLimparTudo);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (JLabel aviso : avisos) {
					aviso.setText("");
				}
				
				if(verificaCampos()) {
					
					Livro l = new Livro(numero, campoTitulo.getText(), campoAutor.getText(), campoLocalização.getText(), true);
					
					if(liv == null) {
						livros.add(l);
						
						threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
						
						JOptionPane.showMessageDialog(null, "Livro adicionado!", "Concluido", JOptionPane.INFORMATION_MESSAGE);
						telaAnterior.setVisible(true);	
					}
					dispose();
				}
			}
		});
		btnConcluir.setIcon(new ImageIcon(TelaAdicionarLivro.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
	}
	
	private boolean verificaCampos() {
			
		boolean ehNumero = false;
		try{
			numero = Integer.parseInt(campoNumero.getText());
			
			ehNumero = true;
			}catch(NumberFormatException ex){

			ehNumero = false;
			}
		
		if(ehNumero == false) {
			avisoNumero.setText("O campo acima não contem um numero válido!");
			
			return false;
		}else if(campoTitulo.getText().trim().isEmpty()) {
			avisoTitulo.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoAutor.getText().trim().isEmpty()) {
			avisoAutor.setText("O campo acima está vazio!");
			
			return false;
		}else if(campoLocalização.getText().trim().isEmpty()) {
			avisoLocalizacao.setText("O campo acima está vazio!");
			
			return false;
		}
		
		return true;
	}

}
