package it.prova.test;

import it.prova.model.Biglietto;
import it.prova.model.Spettatore;

public class SpettatoreTester {
    public static void main (String[] args) {
        Biglietto general1 = new Biglietto("Re leone", 'a', 1, 16);
        Spettatore spettatoreA1= new Spettatore("Michele","Bianchi", "48881206", general1);

        System.out.println("TEST stampaSpettatoreConBiglietto........Start");
        System.out.println("Nome: " + spettatoreA1.getNome());
        System.out.println("Cognome: " + spettatoreA1.getCognome());

        Biglietto b = spettatoreA1.getBiglietto();
        System.out.println("Spettacolo: " + b.getNomeSpettacolo());
        System.out.println("Fila: " + b.getLetteraFila());
        System.out.println("Posto: " + b.getNumeroPosto());

        System.out.println("TEST stampaSpettatoreConBiglietto........End");
        System.out.println(" .......................................... \n");



        Biglietto general2 = new Biglietto("La Bella e la Bestia", 'b', 2, 18);
        Spettatore spettatoreB2 = new Spettatore("Laura", "Rossi", "48761234", general2);
        Biglietto general4 = new Biglietto("Frozen", 'c', 4, 15);
        Spettatore spettatoreC4 = new Spettatore("Chiara", "Neri", "48112233", general4);
        Biglietto general5 = new Biglietto("Re leone", 'a', 2, 16);
        Spettatore spettatoreA2 = new Spettatore("Francesca", "Gialli", "48900123", general5);
        Biglietto general6 = new Biglietto("Re leone", 'a', 3, 16);
        Spettatore spettatoreA3 = new Spettatore("Luca", "Blu", "48673219", general6);
        Biglietto general8 = new Biglietto("Re leone", 'a', 5, 16);
        Spettatore spettatoreA5 = new Spettatore("Marco", "Rossi", "48765432", general8);

        Spettatore[] spettatoriTest1 = new Spettatore[] {spettatoreA5, spettatoreA3, spettatoreC4, spettatoreA1, spettatoreB2};

        System.out.println("TEST incassoDeiPagantiNellaMiaFila........Start");
        float incassoMiaFila = spettatoreA2.incassoDeiPagantiNellaMiaFila(spettatoriTest1);
        System.out.println("L'incasso per la fila " + spettatoreA2.getBiglietto().getLetteraFila() + " è " + incassoMiaFila);
        System.out.println("TEST incassoDeiPagantiNellaMiaFila........End");
        System.out.println(" .......................................... \n");

        System.out.println("TEST numeroSpettatoriDelMioStessoSpettacolo........Start");
        Spettatore[] spettatoriStessoSpettacoloTest = new Spettatore[] {spettatoreB2, spettatoreC4, spettatoreA2, spettatoreA3, spettatoreA5};
        int numeroStessoSpettacolo = spettatoreA2.numeroSpettatoriDelMioStessoSpettacolo(spettatoriStessoSpettacoloTest);
        System.out.println("Numero di spettatori che assistono allo stesso spettacolo mio "  + spettatoreA2.getBiglietto().getNomeSpettacolo() + numeroStessoSpettacolo);
        System.out.println("TEST numeroSpettatoriDelMioStessoSpettacolo........End");
        System.out.println(" ................................................... \n");

        System.out.println("TEST numeroSpettatoriMioSpettacoloSuperaAspettativa........Start");
        boolean superaAspettativa = spettatoreA2.numeroSpettatoriMioSpettacoloSuperaAspettativa(spettatoriStessoSpettacoloTest, 2); // aspettativa = 2
        System.out.println("Il numero di spettatori per lo spettacolo " + spettatoreA2.getBiglietto().getNomeSpettacolo() + " supera l’aspettativa? " + superaAspettativa);
        System.out.println("TEST numeroSpettatoriMioSpettacoloSuperaAspettativa........End");
        System.out.println(" ................................................................\n");

    }
}
