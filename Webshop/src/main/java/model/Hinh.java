package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HINH database table.
 * 
 */
@Entity
@Table(name="HINH")
@NamedQuery(name="Hinh.findAll", query="SELECT h FROM Hinh h")
public class Hinh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="TENHINH")
	private String tenhinh;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne
	@JoinColumn(name="MASP")
	private Sanpham sanpham;

	public Hinh() {
	}

	public Hinh( String tenhinh, Sanpham sanpham) {
		this.tenhinh = tenhinh;
		this.sanpham = sanpham;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenhinh() {
		return this.tenhinh;
	}

	public void setTenhinh(String tenhinh) {
		this.tenhinh = tenhinh;
	}

	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

}