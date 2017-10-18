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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import locatario.GerenciaLocatarios;
import locatario.Locatario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


@SuppressWarnings("serial")
public class TelaLocalizarLocatario extends JFrame {

	private JPanel contentPane;
	private JTextField campoPesquisa;
	
	private Integer nomeLocatario =  new Integer(-1);
	private GerenciaLocatarios gl;
	ArrayList<Locatario> busca;
	
	//op=0 apagar
	//op=1 consultar
	//op=2 editar
	//op=3 emprestimo
	
	public TelaLocalizarLocatario(TelaEmprestimo te, JFrame telaAnterior, String mensagem, ArrayList<Locatario> locatarios, int op) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 331);
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
		
		TelaLocalizarLocatario tlc = this;
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(nomeLocatario != -1) {
					Locatario encontrado = busca.get(nomeLocatario);
					
					if(op == 0) {
						new TelaRemoverLocatario(telaAnterior, tlc, locatarios, encontrado).setVisible(true);
					}else if(op == 1) {
						new TelaConsultarLocatario(telaAnterior, tlc, encontrado).setVisible(true);
					}else if(op == 2) {
						new TelaAdicionarLocatario(telaAnterior, tlc, "Editar Usuário", locatarios, encontrado).setVisible(true);;
					}else if(op == 3) {
						te.loc = encontrado;
						te.lNome.setText(encontrado.getNomeCompleto());
						te.setVisible(true);
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
		
		String[] tiposDeBuscas = {"Nome", "Série"};
		
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
					
					gl = new GerenciaLocatarios(locatarios);
					
					
					if(comboBox.getSelectedIndex() == 0) {
						busca = gl.consultaPorNome(campoPesquisa.getText());
						
					}else {
						busca = gl.consultaPorSerie(campoPesquisa.getText());
						
					}
					
					for (Locatario loc : busca) {
						listModel.addElement(loc.getNomeCompleto());
					}
				}
			}
		});
		btnBuscar.setIcon(new ImageIcon(TelaLocalizarLocatario.class.getResource("/icones/i_buscar_locatario_16.png")));
		 
		
		listResultado.setModel(listModel);
		GroupLayout gl_panelTipoBusca = new GroupLayout(panelTipoBusca);
		gl_panelTipoBusca.setHorizontalGroup(
			gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTipoBusca.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(campoPesquisa, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addComponent(listResultado, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panelTipoBusca.setVerticalGroup(
			gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTipoBusca.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panelTipoBusca.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(campoPesquisa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addComponent(listResultado, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
		);
		panelTipoBusca.setLayout(gl_panelTipoBusca);

		JLabel lblBuscarLocatrio = new JLabel(mensagem);
		lblBuscarLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblBuscarLocatrio, BorderLayout.NORTH);
		
		
		listResultado.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  nomeLocatario = listResultado.getSelectedIndex();
                }
            }
        });
	}
	
	
}
