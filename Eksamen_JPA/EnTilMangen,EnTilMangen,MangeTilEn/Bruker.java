import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bruker {
	@Id
	private String brukerid;
	private String fornavn;
	private String etternavn;
	private int fodselsaar;
}