package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.SystemAdministrator;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SAChangePaymentStatus extends JFrame {

	private JPanel contentPane;
	private SystemAdministrator user;
	private JTextField firstnameField;
	private JTextField lastnameField;
	private JTextField emailField;
	private JTextField parkingSpaceField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (SystemAdministratorsController.getUser() != null) {
						SAChangePaymentStatus frame = new SAChangePaymentStatus();
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

	public SAChangePaymentStatus() {
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
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p1.setBackground(new Color(0, 0, 0, 0));
		p1.setBounds(36, 51, 316, 87);
		mainPanel.add(p1);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 228, 14);
		p1.add(lblNewLabel);
		
		firstnameField = new JTextField();
		firstnameField.setColumns(10);
		firstnameField.setBounds(10, 36, 296, 36);
		p1.add(firstnameField);
		
		JPanel p3 = new JPanel();
		p3.setLayout(null);
		p3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p3.setBackground(new Color(0, 0, 0, 0));
		p3.setBounds(36, 149, 316, 72);
		mainPanel.add(p3);
		
		JLabel lblDuration = new JLabel("Lastname");
		lblDuration.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setBounds(10, 0, 296, 22);
		p3.add(lblDuration);
		
		lastnameField = new JTextField();
		lastnameField.setToolTipText("");
		lastnameField.setColumns(10);
		lastnameField.setBounds(10, 21, 296, 40);
		p3.add(lastnameField);
		
		JPanel p4 = new JPanel();
		p4.setLayout(null);
		p4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p4.setBackground(new Color(0, 0, 0, 0));
		p4.setBounds(36, 215, 316, 87);
		mainPanel.add(p4);
		
		JLabel lbllicencePlatenumber = new JLabel("email");
		lbllicencePlatenumber.setHorizontalAlignment(SwingConstants.LEFT);
		lbllicencePlatenumber.setForeground(Color.WHITE);
		lbllicencePlatenumber.setBounds(10, 11, 296, 15);
		p4.add(lbllicencePlatenumber);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(10, 37, 296, 39);
		p4.add(emailField);
		
		JButton btnChangeStatus = new JButton("Change To Paid");
		btnChangeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = firstnameField.getText();
				String lastname =  lastnameField.getText();
				String email = emailField.getText();
				String parkingSpace = parkingSpaceField.getText();
				
				
				//change payment status
				if(!firstname.equals("") && !lastname.equals("") && !email.equals("") && !parkingSpace.equals("")) {
					if(user.changePaymentStatus(firstname.trim().toLowerCase(), lastname.trim().toLowerCase(), email.trim().toLowerCase(),Integer.parseInt( parkingSpace.trim()))) {
						JOptionPane.showMessageDialog(null, "Status successfuly updated", "Success",JOptionPane.PLAIN_MESSAGE);
						
					}else {
						JOptionPane.showMessageDialog(null, "Invaild User ", " Error",JOptionPane.ERROR_MESSAGE);
					
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Kindly fix error", " Error",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnChangeStatus.setBounds(171, 414, 118, 34);
		mainPanel.add(btnChangeStatus);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// go back to customer landing page
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost",
						"Warning", JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					System.out.println("selected Yes");

					dispose();
					SAManageParkingOfficers.main(null);
				}
			}
		});
		btnGoBack.setBounds(45, 414, 101, 34);
		mainPanel.add(btnGoBack);
		
		JPanel p4_1 = new JPanel();
		p4_1.setLayout(null);
		p4_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p4_1.setBackground(new Color(0, 0, 0, 0));
		p4_1.setBounds(36, 302, 316, 87);
		mainPanel.add(p4_1);
		
		JLabel lbllicencePlatenumber_1 = new JLabel("parkingSpace");
		lbllicencePlatenumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lbllicencePlatenumber_1.setForeground(Color.WHITE);
		lbllicencePlatenumber_1.setBounds(10, 11, 296, 15);
		p4_1.add(lbllicencePlatenumber_1);
		
		parkingSpaceField = new JTextField();
		parkingSpaceField.setColumns(10);
		parkingSpaceField.setBounds(10, 37, 296, 39);
		p4_1.add(parkingSpaceField);
		
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
		
		JLabel lbWelcome = new JLabel("<html>Change Payment Status <html>");
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 101, 282, 146);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("<html>User :"+user.getFirstname()+" "+user.getLastname() +"</html>");
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
		
		JLabel lblGetStarted = new JLabel("<html>Enter customer to change status</html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGetStarted.setBounds(10, 11, 272, 117);
		subSectionPanel.add(lblGetStarted);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg3.jpg"));
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
