package it.prova.test;

import it.prova.model.Biglietto;

import static it.prova.model.Biglietto.trovaIlPiuEconomico;

public class BigliettoTester {
    public static void main (String[] args ){

        Biglietto a1 = new Biglietto("Re leone", 'a', 1, 18);
        Biglietto a2 = new Biglietto("Re leone", 'a', 2, 13);
        Biglietto a3 = new Biglietto("Re leone", 'a', 3, 10);
        Biglietto a4 = new Biglietto("Re leone", 'a', 4, 8);
        Biglietto [] elencoBiglietti = {a1, a2, a3, a4};
        Biglietto piuEconomico = trovaIlPiuEconomico(elencoBiglietti);

        System.out.println("TEST trovaIlPiuEconomico........Start");
        System.out.println("Il biglietto più economico è per lo spettacolo: " + piuEconomico.getNomeSpettacolo() + " " + piuEconomico.getLetteraFila() + piuEconomico.getNumeroPosto() + " " + piuEconomico.getPrezzo());
        System.out.println("TEST trovaIlPiuEconomico........End");
        System.out.println(" ............................................\n");

        System.out.println("TEST bigliettoAncoraInvenduto........Start");
        boolean bigliettoInvenduto = a1.bigliettoAncoraInvenduto(elencoBiglietti);
        System.out.println("Il biglietto è ancora invenduto? : " + bigliettoInvenduto);
        System.out.println("TEST bigliettoAncoraInvenduto........End");
        System.out.println(" ............................................\n");

        /// ///////////////////////////////////////////////
        Biglietto[] elencoBigliettiTest = {
                new Biglietto("Re leone", 'a', 1, 16),
                new Biglietto("Re leone 2", 'a', 2, 16),
                new Biglietto("Re leone", 'a', 3, 16)
        };
        System.out.println("TEST sonoTuttiBigliettiPerLoSpettacoloIntitolato........Start");
        boolean tuttiPerReLeone = Biglietto.sonoTuttiBigliettiPerLoSpettacoloIntitolato(elencoBigliettiTest, "Re leone");
        System.out.println("Tutti i biglietti sono per lo spettacolo 'Re leone'? : " + tuttiPerReLeone);
        System.out.println("TEST sonoTuttiBigliettiPerLoSpettacoloIntitolato........End");
        System.out.println(" ................................................................\n");
        /// ///////////////////////////////////////////////


    }
}
