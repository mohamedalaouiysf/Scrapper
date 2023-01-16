package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import Controller.DbConn;
import Extract.extr;
import ml.classification;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JMenu;

public class Scrapper {

	private JFrame frame;
	Choice choice = new Choice();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scrapper window = new Scrapper();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Scrapper() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 733, 371);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scrapper");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(180, 26, 346, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Lancer Scrapping");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ScrapResult s = new ScrapResult();
				//ScrapResult.main(null);
				String url =choice.getSelectedItem();
				extr.extraire(url);
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 218, 220, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLancerClassification = new JButton("Lancer Classification");
		btnLancerClassification.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
		    //DbConn.connecter();
			try {
				classification.classifier();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//DbConn.fermer();
		    
	
		}});
		btnLancerClassification.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLancerClassification.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		btnLancerClassification.setBounds(240, 218, 229, 44);
		frame.getContentPane().add(btnLancerClassification);
		choice.setBounds(228, 123,300, 50);
		choice.add("Rekrute.ma");
		choice.add("Emploi.ma");
		frame.getContentPane().add(choice);
		
		JButton var = new JButton("Afficher offres");
		var.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*redirection:*/ 
				ScrapResult window2 = new ScrapResult();
				window2.frame.setVisible(true);
			}
		});
		var.setVerticalAlignment(SwingConstants.BOTTOM);
		var.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		var.setBounds(479, 218, 220, 44);
		frame.getContentPane().add(var);
	}
}
