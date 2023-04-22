package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import model.Sanpham;
import model.Size;
import model.SpSize;

public class SPSIZEDAO {
	static EntityManager em = JPAUtils.getEntityManager();

	public static SpSize checkSL(String masp, String masize) {
		try {
			String jpql = "SELECT o FROM SpSize o WHERE o.size.masize = :masize AND o.sanpham.masp = :masp";
			TypedQuery<SpSize> query = em.createQuery(jpql, SpSize.class);
			query.setParameter("masize", masize);
			query.setParameter("masp", masp);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public static SpSize getSPSizeByMaSPmaSize(String masp, String masize) {
		try {
			String jpql = "SELECT o FROM SpSize o WHERE o.size.masize = :masize AND o.sanpham.masp = :masp";
			TypedQuery<SpSize> query = em.createQuery(jpql, SpSize.class);
			query.setParameter("masize", masize);
			query.setParameter("masp", masp);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public static List<SpSize> getAllSPSize() {
		TypedQuery<SpSize> query = em.createNamedQuery("SpSize.findAll", SpSize.class);
		return query.getResultList();
	}

	public static List<SpSize> getSPSizeByMaSP(String masp) {
		String jpql = "SELECT o FROM SpSize o WHERE o.sanpham.masp =:masp";
		TypedQuery<SpSize> query = em.createQuery(jpql, SpSize.class);
		query.setParameter("masp", masp);
		return query.getResultList();
	}

	public static void upadateSPSize(SpSize spsize) {
		try {
			em.getTransaction().begin();
			em.merge(spsize);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public static void insertSPSize(SpSize spsize) {
		try {
			em.getTransaction().begin();
			em.persist(spsize);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
