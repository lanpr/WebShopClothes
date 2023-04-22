package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the [SIZE] database table.
 * 
 */
@Entity
@Table(name="[SIZE]")
@NamedQuery(name="Size.findAll", query="SELECT s FROM Size s")
public class Size implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MASIZE")
	private String masize;

	@Column(name="TENSIZE")
	private String tensize;

	//bi-directional many-to-one association to Hoadonct
	@OneToMany(mappedBy="size")
	private List<Hoadonct> hoadoncts;

	//bi-directional many-to-one association to SpSize
	@OneToMany(mappedBy="size")
	private List<SpSize> spSizes;

	public Size() {
	}

	public String getMasize() {
		return this.masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getTensize() {
		return this.tensize;
	}

	public void setTensize(String tensize) {
		this.tensize = tensize;
	}

	public List<Hoadonct> getHoadoncts() {
		return this.hoadoncts;
	}

	public void setHoadoncts(List<Hoadonct> hoadoncts) {
		this.hoadoncts = hoadoncts;
	}

	public Hoadonct addHoadonct(Hoadonct hoadonct) {
		getHoadoncts().add(hoadonct);
		hoadonct.setSize(this);

		return hoadonct;
	}

	public Hoadonct removeHoadonct(Hoadonct hoadonct) {
		getHoadoncts().remove(hoadonct);
		hoadonct.setSize(null);

		return hoadonct;
	}

	public List<SpSize> getSpSizes() {
		return this.spSizes;
	}

	public void setSpSizes(List<SpSize> spSizes) {
		this.spSizes = spSizes;
	}

	public SpSize addSpSize(SpSize spSize) {
		getSpSizes().add(spSize);
		spSize.setSize(this);

		return spSize;
	}

	public SpSize removeSpSize(SpSize spSize) {
		getSpSizes().remove(spSize);
		spSize.setSize(null);

		return spSize;
	}

}