package model;

import DAO.SanPhamDAO;
import DAO.SizeDAO;

public class CartSanPham {
	private String maSP;
	private String tenSP;
	private String hinh;
	private int sl;
	private String size;
	
	
	public CartSanPham(String maSP, String tenSP, String hinh, int sl, String size) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.hinh = hinh;
		this.sl = sl;
		this.size = size;
	}
	

	public CartSanPham() {
		super();
	}


	public String getMaSP() {
		return maSP;
	}


	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}


	public String getTenSP() {
		return tenSP;
	}


	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}


	public String getHinh() {
		return hinh;
	}


	public void setHinh(String hinh) {
		this.hinh = hinh;
	}


	public int getSl() {
		return sl;
	}


	public void setSl(int sl) {
		this.sl = sl;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
	
	public String getTensize() {
		Size size = SizeDAO.getSizeById(this.size);
		return size.getTensize();
	}
	
	public Double getTongtien() {
		Sanpham sp  = SanPhamDAO.findSanPhamByID(this.getMaSP());
		return sl*sp.getGiaban();
	}
	
	public Double getGiaban() {
		Sanpham sp  = SanPhamDAO.findSanPhamByID(this.getMaSP());
		return sp.getGiaban();
	}
	
	
	
	
}
