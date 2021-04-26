package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.SystemAdministrator;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SAManageParkingOfficers extends JFrame {

	private JPanel contentPane;
	private SystemAdministrator user;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					if (SystemAdministratorsController.getUser() != null) {
						SAManageParkingOfficers frame = new SAManageParkingOfficers();
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

	public SAManageParkingOfficers() {
		this.user = SystemAdministratorsController.getUser();
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
		mainPanel.setBackground(new Color(0, 0, 0, 153));
		mainPanel.setBounds(291, 0, 394, 488);
		contentPane.add(mainPanel);
		
		JButton btnAddOfficer = new JButton("Add Paking Officer");
		btnAddOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SAAddOfficer.main(null);
				
			}
		});
		btnAddOfficer.setForeground(Color.BLACK);
		btnAddOfficer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddOfficer.setBorderPainted(false);
		btnAddOfficer.setBackground(Color.WHITE);
		btnAddOfficer.setBounds(66, 144, 260, 54);
		mainPanel.add(btnAddOfficer);
		
		JButton btnRemoveOfficer = new JButton("Remove Parking Officer");
		btnRemoveOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SARemoveOfficer.main(null);
			}
		});
		btnRemoveOfficer.setForeground(Color.BLACK);
		btnRemoveOfficer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemoveOfficer.setBorderPainted(false);
		btnRemoveOfficer.setBackground(Color.WHITE);
		btnRemoveOfficer.setBounds(66, 209, 260, 54);
		mainPanel.add(btnRemoveOfficer);
		
		JButton btngoBack = new JButton("Go Back");
		btngoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SystemAdministratorsController.main(null);
			}
		});
		btngoBack.setForeground(Color.BLACK);
		btngoBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btngoBack.setBorderPainted(false);
		btngoBack.setBackground(Color.WHITE);
		btngoBack.setBounds(66, 274, 260, 54);
		mainPanel.add(btngoBack);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 153));
		sidebarPanel.setBounds(0, 0, 292, 488);
		contentPane.add(sidebarPanel);
		
		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 292, 110);
		sidebarPanel.add(logo);
		
		JLabel lblSelectSa = new JLabel("<html>Select an option</html>");
		lblSelectSa.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectSa.setForeground(Color.WHITE);
		lblSelectSa.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblSelectSa.setBackground(Color.LIGHT_GRAY);
		lblSelectSa.setBounds(10, 121, 282, 122);
		sidebarPanel.add(lblSelectSa);
		
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
		
		JLabel lblGetStarted = new JLabel("<html>Get<br> Started <strong>Now</strong></html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblGetStarted.setBounds(10, 11, 272, 117);
		subSectionPanel.add(lblGetStarted);
		

		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg3.jpg"));
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
