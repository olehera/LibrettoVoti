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
	 * @return {@code true} nel caso normale, {@code false} se non � riuscito ad aggiungere il voto
	 */
    public boolean add(Voto v) { 
    	if (!this.votoConflitto(v) && !this.esisteGiaVoto(v)) { // non gli passo i singoli dati ma gi� aggregati,
    		voti.add(v);                                        // meno dipendenze ho tra una classe e l'altra e meglio sto!
    		return true; 
    	} else
    		return false;
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
    
    /**
     * Ricerca un {@link Voto} relativo al corso di cui � specificato il nome
     * 
     * @param nomeEsame nome del corso da ricercare
     * @return il {@link Voto} corrispondente, oppure {@code null} se non esiste
     */
    public Voto cercaEsame(String nomeEsame) {
    	Voto vo = new Voto(0, nomeEsame, null);
    	int pos = this.voti.indexOf(vo);
    	
    	if (pos == -1)
    		return null;
    	else
    		return this.voti.get(pos);
    }
    
    /**
     * Dato un {@link Voto}, determina se esiste gi� un voto con uguale corso ed uguale punteggio
     * 
     * @param v
     * @return {@code true} se ha trovato un corso e punteggio uguali,
     *         {@code false} se non ha trovato il corso, oppure l'ha trovato con voto diverso
     */
    public boolean esisteGiaVoto(Voto v) {
    	int pos = this.voti.indexOf(v);
    	
    	if (pos == -1)
    		return false;
    	else 
    		return (v.getPunti() == this.voti.get(pos).getPunti());
    }
    
    /**
     * Mi dice se il {@link Voto} {@code v} � in conflitto con uno dei voti esistenti. Se il voto non esiste,
     * non c'� conflitto. Se esiste ed ha punteggio diverso, c'� conflitto.
     * @param v
     * @return {@code true} se il voto esiste ed ha punteggio diverso, {@code false} se il voto non esiste 
     * oppure esiste ma ha lo stesso punteggio.
     */
    public boolean votoConflitto(Voto v) {
    	int pos = this.voti.indexOf(v);
    	
    	if (pos == -1)
    		return false;
    	else 
    		return (v.getPunti() != this.voti.get(pos).getPunti());
    }
    
    public String toString() {
    	return this.voti.toString();
    }
    
    public Libretto librettoMigliorato() {
    	Libretto nuovo = new Libretto();
    	
    	for (Voto v : this.voti)
    		nuovo.add(v.clone());     // creo dei nuovi oggetti
    	
    	for (Voto v : nuovo.voti) {
    		int punti = v.getPunti();

    		if (punti < 24)
    			punti = punti + 1;
    		else if (punti <= 28)
    			punti = punti + 2;
    		v.setPunti(punti);
    	}
    	return nuovo;
    }
    
    public void cancellaVotiScarsi() {
    	List<Voto> cancellare = new ArrayList<Voto>();
    	
    	for (Voto v : this.voti)
    		if (v.getPunti() < 24)
    			cancellare.add(v);
    	
    	this.voti.removeAll(cancellare);
    }
    
    
}
