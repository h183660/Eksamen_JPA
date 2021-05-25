import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Kommentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kommentarid;
	private LocalDateTime tidspunkt;
	private String tekst;

	@ManyToOne
	@JoinColumn(name = "innleggid", referencedColumnName = "innleggid")
	private Innlegg innlegg;

	@ManyToOne
	@JoinColumn(name = "brukerid", referencedColumnName = "brukerid")
	private Bruker kommentator;
}