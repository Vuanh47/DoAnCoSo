package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import DATABASE.DatabaseConnector;
import model.BenhNhan;

import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.sql.Connection;
import java.awt.SystemColor;
import java.awt.Toolkit;
public class DanhSach extends JFrame implements  ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTable table_1 = new JTable();
	
	 Vector<String> columnNames = new Vector<>();
     Vector<Vector<Object>> data = new Vector<>();
	 int selectedrow = 0 ;
	ResultSet rst;
	DefaultTableModel model;
	private LocalDate currentDate;


	public DanhSach() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DanhSach.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JMenuBar bar = new JMenuBar();
		contentPane.setLayout(null);
		     
		JLabel lblNewLabel = new JLabel("Danh Sách Thông Tin Bệnh Nhân");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(210, 11, 510, 45);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JButton button_TrangChu = new JButton("");
		button_TrangChu.setIcon(new ImageIcon(DanhSach.class.getResource("/Image/hom.png")));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 821, 73);
		panel.setBackground(new Color(102, 0, 153));
		contentPane.add(panel);
		
		JButton btnNewButton_timKiem = new JButton("Tìm");
		btnNewButton_timKiem.setIcon(new ImageIcon(DanhSach.class.getResource("/Image/tim.png")));
		btnNewButton_timKiem.setForeground(new Color(0, 0, 0));
		btnNewButton_timKiem.setBounds(132, 361, 124, 31);
		btnNewButton_timKiem.setBackground(new Color(255, 255, 255));
		btnNewButton_timKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnNewButton_timKiem);
		btnNewButton_timKiem.addActionListener(this);
	
		
		JLabel lblNewLabel_1 = new JLabel("Danh Sách Bệnh Nhân");
		lblNewLabel_1.setBounds(20, 84, 200, 63);
		lblNewLabel_1.setBackground(new Color(0, 0, 128));
		lblNewLabel_1.setIcon(new ImageIcon(DanhSach.class.getResource("/Image/hienthi.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		

		
		JButton btnNewButton_2 = new JButton("Sửa");
		btnNewButton_2.setIcon(new ImageIcon(DanhSach.class.getResource("/Image/edit1.png")));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(572, 361, 124, 31);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(this);

		JButton btnNewButton_them = new JButton("Thêm");
		btnNewButton_them.setIcon(new ImageIcon(DanhSach.class.getResource("/Image/them.png")));
		btnNewButton_them.setForeground(new Color(0, 0, 0));
		btnNewButton_them.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_them.setBackground(new Color(255, 255, 255));
		btnNewButton_them.setBounds(348, 361, 124, 31);
		contentPane.add(btnNewButton_them);
		btnNewButton_them.addActionListener(this);
		
	        try {
	            // Kết nối với MySQL
	        	  DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	              ResultSet resultSet = connector.getConnection().createStatement().executeQuery("SELECT * FROM benhnhan");

	            int columns = resultSet.getMetaData().getColumnCount();
	            for (int i = 1; i <= columns; i++) {
	                columnNames.add(resultSet.getMetaData().getColumnName(i));
	            }

	            while (resultSet.next()) {
	                Vector<Object> row = new Vector<>(columns);
	                for (int i = 1; i <= columns; i++) {
	                    row.addElement(resultSet.getObject(i));
	                }
	                data.addElement(row);
	            }

	            connector.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 147, 801, 181);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
		model = new DefaultTableModel(data, columnNames);
		table_1.setModel(model);
		
		currentDate = LocalDate.now();
	    int day = currentDate.getDayOfMonth();
	    int month = currentDate.getMonthValue();
	    int year = currentDate.getYear();
	    JLabel dayLabel = new JLabel(day+"-" + month+"-"+year);
	    dayLabel.setBounds(737, 73, 84, 45);
	    dayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(dayLabel);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Thêm")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ThemBenhNhan frame = new ThemBenhNhan();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			dispose();
		}
		else if (e.getActionCommand().equals("Sửa")) {
			  int rowIndex = row(); // Giả sử row() trả về chỉ số hàng. Đảm bảo rằng nó không âm.
			  // Kiểm tra xem chỉ số hàng có hợp lệ không
	    	    if (rowIndex < 0 || rowIndex >= data.size()) {
	    	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để chỉnh sửa!", "Thông báo.", JOptionPane.WARNING_MESSAGE);
	    	        return; // Kết thúc phương thức nếu chỉ số hàng không hợp lệ
	    	    }
			
			EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {				
					ChinhSuaThongTin1 frame = new ChinhSuaThongTin1(getMaBN());
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
			dispose();
			
	}
		else if (e.getActionCommand().endsWith("Tìm")) {
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
	

	public int row() {
		int row = table_1.getSelectedRow();
		 return row;
	}

	public int  getMaBN() {
			int dong = table_1.getSelectedRow();
	       Vector<Object> st = (Vector<Object>) data.elementAt(dong);
	       Integer maBN = (int) st.elementAt(0);
	       return maBN;

	}


}

	

