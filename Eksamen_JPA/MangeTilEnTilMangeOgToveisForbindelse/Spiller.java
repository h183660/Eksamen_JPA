import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Spiller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillerid;
	private String fornavn;
	private String etternavn;
	
	@ManyToOne
	@JoinColumn(name = "lagid", referencedColumnName = "lagid")
	private Lag lag;
}