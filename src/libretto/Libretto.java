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
    public void add(Voto v) {    // non gli passo i singoli dati ma già aggregati,
    	voti.add(v);             // meno dipendenze ho tra una classe e l'altra e meglio sto!!
	}
    
    /**
     * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
     * 
     * @param punti punteggio da ricercare
     * @return lista di {@link Voto} aventi quel punteggio (eventualmente vuota)
     */
    public List<Voto> cercaVoti(int punti) {
    	List<Voto> result = new ArrayList<Voto>();
    	
    	for (Voto v: this.voti)
    		if (v.getPunti()==punti)
    			result.add(v);
    	
    	return result;
    }

}
