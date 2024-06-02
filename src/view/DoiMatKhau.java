package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATABASE.DatabaseConnector;
import model.ACC;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;

public class DoiMatKhau extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_MatKhauCu;
	private JTextField textField_MKmoi1;
	private JTextField textField_MKmoi2;
	private static ACC acc;

	public DoiMatKhau() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DoiMatKhau.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 319);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật Khẩu");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(129, 11, 220, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(52, 71, 74, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu Mới:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(45, 121, 136, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác Nhận Mật Khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(35, 171, 136, 24);
		contentPane.add(lblNewLabel_1_2);
		
		textField_MatKhauCu = new JTextField();
		textField_MatKhauCu.setBounds(181, 74, 143, 20);
		contentPane.add(textField_MatKhauCu);
		textField_MatKhauCu.setColumns(10);
		
		textField_MKmoi1 = new JTextField();
		textField_MKmoi1.setColumns(10);
		textField_MKmoi1.setBounds(181, 124, 143, 20);
		contentPane.add(textField_MKmoi1);
		
		textField_MKmoi2 = new JTextField();
		textField_MKmoi2.setColumns(10);
		textField_MKmoi2.setBounds(181, 174, 143, 20);
		contentPane.add(textField_MKmoi2);
		
		JButton btnNewButton = new JButton("Xác Nhận");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(247, 220, 102, 25);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DoiMK1();;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		JButton btnHy = new JButton("Hủy");
		btnHy.setBackground(new Color(255, 255, 255));
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHy.setBounds(97, 220, 102, 25);
		contentPane.add(btnHy);
		btnHy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CaNhan frame = new CaNhan();
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 434, 52);
		contentPane.add(panel);
		
		
		
	}
	public void DoiMK1() throws Exception {
		DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
			
	    try {
	        
	        String MKCu = textField_MatKhauCu.getText();
	        String mk1 = textField_MKmoi1.getText();
	        String mk2 = textField_MKmoi2.getText();
	        String ten = acc.getUser();
	        User tk = new User();
	        tk.setHoTen(ten);
	        tk.setMatKhau(mk1);
	        
	        if(acc.getPassword().equals(MKCu) && mk1.equals(mk2)) {
	        	
	        	connector.DoiMK(tk);
	        	JOptionPane.showMessageDialog(DoiMatKhau.this, "Thay Đổi Mật Khẩu Thành Công!" );
	        	EventQueue.invokeLater(new Runnable() {
	    			public void run() {
	    				try {
	    					CaNhan frame = new CaNhan();
	    					frame.setLocationRelativeTo(null);
	    					frame.setVisible(true);
	    				} catch (Exception e) {
	    					e.printStackTrace();
	    				}
	    			}
	    			
	    		});
	        	dispose();
	        }else {
	        	JOptionPane.showMessageDialog(DoiMatKhau.this, "Thay Đổi Mật Khẩu Thất Bại", "Thông Báo", JOptionPane.ERROR_MESSAGE  );
			}
		
 
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
