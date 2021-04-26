package Controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import logic.Customer;
import logic.User;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerLanding extends JFrame {

	private JPanel contentPane;
	private static Customer user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame.setVisible(true);
					if(user != null) {						
					CustomerLanding frame = new CustomerLanding();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
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

	public CustomerLanding() {
		initialize();
	}

	public static void setUser(User user) {
		CustomerLanding.user = (Customer) user;
	}

	public static Customer getUser() {
		return user;
	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
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
		mainPanel.setBackground(new Color(0, 0, 0, (float) 0));
		mainPanel.setBounds(283, 0, 392, 488);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);

		JButton btnbookParkingSpace = new JButton("Book Parking Space");
		btnbookParkingSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerBookSpace.main(null);
			}
		});
		btnbookParkingSpace.setBorderPainted(false);
		btnbookParkingSpace.setForeground(new Color(0, 0, 0));
		btnbookParkingSpace.setBackground(Color.white);
		btnbookParkingSpace.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnbookParkingSpace.setBounds(66, 83, 260, 54);
		mainPanel.add(btnbookParkingSpace);

		JButton btnCancellations = new JButton("Cancellations");
		btnCancellations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				CustomerCancelParkingSpace.main(null);
			}
		});
		btnCancellations.setForeground(Color.BLACK);
		btnCancellations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancellations.setBorderPainted(false);
		btnCancellations.setBackground(Color.WHITE);
		btnCancellations.setBounds(66, 148, 260, 54);
		mainPanel.add(btnCancellations);

		JButton btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CustomerPayment.main(null);
					dispose();

			}
		});
		btnPayment.setForeground(Color.BLACK);
		btnPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPayment.setBorderPainted(false);
		btnPayment.setOpaque(true);
		btnPayment.setBackground(Color.WHITE);
		btnPayment.setBounds(66, 213, 260, 54);
		mainPanel.add(btnPayment);

		JButton btnViewBooking = new JButton("View Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CustomerViewBookings.main(null);
			}
		});
		btnViewBooking.setForeground(Color.BLACK);
		btnViewBooking.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewBooking.setBorderPainted(false);
		btnViewBooking.setBackground(Color.WHITE);
		btnViewBooking.setBounds(66, 278, 260, 54);
		mainPanel.add(btnViewBooking);

		JButton btnSignout = new JButton("Signout");
		btnSignout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// confirm action
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to signout", "Warning",
						JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
					user.setLoggedIn(false);
					Login_Registation.main(null);
					dispose();

				}

			}
		});
		btnSignout.setForeground(Color.BLACK);
		btnSignout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignout.setBorderPainted(false);
		btnSignout.setBackground(Color.WHITE);
		btnSignout.setBounds(66, 343, 260, 54);
		mainPanel.add(btnSignout);

		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setBackground(new Color(0, 0, 0, (float) 0.4));
		sidebarPanel.setBounds(0, 0, 292, 488);
		contentPane.add(sidebarPanel);
		sidebarPanel.setLayout(null);

		JLabel logo = new JLabel("PMS ");
		logo.setBounds(0, 0, 292, 110);
		sidebarPanel.add(logo);
		logo.setForeground(new Color(255, 255, 255));
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));

		JLabel lbWelcome = new JLabel("Welcome");
		lbWelcome.setBackground(new Color(192, 192, 192));
		lbWelcome.setBounds(10, 121, 282, 67);
		sidebarPanel.add(lbWelcome);
		lbWelcome.setForeground(new Color(255, 255, 255));
		lbWelcome.setHorizontalAlignment(SwingConstants.LEFT);
		lbWelcome.setFont(new Font("Tahoma", Font.BOLD, 50));

		JLabel lblUser = new JLabel("");
		lblUser.setText("User :"+ user.getFirstname()+" "+user.getLastname());

		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(new Color(192, 192, 192));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 194, 272, 75);
		sidebarPanel.add(lblUser);

		JPanel subSectionPanel = new JPanel();
		subSectionPanel.setBackground(new Color(0, 0, 0));
		subSectionPanel.setBounds(0, 349, 292, 139);
		sidebarPanel.add(subSectionPanel);
		subSectionPanel.setLayout(null);

		JLabel lblGetStarted = new JLabel("<html>Get<br> Started <strong>Now</strong></html>");
		lblGetStarted.setBounds(10, 11, 272, 117);
		lblGetStarted.setHorizontalAlignment(SwingConstants.LEFT);
		lblGetStarted.setForeground(new Color(192, 192, 192));
		lblGetStarted.setFont(new Font("Tahoma", Font.PLAIN, 31));
		subSectionPanel.add(lblGetStarted);

		JLabel background = new JLabel("");
		background.setFont(new Font("Tahoma", Font.PLAIN, 13));
		background.setForeground(new Color(255, 255, 255));
		background.setIcon(img);
		background.setBounds(0, 0, 685, 488);
		contentPane.add(background);

	}
}
