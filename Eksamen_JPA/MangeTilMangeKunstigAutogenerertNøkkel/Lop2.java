import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Lop2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lopnr;

	private LocalDate dato;
	private String sted;
	private int distanse;

	@OneToMany(mappedBy = "lop", fetch = FetchType.EAGER)
	private List<Resultat> resultater;
}