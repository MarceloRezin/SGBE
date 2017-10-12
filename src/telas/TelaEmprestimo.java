package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class TelaEmprestimo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestimo frame = new TelaEmprestimo();
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
	
	public JLabel lNome;
	
	public TelaEmprestimo() {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblEmprstimo = new JLabel("Empréstimo");
		lblEmprstimo.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblEmprstimo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 10, 0));
		
		JPanel panelAluno = new JPanel();
		panel.add(panelAluno);
		panelAluno.setBorder(BorderFactory.createTitledBorder("Locatário"));
		panelAluno.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelAluno.add(lblNome);
		
		lNome = new JLabel("");
		lNome.setFont(new Font("Dialog", Font.BOLD, 14));
		panelAluno.add(lNome);
		
		TelaEmprestimo estaClasse = this;
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s="";
				//TelaLocalizarLocatario tl = new TelaLocalizarLocatario(estaClasse, s);
				//tl.setVisible(true);
				//setVisible(false);
				
			}
		});
		btnLocalizar.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_buscar_locatario_16.png")));
		panelAluno.add(btnLocalizar);
		
		JPanel panelLivro = new JPanel();
		panel.add(panelLivro);
		panelLivro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblLivro = new JLabel("Título:");
		panelLivro.add(lblLivro);
		
		JLabel label = new JLabel("");
		panelLivro.add(label);
		panelLivro.setBorder(BorderFactory.createTitledBorder("Livro"));
		
		JButton btnLocalizar_1 = new JButton("Localizar");
		btnLocalizar_1.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_buscar_livro_16.png")));
		panelLivro.add(btnLocalizar_1);
		
		JPanel panelData = new JPanel();
		panel.add(panelData);
		panelData.setBorder(BorderFactory.createTitledBorder("Entrega"));
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolução:");
		panelData.add(lblDataDeDevoluo);
		
		
		


		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		cal.add(Calendar.YEAR, -50);
		Date startDate = cal.getTime();
		cal.add(Calendar.YEAR, 100);
		Date endDate = cal.getTime();
		SpinnerModel model = new SpinnerDateModel(now, startDate, endDate, Calendar.YEAR);
		JSpinner spinner = new JSpinner(model);
			
		panelData.add(spinner);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 0, 0, 0));
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//TelaPrincipal tp = new TelaPrincipal();
				//tp.setVisible(true);
				//setVisible(false);
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_cancelar_16.png")));
		panel_1.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
		
	}

}
