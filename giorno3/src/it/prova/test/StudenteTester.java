package it.prova.test;

import it.prova.model.Studente;

public class StudenteTester {

    public static void main (String[] args) {
        Studente m001 = new Studente("Filippo", "Borghesi", 35, 25);
        Studente m002 = new Studente("Germana", "Caldini", 20, 21);
        Studente m003 = new Studente("Mario", "Rossi", 22, 18);
        Studente m004 = new Studente("Luca", "Verdi", 20, 19);
        Studente m005 = new Studente("Anna", "Bianchi", 19, 30);

        Studente[] corsoMate = new Studente[] {m002, m003, m004, m005};

        boolean tuttiPiuGiovani = m001.sonoTuttiPiuGiovaniDiMe(corsoMate);

        System.out.println("Test metodo sonoTuttiPiuGiovaniDiMe");
        System.out.println("Start.....");
        System.out.println("Tutti gli studenti del corso sono più giovani di " + m001.getNome() + "? " + tuttiPiuGiovani);
        System.out.println("End.......");
        System.out.println(".......... \n");
    }
}
