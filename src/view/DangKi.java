package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import DATABASE.DatabaseConnector;
import model.User;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JList;
import java.awt.Toolkit;

public class DangKi extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPasswordField textField_MK;
	private JTextField textField_HoTen;
	private JTextField txtSDT;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_MK2;
	private JButton btnConfirm;
	private JLabel lblNewLabel;
	private JComboBox<Integer> comboBox_namSinh;
	private JComboBox<String> comboBox_GioiTinh;
	private static String email;
	

	public DangKi() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangKi.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 66, 630, 292);
		desktopPane.setBackground(new Color(230, 230, 250));
		contentPane.add(desktopPane);
		
		lblNewLabel_5 = new JLabel("Gõ Lại Mật Khẩu:");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBackground(Color.GRAY);
		lblNewLabel_5.setBounds(343, 149, 122, 22);
		desktopPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Giới Tính:");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBackground(Color.GRAY);
		lblNewLabel_6.setBounds(375, 42, 90, 22);
		desktopPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Năm Sinh:");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBackground(Color.GRAY);
		lblNewLabel_7.setBounds(369, 92, 103, 22);
		desktopPane.add(lblNewLabel_7);
		
		lblNewLabel_4 = new JLabel("Số Điện Thoại:");
		lblNewLabel_4.setBounds(19, 149, 107, 22);
		desktopPane.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setBounds(136, 150, 135, 20);
		desktopPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Mật Khẩu:");
		lblNewLabel_3.setBounds(19, 92, 84, 22);
		desktopPane.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblNewLabel_1 = new JLabel("Tên Đăng Nhập:");
		lblNewLabel_1.setBounds(7, 42, 122, 22);
		desktopPane.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_MK = new JPasswordField();
		textField_MK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MK.setBounds(136, 93, 135, 20);
		desktopPane.add(textField_MK);
		textField_MK.setColumns(10);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_HoTen.setBounds(136, 43, 135, 20);
		desktopPane.add(textField_HoTen);
		textField_HoTen.setColumns(10);
	       
		textField_MK2 = new JTextField();
		textField_MK2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MK2.setBounds(475, 150, 130, 20);
		desktopPane.add(textField_MK2);
		textField_MK2.setColumns(10);
			
		DefaultComboBoxModel<Integer> comboBoxModel_namSinh = new DefaultComboBoxModel<>();
        for (int i = 1940; i <= 2023; i++) {
        	comboBoxModel_namSinh.addElement(i);
        }

        comboBox_namSinh = new JComboBox<>(comboBoxModel_namSinh);
        comboBox_namSinh.setBounds(469, 94, 136, 22);
        desktopPane.add(comboBox_namSinh);
      
        JButton btnCancel = new JButton("Hủy");
        btnCancel.setBounds(155, 220, 125, 35);
        desktopPane.add(btnCancel);
        btnCancel.setIcon(new ImageIcon(DangKi.class.getResource("/Image/huy.png")));
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.setBackground(new Color(255, 255, 255));
        
        DefaultComboBoxModel<String> model_gioiTinh = new DefaultComboBoxModel<>();
        model_gioiTinh.addElement("Nam");
        model_gioiTinh.addElement("Nữ");

        comboBox_GioiTinh = new JComboBox(model_gioiTinh);
        comboBox_GioiTinh.setBounds(470, 44, 135, 22);
        desktopPane.add(comboBox_GioiTinh);
        
        
        
        btnConfirm = new JButton("Xác Nhận");
        btnConfirm.setBounds(356, 221, 125, 35);
        desktopPane.add(btnConfirm);
        btnConfirm.setIcon(new ImageIcon(DangKi.class.getResource("/Image/ok.png")));
        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnConfirm.setBackground(new Color(255, 255, 255));
        btnConfirm.addActionListener(this);
	      
        btnCancel.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					DangNhap frame = new DangNhap();
        					frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
        	
        	dispose();
        	}
        				
        });

		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(222, 306, 1, 1);
		contentPane.add(desktopPane_1);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBounds(0, 0, 630, 68);
		contentPane.add(desktopPane_2);
		desktopPane_2.setBackground(new Color(102, 0, 152));
		desktopPane_2.setLayout(null);
		
		lblNewLabel = new JLabel("Tạo Tài Khoản");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(200, 11, 313, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		desktopPane_2.add(lblNewLabel);
		
}
	
	  
	    public boolean checkIsEmpty() {
	    	return	!textField_HoTen.getText().isEmpty() &&
	    			!textField_MK.getText().isEmpty() &&
	    			!textField_MK2.getText().isEmpty() &&
	    			!txtSDT.getText().isEmpty();
		}
	    public void isTaiKhoanExists() throws Exception {
	        DatabaseConnector dc = null;
	        try {
	        	 dc = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	        	 String hoten = textField_HoTen.getText();
	        	 User tk = new User();
	        	 tk.setHoTen(hoten);

	        	 if (dc.isTaiKhoanExists(tk)) {
	                throw new IllegalArgumentException("Tên Đăng Nhập Này Đã Tồn Tại!");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	    }

 
	    
	    public void DangKiTaiKhoan() {
	        try {
	            isTaiKhoanExists(); // Nếu tài khoản đã tồn tại, hàm này sẽ ném ra một exception

	            // Nếu chương trình thực hiện đến đây, có nghĩa là tài khoản không tồn tại, tiến hành đăng ký
	            if (checkIsEmpty() && textField_MK.getText().equals(textField_MK2.getText())) {
	                String HoTen = textField_HoTen.getText();
	                String matKhau = textField_MK.getText();
	                int namSinh = (int) comboBox_namSinh.getSelectedItem();
	                String GioiTinh = (String) comboBox_GioiTinh.getSelectedItem();
	               
	                 if (txtSDT.getText().startsWith("0") && txtSDT.getText().length() == 10 || txtSDT.getText().length() == 11) {
	                    String sdt = txtSDT.getText();	                  
	                    DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	                    User taiKhoan = new User(HoTen, matKhau, namSinh, GioiTinh, sdt, email);
	                    connector.DangKiTaiKhoan(taiKhoan);
	                    System.out.println(email);

	                    JOptionPane.showMessageDialog(DangKi.this, "Đăng kí thành công!");
	                    EventQueue.invokeLater(() -> {
	                        try {
	                            DangNhap frame = new DangNhap();
	                            frame.setLocationRelativeTo(null);
	                            frame.setVisible(true);
	                        } catch (Exception e) {
	                            e.printStackTrace();
	                        }
	                    });
	                    dispose();
	                } else {
	                    JOptionPane.showMessageDialog(DangKi.this, "Số điện thoại không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
	                }
	            }else {
	            	JOptionPane.showMessageDialog(DangKi.this, "Đăng Kí Thất Bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	 	           
				}
	        } catch (IllegalArgumentException e) {
	            // Khối này sẽ bắt exception nếu tài khoản đã tồn tại
	            JOptionPane.showMessageDialog(DangKi.this, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	        } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Xác Nhận")) {
			try {
				DangKiTaiKhoan();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	public static void transperEmail(String email1) {
			email = email1;
	}
	
}
