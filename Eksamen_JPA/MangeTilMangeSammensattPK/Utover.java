import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utover {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medlemsnr;

	private LocalDate fodselsdato;
	private String navn;
	private String kjonn;

	@OneToMany(mappedBy = "utover", fetch = FetchType.EAGER)
	private List<Resultat> resultater;
}