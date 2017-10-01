package telas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


@SuppressWarnings("serial")
public class TelaLocalizarLocatario extends JFrame {

	private JPanel contentPane;
	private JTextField campoPesquisa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String s = "";
					TelaLocalizarLocatario frame = new TelaLocalizarLocatario(null, s);
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
	
	String nomeLocatario =  new String();
	
	public TelaLocalizarLocatario(TelaEmprestimo te, String s) {
		super("SGBE - Sistema de Gerenciamento Bibliotecário Escolar");
		
		
		this.nomeLocatario = s;
		
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
		btnCancelar.setIcon(new ImageIcon(TelaLocalizarLocatario.class.getResource("/icones/i_cancelar_16.png")));
		panel1.add(btnCancelar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel1.add(horizontalStrut);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				te.lNome.setText(nomeLocatario);
				te.setVisible(true);
				dispose();
				
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
		comboBox.setBounds(9, 20, 145, 24);
		for(int i=0; i<tiposDeBuscas.length; i++) {
			comboBox.addItem("Busca por " + tiposDeBuscas[i]);
		}
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});
		
		campoPesquisa = new JTextField();
		campoPesquisa.setBounds(159, 20, 168, 25);
		campoPesquisa.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(TelaLocalizarLocatario.class.getResource("/icones/i_buscar_locatario_16.png")));
		btnBuscar.setBounds(331, 20, 110, 25);
		panelTipoBusca.setLayout(null);
		panelTipoBusca.add(comboBox);
		panelTipoBusca.add(campoPesquisa);
		panelTipoBusca.add(btnBuscar);
		 
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		
		listModel.addElement("Marcelo Minato Rezin");
		
		JList<String> listResultado = new JList<String>();
		listResultado.setBounds(9, 60, 430, 150);
		panelTipoBusca.add(listResultado);
		
		listResultado.setModel(listModel);

		JLabel lblBuscarLocatrio = new JLabel("Buscar Locatário");
		lblBuscarLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblBuscarLocatrio, BorderLayout.NORTH);
		
		
		listResultado.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  nomeLocatario = listResultado.getSelectedValue().toString();
                }
            }
        });
	}
}
