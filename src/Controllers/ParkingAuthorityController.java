package Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Customer;
import logic.ParkingAurthority;
import logic.User;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ParkingAuthorityController {

	private JFrame frame;
	private static ParkingAurthority user;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(user != null) {						
					ParkingAuthorityController window = new ParkingAuthorityController();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
					}
					else {
						Login_Registation.main(null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParkingAuthorityController() {
		initialize();
	}
	public static void setUser(User user) {
		ParkingAuthorityController.user = (ParkingAurthority) user;
		System.out.println(ParkingAuthorityController.user.getEmail());
	}
	
	public static ParkingAurthority getUser() {
		return user;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.setBounds(283, 0, 392, 488);
		frame.getContentPane().add(mainPanel);
		
		JButton btnmanageParkingSpace = new JButton("Manage Parking Officer");
		btnmanageParkingSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PAManageParkingSpaces.main(null);
				frame.dispose();
				
			}
		});
		btnmanageParkingSpace.setForeground(Color.BLACK);
		btnmanageParkingSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnmanageParkingSpace.setBorderPainted(false);
		btnmanageParkingSpace.setBackground(Color.WHITE);
		btnmanageParkingSpace.setBounds(66, 144, 260, 54);
		mainPanel.add(btnmanageParkingSpace);
		
		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// confirm action
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to signout", "Warning",
						JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					user.setLoggedIn(false);
					Login_Registation.main(null);
					frame.dispose();

				}
			}
		});
		btnSignout.setForeground(Color.BLACK);
		btnSignout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignout.setBorderPainted(false);
		btnSignout.setBackground(Color.WHITE);
		btnSignout.setBounds(66, 209, 260, 54);
		mainPanel.add(btnSignout);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 102));
		sidebarPanel.setBounds(0, 0, 292, 488);
		frame.getContentPane().add(sidebarPanel);
		
		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 292, 110);
		sidebarPanel.add(logo);
		
		JLabel lbWelcome = new JLabel("Welcome");
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 121, 282, 67);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("<html>Parking Admin:<br>"+ user.getFirstname()+"  "+user.getLastname()+"</html>");
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 194, 272, 144);
		sidebarPanel.add(lblUser);
		
		JPanel subSectionPanel = new JPanel();
		subSectionPanel.setLayout(null);
		subSectionPanel.setBackground(Color.BLACK);
		subSectionPanel.setBounds(0, 349, 292, 139);
		sidebarPanel.add(subSectionPanel);
		
		JLabel lblGetStarted = new JLabel("<html>Get<br> Started <strong>Now</strong></html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblGetStarted.setBounds(10, 11, 272, 117);
		subSectionPanel.add(lblGetStarted);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg2.jpg"));
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
