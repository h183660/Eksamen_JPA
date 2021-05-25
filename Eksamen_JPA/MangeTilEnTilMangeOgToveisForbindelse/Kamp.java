import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Kamp implements Comparable<Kamp> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int kampid;
	private LocalDate kampdato;
	
	@ManyToOne
	@JoinColumn(name = "hjemmelag", referencedColumnName = "lagid")
	private Lag hjemmelag;
	
	@ManyToOne
	@JoinColumn(name = "bortelag", referencedColumnName = "lagid")
	private Lag bortelag;
	private int hmaal;
	private int bmaal;
	
	
	@Override
	public int compareTo(Kamp o) {
		// TODO Auto-generated method stub
		return 0;
	}
}