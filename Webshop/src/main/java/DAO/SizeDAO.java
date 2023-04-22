package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import model.Size;

public class SizeDAO {
static	EntityManager em = JPAUtils.getEntityManager();
	
	
	public static Size getSizeById(String id) {
		return em.find(Size.class,id);
	}
	
	public static List<Size> getAllSize() {
		TypedQuery<Size> query = em.createNamedQuery("Size.findAll", Size.class);
		return query.getResultList();
	}
}
