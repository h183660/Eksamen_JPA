import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Lag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lagid;
	private String navn;
	private String hjemmebane;
	
	@OneToMany(mappedBy = "lag")
	private List<Spiller> spillere;
	
	@OneToMany(mappedBy = "hjemmelag")
	private List<Kamp> hjemmekamper;
	
	@OneToMany(mappedBy = "bortelag")
	private List<Kamp> bortekamper;
}