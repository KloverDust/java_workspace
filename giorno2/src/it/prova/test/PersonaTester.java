package it.prova.test;

import it.prova.model.Persona;

public class PersonaTester {
    public static void main (String[] args) {
        Persona persona1 = new Persona();
        persona1.setEta(18);
        persona1.setNome("Marco");
        persona1.setCognome("Rossi");


        Persona persona2 = new Persona();
        persona2.setEta(25);
        persona2.setNome("Federico");
        persona2.setCognome("Bianchi");

//        if (persona1.getEta() < persona2.getEta()) {
//            System.out.println(persona1.getNome() +" "+ persona1.getCognome() + " è piu piccolo di " + persona2.getNome() + " " +persona2.getCognome());
//        } else if(persona1.getEta() > persona2.getEta()) {
//            System.out.println(persona1.getNome() +" "+ persona1.getCognome() + " è piu grande di " + persona2.getNome() + " " +persona2.getCognome());
//        } else {
//            System.out.println(persona1.getNome() +" "+ persona1.getCognome() + " ha la stessa età di " + persona2.getNome() + " " +persona2.getCognome());
//        }

        boolean soggettoPiuGrande = persona1.ePiuAnziano(persona2);
        if (soggettoPiuGrande) {
            System.out.println(persona1.getNome() + " è più grande di " + persona2.getNome() );
        } else {
            System.out.println(persona1.getNome() + " è più piccolo di " + persona2.getNome() );
        }

    }
}
