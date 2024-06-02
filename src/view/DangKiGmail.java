package view;

import javax.mail.Message;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DATABASE.DatabaseConnector;
import model.User;
	
public class DangKiGmail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_mail;
	private JTextField textField_OTP;
	private int code;
	User tk;
	private JLabel lblNewLabel_TB;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangKiGmail frame = new DangKiGmail();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DangKiGmail() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangKiGmail.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Xác Nhận");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(158, 0, 187, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 472, 55);
		contentPane.add(panel);
		
		textField_mail = new JTextField();
		textField_mail.setBounds(120, 111, 156, 20);
		contentPane.add(textField_mail);
		textField_mail.setColumns(10);
		
		textField_OTP = new JTextField();
		textField_OTP.setColumns(10);
		textField_OTP.setBounds(120, 167, 156, 20);
		contentPane.add(textField_OTP);
		
		JLabel lblNewLabel_1 = new JLabel("Gmail:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(51, 109, 60, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã OTP:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(50, 165, 60, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButtonGui = new JButton("Gửi Mã");
		btnNewButtonGui.setBackground(new Color(255, 255, 255));
		btnNewButtonGui.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButtonGui.setBounds(306, 109, 91, 23);
		contentPane.add(btnNewButtonGui);
		btnNewButtonGui.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 // Kiểm tra định dạng email
				try {
DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
					String email = textField_mail.getText();
					User tk = new User();
					tk.setMail(email);
					Boolean isemail = connector.isEmailExists(tk);
					if(!isemail) {
						  if (!isValidEmail(textField_mail.getText())) {
					            lblNewLabel_TB.setText("Gmail định dạng không đúng.");
					            return;
					        }
						  
							String recever_email = textField_mail.getText();
							sendMessageGmail(recever_email);
							lblNewLabel_TB.setText("Đã gửi mã thành công!!");
							lblNewLabel_TB.setForeground(Color.RED);
							System.out.println("Gửi thành công!!");
						} else {
							lblNewLabel_TB.setText("Đã Tồn tại email này!!");
							lblNewLabel_TB.setForeground(Color.red);
						}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnXcNhn = new JButton("Xác Nhận");
		btnXcNhn.setBackground(new Color(255, 255, 255));
		btnXcNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXcNhn.setBounds(254, 252, 91, 23);
		contentPane.add(btnXcNhn);
		btnXcNhn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					isEmailExists();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
		        // kiem tra mã otp 
				if(Integer.valueOf(textField_OTP.getText())== code) {
					JOptionPane.showMessageDialog(DangKiGmail.this, "Xác nhận Gmail thành công!");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								DangKi frame = new DangKi();
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
					DangKi.transperEmail(textField_mail.getText());
				}else {
					lblNewLabel_TB.setText("Mã OTP không đúng.");
					lblNewLabel_TB.setForeground(Color.red);
				}
		
			}
		});
		
		lblNewLabel_TB = new JLabel();
		lblNewLabel_TB.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_TB.setHorizontalAlignment(SwingConstants.CENTER); 
		lblNewLabel_TB.setBounds(120, 210, 199, 23);
		lblNewLabel_TB.setForeground(new Color(0, 0, 153));
		contentPane.add(lblNewLabel_TB);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHy.setBackground(Color.WHITE);
		btnHy.setBounds(92, 252, 91, 23);
		contentPane.add(btnHy);
		btnHy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
			}
		});
	
	}
public void isEmailExists() throws Exception {
	        DatabaseConnector dc = null;
	        try {
	        	 dc = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	        	 String mail = textField_mail.getText();
	        	 User tk = new User();
	        	 tk.setHoTen(mail);

	        	 if (dc.isEmailExists(tk)) {
	                throw new IllegalArgumentException("Email Này Đã Tồn Tại!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
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
}
