package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class Login {

	private JFrame frame;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 25));
		lblNewLabel.setBounds(188, 10, 193, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 97, 103, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(27, 171, 103, 32);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		textUsername.setBounds(188, 95, 259, 34);
		frame.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				String username = textUsername.getText();
				if(password.contains("1234") && username.contains("1234")) {
					textUsername.setText(null);
					passwordField.setText(null);
					
					Scrapper s = new Scrapper();
					Scrapper.main(null);
					frame.setVisible(false);
					
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid informations" , "Login Error !", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		btnNewButton.setBounds(188, 252, 103, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText(null);
				passwordField.setText(null);
			}
		});
		btnReset.setVerticalAlignment(SwingConstants.TOP);
		btnReset.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		btnReset.setBounds(344, 252, 103, 34);
		frame.getContentPane().add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		passwordField.setBounds(188, 171, 259, 32);
		frame.getContentPane().add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 235, 550, 2);
		frame.getContentPane().add(separator);
	}
}
