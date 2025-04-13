package it.prova.test;

import it.prova.model.*;

public class BibliotecaTester {
    public static void main(String[] args) {
        /// ///////////////////////////////////////////////
        System.out.println("\nTest aggiungiMateriale start ....");
        Biblioteca biblioteca = new Biblioteca(new MaterialeBiblioteca[0]);

        Libro libroISDA = new Libro(250, "fantasy", "Il Signore degli Anelli", "J.R.R. Tolkien", "LIB001", true);
        DVD dvdMatrix = new DVD(120, "Matrix", "Wachowski", "DVD001", true);
        Rivista rivistaFocus = new Rivista(12, 2024, "Focus", "AA.VV.", "RIV001", true);
        MaterialeBiblioteca libroHP1= new Libro(360,"fantasy", "Harry Potter", "J.K.Rowling", "HP001", true);

        biblioteca.aggiungiMateriale(libroISDA);
        biblioteca.aggiungiMateriale(dvdMatrix);
        biblioteca.aggiungiMateriale(rivistaFocus);
        biblioteca.aggiungiMateriale(libroHP1);

        MaterialeBiblioteca[] materiali = biblioteca.getListaMaterialiInBiblioteca();
        for (int i = 0; i < materiali.length; i++) {
            System.out.println("Materiale #" + (i + 1) + ": " + materiali[i].getTitolo() + ", disponibile: " + materiali[i].isDisponibile());
        }
        System.out.println("Test aggiungiMateriale end ....\n");
        /// ///////////////////////////////////////////////


        /// ///////////////////////////////////////////////
        System.out.println("\nTest cercaMaterialePerTitolo start ....");
        Libro libro2 = new Libro(300, "fantasy", "Il Signore degli Anelli", "Autore Diverso", "LIB002", false);
        biblioteca.aggiungiMateriale(libro2);

        MaterialeBiblioteca[] trovati = biblioteca.cercaMaterialePerTitolo("Il Signore degli Anelli");

        System.out.println("Materiali trovati con titolo 'Il Signore degli Anelli': " + trovati.length);
        System.out.println("Test cercaMaterialePerTitolo end ....\n");
        /// ///////////////////////////////////////////////

        /// ///////////////////////////////////////////////
        System.out.println("\nTest elencaMaterialiDisponibili start ....");
        biblioteca.getListaMaterialiInBiblioteca()[0].prestito();
        MaterialeBiblioteca[] disponibili = biblioteca.elencaMaterialiDisponibili();

        System.out.println("Materiali attualmente disponibili: " + disponibili.length);
        for (MaterialeBiblioteca m : disponibili) {
            System.out.println("- Titolo: " + m.getTitolo() + ", ID: " + m.getCodiceIdentificativo());
        }

        System.out.println("Test elencaMaterialiDisponibili end ....\n");
        /// ///////////////////////////////////////////////

        /// ///////////////////////////////////////////////
        System.out.println("\nTest elencaMaterialiNonDisponibili start ....");
        // biblioteca.getListaMaterialiInBiblioteca()[0].prestito(); // libro1
        // biblioteca.getListaMaterialiInBiblioteca()[1].prestito(); // dvd1
        MaterialeBiblioteca[] nonDisponibili = biblioteca.elencaMaterialiNonDisponibili();

        System.out.println("Materiali attualmente NON disponibili: " + nonDisponibili.length);
        for (MaterialeBiblioteca m : nonDisponibili) {
            System.out.println("- Titolo: " + m.getTitolo() + ", ID: " + m.getCodiceIdentificativo());
        }
        System.out.println("Test elencaMaterialiNonDisponibili end ....\n");
        /// ///////////////////////////////////////////////

    }
}
