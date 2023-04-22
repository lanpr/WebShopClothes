package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HOADONCT database table.
 * 
 */
@Entity
@Table(name="HOADONCT")
@NamedQuery(name="Hoadonct.findAll", query="SELECT h FROM Hoadonct h")
public class Hoadonct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="GIA")
	private double gia;

	@Column(name="SLMUA")
	private int slmua;

	//bi-directional many-to-one association to Hoadon
	@ManyToOne
	@JoinColumn(name="MAHD")
	private Hoadon hoadon;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne
	@JoinColumn(name="MASP")
	private Sanpham sanpham;

	//bi-directional many-to-one association to Size
	@ManyToOne
	@JoinColumn(name="MASIZE")
	private Size size;

	public Hoadonct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getGia() {
		return this.gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSlmua() {
		return this.slmua;
	}

	public void setSlmua(int slmua) {
		this.slmua = slmua;
	}

	public Hoadon getHoadon() {
		return this.hoadon;
	}

	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}

	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

	public Size getSize() {
		return this.size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

}