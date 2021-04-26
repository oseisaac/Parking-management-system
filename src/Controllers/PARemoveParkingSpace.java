package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.ParkingAurthority;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PARemoveParkingSpace extends JFrame {

	private JPanel contentPane;
	private ParkingAurthority user;
	private JTextField parkingSpaceField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ParkingAuthorityController.getUser() != null) {
						PARemoveParkingSpace frame = new PARemoveParkingSpace();
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

	
	public PARemoveParkingSpace() {
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
		mainPanel.setBackground(new Color(0, 0, 0, 153));
		mainPanel.setBounds(291, 0, 394, 488);
		contentPane.add(mainPanel);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p1.setBackground(new Color(0, 0, 0, 0));
		p1.setBounds(38, 107, 316, 87);
		mainPanel.add(p1);
		
		JLabel lblNewLabel = new JLabel("Parking Space Number");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 228, 14);
		p1.add(lblNewLabel);
		
		parkingSpaceField = new JTextField();
		parkingSpaceField.setColumns(10);
		parkingSpaceField.setBounds(10, 36, 296, 36);
		p1.add(parkingSpaceField);
		
		JButton btnAddBooking = new JButton("Remove Booking");
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String parkingSpace = parkingSpaceField.getText().trim();
				if(!parkingSpace.equals("")) {
					if(user.removeSpace(Integer.parseInt(parkingSpace))) {
						JOptionPane.showMessageDialog(null, "Space Removed", "Success",JOptionPane.PLAIN_MESSAGE);
						parkingSpaceField.setText(null);
					}else {
						JOptionPane.showMessageDialog(null, "Adding Space Failed", "Manage Space Error",JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Invalid space number - try again", "Manage Space Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddBooking.setBounds(174, 218, 118, 34);
		mainPanel.add(btnAddBooking);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost", "Warning",JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					dispose();
				PAManageParkingSpaces.main(null);
		}
			}
		});
		btnGoBack.setBounds(48, 218, 101, 34);
		mainPanel.add(btnGoBack);
		
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
		
		JLabel lbWelcome = new JLabel("<html>Book Parking <br> Space<html>");
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 101, 282, 146);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("User :<dynamic> <dynamic>");
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 263, 272, 85);
		sidebarPanel.add(lblUser);
		
		JPanel subSectionPanel = new JPanel();
		subSectionPanel.setLayout(null);
		subSectionPanel.setBackground(Color.BLACK);
		subSectionPanel.setBounds(0, 349, 292, 139);
		sidebarPanel.add(subSectionPanel);
		
		JLabel lblGetStarted = new JLabel("<html>Space number range from <strong>1 -50</strong>  </html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGetStarted.setBounds(10, 11, 272, 117);
		subSectionPanel.add(lblGetStarted);
		
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg2.jpg"));
		Image img2 = img.getImage().getScaledInstance(700, 527, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(img2);
		
		JLabel background = new JLabel("");
		background.setForeground(Color.WHITE);
		background.setIcon(img);
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setBounds(0, 0, 685, 488);
		contentPane.add(background);
	}

}
