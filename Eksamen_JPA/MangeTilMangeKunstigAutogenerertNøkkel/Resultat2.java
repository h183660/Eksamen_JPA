import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Resultat2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultatnr;

	private LocalTime tid;

	@ManyToOne
	@JoinColumn(name = "medlemsnr", referencedColumnName = "medlemsnr")
	private Utover utover;

	@ManyToOne
	@JoinColumn(name = "lopnr", referencedColumnName = "lopnr")
	private Lop lop;
}