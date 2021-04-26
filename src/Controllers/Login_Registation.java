package Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import logic.Auth;
import logic.Customer;
import logic.DBReader;
import logic.ParkingAurthority;
import logic.SystemAdministrator;
import logic.User;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;

public class Login_Registation {

	private JFrame frame;
	private JTextField emailField;
	private JTextField passwordRegField;
	private JTextField firstnameRegField;
	private JTextField emailRegField;
	private JTextField lastnameRegField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Registation window = new Login_Registation();
					window.frame.setLocationRelativeTo(null);
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
	public Login_Registation() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 685, 53);
		panel.setBackground(new Color(0, 0, 0, 153));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Parking Managment System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 0, 153));
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel_1.setBounds(0, 53, 343, 435);
		frame.getContentPane().add(panel_1);
		
		JLabel lblUsername = new JLabel("Email");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setBounds(33, 122, 66, 14);
		panel_1.add(lblUsername);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailField.setColumns(10);
		emailField.setBounds(136, 111, 167, 40);
		panel_1.add(emailField);
		
		JLabel lblPassword = new JLabel("Password"); 
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(33, 175, 66, 14);
		panel_1.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password =  passwordField.getText();
				String email = emailField.getText();
				
//				User newUser = new User(email, password);
				Auth auth = new Auth();
				User user = auth.login(email, password);

				if(user != null) {
					passwordField.setText(null);
					emailField.setText(null);
//					System.out.println(user instanceof User);
//					System.out.println(user instanceof Customer);
//					System.out.println(user instanceof SystemAdministrator);
//					System.out.println(user instanceof ParkingAurhority);

					String usertype =user.getUsertype();
					if(user instanceof Customer) {	
////						CustomerBookSpace.main(null);
//						CustomerBookSpace.setUser(user);
						CustomerLanding.main(null);
						CustomerLanding.setUser(user);
					}
					else if(user instanceof SystemAdministrator) {
						SystemAdministratorsController.main(null);
						SystemAdministratorsController.setUser(user);				
					}
					else if(user instanceof ParkingAurthority) {
						ParkingAuthorityController.main(null);
						ParkingAuthorityController.setUser(user);				
					}
										
					frame.dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText(null);
					emailField.setText(null);
				}
			}
		});
		btnLogin.setBounds(136, 228, 167, 40);
		panel_1.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordField.setBounds(136, 162, 167, 40);
		panel_1.add(passwordField);
		
		JPanel panel_1_1 = new JPanel(); 
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(0, 0, 0, 153));
		panel_1_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), null));
		panel_1_1.setBounds(341, 53, 344, 435);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword_1.setForeground(new Color(255, 255, 255));
		lblPassword_1.setBounds(10, 238, 66, 14);
		panel_1_1.add(lblPassword_1);
		
		passwordRegField = new JTextField();
		passwordRegField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		passwordRegField.setColumns(10);
		passwordRegField.setBounds(110, 225, 188, 44);
		panel_1_1.add(passwordRegField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = firstnameRegField.getText().trim().toLowerCase();
				String lastname = lastnameRegField.getText().trim().toLowerCase();
				String email = emailRegField.getText().trim().toLowerCase();
				String password = passwordRegField.getText().trim().toLowerCase();
				
				
				Auth auth = new Auth();
//				JLabel succesMsg = new JLabel("This was a success");
//				succesMsg.setBounds(10, 124, 66, 14);
//				panel_1_1.add(succesMsg);
				
				if(	auth.Register(firstname,lastname,email, password)) {
					System.out.println("Registerd");
					JOptionPane.showMessageDialog(null, "Successfully Registered", "Success",JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Registration Details", "Registration Error",JOptionPane.ERROR_MESSAGE);
					firstnameRegField.setText(null);
					lastnameRegField.setText(null);
					emailRegField.setText(null);
					passwordRegField.setText(null);
				}
				
				
			}
		});
		btnRegister.setBounds(110, 291, 188, 44);
		panel_1_1.add(btnRegister);
		
		JLabel lblFirstname = new JLabel("Firstname");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstname.setForeground(new Color(255, 255, 255));
		lblFirstname.setBounds(10, 80, 66, 14);
		panel_1_1.add(lblFirstname);
		
		firstnameRegField = new JTextField();
		firstnameRegField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		firstnameRegField.setColumns(10);
		firstnameRegField.setBounds(110, 70, 188, 38);
		panel_1_1.add(firstnameRegField);
		
		emailRegField = new JTextField();
		emailRegField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailRegField.setColumns(10);
		emailRegField.setBounds(110, 174, 188, 38);
		panel_1_1.add(emailRegField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setBounds(10, 184, 66, 14);
		panel_1_1.add(lblEmail);
		
		lastnameRegField = new JTextField();
		lastnameRegField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lastnameRegField.setColumns(10);
		lastnameRegField.setBounds(110, 119, 188, 44);
		panel_1_1.add(lastnameRegField);
		
		JLabel lblLastname_1 = new JLabel("Lastname");
		lblLastname_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastname_1.setForeground(new Color(255, 255, 255));
		lblLastname_1.setBounds(10, 132, 66, 14);
		panel_1_1.add(lblLastname_1);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg4.jpg"));
		Image img2 = img.getImage().getScaledInstance(700, 527, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(img2);
		
		JLabel background = new JLabel("");
		background.setForeground(Color.WHITE);
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setIcon(img);
		background.setBounds(0, 0, 685, 488);
		frame.getContentPane().add(background);
	}
}
