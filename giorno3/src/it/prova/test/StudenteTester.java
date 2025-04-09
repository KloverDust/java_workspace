package it.prova.test;

import it.prova.model.Studente;

public class StudenteTester {

    public static void main (String[] args) {
        Studente m001 = new Studente("Filippo", "Borghesi", 29, 25);
        Studente m002 = new Studente("Germana", "Caldini", 20, 21);
        Studente m003 = new Studente("Mario", "Rossi", 22, 18);
        Studente m004 = new Studente("Luca", "Verdi", 20, 19);
        Studente m005 = new Studente("Anna", "Bianchi", 19, 24);

        Studente[] corsoMate = new Studente[] {m002, m003, m004, m005};

        boolean tuttiPiuGiovani = m001.sonoTuttiPiuGiovaniDiMe(corsoMate);
        System.out.println("Test metodo sonoTuttiPiuGiovaniDiMe");
        System.out.println("Start.....");
        System.out.println("Tutti gli studenti del corso sono più giovani di " + m001.getNome() + "? " + tuttiPiuGiovani);
        System.out.println("End.......");
        System.out.println(".......... \n");

        boolean qualcunoHaMediaMigliore = m001.almenoUnoHaLaMediaMiglioreDellaMia(corsoMate);
        System.out.println("Test metodo almenoUnoHaLaMediaMiglioreDellaMia");
        System.out.println("Start.....");
        System.out.println("Almeno uno ha una media migliore di " + m001.getNome() + "? " + qualcunoHaMediaMigliore);
        System.out.println("End.......");
        System.out.println(".......... \n");

        Studente s1 = new Studente("Filippo", "Neri", 17, 22);
        Studente s2 = new Studente("Filippo", "Rosa", 16, 23);
        Studente s3 = new Studente("Filippo", "Blu", 19, 21);
        Studente s4 = new Studente("Luca", "Verdi", 17, 24);

        Studente[] studentiCorso = {s1, s2, s3, s4};
        int numeroOmonimiMinorenni = m001.numeroOmonimiMinorenni(studentiCorso);
        System.out.println("Test metodo numeroOmonimiMinorenni");
        System.out.println("Start.....");
        System.out.println("Numero di omonimi minorenni di " + m001.getNome() + ": " + numeroOmonimiMinorenni);
        System.out.println("End.......");
        System.out.println(".......... \n");
    }
}
