package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DANHMUC database table.
 * 
 */
@Entity
@Table(name="DANHMUC")
@NamedQuery(name="Danhmuc.findAll", query="SELECT d FROM Danhmuc d")
public class Danhmuc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MADANHMUC")
	private String madanhmuc;

	@Column(name="TENDANHMUC")
	private String tendanhmuc;

	//bi-directional many-to-one association to Sanpham
	@OneToMany(mappedBy="danhmuc")
	private List<Sanpham> sanphams;

	public Danhmuc() {
	}

	public String getMadanhmuc() {
		return this.madanhmuc;
	}

	public void setMadanhmuc(String madanhmuc) {
		this.madanhmuc = madanhmuc;
	}

	public String getTendanhmuc() {
		return this.tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	public List<Sanpham> getSanphams() {
		return this.sanphams;
	}

	public void setSanphams(List<Sanpham> sanphams) {
		this.sanphams = sanphams;
	}

	public Sanpham addSanpham(Sanpham sanpham) {
		getSanphams().add(sanpham);
		sanpham.setDanhmuc(this);

		return sanpham;
	}

	public Sanpham removeSanpham(Sanpham sanpham) {
		getSanphams().remove(sanpham);
		sanpham.setDanhmuc(null);

		return sanpham;
	}
	
	
	@Override
	public String toString() {
		return this.getTendanhmuc();
	}

}