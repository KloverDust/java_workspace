package it.prova.listandstreams;

import java.util.ArrayList;
import java.util.List;

public class MockData {

	public static final List<Autore> AUTORI_LIST = new ArrayList<>();

	static {
		Autore pippo = new Autore(1L, "pippo", "pippocognome", 29, "AKEFJD98");
		Libro libroDiPippo1 = new Libro(45L, "tiolo di pippo1", "genere di pippo1", 562, pippo);
		pippo.getLibri().add(libroDiPippo1);
		Libro libroDiPippo2 = new Libro(433L, "tiolo di pippo2", "genere di pippo2", 562, pippo);
		pippo.getLibri().add(libroDiPippo2);

		Autore pluto = new Autore(2L, "pluto", "plutocognome", 24, "MMMMMD983");
		Libro libroDiPluto1 = new Libro(451L, "tiolo di pluto1", "genere di pluto1", 5214, pluto);
		pluto.getLibri().add(libroDiPluto1);

		Autore topolino = new Autore(3L, "topolino", "topolinocognome", 44, "JDHFDJSFD98");
		Libro libroDiTopolino1 = new Libro(455L, "tiolo di topolino1", "genere di topolino1", 562, topolino);
		topolino.getLibri().add(libroDiTopolino1);
		Libro libroDiTopolino2 = new Libro(567L, "tiolo di topolino2", "genere di topolino2", 741, topolino);
		topolino.getLibri().add(libroDiTopolino2);

		Autore minnie = new Autore(4L, "minnie", "minnicognome", 54, "LSDJFSOJEFO981");
		Libro libroDiMinnie1 = new Libro(589L, "tiolo di minnie1", "genere di minnie1", 562, minnie);
		minnie.getLibri().add(libroDiMinnie1);
		Libro libroDiMinnie2 = new Libro(590L, "tiolo di minnie2", "genere di minnie2", 485, minnie);
		minnie.getLibri().add(libroDiMinnie2);
		Libro libroDiMinnie3 = new Libro(619L, "tiolo di minnie3", "genere di minnie3", 412, minnie);
		minnie.getLibri().add(libroDiMinnie3);

		AUTORI_LIST.add(pippo);
		AUTORI_LIST.add(pluto);
		AUTORI_LIST.add(topolino);
		AUTORI_LIST.add(minnie);

	}

}
