package it.prova.test;

import it.prova.utility.ArrayUtility;

public class MethodTester {

    public static void main (String[] args) {

        //TEST calcolaParoleDispari
        System.out.println("TEST calcolaParoleDispari........Start ");
        String[] parole = {"Guglielmo", "Marco", "Alessandro"};
        int numParoleDispari = ArrayUtility.calcolaParoleDispari(parole);
        System.out.println("Numero di parole dispari trovate " + numParoleDispari);
        System.out.println("TEST calcolaParoleDispari........End ");
        System.out.println(" ....................... ");

        //TEST sommaNulla
        System.out.println("TEST sommaNulla........Start ");
        int [] numeriDaTestare = {1, 4, -5, 8, 10, -11, -7};
        boolean sommaNulla = ArrayUtility.sommaNulla(numeriDaTestare);
        System.out.println("La somma dei numeri dell'array è nulla? " + sommaNulla);
        System.out.println("TEST sommaNulla........End ");
        System.out.println(" ....................... ");


        //TEST invertiStringa
        System.out.println("TEST invertiStringa........Start ");
        String parolaDaInvertire = "Geronimo";
        String parolaInvertita = ArrayUtility.invertiStringa(parolaDaInvertire);
        System.out.println("L'inverso della parola " + parolaDaInvertire + " è " + parolaInvertita);
        System.out.println("TEST invertiStringa........End ");
        System.out.println(" ....................... ");

        //TEST lunghezzaUguale
        System.out.println("TEST lunghezzaUguale........Start ");
        String[] paroleLunghezzaUguale = {"start", "ciaoo", "liami"};
        boolean lunghezzaUguale = ArrayUtility.lunghezzaUguale(paroleLunghezzaUguale);
        System.out.println("Le parole sono della stessa lunghezza? " + lunghezzaUguale);
        System.out.println("TEST lunghezzaUguale........End ");
        System.out.println(" ....................... ");

        //TEST checkLastLetter
        System.out.println("TEST checkLastLetter........Start ");
        char carattereControllo = 'a';
        String[] paroleDaControllare = {"banana", "mela", "arancia"};
        boolean checkStessaLetteraFinale = ArrayUtility.checkLastLetter(paroleDaControllare, carattereControllo);
        System.out.println("Le parole terminano con la stessa lettera? " + checkStessaLetteraFinale);
        System.out.println("TEST checkLastLetter........End ");
        System.out.println(" ....................... ");

        //TEST sommaLunghezzeParole
        System.out.println("TEST sommaLunghezzeParole........Start ");
        String[] paroleConLettereDaSommare = {"giglio", "tulipano", "rosa"};
        int sommaDelleLunghezzeParole = ArrayUtility.sommaLunghezzeParole(paroleConLettereDaSommare);
        System.out.println("La somma del numero delle lettere nelle parole è " + sommaDelleLunghezzeParole);
        System.out.println("TEST sommaLunghezzeParole........End ");
        System.out.println(" ....................... ");
}
}
