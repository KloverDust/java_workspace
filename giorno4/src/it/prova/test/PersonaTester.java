package it.prova.test;

import it.prova.model.Indirizzo;
import it.prova.model.Persona;


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



    }

}
