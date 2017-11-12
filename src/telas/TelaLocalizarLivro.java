package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import livro.Biblioteca;
import livro.Emprestimo;
import livro.Livro;

@SuppressWarnings("serial")
public class TelaLocalizarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField campoPesquisa;
	
	private Integer numeroLivro =  new Integer(-1);
	private Biblioteca lib;
	ArrayList<Livro> busca;
	private JCheckBox checkDisponivel;
	
	//op=0 apagar
	//op=1 consultar
	//op=2 editar
	//op=3 emprestimo
	//op=4 devolução
	//op=5 renovação

	public TelaLocalizarLivro(TelaEmprestimo te, TelaPrincipal tp,JFrame telaAnterior, String mensagem, ArrayList<Livro> livros, ArrayList<Emprestimo> emprestimos, int op) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.SOUTH);
		panel1.setLayout(new GridLayout(1, 3, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaAnterior.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setIcon(new ImageIcon(TelaLocalizarLocatario.class.getResource("/icones/i_cancelar_16.png")));
		panel1.add(btnCancelar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel1.add(horizontalStrut);
		
		TelaLocalizarLivro tll = this;
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(numeroLivro != -1) {
					Livro liv = busca.get(numeroLivro);
					
					if(op == 0) {
						new TelaRemoverLivro(telaAnterior, tll, livros, liv).setVisible(true);
						setVisible(false);
					}else if(op == 1) {
						new TelaConsultarLivro(telaAnterior, tll, liv).setVisible(true);
					}else if(op == 2) {
						new TelaAdicionarLivro(telaAnterior, tll, livros, "Editar Livro", liv).setVisible(true);
					}else if(op == 3) {
						te.liv = liv;
						te.lLivro.setText(liv.getTitulo());
						te.setVisible(true);
					}else if(op == 4) {
						new TelaDevolucaoLivro(tp,tll,livros, emprestimos, liv).setVisible(true);
					}else if(op==5) {
						new TelaEmprestimo(tp, tll, emprestimos, null, livros, liv).setVisible(true);
					}
					
					if(te== null) {
						setVisible(false);
					}else {
						dispose();
					}
				}	
			}
		});
		btnSelecionar.setIcon(new ImageIcon(TelaLocalizarLocatario.class.getResource("/icones/i_concluir_16.png")));
		panel1.add(btnSelecionar);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelTipoBusca = new JPanel();
		panel.add(panelTipoBusca);
		panelTipoBusca.setBorder(BorderFactory.createTitledBorder("Busca"));
		
		String[] tiposDeBuscas = {"Numero", "Título"};
		
		JComboBox<String> comboBox = new JComboBox<String>();
		for(int i=0; i<tiposDeBuscas.length; i++) {
			comboBox.addItem("Busca por " + tiposDeBuscas[i]);
		}
		
		campoPesquisa = new JTextField();
		campoPesquisa.setFont(new Font("Dialog", Font.PLAIN, 14));
		campoPesquisa.setColumns(10);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		JList<String> listResultado = new JList<String>();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!campoPesquisa.getText().trim().isEmpty()) {
					listModel.removeAllElements();
					lib = new Biblioteca(livros);
						
					if(comboBox.getSelectedIndex() == 0) {
						
						boolean ehNumero = false;
						
						try{
							Integer.parseInt(campoPesquisa.getText());
							
							ehNumero = true;
						}catch(NumberFormatException ex){

							ehNumero = false;
						}
						
						if(ehNumero) {
							
							if(op == 3) {
								busca = lib.consultaNumeroRegistro(campoPesquisa.getText(), true);
							}else if(op == 4 || op == 5) {
								busca = lib.consultaNumeroRegistro(campoPesquisa.getText(), false);
							}else {
								if(checkDisponivel.isSelected() == true) {
									busca = lib.consultaNumeroRegistro(campoPesquisa.getText(), true);
									
								}else {
									busca = lib.consultaNumeroRegistro(campoPesquisa.getText());
								}
							}
							
						}
						
					}else {
						if(op == 3) {
							busca = lib.consultaTitulo(campoPesquisa.getText(), true);
						}else if(op == 4 || op == 5) {
							busca = lib.consultaTitulo(campoPesquisa.getText(), false);
						}else {
							if(checkDisponivel.isSelected() == true) {
								busca = lib.consultaTitulo(campoPesquisa.getText(), true);
								
							}else {
								busca = lib.consultaTitulo(campoPesquisa.getText());
							}
						}
					}
					
					if(busca != null) {
						for (Livro livro : busca) {
							listModel.addElement(livro.getTitulo());
						}
					}
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(TelaLocalizarLivro.class.getResource("/icones/i_buscar_livro_16.png")));
		 
		
		listResultado.setModel(listModel);
		
		checkDisponivel = new JCheckBox("Disponiveis apenas");
		checkDisponivel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBuscar.doClick();
				
			}
		});
		
		if(op == 3) {
			checkDisponivel.setSelected(true);
			checkDisponivel.setEnabled(false);
		}
		
		if(op == 4 || op == 5) {
			checkDisponivel.setText("Não disponivel apenas");
			checkDisponivel.setSelected(true);
			checkDisponivel.setEnabled(false);
		}
		GroupLayout gl_panelTipoBusca = new GroupLayout(panelTipoBusca);
		gl_panelTipoBusca.setHorizontalGroup(
			gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(campoPesquisa, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(checkDisponivel)
					.addGap(305))
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addComponent(listResultado, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelTipoBusca.setVerticalGroup(
			gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panelTipoBusca.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(campoPesquisa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(checkDisponivel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listResultado, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		panelTipoBusca.setLayout(gl_panelTipoBusca);

		JLabel lblBuscarLocatrio = new JLabel(mensagem);
		lblBuscarLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblBuscarLocatrio, BorderLayout.NORTH);
		
		
		listResultado.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  numeroLivro = listResultado.getSelectedIndex();
                }
            }
        });
	}
}
