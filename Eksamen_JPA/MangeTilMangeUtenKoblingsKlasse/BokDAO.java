import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class BokDAO {

	private EntityManagerFactory emf;

	public BokDAO() {
		emf = Persistence.createEntityManagerFactory("");
	}

	public List<Bok> finnBokerUtgittIAar(int aar) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Bok> query = em.createQuery("SELECT b FROM Bok b WHERE b.aar = :aar", Bok.class);
			query.setParameter("aar", aar);
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public List<Bok> finnBokerMedForfatter(String fornavn, String etternavn) {
		EntityManager em = emf.createEntityManager();
		try {
			TypedQuery<Bok> query = em.createQuery("SELECT b FROM Bok b JOIN b.forfattere f "
					+ "WHERE f.fornavn = :fornavn AND f.etternavn = :etternavn", Bok.class);
			query.setParameter("fornavn", fornavn);
			query.setParameter("etternavn", etternavn);
			return query.getResultList();
		} finally {
			em.close();
		}
	}
}
