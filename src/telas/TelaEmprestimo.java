package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import arquivos.Diretorio;
import arquivos.GravaJSON;
import livro.Emprestimo;
import livro.Livro;
import locatario.Locatario;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class TelaEmprestimo extends JFrame {

	private JPanel contentPane;
	
	public JLabel lNome;
	public Locatario loc;
	public Livro liv;
	public JLabel lLivro;
	
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(2);
	
	public TelaEmprestimo(TelaPrincipal tp, ArrayList<Emprestimo> emprestimos, ArrayList<Locatario> locatarios, ArrayList<Livro> livros) {
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
		
		TelaEmprestimo te = this;
		
		JButton btnLocalizarLoc = new JButton("Localizar");
		btnLocalizarLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TelaLocalizarLocatario(te, te, "Selecione o usuário para o empréstimo", locatarios, 3).setVisible(true);
				setVisible(false);
				
			}
		});
		btnLocalizarLoc.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_buscar_locatario_16.png")));
		panelAluno.add(btnLocalizarLoc);
		
		JPanel panelLivro = new JPanel();
		panel.add(panelLivro);
		panelLivro.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblLivro = new JLabel("Título:");
		panelLivro.add(lblLivro);
		
		lLivro = new JLabel("");
		lLivro.setFont(new Font("Dialog", Font.BOLD, 14));
		panelLivro.add(lLivro);
		panelLivro.setBorder(BorderFactory.createTitledBorder("Livro"));
		
		JButton btnLocalizarLiv = new JButton("Localizar");
		btnLocalizarLiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLivro(te, te, "Selecione o livro a ser emprestado", livros, 3).setVisible(true);
				setVisible(false);
			}
		});
		btnLocalizarLiv.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_buscar_livro_16.png")));
		panelLivro.add(btnLocalizarLiv);
		
		JPanel panelData = new JPanel();
		panel.add(panelData);
		panelData.setBorder(BorderFactory.createTitledBorder("Entrega"));
		
		JLabel lblDataDeDevoluo = new JLabel("Data de Devolução:");
		panelData.add(lblDataDeDevoluo);
		
		Calendar cal = Calendar.getInstance();
		int mesAtual = cal.get(GregorianCalendar.MONTH);
		
		LocalDate dataEmprestimo = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
		
		cal.add(Calendar.DATE, 7);
		
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.add(Calendar.DATE, 1);
		}else if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			cal.add(Calendar.DATE, 2);
		}
		
		LocalDate dataEntrega = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH));
		
		JComboBox<Integer> cDia = new JComboBox<Integer>();
		panelData.add(cDia);
				
		JComboBox<Integer> cMes = new JComboBox<Integer>();
		panelData.add(cMes);
		for(int i=1; i<=12; i++) {
			cMes.addItem(i);
		}
		
		cMes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cal.set(Calendar.MONTH, cMes.getSelectedIndex());
				
				int a = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
				
					cDia.removeAllItems();
					
					for(int i=1; i<=a; i++) {
						cDia.addItem(i);
					}
				
					cDia.setSelectedIndex(cal.get(GregorianCalendar.DAY_OF_MONTH) -1);
			}
		});
		
		
		JComboBox<Integer> cAno = new JComboBox<Integer>();
		panelData.add(cAno);
		
		for(int i=2017; i<=2020; i++) {
			cAno.addItem(i);
		}
		
		cMes.setSelectedItem(mesAtual + 1);
		
		
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
				
				tp.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_cancelar_16.png")));
		panel_1.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Emprestimo ep = new Emprestimo(loc.getNomeCompleto(), liv.getNumeroRegistro(), dataEmprestimo, dataEntrega, false);
				liv.setDisponivel(false);
				
				emprestimos.add(ep);
				
				threadpool.submit(new GravaJSON<>(emprestimos, Diretorio.DIR_EMPRESTIMOS));
				threadpool.submit(new GravaJSON<>(livros, Diretorio.DIR_LIVROS));
			}
		});
		btnConcluir.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
		
	}

}
