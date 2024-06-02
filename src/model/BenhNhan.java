package model;


import java.sql.Date;
import java.util.List;

public class BenhNhan {

    private int maBenhNhan;
    private String hoTen;
    private String ngayKham;
    private String gioiTinh;
    private Double vienPhi;
    private int soPhong;
    private String chuanDoan;
    private String BHYT;
    
	public BenhNhan(int maBenhNhan, String hoTen, String ngayKham, String gioiTinh, double vienPhi, int soPhong,
			String chuanDoan, String bHYT) {
		super();
		this.maBenhNhan = maBenhNhan;
		this.hoTen = hoTen;
		this.ngayKham = ngayKham;
		this.gioiTinh = gioiTinh;
		this.vienPhi = vienPhi;
		this.soPhong = soPhong;
		this.chuanDoan = chuanDoan;
		BHYT = bHYT;
	}

	public BenhNhan() {
		// TODO Auto-generated constructor stub
	}

	public BenhNhan( String hoTen, String ngayKham, String gioiTinh, double vienPhi, int soPhong,
			String chuanDoan, String bHYT,int maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
		this.hoTen = hoTen;
		this.ngayKham = ngayKham;
		this.gioiTinh = gioiTinh;
		this.vienPhi = vienPhi;
		this.soPhong = soPhong;
		this.chuanDoan = chuanDoan;
		BHYT = bHYT;
	}

	public int getMaBenhNhan() {
		return maBenhNhan;
	}

	public void setMaBenhNhan(int maBenhNhan) {
		this.maBenhNhan = maBenhNhan;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgayKham() {
		return ngayKham;
	}

	public void setNgayKham(String ngayKham) {
		this.ngayKham = ngayKham;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Double getVienPhi() {
		return vienPhi;
	}

	public void setVienPhi(Double vienPhi) {
		this.vienPhi = vienPhi;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public String getChuanDoan() {
		return chuanDoan;
	}

	public void setChuanDoan(String chuanDoan) {
		this.chuanDoan = chuanDoan;
	}

	public String getBHYT() {
		return BHYT;
	}

	public void setBHYT(String bHYT) {
		BHYT = bHYT;
	}
 

    


    
	



}