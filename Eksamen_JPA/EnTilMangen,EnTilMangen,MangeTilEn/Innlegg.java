import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Innlegg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int innleggid;
	private LocalDateTime tidspunkt;
	private String tekst;
	
	@ManyToOne
	@JoinColumn(name = "brukerid", referencedColumnName = "brukerid")
	private Bruker bruker;
	
	@OneToMany(mappedBy = "innlegg")
	private List<Kommentar> kommentarer;
}