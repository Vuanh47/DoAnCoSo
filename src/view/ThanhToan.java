package view;
import javax.swing.text.*;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.JTextArea;
import java.awt.Toolkit;

public class ThanhToan extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	Vector<String> columnNames = new Vector<>();
	Vector<Vector<Object>> data = new Vector<>();
	DefaultTableModel model;
	private JTable table_1;
	private JTextArea bill;
	private LocalDate currentDate;


	public static void main(String[] args) {
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
	}
	public ThanhToan() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ThanhToan.class.getResource("/Image/avt.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thanh Toán Viện Phí");
		lblNewLabel.setBounds(300, 11, 400, 57);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JButton button_TrangChu = new JButton("");
		button_TrangChu.setBounds(23, 23, 84, 38);
		button_TrangChu.setIcon(new ImageIcon(ThanhToan.class.getResource("/Image/hom.png")));
		button_TrangChu.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_TrangChu.setBackground(SystemColor.text);
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
		
		
		
		textField = new JTextField();
		textField.setBounds(233, 104, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);


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
        scrollPane.setBounds(10, 155, 585, 231);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
		model = new DefaultTableModel(data, columnNames);
		table_1.setModel(model);

		
		JLabel lblNewLabel_1 = new JLabel("Mã Bệnh Nhân:");
		lblNewLabel_1.setBounds(85, 96, 127, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButtonTim = new JButton("");
		btnNewButtonTim.setBounds(454, 103, 61, 33);
		btnNewButtonTim.setBackground(new Color(255, 255, 255));
		btnNewButtonTim.setIcon(new ImageIcon(ThanhToan.class.getResource("/Image/tim.png")));
		contentPane.add(btnNewButtonTim);
		btnNewButtonTim.addActionListener(new ActionListener() {
			public void TimKiemMBN() throws Exception {
			    DatabaseConnector connector = null;
			    try {
				    connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
			        int maBN = Integer.valueOf(textField.getText());
			        BenhNhan bn = new BenhNhan();
			        bn.setMaBenhNhan(maBN);
			        
			        ResultSet rs = connector.timKiemMaBN(bn);
			       try {
				            // Kết nối với MySQL
						 	model.setRowCount(0);
				            int columns = rs.getMetaData().getColumnCount();
				            for (int i = 1; i <= columns; i++) {
				                columnNames.add(rs.getMetaData().getColumnName(i));
				            }
				            	Vector<Object> row = new Vector<>(columns);
				                for (int i = 1; i <= columns; i++) {
				                    row.addElement(rs.getObject(i));
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
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					TimKiemMBN();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 878, 78);
		panel.setBackground(new Color(102, 0, 153));
		contentPane.add(panel);
		
		JButton buttonThanhToan = new JButton("Thanh Toán");
		buttonThanhToan.setBounds(238, 409, 139, 44);
		buttonThanhToan.setBackground(new Color(102, 0, 153));
		buttonThanhToan.setForeground(new Color(255, 255, 255));
		buttonThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(buttonThanhToan);
		buttonThanhToan.addActionListener(this);
		
	      bill = new JTextArea();
		  bill.setBounds(610, 96, 240, 260);
		  contentPane.add(bill);
		  bill.setEditable(false); // Để ngăn người dùng chỉnh sửa văn bản

		  	 currentDate = LocalDate.now();
	        int day = currentDate.getDayOfMonth();
	        int month = currentDate.getMonthValue();
	        int year = currentDate.getYear();
	        JLabel dayLabel = new JLabel(day+"-" + month+"-"+year);
	        dayLabel.setBounds(794, 432, 74, 33);
	        dayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			contentPane.add(dayLabel);
			
			
			
			JButton btnNewButton = new JButton("Xác Nhận");
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setBackground(new Color(102, 0, 153));
			btnNewButton.setBounds(681, 386, 109, 38);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
			contentPane.add(btnNewButton);
			btnNewButton.addActionListener(this);
	}

	public void xoa() {
	    try {
	    	DatabaseConnector connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
	    	// Lấy nội dung hàng đã chọn từ Vector data
	        Vector<Object> st = (Vector<Object>) data.elementAt(selectedrow);
	        connector.xoaData(st.elementAt(0));
		    // Xóa nội dung hàng tương ứng từ Vector data
	        data.remove(row());
	        // Cập nhật nội dung trên bảng
	        model.fireTableDataChanged();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private Object frame;
	private int selectedrow;
	
	public int row() {
		int row = table_1.getSelectedRow();
		 return row;
	}
	
	
	public void bill() {
		
		  int rowIndex = row(); // Giả sử row() trả về chỉ số hàng. Đảm bảo rằng nó không âm.

		    // Kiểm tra xem chỉ số hàng có hợp lệ không
		    if (rowIndex < 0 || rowIndex >= data.size()) {
		        JOptionPane.showMessageDialog(null, "Vui lòng chọn hàng để in hóa đơn!", "Thông báo", JOptionPane.WARNING_MESSAGE);
		        return; // Kết thúc phương thức nếu chỉ số hàng không hợp lệ
		    }

		    
			Vector<Object> row = (Vector<Object>)data.elementAt(row());
		     // Create a JTextArea
	   
	        bill.setEditable(false);

	        // Create the bill content
	        StringBuilder content = new StringBuilder();
	        content.append("          Trung tâm chăm sóc sức khỏe\n");
	        content.append("\t PHÚC AN\n\n");
	        content.append("          Hóa đơn thanh toán viện phí\n");
	        content.append("----------------------------------------------------------\n");
	        content.append("\t\t" + currentDate + "\n\n");
	        content.append("Họ Tên:       " + row.elementAt(1) + "\n");
	        content.append("Mã Bệnh Nhân: " + row.elementAt(0) + "\n");
	        content.append("Giới Tính:    " + row.elementAt(3) + "\n");
	        content.append("Ngày Khám:    " + row.elementAt(2) + "\n");
	        content.append("Số Phòng:     " + row.elementAt(5) + "\n");
	        content.append("Bảo Hiểm Y Tế: " + row.elementAt(7) + "\n");
	        content.append("Chuẩn Đoán:   " + row.elementAt(6) + "\n");
	        content.append("----------------------------------------------------------\n");
	        content.append("Viện Phí: " + row.elementAt(4) + "\n");

	        // Set the content to the JTextArea
	        bill.setText(content.toString());
	}
	public void xacnhan() {
		int choice = JOptionPane.showOptionDialog((Component) frame,
                "Bạn có chắc chắn muốn Thanh toán không?",
                "Xác Nhận",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Đồng Ý", "Hủy"},
                "Đồng Ý");
				try {
					bill.print();
				} catch (PrinterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        if (choice == JOptionPane.YES_OPTION) {
        	xoa();
            JOptionPane.showMessageDialog((Component) frame, "Thanh toán thành công!");
            xacnhan1();
            
        } else if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog((Component) frame, "Bạn đã chọn Hủy!", "Thông báo.", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	private boolean paymentCompleted = false;

	
	public void actionPerformed(ActionEvent e) {
	    if (e.getActionCommand().equals("Thanh Toán")) {
	        bill();
	        paymentCompleted = true; // Đánh dấu thanh toán đã được thực hiện
	    } else if (e.getActionCommand().equals("Xác Nhận") && paymentCompleted) {
	        xacnhan(); // Thực hiện chức năng của nút "Xác Nhận" chỉ khi thanh toán đã được thực hiện
	        bill.setText(null);
	        paymentCompleted = false;
	    }
	}
	
	 private void xacnhan1() {
	        // Lưu hóa đơn vào file text
	        String paymentContent = bill.getText(); // Nội dung hóa đơn

	        try {
	            FileWriter fileWriter = new FileWriter("hoadon.txt");
	            PrintWriter printWriter = new PrintWriter(fileWriter);
	            printWriter.println(paymentContent);
	            printWriter.close();
	            System.out.println("Hóa đơn đã được lưu vào file hoadon.txt");
	        } catch (IOException ex) {
	            System.err.println("Lỗi khi ghi vào file hoadon.txt: " + ex.getMessage());
	        }
	    }
	 
	public int  getMaBN() {
		int dong = table_1.getSelectedRow();
       Vector<Object> st = (Vector<Object>) data.elementAt(dong);
       Integer maBN = (int) st.elementAt(0);
       return maBN;

	}

}
