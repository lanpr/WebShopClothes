package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMAIL")
	private String email;

	@Column(name="DIACHI")
	private String diachi;

	@Column(name="GIOITINH")
	private boolean gioitinh;

	@Column(name="HOTEN")
	private String hoten;

	@Column(name="MATKHAU")
	private String matkhau;

	@Column(name="NGAYSINH")
	private Date ngaysinh;

	@Column(name="SDT")
	private String sdt;

	@Column(name="VAITRO")
	private boolean vaitro;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="user")
	private List<Hoadon> hoadons;

	public User() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return this.diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public boolean getGioitinh() {
		return this.gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getHoten() {
		return this.hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getMatkhau() {
		return this.matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public Date getNgaysinh() {
		return this.ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getSdt() {
		return this.sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public boolean getVaitro() {
		return this.vaitro;
	}

	public void setVaitro(boolean vaitro) {
		this.vaitro = vaitro;
	}

	public List<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	public Hoadon addHoadon(Hoadon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setUser(this);

		return hoadon;
	}

	public Hoadon removeHoadon(Hoadon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setUser(null);

		return hoadon;
	}

}