package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SANPHAM database table.
 * 
 */
@Entity
@Table(name="SANPHAM")
@NamedQuery(name="Sanpham.findAll", query="SELECT s FROM Sanpham s")
public class Sanpham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MASP")
	private String masp;

	@Column(name="GIABAN")
	private double giaban;

	@Column(name="MOTA")
	private String mota;

	@Column(name="TENSP")
	private String tensp;

	//bi-directional many-to-one association to Hinh
	@OneToMany(mappedBy="sanpham")
	private List<Hinh> hinh;

	//bi-directional many-to-one association to Hoadonct
	@OneToMany(mappedBy="sanpham")
	private List<Hoadonct> hoadoncts;

	//bi-directional many-to-one association to Danhmuc
	@ManyToOne
	@JoinColumn(name="MADANHMUC")
	private Danhmuc danhmuc;

	//bi-directional many-to-one association to SpSize
	@OneToMany(mappedBy="sanpham")
	private List<SpSize> spSize;

	public Sanpham() {
	}

	public Sanpham(String masp, double giaban, String mota, String tensp, List<Hinh> hinh, List<Hoadonct> hoadoncts,
			Danhmuc danhmuc, List<SpSize> spSize) {
		super();
		this.masp = masp;
		this.giaban = giaban;
		this.mota = mota;
		this.tensp = tensp;
		this.hinh = hinh;
		this.hoadoncts = hoadoncts;
		this.danhmuc = danhmuc;
		this.spSize = spSize;
	}

	public String getMasp() {
		return this.masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public double getGiaban() {
		return this.giaban;
	}

	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTensp() {
		return this.tensp;
	}

	public void setTensp(String tensp) {
		this.tensp = tensp;
	}

	public List<Hinh> getHinh() {
		return this.hinh;
	}

	public void setHinh(List<Hinh> hinh) {
		this.hinh = hinh;
	}

	public Hinh addHinh(Hinh hinh) {
		getHinh().add(hinh);
		hinh.setSanpham(this);

		return hinh;
	}

	public Hinh removeHinh(Hinh hinh) {
		getHinh().remove(hinh);
		hinh.setSanpham(null);

		return hinh;
	}

	public List<Hoadonct> getHoadoncts() {
		return this.hoadoncts;
	}

	public void setHoadoncts(List<Hoadonct> hoadoncts) {
		this.hoadoncts = hoadoncts;
	}

	public Hoadonct addHoadonct(Hoadonct hoadonct) {
		getHoadoncts().add(hoadonct);
		hoadonct.setSanpham(this);

		return hoadonct;
	}

	public Hoadonct removeHoadonct(Hoadonct hoadonct) {
		getHoadoncts().remove(hoadonct);
		hoadonct.setSanpham(null);

		return hoadonct;
	}

	public Danhmuc getDanhmuc() {
		return this.danhmuc;
	}

	public void setDanhmuc(Danhmuc danhmuc) {
		this.danhmuc = danhmuc;
	}

	public List<SpSize> getSpSize() {
		return this.spSize;
	}

	public void setSpSize(List<SpSize> spSizes) {
		this.spSize = spSizes;
	}

	public SpSize addSpSize(SpSize spSize) {
		getSpSize().add(spSize);
		spSize.setSanpham(this);

		return spSize;
	}

	public SpSize removeSpSize(SpSize spSize) {
		getSpSize().remove(spSize);
		spSize.setSanpham(null);

		return spSize;
	}

}