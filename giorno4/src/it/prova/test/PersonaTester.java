package it.prova.test;

import it.prova.model.Indirizzo;
import it.prova.model.Persona;


public class PersonaTester {
    public static void main(String[] args) {
        Persona p1 = new Persona("Marco", "Rossi", 30);
        Indirizzo indirizzo1 = new Indirizzo("Roma", "Via Mosca", "52");
        p1.setIndirizzo(indirizzo1);
        System.out.println(p1.getIndirizzo().getCivico());

        Persona p2 = new Persona("Luca", "Bianchi", 38);
        Indirizzo indirizzo2 = new Indirizzo("Genova", "Via Mosca", "51");
        p2.setIndirizzo(indirizzo2);
        System.out.println(p2.getIndirizzo().getCivico());

        Persona p3 = new Persona("Michele", "Verdi", 22);
        Indirizzo indirizzo3 = new Indirizzo("Milano", "Via Mosca", "50");
        p3.setIndirizzo(indirizzo3);
        System.out.println(p3.getIndirizzo().getCivico());

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
    }

}
