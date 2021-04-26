package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import logic.Booking;
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
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerViewBookings extends JFrame {

	private JPanel contentPane;
	private  Customer user;
	private JTable table;
	private String[][] tableData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(CustomerLanding.getUser() != null) {						
						CustomerViewBookings frame = new CustomerViewBookings();
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
	
	
	public CustomerViewBookings() {
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
		mainPanel.setBounds(212, 0, 473, 488);
		contentPane.add(mainPanel);
		
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
		btnGoBack.setBounds(10, 270, 101, 34);
		mainPanel.add(btnGoBack);
		
		JScrollPane tablePane = new JScrollPane();
		tablePane.setBounds(10, 121, 453, 127);
		mainPanel.add(tablePane);
		
		//get bookings
		if(user.getBookings() != null) {			
		int size = user.getBookings().size();
		tableData=new String[size][5];
		for(int i=0;i<size; i++) {
			Booking booking = user.getBookings().get(i);
			this.tableData[i][0] = String.valueOf(booking.getBookingId());
			this.tableData[i][1] = String.valueOf(booking.getParkingSpace());
			this.tableData[i][2] = String.valueOf(booking.getTime());
			this.tableData[i][3] = booking.hasExpired()? "Expired": "Active";
			this.tableData[i][4] = booking.isPaid() ? "Paid":"Non Paid";
		}
		}
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table.rowAtPoint(e.getPoint());
			        int col = table.columnAtPoint(e.getPoint());
			        System.out.println("row "+row + " column "+col);
			}
		});
		table.setModel(new DefaultTableModel(
				tableData,
				new String[] {
					"BookingId", "ParkingSpace", "Time", "ExpiryStatus", "PaymentStatus"
				}
			));
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		tablePane.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		mainPanel.add(scrollPane);
		
		JPanel sidebarPanel = new JPanel();
		sidebarPanel.setLayout(null);
		sidebarPanel.setBackground(new Color(0, 0, 0, 153));
		sidebarPanel.setBounds(0, 0, 215, 488);
		contentPane.add(sidebarPanel);
		
		JLabel logo = new JLabel("PMS ");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.WHITE);
		logo.setFont(new Font("Tahoma", Font.BOLD, 23));
		logo.setBounds(0, 0, 215, 110);
		sidebarPanel.add(logo);
		
		JLabel lblViewBookings = new JLabel("<html>View Bookings</html>");
		lblViewBookings.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewBookings.setForeground(Color.WHITE);
		lblViewBookings.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblViewBookings.setBackground(Color.LIGHT_GRAY);
		lblViewBookings.setBounds(10, 101, 205, 146);
		sidebarPanel.add(lblViewBookings);
		
		JLabel lblUser = new JLabel("<html>User :"+user.getFirstname()+" "+user.getLastname()+"</html>");
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 263, 195, 125);
		sidebarPanel.add(lblUser);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/bg1.jpg"));
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
