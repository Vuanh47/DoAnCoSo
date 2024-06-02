package view;

import java.awt.EventQueue;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DATABASE.DatabaseConnector;
import DATABASE.ExceptionRegester;
import model.BenhNhan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class ThemBenhNhan extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_hoTen;
	private JTextField textField_NgayKham;
	private JTextField textField_vienPhi;
	private JComboBox<String> comboBox_gioiTinh;
	private JComboBox<Integer> comboBoxSoPhong;
	private JComboBox<String> comboBox_BHYT;
	private JTextField textField_chuanDoan;
	private JTextField textField_MaBN;


	public ThemBenhNhan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThemBenhNhan.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 428);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Bệnh Nhân");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(250, 0, 257, 77);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Tên:");
		lblNewLabel_1.setBounds(27, 104, 81, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JButton button_TrangChu = new JButton("");
		button_TrangChu.setBounds(21, 25, 87, 33);
		button_TrangChu.setBackground(SystemColor.text);
		button_TrangChu.setIcon(new ImageIcon(ThemBenhNhan.class.getResource("/Image/hom.png")));
		button_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(button_TrangChu);
		button_TrangChu.addActionListener(new ActionListener() {
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
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày Khám:");
		lblNewLabel_1_2.setBounds(27, 254, 102, 29);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 77);
		panel.setBackground(new Color(102, 0, 153));
		contentPane.add(panel);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setBounds(121, 110, 125, 20);
		contentPane.add(textField_hoTen);
		textField_hoTen.setColumns(10);
		
		 textField_NgayKham= new JTextField();
		textField_NgayKham.setBounds(123, 259, 123, 20);
		textField_NgayKham.setColumns(10);
		contentPane.add(textField_NgayKham);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setBounds(394, 104, 97, 29);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Phòng:");
		lblNewLabel_1_5.setBounds(394, 150, 113, 29);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Viện Phí:");
		lblNewLabel_1_6.setBounds(394, 202, 113, 29);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_6);
		
		textField_vienPhi = new JTextField();
		textField_vienPhi.setBounds(501, 207, 125, 20);
		textField_vienPhi.setColumns(10);
		contentPane.add(textField_vienPhi);


		
		JLabel lblNewLabel_1_6_1 = new JLabel("Chuẩn Đoán:");
		lblNewLabel_1_6_1.setBounds(394, 242, 102, 52);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_6_1);
	
	
		
		JButton buttonOK = new JButton("ok");
		buttonOK.setBounds(378, 324, 113, 29);
		buttonOK.setBackground(Color.white);
		buttonOK.setIcon(new ImageIcon(ThemBenhNhan.class.getResource("/Image/tick.png")));
		buttonOK.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(buttonOK);
		buttonOK.addActionListener(this);
		
		JButton btnNewButton_Huy = new JButton("Hủy");
		btnNewButton_Huy.setBounds(183, 324, 113, 29);
		btnNewButton_Huy.setBackground(Color.white);
		btnNewButton_Huy.setIcon(new ImageIcon(ThemBenhNhan.class.getResource("/Image/huy.png")));
		btnNewButton_Huy.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_Huy);
		btnNewButton_Huy.addActionListener(this);
		
		

		textField_chuanDoan = new JTextField();
		textField_chuanDoan.setBounds(501, 259, 125, 20);
		contentPane.add(textField_chuanDoan);
		textField_chuanDoan.setColumns(10);
		
        DefaultComboBoxModel<String> model_gioiTinh = new DefaultComboBoxModel<>();
        model_gioiTinh.addElement("Nam");
        model_gioiTinh.addElement("Nữ");


		 comboBox_gioiTinh = new JComboBox(model_gioiTinh);
		comboBox_gioiTinh.setBounds(501, 109, 125, 22);
		contentPane.add(comboBox_gioiTinh);
		
		 DefaultComboBoxModel<Integer> model_soPhong = new DefaultComboBoxModel<>();
		 for(int i = 1; i< 51;i++) {
			 model_soPhong.addElement(i);
		 }
		
		 comboBoxSoPhong = new JComboBox(model_soPhong);
		 comboBoxSoPhong.setBounds(501, 155, 125, 22);
		contentPane.add(comboBoxSoPhong);
		
		JLabel lblNewLabel_BHYT = new JLabel("BHYT:");
		lblNewLabel_BHYT.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_BHYT.setBounds(27, 203, 66, 29);
		contentPane.add(lblNewLabel_BHYT);
		
		DefaultComboBoxModel<String> model_BHYT= new DefaultComboBoxModel<>();
        model_BHYT.addElement("Không");
        model_BHYT.addElement("Có");
        
		comboBox_BHYT = new JComboBox(model_BHYT);
		comboBox_BHYT.setBounds(123, 207, 123, 22);
		contentPane.add(comboBox_BHYT);
		
		textField_MaBN = new JTextField();
		textField_MaBN.setColumns(10);
		textField_MaBN.setBounds(123, 156, 123, 20);
		contentPane.add(textField_MaBN);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã bệnh nhân:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(6, 150, 117, 29);
		contentPane.add(lblNewLabel_1_1);
		
		
        

		
}

			public boolean check() {
				return !textField_hoTen.getText().equals("")&&!comboBox_gioiTinh.getSelectedItem().equals("")&&
					       !textField_NgayKham.getText().equals("")&&
					       !comboBoxSoPhong.getSelectedItem().equals("")&&!textField_vienPhi.getText().equals("")&&
					       !textField_chuanDoan.getText().equals("");
				}
			
			
			public boolean isInt(String value) {
				try {
					int textMaBN = Integer.parseInt(textField_MaBN.getText());
					return true ;
				} catch (Exception e) {
					return false;
				}
			}
			
				
			private boolean isDoubleBuffered(String values) {
				try {
					Double.parseDouble(textField_vienPhi.getText());
					return true ;
				} catch (Exception e) {
					return false;
				}
				
			}
			
			public void checkInfor(String textMaBN, String textVienPhi) throws ExceptionRegester{
				if (!isInt(textMaBN)) {
					throw new ExceptionRegester("Mã bệnh nhân không hợp lệ!");
				}
				
				if (!isDoubleBuffered(textVienPhi)) {
					throw new ExceptionRegester(" Phí bệnh viện không hợp lệ!");
				}
			}
				
			

			public void ThemDB() throws Exception {
				DatabaseConnector dc = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
				if(check()) {
					try {
						Integer maBN = Integer.parseInt(textField_MaBN.getText());
						BenhNhan bn = new BenhNhan();
						bn.setMaBenhNhan(maBN);
						  // Kiểm tra xem mã bệnh nhân đã tồn tại trong cơ sở dữ liệu hay chưa
			            if (dc.isBenhNhanExists(bn)){
			                JOptionPane.showMessageDialog(ThemBenhNhan.this, "Mã bệnh nhân đã tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
			                return; // Thoát khỏi phương thức nếu mã đã tồn tại
			            }
			            
						checkInfor(textField_MaBN.getText(), textField_vienPhi.getText());
						int textMaBN = Integer.parseInt(textField_MaBN.getText());
						String textTen = textField_hoTen.getText();
						String BHYT = (String) comboBox_BHYT.getSelectedItem();
						String textNGAYkham = textField_NgayKham.getText();
						int textSophong = (int) comboBoxSoPhong.getSelectedItem();
						String textGioiTinh = (String) comboBox_gioiTinh.getSelectedItem();
						double textVienPhi = Double.valueOf(textField_vienPhi.getText());
						String chuanDoan = textField_chuanDoan.getText();
						
						BenhNhan bn1 = new BenhNhan(textMaBN , textTen , textNGAYkham , textGioiTinh , textVienPhi , textSophong , chuanDoan , BHYT ); 
						int result = dc.themBenhNhan(bn1);
						
						if (result != 0 ) {
							// thông báo 
							JOptionPane.showMessageDialog(ThemBenhNhan.this, "Đã thêm Bệnh Nhân.");
					    	EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										DanhSach frame = new DanhSach();
										frame.setLocationRelativeTo(null);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							dispose();
						}
					} catch (ExceptionRegester e) {
						 JOptionPane.showMessageDialog(ThemBenhNhan.this ,e.getMessage());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
			} else {
				 JOptionPane.showMessageDialog(ThemBenhNhan.this, "Vui lòng nhập thông tin đầy đủ", "Thông báo", JOptionPane.ERROR_MESSAGE);
					
				}
	
	}

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("ok")){
						try {
							ThemDB();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}else if (e.getActionCommand().equals("Hủy")) {
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
					
				}
	
	}

