package model;

public class User {
	
	String HoTen;
	String matKhau;
	int NamSinh;
	String GioiTinh;
	String sdt ;
	String mail;
	
	public User(String hoTen, String matKhau, int namSinh, String gioiTinh, String sdt, String mail) {
		super();
		HoTen = hoTen;
		this.matKhau = matKhau;
		NamSinh = namSinh;
		GioiTinh = gioiTinh;
		this.sdt = sdt;
		this.mail = mail;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(int namSinh) {
		NamSinh = namSinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


}
