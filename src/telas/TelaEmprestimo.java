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
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import livro.Emprestimo;
import livro.GerenciaEmprestimo;
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
	
	public TelaEmprestimo(TelaPrincipal tp, JFrame telaAnterior, ArrayList<Emprestimo> emprestimos, ArrayList<Locatario> locatarios, ArrayList<Livro> livros, Livro livroRenovar) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GerenciaEmprestimo ge = new GerenciaEmprestimo(null, livros, emprestimos, (livroRenovar==null ? liv : livroRenovar));
		
		JLabel lblEmprstimo = new JLabel((livroRenovar==null?"Empréstimo":"Renovação"));
		lblEmprstimo.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblEmprstimo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 10, 0));
		
		JPanel panelAluno = new JPanel();
		panel.add(panelAluno);
		panelAluno.setBorder(BorderFactory.createTitledBorder("Usuário"));
		panelAluno.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelAluno.add(lblNome);
		
		lNome = new JLabel((livroRenovar==null?"":ge.localizarPorLivro().getNomeLocatario()));
		lNome.setFont(new Font("Dialog", Font.BOLD, 14));
		panelAluno.add(lNome);
		
		TelaEmprestimo te = this;
		
		JButton btnLocalizarLoc = new JButton("Localizar");
		if(livroRenovar != null) {
			btnLocalizarLoc.setEnabled(false);
		}
		
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
		
		lLivro = new JLabel((livroRenovar==null?"":livroRenovar.getTitulo()));
		lLivro.setFont(new Font("Dialog", Font.BOLD, 14));
		panelLivro.add(lLivro);
		panelLivro.setBorder(BorderFactory.createTitledBorder("Livro"));
		
		JButton btnLocalizarLiv = new JButton("Localizar");
		if(livroRenovar != null) {
			btnLocalizarLiv.setEnabled(false);
		}
		btnLocalizarLiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaLocalizarLivro(te, null, te, "Selecione o livro a ser emprestado", livros, null, 3).setVisible(true);
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
				
				if(livroRenovar == null) {
					tp.setVisible(true);
				}else {
					telaAnterior.setVisible(true);
				}
	
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_cancelar_16.png")));
		panel_1.add(btnCancelar);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate dataEntrega = LocalDate.of((Integer)cAno.getSelectedItem(), (Integer)cMes.getSelectedItem(), (Integer)cDia.getSelectedItem());
				
				if(lNome.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Você ainda não definiu um usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else if(lLivro.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Você ainda não definiu um livro!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else if(dataEmprestimo.isAfter(dataEntrega) || dataEmprestimo.isEqual(dataEntrega)) {
					JOptionPane.showMessageDialog(null, "A data de devolução não pode ser igual ou anterior à data de empréstimo!", "Erro", JOptionPane.ERROR_MESSAGE);
				}else {
					Emprestimo ep = (livroRenovar==null ? new Emprestimo(loc.getNomeCompleto(), liv.getNumeroRegistro(), dataEmprestimo, dataEntrega, false) : ge.localizarPorLivro());
					
					if(livroRenovar != null) {
						ep.setDataPrevistaEntrega(dataEntrega);
						ge.setEmprestimo(ep);
						ge.atualizarRegistros();
					}else {
						ge.setLivro(liv);
						ge.setEmprestimo(ep);
						ge.emprestar();
					}
					
					if(livroRenovar == null) {
						if(JOptionPane.showConfirmDialog(null, "Emprestimo Realizado! Deseja realizar outro emprestimo?", "Concluido!", 0) == JOptionPane.YES_OPTION) {
							new TelaEmprestimo(tp, null, emprestimos, locatarios, livros, null).setVisible(true);
							dispose();
						}else {
							tp.setVisible(true);
							dispose();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Renovação realizada!", "Concluido", JOptionPane.INFORMATION_MESSAGE);
						tp.setVisible(true);
						dispose();
					}
					
				}
			}
		});
		btnConcluir.setIcon(new ImageIcon(TelaEmprestimo.class.getResource("/icones/i_concluir_16.png")));
		panel_1.add(btnConcluir);
		
	}

}
