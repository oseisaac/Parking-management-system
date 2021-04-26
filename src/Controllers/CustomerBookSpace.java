package Controllers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import logic.Booking;
import logic.Customer;
import logic.User;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.AbstractListModel;
import javax.swing.border.EmptyBorder;

public class CustomerBookSpace {

	private JFrame frame;
	private  Customer user;
	private JTextField parkingSpaceField;
	private JTextField durationField;
	private JTextField licensePlatetField;
	private int newBookingPointer = -1;
	private int newBookingCounter =0;
	private boolean updating =false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(CustomerLanding.getUser() != null) {						
					CustomerBookSpace window = new CustomerBookSpace();
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
	public CustomerBookSpace() {
		this.user = CustomerLanding.getUser();
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
	
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg1.jpg"));
		Image img2 = img.getImage().getScaledInstance(700, 527, java.awt.Image.SCALE_SMOOTH);
		img = new ImageIcon(img2);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0,0,0,(float)0.6));
		mainPanel.setLayout(null);
		mainPanel.setBounds(291, 0, 394, 488);
		frame.getContentPane().add(mainPanel);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(0,0,0,(float)0));
		p1.setLayout(null);
		p1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p1.setBounds(36, 70, 316, 87);
		mainPanel.add(p1);
		
		JLabel lblNewLabel = new JLabel("Parking Space");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(10, 11, 228, 14);
		p1.add(lblNewLabel);
		
		parkingSpaceField = new JTextField();
		parkingSpaceField.setColumns(10);
		parkingSpaceField.setBounds(10, 36, 296, 36);
		p1.add(parkingSpaceField);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color(0,0,0,(float)0));
		p3.setLayout(null);
		p3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p3.setBounds(36, 168, 316, 72);
		mainPanel.add(p3);
		
		JLabel lblDuration = new JLabel("<html>Duration  in Mintues</html>");
		lblDuration.setForeground(new Color(255, 255, 255));
		lblDuration.setHorizontalAlignment(SwingConstants.LEFT);
		lblDuration.setBounds(10, 0, 296, 22);
		p3.add(lblDuration);
		
		durationField = new JTextField();
		durationField.setToolTipText("Must be an Interger value");
		durationField.setText("30");
		durationField.setColumns(10);
		durationField.setBounds(10, 21, 296, 40);
		p3.add(durationField);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color(0,0,0,(float)0));
		p4.setLayout(null);
		p4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		p4.setBounds(36, 251, 316, 87);
		mainPanel.add(p4);
		
		JLabel lbllicencePlatenumber = new JLabel("Licence Plate Number");
		lbllicencePlatenumber.setForeground(new Color(255, 255, 255));
		lbllicencePlatenumber.setHorizontalAlignment(SwingConstants.LEFT);
		lbllicencePlatenumber.setBounds(10, 11, 296, 15);
		p4.add(lbllicencePlatenumber);
		
		licensePlatetField = new JTextField();
		licensePlatetField.setColumns(10);
		licensePlatetField.setBounds(10, 37, 296, 39);
		p4.add(licensePlatetField);
		
		JButton btnAddBooking = new JButton("Add Booking");
		
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String parkingSpace = parkingSpaceField.getText();
				String duration = durationField.getText();
				String plateNumber = licensePlatetField.getText();
				
				if(!parkingSpace.trim().equals("")  && !duration.trim().equals("") && !plateNumber.trim().equals("") ) {
					if(!isNumeric(parkingSpace)) {
						JOptionPane.showMessageDialog(null, "Invalid space number - select from  1-50", "Booking Error",JOptionPane.ERROR_MESSAGE);
					}
					if(!isNumeric(duration)) {
						JOptionPane.showMessageDialog(null, "Invalid duration - duration is in mins ie 30", "Booking Error",JOptionPane.ERROR_MESSAGE);
					}else {
						
						System.out.println("updating "+updating);
						if(updating) {
							int count = user.getBookings().size();
							user.removeByIndex(count-1);
							
							//check if the item to be updated has been removed
							if(count < user.getBookings().size()) {								
								updating=false;
							}
						}
							String response = user.addBooking(Integer.parseInt(parkingSpace), Integer.parseInt(duration), plateNumber);
						System.out.println(response);
						if(!response.equals("true")) {
							JOptionPane.showMessageDialog(null,response, "Booking Error",JOptionPane.ERROR_MESSAGE);							
						}else {
							
							//update the newBookingPointer and counter  for the purpose of editing previously added items in a single session 
							newBookingPointer=user.getBookings().size() - 1;
							newBookingCounter++;
							
							//display message
							System.out.println(user.getBookings());
							JOptionPane.showMessageDialog(null,"Booking Added Successfully", "Succes",JOptionPane.PLAIN_MESSAGE);
							parkingSpaceField.setText(null);
							durationField.setText(null);
							licensePlatetField.setText(null);
						}

					}

				}else {
					JOptionPane.showMessageDialog(null, "Kindly Fill Empty Fields", "Booking Error",JOptionPane.ERROR_MESSAGE);
//					JOptionPane.showMessageDialog(parkingSpaceField, "Enter Info");
				}
				
			}
			
			public boolean isNumeric(String str) { 
				  try {  
				    Integer.parseInt(str);  
				    return true;
				  } catch(NumberFormatException e){  
				    return false;  
				  }  
				}
		});
		btnAddBooking.setBounds(136, 370, 118, 34);
		mainPanel.add(btnAddBooking);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = user.getBookings().size()-1;
				if(JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost", "Warning",JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					System.out.println("selected Yes");
					
					//edit previously added item
					if(newBookingPointer != -1 && newBookingCounter > 0) {
						updating=true;
						
						 parkingSpaceField.setText(String.valueOf(user.getBookings().get(newBookingPointer).getParkingSpace()));
						durationField.setText(String.valueOf(user.getBookings().get(newBookingPointer).getDuration()));
						licensePlatetField.setText(String.valueOf(user.getBookings().get(newBookingPointer).getPlateNumber()));
						
						btnAddBooking.setLabel("Update Booking");
						newBookingPointer--;
						newBookingCounter--;
						
					}else {
						frame.dispose();
						CustomerLanding.main(null);
					}
				}
				
				
			}
		});
		btnGoBack.setBounds(10, 370, 101, 34);
		mainPanel.add(btnGoBack);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(user.getBookings().size() > 0 && JOptionPane.showOptionDialog(null, "Are you sure you want to checkout", "Warning",JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {					
					CustomerPayment.main(null);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "No bookings to checkout", "Booking Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCheckout.setBounds(281, 370, 101, 34);
		mainPanel.add(btnCheckout);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0,0,0,(float)0.6));
		sidebarPanel.setBounds(0, 0, 292, 488);
		frame.getContentPane().add(sidebarPanel);
		
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
		
		JLabel lblUser = new JLabel("User :"+ user.getFirstname()+" "+user.getLastname());
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
		
		JLabel background = new JLabel("");
		background.setForeground(Color.WHITE);
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setBounds(0, 0, 685, 488);
		frame.getContentPane().add(background);
		
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setForeground(new Color(255, 255, 255));		
		background.setIcon(img);
		background.setBounds(0, 0, 685, 488);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime time = LocalTime.now();
	}
}
