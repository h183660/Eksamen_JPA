import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Bok {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tittel;
	private int aar;
	private String isbn;
	
	@ManyToOne
	@JoinColumn(name = "forlag_id", referencedColumnName = "id")
	private Forlag forlag;
	
	@ManyToMany
	@JoinTable(name = "forfatter_av_bok", joinColumns = @JoinColumn(name = "bok_id"), inverseJoinColumns = @JoinColumn(name = "forfatter_id"))
	private List<Forfatter> forfattere;
}