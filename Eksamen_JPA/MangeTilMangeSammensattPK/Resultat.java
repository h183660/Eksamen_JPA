import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ResultatPK.class) 
public class Resultat {
	
	private LocalTime tid;
	
	@Id
	@ManyToOne
	@JoinColumn(name="medlemsnr", referencedColumnName="medlemsnr")
	private Utover utover;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "lopnr", referencedColumnName = "lopnr")
	private Lop lop;
}