import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ForumDAO {

	private EntityManagerFactory emf;

	public ForumDAO() {
		emf = Persistence.createEntityManagerFactory("");
	}

	public Innlegg finnInnlegg(int innleggid) {

		EntityManager em = emf.createEntityManager();

		try {
			Innlegg innlegg = em.find(Innlegg.class, innleggid);
			return innlegg;
		} finally {
			em.close();
		}
	}

	public List<Kommentar> finnKommentarer(String brukerid, int aarstall) {

		EntityManager em = emf.createEntityManager();

		try {
			TypedQuery<Kommentar> query = em.createQuery("SELECT k FROM Kommentar k"
					+ "WHERE k.bruker.brukerid = :brukerid" + "AND k.tidspunkt.year = :aarstall", Kommentar.class);

			query.setParameter("brukerid", brukerid);
			query.setParameter("aarstall", aarstall);

			return query.getResultList();
		} finally {
			em.close();
		}
	}

	public void slettInnlegg(int innleggid) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Innlegg innlegg = em.find(Innlegg.class, innleggid);

			if (innlegg != null) {
				em.remove(innlegg);
			}

			tx.commit();

		} catch (Throwable e) {
			tx.rollback();
		} finally {
			em.close();
		}
	}
}
