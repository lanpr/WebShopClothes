package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import model.Hinh;
import model.User;

public class UserDAO {
static EntityManager em =  JPAUtils.getEntityManager();
	
	public static void createUser(User u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().getRollbackOnly();
		}
	}
	
	
	public static User findUserById(String username) {
		return em.find(User.class,username);
	}
	
	
	public static List<User> findAllUser() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
}
