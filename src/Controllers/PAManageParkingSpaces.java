package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Customer;
import logic.ParkingAurthority;
import logic.ParkingSpaces;
import logic.User;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PAManageParkingSpaces extends JFrame {

	private JPanel contentPane;
	private ParkingAurthority user;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ParkingAuthorityController.getUser() != null) {
						PAManageParkingSpaces frame = new PAManageParkingSpaces();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} else {
						Login_Registation.main(null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PAManageParkingSpaces(){
		this.user = ParkingAuthorityController.getUser();
		initialize();
		
	}
	
	
	/**
	 * Create the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.setBounds(283, 0, 392, 488);
		contentPane.add(mainPanel);
		
		JButton btnAddSpace = new JButton("Add Space");
		btnAddSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PAAddParkingSpaces.main(null);
			}
		});
		btnAddSpace.setForeground(Color.BLACK);
		btnAddSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddSpace.setBorderPainted(false);
		btnAddSpace.setBackground(Color.WHITE);
		btnAddSpace.setBounds(66, 83, 260, 54);
		mainPanel.add(btnAddSpace);
		
		JButton btnRemoveSpace = new JButton("Remove Space");
		btnRemoveSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				PARemoveParkingSpace.main(null);
			}
		});
		btnRemoveSpace.setForeground(Color.BLACK);
		btnRemoveSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemoveSpace.setBorderPainted(false);
		btnRemoveSpace.setBackground(Color.WHITE);
		btnRemoveSpace.setBounds(66, 148, 260, 54);
		mainPanel.add(btnRemoveSpace);
		
		JButton btnCancelRequest = new JButton("Cancel Request");
		btnCancelRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PAViewRequests.main(null);
			}
		});
		btnCancelRequest.setOpaque(true);
		btnCancelRequest.setForeground(Color.BLACK);
		btnCancelRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancelRequest.setBorderPainted(false);
		btnCancelRequest.setBackground(Color.WHITE);
		btnCancelRequest.setBounds(66, 213, 260, 54);
		mainPanel.add(btnCancelRequest);
		
		JButton btnGrantRequest = new JButton("Grant Request");
		btnGrantRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				PAViewRequests.main(null);
			}
		});
		btnGrantRequest.setForeground(Color.BLACK);
		btnGrantRequest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGrantRequest.setBorderPainted(false);
		btnGrantRequest.setBackground(Color.WHITE);
		btnGrantRequest.setBounds(66, 278, 260, 54);
		mainPanel.add(btnGrantRequest);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ParkingAuthorityController.main(null);
				
			}
		});
		btnGoBack.setForeground(Color.BLACK);
		btnGoBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGoBack.setBorderPainted(false);
		btnGoBack.setBackground(Color.WHITE);
		btnGoBack.setBounds(66, 343, 260, 54);
		mainPanel.add(btnGoBack);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 102));
		sidebarPanel.setBounds(0, 0, 292, 488);
		contentPane.add(sidebarPanel);
		
		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 292, 110);
		sidebarPanel.add(logo);
		
		JLabel lbWelcome = new JLabel("Manage Spaces");
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 28));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 121, 282, 67);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("<html>Parking Admin:<br><dynamic>  <dynamic></html>");
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
		
		JLabel lblGetStarted = new JLabel("<html>Select an option to take action</html>");
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
		contentPane.add(background);
	}

}
