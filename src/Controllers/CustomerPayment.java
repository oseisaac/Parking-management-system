package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Booking;
import logic.Customer;
import logic.Payment;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class CustomerPayment extends JFrame {

	private JPanel contentPane;
	private Customer user;
	private JTextField parkingSpaceField;
	private JTextField totalPriceField;
	private ArrayList<Booking> toPurchase = new ArrayList<Booking>();
	private JTextField txtCardNumber;
	private JTextField txtExpiry;
	private JTextField txtCvv;
	private JTextField txtPaypalEmail;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (CustomerLanding.getUser() != null) {
						CustomerPayment frame = new CustomerPayment();
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

	public CustomerPayment() {
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

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 0, 0, 153));
		mainPanel.setBounds(199, 0, 486, 488);
		contentPane.add(mainPanel);

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String response = Payment.pay(toPurchase, user);
				if (response.equals("true")) {
					JOptionPane.showMessageDialog(null, "Payment Sucessful", "Success ", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Payment Failed", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnPay.setBounds(200, 414, 118, 34);
		mainPanel.add(btnPay);

		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// go back to customer landing page
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost",
						"Warning", JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					System.out.println("selected Yes");

					dispose();
					CustomerLanding.main(null);
				}

			}
		});
		btnGoBack.setBounds(74, 414, 101, 34);
		mainPanel.add(btnGoBack);

		parkingSpaceField = new JTextField();
		parkingSpaceField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		parkingSpaceField.setColumns(10);
		parkingSpaceField.setBounds(53, 56, 189, 36);
		mainPanel.add(parkingSpaceField);

		JLabel lblNewLabel = new JLabel("Enter Parking Space Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(53, 31, 228, 14);
		mainPanel.add(lblNewLabel);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(353, 58, 108, 25);
		mainPanel.add(lblTotal);

		totalPriceField = new JTextField();
		totalPriceField.setHorizontalAlignment(SwingConstants.CENTER);
		totalPriceField.setFont(new Font("Tahoma", Font.BOLD, 24));
		totalPriceField.setText("30");
		totalPriceField.setEditable(false);
		totalPriceField.setColumns(10);
		totalPriceField.setBounds(353, 100, 108, 73);
		mainPanel.add(totalPriceField);

		JTextPane txtpnBookingIdParking = new JTextPane();
		txtpnBookingIdParking.setText("Selected Orders");
		txtpnBookingIdParking.setBounds(53, 103, 290, 70);
		mainPanel.add(txtpnBookingIdParking);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String parkingSpace = parkingSpaceField.getText();

				Booking booking = user.getBooking(Integer.parseInt(parkingSpace));
				if (booking != null && !toPurchase.contains(booking)) {
					toPurchase.add(booking);
					setdetails();
					totalPriceField.setText("$ " + String.valueOf(Payment.getTotalPrice(toPurchase)));
					parkingSpaceField.setText(null);

//					System.out.println(toPurchase.toString());
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Parking Space Number", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

			public void setdetails() {
				String orders = "";
				for (Booking booking : toPurchase) {
					orders += "\r\nBooking Id: " + booking.getBookingId() + " Parking Space:  "
							+ booking.getParkingSpace() + " Duration: " + booking.getParkingSpace();
				}

				txtpnBookingIdParking.setText(orders);
			}
		});
		btnAdd.setBounds(252, 56, 91, 34);
		mainPanel.add(btnAdd);
		
		txtPaypalEmail = new JTextField();
		txtPaypalEmail.setText("PayPal Email");
		txtPaypalEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPaypalEmail.setColumns(10);
		txtPaypalEmail.setBounds(53, 288, 290, 36);
		mainPanel.add(txtPaypalEmail);
		txtPaypalEmail.setVisible(false);

		JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCreditCard.setSelected(true);
		JRadioButton rdbtnDebitCard = new JRadioButton("Debit Card");
		JRadioButton rdbtnPaypal = new JRadioButton("PayPal");
		
	

		rdbtnCreditCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnCreditCard.isSelected()) {
					rdbtnDebitCard.setSelected(false);
					rdbtnPaypal.setSelected(false);
					
					txtCardNumber.setVisible(true);
					txtExpiry.setVisible(true);
					txtCvv.setVisible(true);
					txtPaypalEmail.setVisible(false);
					
					
					txtCardNumber.revalidate();
					txtCardNumber.repaint();
					txtExpiry.revalidate();
					txtExpiry.repaint();
					txtCvv.revalidate();
					txtCvv.repaint();
					txtPaypalEmail.revalidate();
					txtPaypalEmail.repaint();
				}

			}
		});
		rdbtnCreditCard.setBounds(53, 222, 109, 23);
		mainPanel.add(rdbtnCreditCard);

		rdbtnDebitCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnDebitCard.isSelected()) {
					rdbtnCreditCard.setSelected(false);
					rdbtnPaypal.setSelected(false);
					
					txtCardNumber.setVisible(true);
					txtExpiry.setVisible(true);
					txtCvv.setVisible(true);
					txtPaypalEmail.setVisible(false);
					
					txtCardNumber.revalidate();
					txtCardNumber.repaint();
					txtExpiry.revalidate();
					txtExpiry.repaint();
					txtCvv.revalidate();
					txtCvv.repaint();
					txtPaypalEmail.revalidate();
					txtPaypalEmail.repaint();
				}
			}
		});
		rdbtnDebitCard.setBounds(172, 222, 109, 23);
		mainPanel.add(rdbtnDebitCard);
		
		txtCardNumber = new JTextField();
		txtCardNumber.setText("Card Number");
		txtCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCardNumber.setColumns(10);
		txtCardNumber.setBounds(53, 288, 290, 36);
		mainPanel.add(txtCardNumber);
		
		txtExpiry = new JTextField();
		txtExpiry.setText("Expiry");
		txtExpiry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtExpiry.setColumns(10);
		txtExpiry.setBounds(53, 335, 137, 36);
		mainPanel.add(txtExpiry);
		
		txtCvv = new JTextField();
		txtCvv.setText("CVV");
		txtCvv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCvv.setColumns(10);
		txtCvv.setBounds(200, 335, 143, 36);
		mainPanel.add(txtCvv);
		
		
		rdbtnPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnPaypal.isSelected()) {
					rdbtnCreditCard.setSelected(false);
					rdbtnDebitCard.setSelected(false);
					
					txtCardNumber.setVisible(false);
					txtExpiry.setVisible(false);
					txtCvv.setVisible(false);
					txtPaypalEmail.setVisible(true);
					
//					mainPanel.revalidate();
//					mainPanel.repaint();
					txtCardNumber.revalidate();
					txtCardNumber.repaint();
					txtExpiry.revalidate();
					txtExpiry.repaint();
					txtCvv.revalidate();
					txtCvv.repaint();
					txtPaypalEmail.revalidate();
					txtPaypalEmail.repaint();
				}
				
			}
		});
		rdbtnPaypal.setBounds(292, 222, 109, 23);
		mainPanel.add(rdbtnPaypal);
		
		

		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 153));
		sidebarPanel.setBounds(0, 0, 201, 488);
		contentPane.add(sidebarPanel);

		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 191, 110);
		sidebarPanel.add(logo);

		JLabel lbWelcome = new JLabel("<html>Payment<html>");
		lbWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lbWelcome.setForeground(Color.WHITE);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 32));
		lbWelcome.setBackground(Color.LIGHT_GRAY);
		lbWelcome.setBounds(10, 101, 181, 110);
		sidebarPanel.add(lbWelcome);

		JLabel lblUser = new JLabel("<html>User :"+user.getFirstname()+" "+user.getLastname()+"</html>");
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 238, 181, 110);
		sidebarPanel.add(lblUser);

		JPanel subSectionPanel = new JPanel();
		subSectionPanel.setLayout(null);
		subSectionPanel.setBackground(Color.BLACK);
		subSectionPanel.setBounds(0, 349, 292, 139);
		sidebarPanel.add(subSectionPanel);

		JLabel lblGetStarted = new JLabel("<html>Enter space numebers to chekout</html>");
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(Color.LIGHT_GRAY);
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGetStarted.setBounds(10, 11, 179, 117);
		subSectionPanel.add(lblGetStarted);

		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg1.jpg"));
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
