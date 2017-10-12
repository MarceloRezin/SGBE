package telas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import locatario.Locatario;

@SuppressWarnings("serial")
public class TelaRemoverLocatario extends JFrame {

	private JPanel contentPane;

	
	public TelaRemoverLocatario(JFrame telaAnterior, TelaLocalizarLocatario tlc, Locatario loc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblRemoverLocatrio = new JLabel("Remover Locatário");
		lblRemoverLocatrio.setFont(new Font("Dialog", Font.BOLD, 17));
		contentPane.add(lblRemoverLocatrio, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNome = new JLabel("Nome:");
		panel.add(lblNome);
		
				
		JLabel lCampoNome = new JLabel(loc.getNomeCompleto());
		panel.add(lCampoNome);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnLocalizar = new JButton("Localizar");
		panel_1.add(btnLocalizar);
	}

}
