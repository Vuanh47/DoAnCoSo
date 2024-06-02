package main;

import java.awt.EventQueue;

import view.DangNhap;

public class main {
public static void main(String[] args) {
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
}
}
