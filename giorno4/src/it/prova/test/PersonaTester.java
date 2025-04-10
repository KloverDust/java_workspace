package it.prova.test;

import it.prova.model.Indirizzo;
import it.prova.model.Persona;

import static it.prova.model.Persona.listaIndirizziDegliOver60;


public class PersonaTester {
    public static void main(String[] args) {
        Persona p1 = new Persona("Marco", "Rossi", 30);
        Indirizzo indirizzo1 = new Indirizzo("Roma", "Via Mosca", "52");
        p1.setIndirizzo(indirizzo1);

        Persona p2 = new Persona("Luca", "Bianchi", 38);
        Indirizzo indirizzo2 = new Indirizzo("Genova", "Via Mosca", "51");
        p2.setIndirizzo(indirizzo2);

        Persona p3 = new Persona("Michele", "Verdi", 22);
        Indirizzo indirizzo3 = new Indirizzo("Milano", "Via Mosca", "50");
        p3.setIndirizzo(indirizzo3);

        Persona [] elenco = new Persona[] { p2, p3};

        //TEST abitaA
        System.out.println("TEST abitaA........Start ");
        String cittaDiControllo = "Roma";
        boolean abitaACheck = p1.abitaA(cittaDiControllo);
        System.out.println(p1.getNome() +" abita a " + cittaDiControllo + " ?" + abitaACheck);
        System.out.println("TEST abitaA........End ");
        System.out.println(" ....................... \n");

        //TEST haAlmenoUnConcittadino
        System.out.println("TEST haAlmenoUnConcittadino........Start ");
        boolean haAlmenoUnConcittadinoCheck = p1.haAlmenoUnConcittadino(elenco);
        System.out.println(p1.getNome() +" ha alemno un concittadino? " + haAlmenoUnConcittadinoCheck);
        System.out.println("TEST haAlmenoUnConcittadino........End ");
        System.out.println(" ....................... \n");

        //TEST sonoTuttiPiuAnziani
        System.out.println("TEST sonoTuttiPiuAnziani........Start ");
        boolean sonoTuttiPiuAnzianiCheck = p1.sonoTuttiPiuAnziani(elenco);
        System.out.println(p1.getNome() +" è il piu piccolo? " + sonoTuttiPiuAnzianiCheck);
        System.out.println("TEST sonoTuttiPiuAnziani........End ");
        System.out.println(" ....................... \n");

        Persona p4 = new Persona("Giulia", "Neri", 27);
        Indirizzo indirizzo4 = new Indirizzo("Firenze", "Via Roma", "12");
        p4.setIndirizzo(indirizzo4);

        Persona p5 = new Persona("Alessandro", "Russo", 45);
        Indirizzo indirizzo5 = new Indirizzo("Firenze", "Via Roma", "12");
        p5.setIndirizzo(indirizzo5);

        Persona p6 = new Persona("Sara", "Gallo", 33);
        Indirizzo indirizzo6 = new Indirizzo("Bologna", "Via Indipendenza", "101");
        p6.setIndirizzo(indirizzo6);


        Persona [] persone2 = new Persona[] {p1,p3,p5,p6};

        //TEST quantiCoabitanoNelMioStessoPalazzo
        System.out.println("TEST quantiCoabitanoNelMioStessoPalazzo........Start ");
        int quantiCoabitanoNelMioStessoPalazzoCheck = p4.quantiCoabitanoNelMioStessoPalazzo(persone2);
        System.out.println(p4.getNome() +" coabita nello stesso palazzo con quanti altri? " + quantiCoabitanoNelMioStessoPalazzoCheck);
        System.out.println("TEST quantiCoabitanoNelMioStessoPalazzo........End ");
        System.out.println(" ....................... \n");

        //TEST assegnaCoinquilino
        System.out.println("TEST assegnaCoinquilino........Start ");
        p1.assegnaCoinquilino(p2);
        System.out.println("L'indirizzo del primo coinquilino è " + indirizzo1.getCitta() + " " + indirizzo1.getVia() + " " + indirizzo1.getCivico());
        System.out.println("L'indirizzo del nuovo coinquilino adesso è " + indirizzo2.getCitta() + " " + indirizzo2.getVia() + " " + indirizzo2.getCivico());
        System.out.println("TEST assegnaCoinquilino........End ");
        System.out.println(" ....................... \n");

        Persona young1 = new Persona("Sara", "Mattei", 33);
        Indirizzo indirizzoY1 = new Indirizzo("Bologna", "Via Indipendenza", "101");
        young1.setIndirizzo(indirizzoY1);

        Persona young2 = new Persona("Cara", "Vigneti", 24);
        Indirizzo indirizzoY2 = new Indirizzo("Bologna", "Via Indipendenza", "101");
        young2.setIndirizzo(indirizzoY2);

        Persona old1 = new Persona("Erica", "Anselmi", 66);
        Indirizzo indirizzoOld1 = new Indirizzo("Bologna", "Via Indipendenza", "101");
        old1.setIndirizzo(indirizzoOld1);

        Persona[] personeYoungAndOld = new Persona[] {young1, young2, old1};

        //Test listaIndirizziDegliOver60
        System.out.println("TEST listaIndirizziDegliOver60........Start ");
        System.out.println("TEST listaIndirizziDegliOver60..........End ");
        Indirizzo[] indirizziOver60 = listaIndirizziDegliOver60(personeYoungAndOld);

        for (Indirizzo ind : indirizziOver60) {
            System.out.println("Over60: " + ind.getCitta() + " " + ind.getVia() + " " + ind.getCivico());
        }
        System.out.println(" .......................................... \n");


        // Test quantiMieiOmonimiNellaMiaStessaCitta
        System.out.println("TEST quantiMieiOmonimiNellaMiaStessaCitta........Start ");

        Persona a1 = new Persona("Luca", "Bianchi", 25);
        a1.setIndirizzo(new Indirizzo("Milano", "Via Roma", "10"));
        Persona a2 = new Persona("Luca", "Verdi", 40); // stesso nome, stessa città
        a2.setIndirizzo(new Indirizzo("Milano", "Via Milano", "11"));
        Persona a3 = new Persona("Marco", "Bianchi", 35); // nome diverso
        a3.setIndirizzo(new Indirizzo("Milano", "Via Roma", "10"));
        Persona[] elencoOmonimiStessaCitta = new Persona[] {a1, a2, a3};

        int omonimi = a1.quantiMieiOmonimiNellaMiaStessaCitta(elencoOmonimiStessaCitta);
        System.out.println("Numero di omonimi di " + a1.getNome() + " a " + a1.getIndirizzo().getCitta() + ": " + omonimi);
        System.out.println("TEST quantiMieiOmonimiNellaMiaStessaCitta........End ");
        System.out.println(" .......................................... \n");

        System.out.println("TEST almenoLaMetaAbitanoNellaMiaStessaVia........Start");

        Persona b1 = new Persona("Mario", "Rossi", 30);
        b1.setIndirizzo(new Indirizzo("Roma", "Via Milano", "1"));
        Persona b2 = new Persona("Laura", "Bianchi", 25);
        b2.setIndirizzo(new Indirizzo("Roma", "Via Milano", "2")); // stessa via
        Persona b3 = new Persona("Luca", "Neri", 40);
        b3.setIndirizzo(new Indirizzo("Roma", "Via Milano", "3")); // stessa via
        Persona b4 = new Persona("Anna", "Verdi", 35);
        b4.setIndirizzo(new Indirizzo("Roma", "Via Roma", "10")); // via diversa
        Persona b5 = new Persona("Marco", "Blu", 50);
        b5.setIndirizzo(new Indirizzo("Milano", "Via Milano", "3")); // città diversa

        Persona[] elencoB = new Persona[] {b1, b2, b3, b4, b5};

        boolean risultato = b1.almenoLaMetaAbitanoNellaMiaStessaVia(elencoB);
        System.out.println("Almeno metà abitano nella stessa via di " + b1.getNome() + "? " + risultato);

        System.out.println("TEST almenoLaMetaAbitanoNellaMiaStessaVia........End");
        System.out.println(" .......................................... \n");





    }

}
