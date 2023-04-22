package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	static EntityManagerFactory emf;

	public static EntityManager getEntityManager() {
		if (emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory("JAVA4_ASM");
		}
		EntityManager em = emf.createEntityManager();
		return em;
	}

	public static void close() {
		if (emf != null || emf.isOpen()) {
			emf.close();
		}
		emf = null;

	}
}
