package it.prova.listandstreams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamsFilter {

	public static void main(String[] args) {
		List<Autore> listaAutoriMOCK = MockData.AUTORI_LIST;

		// voglio una sotto-lista degli autori under 30
		System.out.println("voglio una sotto-lista degli autori under 30");
		List<Autore> listaAutoriUnderTrenta = listaAutoriMOCK.stream().filter(
				autoreItem -> autoreItem.getEta() < 30)
				.toList();

		// la stampo
		listaAutoriUnderTrenta
				.forEach(autoreItem -> System.out.println(autoreItem.getNome() + " di anni " + autoreItem.getEta()));

		System.out
				.println("voglio trasformare la lista di autori under 30 in String x es. mario rossi con cf ADKF3120");
		// voglio trasformare la lista di autori under 30 in String x es. mario rossi
		// con cf ADKF3120
		List<String> messaggiListaAutoriUnderTrenta = listaAutoriUnderTrenta.stream().map(autoreItem -> {
			String messaggio = autoreItem.getNome() + " " + autoreItem.getCognome() + " con CF "
					+ autoreItem.getCodiceFiscale();
			return messaggio;
		}).toList();
		// stampo
		messaggiListaAutoriUnderTrenta.forEach(s -> System.out.println(s));

		System.out
				.println("nella listaAutori totale voglio cercare se esiste almeno un Autore col CF terminante in 98");
		// nella listaAutori totale voglio cercare se esiste almeno un Autore col CF
		// terminante in 98
		// in Java classico?????????????????? mamma mia
		Autore autoreDaCercare = listaAutoriMOCK.stream()
				.filter(autoreItem -> autoreItem.getCodiceFiscale().endsWith("98")).findAny().orElse(null);
		System.out.println(autoreDaCercare.getCodiceFiscale());

		System.out.println("degli autori under 30 voglio la lista di libri");
		// degli autori under 30 voglio la lista di libri
		List<Libro> listaLibriDegliUnderTrenta = listaAutoriUnderTrenta.stream().flatMap(x -> x.getLibri().stream())
				.toList();
		// map produce un output per ogni elemento che valuta, flatmap un numero
		// indefinito

		// stampo i titoli
		listaLibriDegliUnderTrenta.forEach(libroItem -> System.out.println(libroItem.getTitolo()));

		System.out.println("voglio la lista dei nomi degli autori con libri oltre 600 pagine");
		// voglio la lista dei nomi degli autori con libri oltre 600 pagine
		// e mentre filtro uso il peek per capire cosa transita
		List<String> listaNomiAutoriConLibriOltreSeicentoPagine = listaAutoriMOCK.stream()
				.filter(autoreItem -> autoreItem.getLibri().stream().anyMatch(libroItem -> libroItem.getPagine() > 600))
				.map(autoreItem -> autoreItem.getNome())
				.peek(autoreNomeItem -> System.out.println("giusto per capire cosa passa..." + autoreNomeItem))
				.toList();
		listaNomiAutoriConLibriOltreSeicentoPagine.forEach(l -> System.out.println(l));

		System.out.println("voglio un autore con almeno 40 anni, mi va bene il primo che trovo");
		// voglio un autore con almeno 40 anni, mi va bene il primo che trovo altrimenti
		// null
		Autore primoAutoreDiQuarantaAnniCheTrovo = listaAutoriMOCK.stream()
				.filter(autoreItem -> autoreItem.getEta() >= 40).findFirst().orElse(null);
		// questo è un optional, sempre nato con java 8, ma non ha a che fare con le
		// lambda expr
		Optional.of(primoAutoreDiQuarantaAnniCheTrovo).ifPresentOrElse(
				aut -> System.out.println(aut.getCodiceFiscale()), 
				() -> System.out.println("non c'è"));

		System.out.println("voglio un autore con almeno 40 anni, mi va bene uno qualsiasi");
		// voglio un autore con almeno 40 anni, mi va bene uno qualsiasi altrimenti null
		// ATTENZIONE!!!! Sembra funzionare come il findFirst ma in realtà non c'è
		// sicurezza nel fatto
		// che sia il primo che incontra!!!
		Autore autoreDiQuarantaAnniUnoQualsiasi = listaAutoriMOCK.stream()
				.filter(autoreItem -> autoreItem.getEta() >= 40).findAny().orElse(null);
		// questo è un optional, sempre nato con java 8, ma non ha a che fare con le
		// lambda expr
		Optional.of(autoreDiQuarantaAnniUnoQualsiasi).ifPresentOrElse(aut -> System.out.println(aut.getCodiceFiscale()),
				() -> System.out.println("non c'è"));

		System.out.println("Voglio la somma delle età di tutti gli autori");
		//la reduce riceve un default ed una funzione di riduzione, in questo caso la somma
		Integer sommaEta = listaAutoriMOCK.stream().map(autoreItem -> autoreItem.getEta()).reduce(0, (a, b) -> a + b);
		System.out.println("sotta totale delle età degli autori: "+sommaEta);

	}

}
