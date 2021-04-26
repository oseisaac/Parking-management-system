package Controllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logic.Booking;
import logic.Bookings;
import logic.ParkingAurthority;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PAViewRequests extends JFrame {

	private JPanel contentPane;
	private ParkingAurthority user;
	private JTable table;
	private String[][] tableData;
	private int selectedBookingId=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ParkingAuthorityController.getUser() != null) {
						PAViewRequests frame = new PAViewRequests();
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

	public PAViewRequests() {
		this.user = ParkingAuthorityController.getUser();
		initialize();
	}

	public String[][] getTableData() {
		// get bookings
				int size = Bookings.getBookings().size();
				tableData = new String[size][5];
				for (int i = 0; i < size; i++) {
					Booking booking = Bookings.getBookings().get(i);
//					if (!booking.getTime().equals("null") && !booking.hasExpired() || booking.getTime().equals("null")) {
						this.tableData[i][0] = String.valueOf(booking.getBookingId());
						this.tableData[i][1] = String.valueOf(booking.getParkingSpace());
						this.tableData[i][2] = booking.hasExpired() ? "Expired" : "Not Expired";
						this.tableData[i][3] = booking.getIsGranted() ? "Granted" : "Not Granted";
						this.tableData[i][4] = booking.isPaid() ? "Paid" : "Non Paid";
//					}
				}
				
				return tableData;
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

				// go back to customer landing page
				if (JOptionPane.showOptionDialog(null, "Are you sure you want to go back, current data would be lost",
						"Warning", JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {

					PAManageParkingSpaces.main(null);
					dispose();

				}
			}
		});
		btnGoBack.setBounds(10, 270, 101, 34);
		mainPanel.add(btnGoBack);

		JScrollPane tablePane = new JScrollPane();
		tablePane.setBounds(10, 97, 453, 151);
		mainPanel.add(tablePane);

		

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				int col = table.columnAtPoint(e.getPoint());
				
				selectedBookingId = Integer.parseInt(tableData[row][0]);
						
//				System.out.println("row " + row + " column " + col);
			}
		});
		table.setModel(new DefaultTableModel(getTableData(),
				new String[] { "BookingId", "ParkingSpace", "ExpiryStatus","Request State", "PaymentStatus" }));
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		tablePane.setViewportView(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		mainPanel.add(scrollPane);

		JButton btnCancelRequest = new JButton("Cancel Request");
		btnCancelRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// prompt to accept cancellation request
				if (JOptionPane.showOptionDialog(null, "Are you sure you want cancel this request","Warning", JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
						
						if(user.cancelRequest(selectedBookingId)) {
							JOptionPane.showMessageDialog(null, "Action Completed", "Success",JOptionPane.PLAIN_MESSAGE);
							table.setModel(new DefaultTableModel(getTableData(),
									new String[] { "BookingId", "ParkingSpace", "ExpiryStatus","Request State", "PaymentStatus" }));
						}else {
							JOptionPane.showMessageDialog(null, "Action Failed", "Error",JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		});
		btnCancelRequest.setBounds(134, 270, 121, 34);
		mainPanel.add(btnCancelRequest);

		JButton btnGrantRequest = new JButton("Grant Request");
		btnGrantRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// prompt to accept grant request
				if (JOptionPane.showOptionDialog(null, "Are you sure you want Grant this request","Warning", JOptionPane.YES_NO_OPTION, 0, null, null, e) == JOptionPane.YES_OPTION) {
						if(user.grantRequest(selectedBookingId)) {
							JOptionPane.showMessageDialog(null, "Action Completed", "Success",JOptionPane.PLAIN_MESSAGE);
							table.setModel(new DefaultTableModel(getTableData(),
									new String[] { "BookingId", "ParkingSpace", "ExpiryStatus","Request State", "PaymentStatus" }));
						}else {
							JOptionPane.showMessageDialog(null, "Action Failed", "Error",JOptionPane.ERROR_MESSAGE);
						}
				}
			}
		});
		btnGrantRequest.setBounds(283, 270, 128, 34);
		mainPanel.add(btnGrantRequest);

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

		JLabel lblViewBookings = new JLabel("<html>Cancel or Grant Request</html>");
		lblViewBookings.setHorizontalAlignment(SwingConstants.LEFT);
		lblViewBookings.setForeground(Color.WHITE);
		lblViewBookings.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblViewBookings.setBackground(Color.LIGHT_GRAY);
		lblViewBookings.setBounds(10, 101, 205, 146);
		sidebarPanel.add(lblViewBookings);

		JLabel lblUser = new JLabel("");
//		lblUser.setText("<html>Parking Admin : " + user.getFirstname() + " " + user.getLastname() + "</html>");
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		lblUser.setForeground(Color.LIGHT_GRAY);
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setBounds(10, 263, 195, 125);
		sidebarPanel.add(lblUser);

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
