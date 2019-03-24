package libretto;

import java.time.LocalDate;
import java.util.*;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto l = new Libretto();

		l.add(new Voto(23, "Analisi I", LocalDate.of(2017, 1, 31)));
		l.add(new Voto(25, "Sistemi Elettrici", LocalDate.of(2018, 6, 27)));
		l.add(new Voto(30, "Economia", LocalDate.of(2018, 7, 2)));
		l.add(new Voto(25, "Sistemi Telematici", LocalDate.of(2019, 2, 8)));
		l.add(new Voto(26, "Ricerca Operativa", LocalDate.of(2018, 7, 8)));
		l.add(new Voto(18, "Geometria", LocalDate.of(2017, 7, 12)));
		
		List<Voto> venticinque = l.cercaVoti(25);
		System.out.println(venticinque);
		
		Voto a1 = l.cercaEsame("Analisi I");
		Voto a2 = l.cercaEsame("Economia");
		Voto a3 = l.cercaEsame("Marketing");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		
		Voto giusto = new Voto(18, "Geometria", LocalDate.now());
		Voto sbagliato = new Voto(28, "Geometria", LocalDate.now());
		Voto mancante = new Voto(30, "Merendine", LocalDate.now());
		System.out.format("Il voto %s è %s\n", giusto.toString(), l.esisteGiaVoto(giusto));
		System.out.format("Il voto %s è %s\n", sbagliato.toString(), l.esisteGiaVoto(sbagliato));
		System.out.format("Il voto %s è %s\n", mancante.toString(), l.esisteGiaVoto(mancante));
	}

}
