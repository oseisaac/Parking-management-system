package Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;

import logic.Customer;
import logic.SystemAdministrator;
import logic.User;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SystemAdministratorsController {

	private JFrame frame;
	private static User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(user != null) {						
					SystemAdministratorsController window = new SystemAdministratorsController();
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
	public SystemAdministratorsController() {
		initialize();
		System.out.println("controller "+ user);
	}
	public static void setUser(User user) {
		SystemAdministratorsController.user = user;
	}

	public static SystemAdministrator getUser() {
		return (SystemAdministrator) user;
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
		mainPanel.setBackground(new Color(0, 0, 0, 153));
		mainPanel.setBounds(291, 0, 394, 488);
		frame.getContentPane().add(mainPanel);
		
		JButton btnbookParkingSpace = new JButton("Manage Parking Officers");
		btnbookParkingSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				SAManageParkingOfficers.main(null);
				
			}
		});
		btnbookParkingSpace.setForeground(Color.BLACK);
		btnbookParkingSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnbookParkingSpace.setBorderPainted(false);
		btnbookParkingSpace.setBackground(Color.WHITE);
		btnbookParkingSpace.setBounds(81, 123, 260, 54);
		mainPanel.add(btnbookParkingSpace);
		
		JButton btnCancellations = new JButton("Change Payment status");
		btnCancellations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SAChangePaymentStatus.main(null);
			}
		});
		btnCancellations.setForeground(Color.BLACK);
		btnCancellations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancellations.setBorderPainted(false);
		btnCancellations.setBackground(Color.WHITE);
		btnCancellations.setBounds(81, 188, 260, 54);
		mainPanel.add(btnCancellations);
		
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
		btnSignout.setBounds(81, 253, 260, 54);
		mainPanel.add(btnSignout);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 153));
		sidebarPanel.setBounds(0, 0, 292, 488);
		frame.getContentPane().add(sidebarPanel);
		
		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 292, 110);
		sidebarPanel.add(logo);
		
		JLabel lbWelcome = new JLabel("<html>Welcome<html>");
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 40));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 101, 282, 146);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("System Admin");
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
		
		JLabel lblGetStarted = new JLabel("<html>Select an option</html>");
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
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setIcon(img);
		background.setBounds(0, 0, 685, 488);
		frame.getContentPane().add(background);
		
		
	}

}
