package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DATABASE.DatabaseConnector;
import model.BenhNhan;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class TrangChuAdmin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_hoTen;
	private JTextField textField_MaBN;
	private JTextField textField_SoPhong;
	 Vector<String> columnNames = new Vector<>();
     Vector<Vector<Object>> data = new Vector<>();
	private JTable table_1;
	DefaultTableModel model;
	private ResultSet resultSet;

	
	public TrangChuAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChuAdmin.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 498);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDanhSach = new JButton("Danh Sách");
		btnDanhSach.setBounds(15, 108, 183, 51);
		btnDanhSach.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/list.png")));
		btnDanhSach.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDanhSach.setBackground(SystemColor.text);
		contentPane.add(btnDanhSach);
		btnDanhSach.addActionListener(this);
	
		JButton buttonThemBN = new JButton("Thêm Bệnh Nhân");
		buttonThemBN.setBounds(15, 194, 183, 51);
		buttonThemBN.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/them.png")));
		buttonThemBN.setBackground(SystemColor.text);
		buttonThemBN.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(buttonThemBN);
		buttonThemBN.addActionListener(this);

		JButton btnNewButton_CaNhan = new JButton("Tài Khoản");
		btnNewButton_CaNhan.setBounds(15, 369, 183, 51);
		btnNewButton_CaNhan.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/user.png")));
		btnNewButton_CaNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_CaNhan.setBackground(SystemColor.text);
		contentPane.add(btnNewButton_CaNhan);
		btnNewButton_CaNhan.addActionListener(this);
		
		JButton btnNewButton_VienPhi = new JButton("Viện Phí");
		btnNewButton_VienPhi.setBounds(15, 279, 183, 51);
		btnNewButton_VienPhi.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/bill.png")));
		btnNewButton_VienPhi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_VienPhi.setBackground(SystemColor.text);
		contentPane.add(btnNewButton_VienPhi);
		btnNewButton_VienPhi.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Trang Chủ Bệnh Viện");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(243, 7, 476, 73);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lý Bệnh Nhân");
		lblNewLabel_1.setBackground(new Color(102, 102, 255));
		lblNewLabel_1.setBounds(10, 11, 186, 86);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/tk.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_DangXuat = new JButton("Đăng Xuất");
		btnNewButton_DangXuat.setBounds(751, 27, 95, 33);
		btnNewButton_DangXuat.setForeground(new Color(0, 0, 0));
		btnNewButton_DangXuat.setBackground(new Color(255, 250, 250));
		btnNewButton_DangXuat.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(btnNewButton_DangXuat);
		btnNewButton_DangXuat.addActionListener(this) ;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 210, 459);
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel);
				
		JLabel lblNewLabel_2 = new JLabel("Họ Tên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(243, 110, 122, 47);
		contentPane.add(lblNewLabel_2);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setBounds(352, 122, 148, 20);
		contentPane.add(textField_hoTen);
		textField_hoTen.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã Bệnh Nhân:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(243, 168, 107, 47);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Số Phòng:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_2.setBounds(243, 226, 107, 47);
		contentPane.add(lblNewLabel_2_2);
		
		textField_MaBN = new JTextField();
		textField_MaBN.setBounds(352, 180, 148, 20);
		contentPane.add(textField_MaBN);
		textField_MaBN.setColumns(10);
		
		textField_SoPhong = new JTextField();
		textField_SoPhong.setColumns(10);
		textField_SoPhong.setBounds(352, 240, 148, 20);
		contentPane.add(textField_SoPhong);
		
		JButton btnNewButton_TimKiem = new JButton("");
		btnNewButton_TimKiem.setBackground(Color.white);
		btnNewButton_TimKiem.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/tim.png")));
		btnNewButton_TimKiem.setBounds(567, 137, 76, 33);
		contentPane.add(btnNewButton_TimKiem);
		btnNewButton_TimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(!textField_hoTen.getText().isEmpty()) {
						TimKiemtenBN();;
					}else if (!textField_MaBN.getText().isEmpty()) {
						TimKiemMBN();
					}else if (!textField_SoPhong.getText().isEmpty()) {
						TimKiemSoPhong();
					}
			
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	
		
		JButton btnNewButton_Huy = new JButton("");
		btnNewButton_Huy.setBackground(Color.white);
		btnNewButton_Huy.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/huy.png")));
		btnNewButton_Huy.setBounds(567, 198, 76, 33);
		contentPane.add(btnNewButton_Huy);
		btnNewButton_Huy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_hoTen.setText("");
				textField_MaBN.setText("");
				textField_SoPhong.setText("");
				  refreshTable();
			}

			
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 0, 153));
		panel_1.setBounds(210, 0, 658, 80);
		contentPane.add(panel_1);
		
		try {
	            // Kết nối với MySQL
	        	  DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	              resultSet = connector.getConnection().createStatement().executeQuery("SELECT * FROM benhnhan");

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
		scrollPane.setBounds(220, 297, 638, 151);
		contentPane.add(scrollPane);
		table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
		model = new DefaultTableModel(data, columnNames);
		table_1.setModel(model);
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TrangChuAdmin.class.getResource("/Image/boyte.png")));
		lblNewLabel_3.setBounds(659, 94, 187, 192);
		contentPane.add(lblNewLabel_3);

	}
	public void TimKiemMBN() throws Exception {
		DatabaseConnector conn = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	    try {
	      
	       int maBN = Integer.valueOf(textField_MaBN.getText());
	       BenhNhan bn = new BenhNhan();
	       bn.setMaBenhNhan(maBN);
	       resultSet = conn.timKiemMaBN(bn);	    
			 try {
		            
				 	 model.setRowCount(0); // xóa dữ liệu
				 	 int columns = resultSet.getMetaData().getColumnCount();
			            for (int i = 1; i <= columns; i++) {
			                columnNames.add(resultSet.getMetaData().getColumnName(i));
			            }
			            Vector<Object> row = new Vector<>(columns);
			            for (int i = 1; i <= columns; i++) {
			                row.addElement(resultSet.getObject(i));
			            }
			            data.addElement(row);	
			            conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	       
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (conn != null) {
	            conn.close(); // Đảm bảo đóng kết nối sau khi sử dụng
	        }
	    }
	}
	
	public void TimKiemtenBN() throws Exception {
	    DatabaseConnector connector = null;
	    try {
	    	connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	        String ten = textField_hoTen.getText();
	        BenhNhan bn = new BenhNhan();
	        bn.setHoTen(ten);
	        
	        resultSet= connector.timKiemhoTenBN(bn);
	        try {
		            // Kết nối với MySQL
				 	model.setRowCount(0);
		            int columns = resultSet.getMetaData().getColumnCount();
		            for (int i = 1; i <= columns; i++) {
		                columnNames.add(resultSet.getMetaData().getColumnName(i));
		            }
		            Vector<Object> row = new Vector<>(columns);
		            for (int i = 1; i <= columns; i++) {
		                 row.addElement(resultSet.getObject(i));
		            }
		            data.addElement(row);
		           connector.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			 
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (connector != null) {
	            connector.close(); // Đảm bảo đóng kết nối sau khi sử dụng
	        }
	    }
	}
	
	 public void refreshTable() {
	        // Xóa tất cả các dòng hiện tại trong bảng
			model.setRowCount(0);
			try {
	            // Kết nối với MySQL
	        	  DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	              resultSet = connector.getConnection().createStatement().executeQuery("SELECT * FROM benhnhan");

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
	       

	        // Thông báo cho bảng biết để cập nhật giao diện
	        model.fireTableDataChanged();
	    }

	public void TimKiemSoPhong() throws Exception {
	    DatabaseConnector connector = null;
	    try {
	        connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	        int soPhong = Integer.valueOf(textField_SoPhong.getText());
	        BenhNhan bn = new BenhNhan();
	        bn.setSoPhong(soPhong);
	        ResultSet rs = connector.timKiemSoPhong(bn);
	       try {
	            model.setRowCount(0); // Xóa tất cả các hàng hiện tại trong model
	            if (rs != null) {
	                int columns = rs.getMetaData().getColumnCount();
	                for (int i = 1; i <= columns; i++) {
	                    columnNames.add(rs.getMetaData().getColumnName(i));
	                }
	                
	                while (rs.next()) {
	                    Vector<Object> row = new Vector<>(columns);
	                    for (int i = 1; i <= columns; i++) {
	                        row.addElement(rs.getObject(i));
	                    }
	                    data.addElement(row);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Không tìm thấy bệnh nhân nào có số phòng này!", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            connector.close();
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (connector != null) {
	            connector.close(); // Đảm bảo đóng kết nối sau khi sử dụng
	        }
	    }
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Danh Sách")) {
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
		
		else if (e.getActionCommand().equals("Thêm Bệnh Nhân")) {
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
		else if (e.getActionCommand().equals("Tài Khoản")) {
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
		else if (e.getActionCommand().equals("Viện Phí")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ThanhToan frame = new ThanhToan();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			dispose();
		}else if (e.getActionCommand().equals("Đăng Xuất")) {
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
		
	}
}
