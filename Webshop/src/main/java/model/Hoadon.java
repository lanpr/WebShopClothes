package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOADON database table.
 * 
 */
@Entity
@Table(name="HOADON")
@NamedQuery(name="Hoadon.findAll", query="SELECT h FROM Hoadon h")
public class Hoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MAHD")
	private int mahd;

	@Column(name="HINHTHUCTT")
	private boolean hinhthuctt;

	@Column(name="NGAYDAT")
	@Temporal(TemporalType.DATE)
	private Date ngaydat;

	//bi-directional many-to-one association to Trangthai
	@ManyToOne
	@JoinColumn(name="MATT")
	private Trangthai trangthai;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="EMAIL")
	private User user;

	//bi-directional many-to-one association to Hoadonct
	@OneToMany(mappedBy="hoadon")
	private List<Hoadonct> hoadoncts;

	public Hoadon() {
	}

	public int getMahd() {
		return this.mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public boolean getHinhthuctt() {
		return this.hinhthuctt;
	}

	public void setHinhthuctt(boolean hinhthuctt) {
		this.hinhthuctt = hinhthuctt;
	}

	public Date getNgaydat() {
		return this.ngaydat;
	}

	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public Trangthai getTrangthai() {
		return this.trangthai;
	}

	public void setTrangthai(Trangthai trangthai) {
		this.trangthai = trangthai;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Hoadonct> getHoadoncts() {
		return this.hoadoncts;
	}

	public void setHoadoncts(List<Hoadonct> hoadoncts) {
		this.hoadoncts = hoadoncts;
	}

	public Hoadonct addHoadonct(Hoadonct hoadonct) {
		getHoadoncts().add(hoadonct);
		hoadonct.setHoadon(this);

		return hoadonct;
	}

	public Hoadonct removeHoadonct(Hoadonct hoadonct) {
		getHoadoncts().remove(hoadonct);
		hoadonct.setHoadon(null);

		return hoadonct;
	}

}