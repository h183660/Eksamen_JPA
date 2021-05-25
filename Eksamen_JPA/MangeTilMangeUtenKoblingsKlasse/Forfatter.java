import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Forfatter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fornavn;
	private String etternavn;
	private String epost;
	
	@ManyToMany(mappedBy = "forfattere")
	private List<Bok> boker;
}