package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import DATABASE.DatabaseConnector;
import model.ACC;
import model.Admin;
import model.User;

public class DangNhap extends JFrame implements MouseListener {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_username;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                DangNhap frame = new DangNhap();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DangNhap() {
        setTitle("Đăng Nhập");
        setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhap.class.getResource("/Image/avt.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 701, 421);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        initUI();
    }

    private void initUI() {
        JLabel lblUsername = new JLabel("Tên Đăng Nhập");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(365, 169, 124, 24);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Mật Khẩu");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(385, 204, 81, 24);
        contentPane.add(lblPassword);

        textField_username = new JTextField();
        textField_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField_username.setBounds(479, 170, 166, 22);
        contentPane.add(textField_username);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordField.setBounds(479, 210, 166, 20);
        contentPane.add(passwordField);

        JButton btnLogin = new JButton("Đăng Nhập");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(123, 104, 238));
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.setBounds(430, 290, 205, 30);
        contentPane.add(btnLogin);
        btnLogin.addActionListener(e -> {
        	 
            	  loginAdmin();
              
        });

        JCheckBox showPasswordCheckBox = new JCheckBox("Hiển Thị Mật Khẩu");
        showPasswordCheckBox.setBackground(new Color(248, 248, 255));
        showPasswordCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        showPasswordCheckBox.setBounds(459, 257, 130, 20);
        showPasswordCheckBox.addItemListener(this::togglePasswordVisibility);
        contentPane.add(showPasswordCheckBox);

        JLabel lblWelcomeIcon = new JLabel(new ImageIcon(DangNhap.class.getResource("/Image/bv1.png")));
        lblWelcomeIcon.setBounds(486, -3, 124, 113);
        contentPane.add(lblWelcomeIcon);

        JLabel lblWelcome = new JLabel("Welcome ");
        lblWelcome.setForeground(Color.BLACK);
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblWelcome.setBounds(469, 101, 120, 30);
        contentPane.add(lblWelcome);

        JLabel lblBanner = new JLabel(new ImageIcon(DangNhap.class.getResource("/Image/temp.png")));
        lblBanner.setBounds(10, 9, 365, 355);
        contentPane.add(lblBanner);

        JLabel lblForgotPassword = new JLabel("Quên Mật Khẩu?");
        lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblForgotPassword.setBounds(533, 331, 130, 24);
        lblForgotPassword.addMouseListener(this);
        contentPane.add(lblForgotPassword);

        JLabel lblRegister = new JLabel("Đăng Kí Tài Khoản");
        lblRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblRegister.setBounds(393, 331, 130, 24);
        lblRegister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EventQueue.invokeLater(() -> {
                    try {
                        DangKiGmail frame = new DangKiGmail();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                dispose();
            }
        });
        contentPane.add(lblRegister);
    }

    private void loginAdmin() {
        DatabaseConnector connector = null;
        String username = textField_username.getText();
        String password = new String(passwordField.getPassword());

        User tk = new User();
        tk.setHoTen(username);
        tk.setMatKhau(password);

        try {
            connector = new DatabaseConnector("jdbc:mysql://localhost:3306/quanlybenhnhan", "root", "1234");
            boolean kq = connector.LoginUser(tk);

            if (kq) {
                JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công!");
                 EventQueue.invokeLater(() -> {
                    try {
                        TrangChuAdmin frame = new TrangChuAdmin();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                
                ACC account = new ACC(username, password);
                CaNhan.receiverInfor(account);
                DoiMatKhau.receiverInfor(account);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Đăng nhập thất bại!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void togglePasswordVisibility(ItemEvent e) {
        passwordField.setEchoChar(e.getStateChange() == ItemEvent.SELECTED ? (char) 0 : '\u2022');
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JLabel) {
            JLabel label = (JLabel) e.getSource();
            if ("Quên Mật Khẩu?".equals(label.getText())) {
                EventQueue.invokeLater(() -> {
                    try {
                        QuenMatKhau frame = new QuenMatKhau();
                        frame.setLocationRelativeTo(null);
                        frame.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                dispose();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
