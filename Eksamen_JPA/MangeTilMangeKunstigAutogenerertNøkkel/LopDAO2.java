import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LopDAO2 {

	private EntityManagerFactory emf;

	public LopDAO2() {
		emf = Persistence.createEntityManagerFactory("");
	}

	/*
	 * Antagelser: - Antar at EntityManagerFactory emf eksisterer (som
	 * instansvariabel) og er opprettet i klassen som inneholder denne metoden vi
	 * skal skrive.
	 * 
	 * - Antar at Resultat har en parametrisk konstrukt�r for � opprette et
	 * resultat-objekt.
	 * 
	 * - Antar at vi b�de i Utover og Lop har en metode for � legge til et resultat
	 * slik: public void leggTilResultat(Resultat resultat){
	 * resultater.add(resultat); }
	 */

	void registrerResultat(int medlemsnr, int lopnr, LocalTime tid) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			Utover utover = em.find(Utover.class, medlemsnr);
			Lop lop = em.find(Lop.class, lopnr);
			Resultat resultat = new Resultat(utover, lop, tid);

			em.persist(resultat);
			utover.leggTilResultat(resultat);
			lop.leggTilResultat(resultat);

			tx.commit();

		} catch (Throwable e) {
			tx.rollback();
		} finally {
			em.close();
		}
	}

	/*
	 * - Antar at EntityManagerFactory emf eksisterer (som instansvariabel) og er
	 * opprettet i klassen som inneholder denne metoden vi skal skrive.
	 */
	List<Resultat> hentResultaterFor(int studentnr) {

		EntityManager em = emf.createEntityManager();

		try {
			Utover s = em.find(Student.class, studentnr);
			return s.getResultater();
			// Merknad: Oppgaven kan ogs� l�ses ved � bruke JPQL.

		} catch (Throwable e) {

		} finally {
			em.close();
		}
	}
}