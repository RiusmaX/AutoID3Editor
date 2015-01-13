package fr.autoid3tageditor;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class IHM extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3994651912308970854L;
	private JTextField textField;
	private JFileChooser chooser = new JFileChooser();
	
	public IHM() {		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(35);
		
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		JButton btnDossier = new JButton("Dossier");
		btnDossier.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {				
			    chooser.setCurrentDirectory(new java.io.File("C:\\Users\\Marius\\Music\\Trap"));
			    chooser.setDialogTitle("choosertitle");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	textField.setText(chooser.getSelectedFile().toString());
			    } else {
			      System.out.println("No Selection ");
			    }
				
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
		panel.add(btnDossier);
		
		JButton btnTag = new JButton("TAG !");
		btnTag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AutoEditor ae = new AutoEditor();
				ae.editor(chooser.getSelectedFile());				
			}
		});
		panel.add(btnTag);
	}
}
