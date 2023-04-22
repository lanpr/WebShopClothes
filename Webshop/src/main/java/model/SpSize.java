package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SP_SIZE database table.
 * 
 */
@Entity
@Table(name="SP_SIZE",uniqueConstraints = {@UniqueConstraint(columnNames = {"MASP","MASIZE"})})
@NamedQuery(name="SpSize.findAll", query="SELECT s FROM SpSize s")
public class SpSize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="SLCON")
	private int slcon;

	//bi-directional many-to-one association to Sanpham
	@ManyToOne
	@JoinColumn(name="MASP")
	private Sanpham sanpham;

	//bi-directional many-to-one association to Size
	@ManyToOne
	@JoinColumn(name="MASIZE")
	private Size size;

	public SpSize(int slcon, Sanpham sanpham, Size size) {
		super();
		this.slcon = slcon;
		this.sanpham = sanpham;
		this.size = size;
	}

	public SpSize() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSlcon() {
		return this.slcon;
	}

	public void setSlcon(int slcon) {
		this.slcon = slcon;
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