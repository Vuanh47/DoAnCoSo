package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DATABASE.DatabaseConnector;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Random;
import java.awt.Toolkit;
import javax.swing.JCheckBox;

public class QuenMatKhau extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_mail;
	private JPasswordField textField_password;
	private LocalDate currentDate;
	private JTextField textField_OTP;
	private int code;
	private JLabel lblNewLabel_TB;
	private JTextField textField_username;

	public QuenMatKhau() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuenMatKhau.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quên Mật Khẩu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(160, 11, 234, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 509, 59);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Đăng Nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(43, 203, 126, 28);
		contentPane.add(lblNewLabel_1);
		
		JButton Button_XacNhan = new JButton("Xác Nhận");
		Button_XacNhan.setForeground(Color.BLACK);
		Button_XacNhan.setBackground(Color.WHITE);
		Button_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 11));
		Button_XacNhan.setBounds(275, 348, 109, 23);
		contentPane.add(Button_XacNhan);
		Button_XacNhan.addActionListener(this);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.setBounds(112, 348, 109, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(75, 101, 94, 28);
		contentPane.add(lblNewLabel_1_1);
		
		textField_mail = new JTextField();
		textField_mail.setColumns(10);
		textField_mail.setBounds(179, 107, 163, 20);
		contentPane.add(textField_mail);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mật Khẩu Mới:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(43, 253, 110, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		currentDate = LocalDate.now();
        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();
        int year = currentDate.getYear();
        JLabel dayLabel = new JLabel(day+"-" + month+"-"+year);
        dayLabel.setBounds(435, 360, 74, 33);
        dayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(dayLabel);
			
		textField_password = new JPasswordField();
		textField_password.setColumns(10);
		textField_password.setEditable(false); 
		textField_password.setBounds(179, 259, 163, 20);
		contentPane.add(textField_password);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Mã OTP:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(71, 153, 110, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_OTP = new JTextField();
		textField_OTP.setColumns(10);
		textField_OTP.setBounds(179, 159, 163, 20);
		contentPane.add(textField_OTP);
		
		JButton btnGiM = new JButton("Gửi mã");
		btnGiM.setForeground(Color.BLACK);
		btnGiM.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGiM.setBackground(Color.WHITE);
		btnGiM.setBounds(378, 106, 94, 23);
		contentPane.add(btnGiM);
		btnGiM.addActionListener(new ActionListener() {
			
			@Override
		public void actionPerformed(ActionEvent e) {
			   if (!isValidEmail(textField_mail.getText())) {
		            lblNewLabel_TB.setText("Gmail định dạng không đúng.");
		            return;
		        }
				String recever_email = textField_mail.getText();
				sendMessageGmail(recever_email);
				System.out.println(recever_email);
				lblNewLabel_TB.setText("Đã gửi mã thành công!!");
				lblNewLabel_TB.setForeground(Color.blue);
			}
		});
		
		lblNewLabel_TB = new JLabel();
		lblNewLabel_TB.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_TB.setHorizontalAlignment(SwingConstants.CENTER); 
		lblNewLabel_TB.setBounds(142, 302, 218, 23);
		lblNewLabel_TB.setForeground(new Color(0, 0, 153));
		contentPane.add(lblNewLabel_TB);

		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setEditable(false);
		textField_username.setBounds(179, 209, 163, 20);
		contentPane.add(textField_username);
		
		JButton Button_OTP = new JButton("Xác Nhận");
		Button_OTP.setForeground(Color.BLACK);
		Button_OTP.setFont(new Font("Tahoma", Font.BOLD, 11));
		Button_OTP.setBackground(Color.WHITE);
		Button_OTP.setBounds(378, 158, 94, 23);
		contentPane.add(Button_OTP);
		
		JCheckBox chckbxHinTh = new JCheckBox("Hiển Thị");
		chckbxHinTh.setBackground(Color.WHITE);
		chckbxHinTh.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxHinTh.setBounds(375, 258, 83, 23);
		contentPane.add(chckbxHinTh);

		chckbxHinTh.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//kiem tra co dc chon khong
				  if (chckbxHinTh.isSelected()) {
	                    // Nếu đang được chọn, hiển thị mật khẩu
	                    textField_password.setEchoChar((char) 0); // Hiển thị mật khẩu dưới dạng văn bản thông thường
	                } else {
	                    // Nếu không được chọn, ẩn mật khẩu
	                    textField_password.setEchoChar('\u2022'); // Sử dụng ký tự "•" để ẩn mật khẩu
	                }
	            }
			
		});
		Button_OTP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(textField_OTP.getText())== code) {
					lblNewLabel_TB.setText("Mời nhập mật khẩu");
					HienthiTen();
					textField_password.setEditable(true); 
					textField_username.setEditable(true);
					
					
				}else {
					lblNewLabel_TB.setText("Mã OTP không đúng.");
					lblNewLabel_TB.setForeground(Color.red);
				}
		
			}
		});
				
		
	}	
	 public int sendMessageGmail(String addressreceiver) {
	    	String HOST_NAME = "smtp.gmail.com";
	    	int SSL_PORT = 465;
	        String APP_EMAIL = "daovuanh2207@gmail.com"; // your email // gửi
	        String APP_PASSWORD = "vfzu ervs pmld brca";

	        // Get properties object
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", HOST_NAME);
	        props.put("mail.smtp.socketFactory.port", SSL_PORT);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.port", SSL_PORT);

	        // get Session
	        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
	            }
	        });
	        int min = 1000;
	        int max = 9999;
	        // tạo mã 
	        Random random = new Random();
	        code = random.nextInt(max - min + 1) + min ; 
	        // compose message
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressreceiver));
	            message.setSubject("MÃ QUẢN LÝ BỆNH VIỆN");
	            message.setText("Mã OTP của bạn là: " + code );

	            // send message
	            Transport.send(message);
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	        
	        return code ;
	    }
	 
	    public static boolean isValidEmail(String email) {
	        // Kiểm tra xem chuỗi có chứa ký tự @ và ít nhất một dấu chấm không
	        return email.contains("@") && email.contains(".")&&(email.contains("gmail")||email.contains("com")||email.contains("vn"));
	    }
	
	


	public void QuenMK() throws Exception {
		DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
		
	    try {
			@SuppressWarnings("deprecation")
			String password = textField_password.getText();
			String email = textField_mail.getText();
			User tk = new User();
	        tk.setMatKhau(password);
	        tk.setMail(email);
	        	connector.QuenMK(tk);
	        	
	        	JOptionPane.showMessageDialog(QuenMatKhau.this, "Thay đổi mật khẩu thành công." );
	        	EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					DangNhap frame = new DangNhap();
	    					frame.setLocationRelativeTo(null);
	    					frame.setVisible(true);
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    			}
	    			
	    		});
	        	dispose();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void HienthiTen() {
		 DatabaseConnector connector = null;
			try {
				connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		        
	        try {
	            String email = textField_mail.getText();
	            User tk = new User();
	            tk.setMail(email);
	            
	            ResultSet rs = connector.timKiemTaiKhoanBiQuen(tk);
	            if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên
	                // Hiển thị dữ liệu từ ResultSet
	                textField_username.setText(rs.getString("TenDangNhap"));
	                // Các dòng code khác để hiển thị thông tin khác nếu cần
	            } else {
	                // Xử lý trường hợp không tìm thấy dữ liệu
	                textField_mail.setText("Không tìm thấy tài khoản");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Hủy")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DangNhap frame = new DangNhap();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}else if (e.getActionCommand().equals("Xác Nhận")) {
			try {
				QuenMK();
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}
}
