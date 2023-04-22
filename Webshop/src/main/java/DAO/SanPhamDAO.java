package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;



import Utils.JPAUtils;
import model.Sanpham;

public class SanPhamDAO {
	static EntityManager em = JPAUtils.getEntityManager();

	public static List<Sanpham> getAllSanPham() {
		TypedQuery<Sanpham> query = em.createNamedQuery("Sanpham.findAll", Sanpham.class);
		return query.getResultList();
	}
	
	
	public static List<Sanpham> getAllByPage(int page) {
		TypedQuery<Sanpham> query = em.createNamedQuery("Sanpham.findAll", Sanpham.class);
		query.setFirstResult(page*6);
		query.setMaxResults(6);
		return query.getResultList();
	}

	public static List<Sanpham> finbyDM(String maDM) {
		String jpql = "SELECT o FROM Sanpham o WHERE o.danhmuc.madanhmuc = :madanhmuc";
		TypedQuery<Sanpham> query = em.createQuery(jpql, Sanpham.class);
		query.setParameter("madanhmuc", maDM);
		return query.getResultList();
	}

	public static Sanpham findSanPhamByID(String maSP) {
		return em.find(Sanpham.class, maSP);
	}

	public static void insertSP(Sanpham sp) {
		try {
			em.getTransaction().begin();
			em.persist(sp);

			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().getRollbackOnly();

		}
	}

	public static void updateSP(Sanpham sp) {
		try {
			em.getTransaction().begin();
			em.merge(sp);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().getRollbackOnly();

		}
	}

	public static List<Sanpham> findByDMGiaSapXep(String madm, int khoangGia, int sapXep) {
		String jpql = "SP_FINDM";
		try {
			System.out.println("madanhmuc "+ madm);
				if(madm==null) {
					madm = "";
				}
			StoredProcedureQuery query = em.createStoredProcedureQuery(jpql, Sanpham.class);
			
			query.registerStoredProcedureParameter("MADM", String.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("KHOANGGIA", Integer.class, ParameterMode.IN);
			query.registerStoredProcedureParameter("SAPXEP", Integer.class, ParameterMode.IN);
			query.setParameter("MADM", madm);
			query.setParameter("KHOANGGIA", khoangGia);
			query.setParameter("SAPXEP", sapXep);
			return query.getResultList();

		} catch (Exception e) {
			System.out.println(e);
			em.getTransaction().getRollbackOnly();

		}
		return null;
	}

}
