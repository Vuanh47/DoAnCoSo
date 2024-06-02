package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATABASE.DatabaseConnector;
import model.ACC;
import model.BenhNhan;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class CaNhan extends JFrame {
	
	private static ACC acc ; 

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DatabaseConnector connector;
	private LocalDate currentDate;
	private JLabel lblNewLabel_ten;
	private JLabel lblNewLabel_namsinh;
	private JLabel lblNewLabel_gioiTinh;
	private JLabel lblNewLabel_sdt;


	public CaNhan() throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CaNhan.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button_TrangChu = new JButton("");
		button_TrangChu.setIcon(new ImageIcon(CaNhan.class.getResource("/Image/hom.png")));
		button_TrangChu.setBounds(10, 18, 85, 38);
		button_TrangChu.setBackground(SystemColor.text);
		button_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(button_TrangChu);
		button_TrangChu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							TrangChuAdmin frame = new TrangChuAdmin();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
				
		
		JLabel lblNewLabel = new JLabel("Thông tin tài khoản");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(245, 0, 261, 70);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		String username = acc.getUser();
		lblNewLabel_ten = new JLabel(username);
		lblNewLabel_ten.setText(username);
		
		
		lblNewLabel_ten.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel_ten.setHorizontalAlignment(SwingConstants.CENTER);  // Canh giữa ngang
		lblNewLabel_ten.setBounds(5, 188, 209, 70);
		contentPane.add(lblNewLabel_ten);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chào mừng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2_1.setBounds(24, 139, 175, 38);
		contentPane.add(lblNewLabel_2_1);
		

	 	JLabel lblNewLabel_2_1_1 = new JLabel("Hi!");
	 	lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
	 	lblNewLabel_2_1_1.setBounds(20, 111, 152, 36);
	 	contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng Bệnh Nhân:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(272, 116, 170, 31);
		contentPane.add(lblNewLabel_3);
		
		connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
		ResultSet resultSet = connector.getConnection().createStatement().executeQuery("SELECT * FROM benhnhan");

		// Đếm số lượng hàng
		int rowCount = 0;
		while (resultSet.next()) {
		    rowCount++;
		}
	
		JLabel lblNewLabel_SoBN = new JLabel();
		lblNewLabel_SoBN.setText(String.valueOf(rowCount));
		lblNewLabel_SoBN.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_SoBN.setBounds(450, 115, 42, 31);
		contentPane.add(lblNewLabel_SoBN);
		
		JLabel lblNewLabel_3_1 = new JLabel("Năm Sinh:");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(272, 176, 116, 31);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Giới Tính:");
		lblNewLabel_3_2.setForeground(Color.BLACK);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(272, 235, 116, 31);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Số Điện Thoại:");
		lblNewLabel_3_3.setForeground(Color.BLACK);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(272, 302, 116, 31);
		contentPane.add(lblNewLabel_3_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(72, 61, 139));
		panel_1.setBounds(0, 0, 700, 70);
		contentPane.add(panel_1);
		
		JButton btnNewButton_doiMK = new JButton("Thay Đổi Mật Khẩu");
		btnNewButton_doiMK.setBackground(new Color(255, 255, 255));
		btnNewButton_doiMK.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_doiMK.setBounds(24, 351, 160, 23);
		contentPane.add(btnNewButton_doiMK);
		btnNewButton_doiMK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DoiMatKhau frame = new DoiMatKhau();
							frame.setLocationRelativeTo(null);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				dispose();
			}
		});
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(123, 104, 238));
		panel_2.setBounds(0, 70, 223, 319);
		contentPane.add(panel_2);
		
		 lblNewLabel_sdt = new JLabel("sdt");
		lblNewLabel_sdt.setForeground(Color.BLACK);
		lblNewLabel_sdt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_sdt.setBounds(398, 302, 116, 31);
		contentPane.add(lblNewLabel_sdt);
		
		 lblNewLabel_gioiTinh = new JLabel("gioitinh");
		lblNewLabel_gioiTinh.setForeground(Color.BLACK);
		lblNewLabel_gioiTinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_gioiTinh.setBounds(398, 235, 116, 31);
		contentPane.add(lblNewLabel_gioiTinh);
		
		 lblNewLabel_namsinh = new JLabel("namsinh");
		lblNewLabel_namsinh.setForeground(Color.BLACK);
		lblNewLabel_namsinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_namsinh.setBounds(398, 176, 116, 31);
		contentPane.add(lblNewLabel_namsinh);

		currentDate = LocalDate.now();
       int day = currentDate.getDayOfMonth();
       int month = currentDate.getMonthValue();
       int year = currentDate.getYear();
       JLabel dayLabel = new JLabel(day+"-" + month+"-"+year);
       dayLabel.setBounds(617, 351, 83, 38);
       dayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(dayLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(538, 132, 152, 145);
	 	contentPane.add(lblNewLabel_1);
		
		 try {
	    	DatabaseConnector connector = null;
	        connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	      
	        String HoTen = lblNewLabel_ten.getText();
	        BenhNhan bn = new BenhNhan();
	        bn.setHoTen(HoTen);
	        ResultSet rs = connector.timKiemThongTinCN(bn);
		    // Kết nối với MySQL
			lblNewLabel_gioiTinh.setText(rs.getString("GioiTinh"));
			lblNewLabel_namsinh.setText(rs.getString("NamSinh"));
			lblNewLabel_sdt.setText(rs.getString("sdt"));
			connector.close();
   
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (connector != null) {
	            connector.close(); // Đảm bảo đóng kết nối sau khi sử dụng
	        }
	    }
	}
	

	public static void receiverInfor(ACC account) {
		acc = account ; 
		
	}
	
}
