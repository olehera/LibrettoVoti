package libretto;

import java.util.*;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v il {@link Voto} da aggiungere
	 */
    public void add(Voto v) {    // meno dipendenze ho tra una classe e l'altra e meglio sto!!
		voti.add(v);
	}

}
