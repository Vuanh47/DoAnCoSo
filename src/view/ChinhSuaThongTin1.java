package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DATABASE.DatabaseConnector;
import model.BenhNhan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
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
import java.awt.Toolkit;

public class ChinhSuaThongTin1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_hoTen;
	private JTextField textField_NgayKham;
	private JTextField textField_vienPhi;
	static String hoTen;
	static int ngayKham;
	static int textSophong;
	 static String textGioiTinh;
	 static Double textVienPhi;
	 static String tinhTrang ;
	 static int maBN;
	DefaultTableModel model;
    Vector<Vector<Object>> data = new Vector<>();
	private JComboBox comboBox_gioiTinh;
	private JComboBox comboBoxSoPhong;
	private JTextField textField_chuanDoan;
	private JComboBox comboBox_BHYT;
	private JTextField textField_MaBN;
	
	public ChinhSuaThongTin1(int maBN) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChinhSuaThongTin1.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Họ Tên:");
		lblNewLabel_1.setBounds(39, 90, 81, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ngày Khám:");
		lblNewLabel_1_2.setBounds(39, 245, 113, 29);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_2);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setBounds(130, 96, 125, 20);
		contentPane.add(textField_hoTen);
		textField_hoTen.setColumns(10);
		
		 textField_NgayKham= new JTextField();
		textField_NgayKham.setBounds(133, 245, 122, 20);
		textField_NgayKham.setColumns(10);
		contentPane.add(textField_NgayKham);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giới Tính:");
		lblNewLabel_1_4.setBounds(356, 90, 81, 29);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Số Phòng:");
		lblNewLabel_1_5.setBounds(355, 135, 113, 29);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Viện Phí:");
		lblNewLabel_1_6.setBounds(355, 186, 113, 29);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_6);
		
		textField_vienPhi = new JTextField();
		textField_vienPhi.setBounds(457, 192, 125, 20);
		textField_vienPhi.setColumns(10);
		contentPane.add(textField_vienPhi);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Chuẩn Đoán:");
		lblNewLabel_1_6_1.setBounds(356, 232, 101, 52);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1_6_1);
	
		JButton buttonOK = new JButton("Xác Nhận");
		buttonOK.setBounds(344, 307, 120, 29);
		buttonOK.setBackground(Color.WHITE);
		buttonOK.setIcon(new ImageIcon(ChinhSuaThongTin1.class.getResource("/Image/ok.png")));
		buttonOK.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(buttonOK);
		buttonOK.addActionListener(this);
		
		JButton btnNewButton_Huy = new JButton("Hủy");
		btnNewButton_Huy.setBounds(173, 307, 113, 29);
		btnNewButton_Huy.setBackground(Color.WHITE);
		btnNewButton_Huy.setIcon(new ImageIcon(ChinhSuaThongTin1.class.getResource("/Image/huy.png")));
		btnNewButton_Huy.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btnNewButton_Huy);
		
		textField_chuanDoan = new JTextField();
		textField_chuanDoan.setBounds(457, 245, 138, 25);
		contentPane.add(textField_chuanDoan);
		textField_chuanDoan.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Edit Information");
		lblNewLabel.setForeground(new Color(255, 250, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(200, 11, 229, 41);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 153));
		panel.setBounds(0, 0, 622, 63);
		contentPane.add(panel);
		
		 DefaultComboBoxModel<String> model_gioiTinh = new DefaultComboBoxModel<>();
		 model_gioiTinh.addElement("Nam");
		 model_gioiTinh.addElement("Nữ");

		 comboBox_gioiTinh = new JComboBox(model_gioiTinh);
		 comboBox_gioiTinh.setBounds(457, 95, 125, 22);
		contentPane.add(comboBox_gioiTinh);
		
		 DefaultComboBoxModel<Integer> model_soPhong = new DefaultComboBoxModel<>();
		 for(int i = 1; i< 300;i++) {
			 model_soPhong.addElement(i);
		 }
		 
		 comboBoxSoPhong = new JComboBox(model_soPhong);
		 comboBoxSoPhong.setBounds(457, 140, 125, 22);
		contentPane.add(comboBoxSoPhong);
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("BHYT:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1.setBounds(39, 187, 113, 29);
		contentPane.add(lblNewLabel_1_2_1);
		
		 DefaultComboBoxModel<String> model_BHYT = new DefaultComboBoxModel<>();
		 model_BHYT.addElement("Không");
		 model_BHYT.addElement("Có");
		 
		 comboBox_BHYT = new JComboBox(model_BHYT);
		comboBox_BHYT.setBounds(130, 191, 125, 22);
		contentPane.add(comboBox_BHYT);
		
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Mã Bênh Nhân:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2_1_1.setBounds(26, 140, 113, 29);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		textField_MaBN = new JTextField();
		textField_MaBN.setText((String) null);
		textField_MaBN.setColumns(10);
		textField_MaBN.setBounds(133, 147, 122, 20);
		contentPane.add(textField_MaBN);
		
		
		try {
			DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
		
			BenhNhan bn = new BenhNhan();
			bn.setMaBenhNhan(maBN);
			ResultSet resultSet = connector.getDataBenhNhan(bn);
			if(resultSet == null) {
				System.out.println("null");
			}
			textField_MaBN.setText(resultSet.getString("MaBenhNhan"));
		 	textField_hoTen.setText(resultSet.getString("HoTen"));
		 	textField_NgayKham.setText(resultSet.getString("NgayKham"));
			comboBox_gioiTinh.setSelectedItem(resultSet.getString("GioiTinh"));
			textField_vienPhi.setText(resultSet.getString("VienPhi"));
			comboBox_gioiTinh.setSelectedItem(resultSet.getString("SoPhong"));
			textField_chuanDoan.setText(resultSet.getString("ChuanDoan"));
			comboBox_BHYT.setSelectedItem(resultSet.getString("BHYT"));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
}
	public void chinh() {
		try {	 
			int textMaBN = Integer.valueOf(textField_MaBN.getText());
			String textTen = textField_hoTen.getText();
			String textNGAYkham = textField_NgayKham.getText();
			int textSophong = (int) comboBoxSoPhong.getSelectedItem();
			String textGioiTinh = (String) comboBox_gioiTinh.getSelectedItem();
			double textVienPhi = Double.valueOf(textField_vienPhi.getText());
			String text_chuanDoan = textField_chuanDoan.getText();
			String textBHYT = (String) comboBox_BHYT.getSelectedItem();
			
			DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
			BenhNhan bn = new BenhNhan(textTen, textNGAYkham ,    textGioiTinh ,  textVienPhi ,textSophong , text_chuanDoan,textBHYT ,textMaBN  );
		    connector.chinhsua( bn);
      
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean error() {
		return textField_hoTen.getText().equals("")|| 
				textField_NgayKham.getText().equals("")||
				textField_chuanDoan.getText().equals("")||
				textField_vienPhi.getText().equals("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(error()) {
		JOptionPane.showMessageDialog(ChinhSuaThongTin1.this, "Vui lòng nhập đầy đủ thông tin!", "Chỉnh sửa thất bại.", JOptionPane.ERROR_MESSAGE);
		}
		else {
				chinh();
				JOptionPane.showMessageDialog(ChinhSuaThongTin1.this, "Chỉnh sửa thành công." );
				
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

	}
}
