package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TRANGTHAI database table.
 * 
 */
@Entity
@Table(name="TRANGTHAI")
@NamedQuery(name="Trangthai.findAll", query="SELECT t FROM Trangthai t")
public class Trangthai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MATT")
	private String matt;

	@Column(name="TENTT")
	private String tentt;

	//bi-directional many-to-one association to Hoadon
	@OneToMany(mappedBy="trangthai")
	private List<Hoadon> hoadons;

	public Trangthai() {
	}

	public String getMatt() {
		return this.matt;
	}

	public void setMatt(String matt) {
		this.matt = matt;
	}

	public String getTentt() {
		return this.tentt;
	}

	public void setTentt(String tentt) {
		this.tentt = tentt;
	}

	public List<Hoadon> getHoadons() {
		return this.hoadons;
	}

	public void setHoadons(List<Hoadon> hoadons) {
		this.hoadons = hoadons;
	}

	public Hoadon addHoadon(Hoadon hoadon) {
		getHoadons().add(hoadon);
		hoadon.setTrangthai(this);

		return hoadon;
	}

	public Hoadon removeHoadon(Hoadon hoadon) {
		getHoadons().remove(hoadon);
		hoadon.setTrangthai(null);

		return hoadon;
	}

}