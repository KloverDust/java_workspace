package it.prova.listandstreams;

import java.util.List;

public class TestListAndStreams {

	public static void main(String[] args) {
		List<Autore> listaAutori = MockData.AUTORI_LIST;

		// lambda forEach
		System.out.println("lambda forEach");
		listaAutori.forEach(item -> System.out.println(item.getId() + " " + item.getNome()));

		// stampa solo quelli con id maggiore di 2
		System.out.println("stampa solo quelli con id maggiore di 2");
		listaAutori.forEach(item -> {
			if (item.getId() > 2) {
				System.out.println(item.getId() + " " + item.getNome());
			}
		});

		// stampa solo quelli il cui nome finisce per 'ino'
		System.out.println("stampa solo quelli il cui nome finisce per 'ino'");
		listaAutori.forEach(item -> {
			if (item.getNome().endsWith("ino")) {
				System.out.println(item.getId() + " " + item.getNome());
			}
		});

		// stampa solo quelli con un libro di almeno 600 pagine
		System.out.println("stampa solo quelli con un libro di almeno 600 pagine");
		listaAutori.forEach(autoreItem -> {
			autoreItem.getLibri().forEach(libroItem -> {
				if (libroItem.getPagine() > 600)
					System.out.println("libro " + libroItem.getTitolo() + " dell'autore " + autoreItem.getNome()
							+ "di pagine " + libroItem.getPagine());
			});
		});

	}

}
