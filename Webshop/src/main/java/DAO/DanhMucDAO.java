package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import model.Danhmuc;

public class DanhMucDAO {
	static EntityManager em = JPAUtils.getEntityManager();

	public static List<Danhmuc> findAll() {
		TypedQuery<Danhmuc> query = em.createNamedQuery("Danhmuc.findAll", Danhmuc.class);
		return query.getResultList();
	}

	public static Danhmuc findByID(String madanhmuc) {
		return em.find(Danhmuc.class, madanhmuc);
	}

}
