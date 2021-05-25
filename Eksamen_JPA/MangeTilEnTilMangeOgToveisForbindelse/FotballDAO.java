import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FotballDAO {
	private EntityManagerFactory emf;

	public FotballDAO() {
		emf = Persistence.createEntityManagerFactory("");
	}

	public void lagreResultat(int kampid, int hjemmemaal, int bortemaal) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			Kamp kamp = em.find(Kamp.class, kampid);
			if (kamp != null) {
				tx.begin();
				kamp.setHmaal(hjemmemaal);
				kamp.setBmaal(bortemaal);
				tx.commit();
			}
		} catch (Throwable e) {
			tx.rollback();

		} finally {
			em.close();
		}
	}

	public List<Spiller> finnSpillere(int lagid) {
		
		EntityManager em = emf.createEntityManager();
		
		try {
			Lag lag = em.find(Lag.class, lagid);
			
			if(lag != null) {
				return lag.getSpillere()
			}else {
				return null;
			}
		} finally {
			em.close();
		}
	}

	public List<Kamp> finnKamper(int lagid) {
		EntityManager em = emf.createEntityManager();

		try {
			Lag lag = em.find(Lag.class, lagid);

			if (lag != null) {
				List<Kamp> kamper = lag.getHjemmekamper();
				kamper.addAll(lag.getBortekamper());

				// For å gjøre det sortert må Kamp implementere
				// Comparable som sammeligner kampdatoer.
				Collections.sort(kamper);

				return kamper;
			} else {
				return null;
			}

		} finally {
			em.close();
		}
	}
}