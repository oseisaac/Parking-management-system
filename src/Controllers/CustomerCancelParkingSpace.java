package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logic.Customer;

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

public class CustomerCancelParkingSpace extends JFrame {

	private JPanel contentPane;
	private JTextField bookingIdField;
	private  Customer user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(CustomerLanding.getUser() != null) {						
						CustomerCancelParkingSpace frame = new CustomerCancelParkingSpace();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
						}
						else {
							Login_Registation.main(null);
						};
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CustomerCancelParkingSpace() {
		this.user = CustomerLanding.getUser();
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
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg1.jpg"));
		Image img2 = img.getImage().getScaledInstance(700, 527, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(img2);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 0, 0, 153));
		mainPanel.setBounds(293, 0, 392, 488);
		contentPane.add(mainPanel);
		
		JButton btnAddBooking = new JButton("Cancel Booking");
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookingId = bookingIdField.getText(); 
				
				String response = user.cancelBooking(Integer.parseInt(bookingId));
				if(!response.equals("true")) {
					JOptionPane.showMessageDialog(null,response, "Error",JOptionPane.ERROR_MESSAGE);	
				}else {
					JOptionPane.showMessageDialog(null,"Booking Successfully", "Success",JOptionPane.PLAIN_MESSAGE);	
				}
				
				
			}
		});
		btnAddBooking.setBounds(210, 254, 118, 34);
		mainPanel.add(btnAddBooking);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//go back to customer landing page
				if(JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost", "Warning",JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					System.out.println("selected Yes");
					
						dispose();
						CustomerLanding.main(null);
				}
			}
		});
		btnGoBack.setBounds(84, 254, 101, 34);
		mainPanel.add(btnGoBack);
		
		bookingIdField = new JTextField();
		bookingIdField.setBounds(56, 181, 296, 36);
		mainPanel.add(bookingIdField);
		bookingIdField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter A Booking ID");
		lblNewLabel.setBounds(56, 156, 228, 14);
		mainPanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		
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
		
		JLabel lbWelcome = new JLabel("<html>Cancel a Parking space<html>");
		lbWelcome.setVerticalAlignment(SwingConstants.TOP);
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 38));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 101, 272, 145);
		sidebarPanel.add(lbWelcome);
		
		JLabel lblUser = new JLabel("User :"+ user.getFirstname()+" "+user.getLastname());
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 261, 272, 87);
		sidebarPanel.add(lblUser);
		
		JPanel subSectionPanel = new JPanel();
		subSectionPanel.setLayout(null);
		subSectionPanel.setBackground(Color.BLACK);
		subSectionPanel.setBounds(0, 349, 292, 139);
		sidebarPanel.add(subSectionPanel);
		
		JLabel lblGetStarted = new JLabel("<html>Enter a booking ID to be canceled  </html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGetStarted.setBounds(10, 11, 272, 117);
		subSectionPanel.add(lblGetStarted);
		
		JLabel background = new JLabel("");
		background.setForeground(Color.WHITE);
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setIcon(img);
		background.setBounds(0, 0, 685, 488);
		contentPane.add(background);
	}

}
