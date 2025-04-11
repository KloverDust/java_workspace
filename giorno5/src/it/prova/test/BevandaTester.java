package it.prova.test;

import it.prova.model.Bevanda;
import it.prova.model.LongDrink;
import it.prova.model.SoftDrink;

public class BevandaTester {

    public static void main (String[] args) {
       // Bevanda [] bevandeDaControllare = new Bevanda[4];

        SoftDrink fanta = new SoftDrink("Fanta", 300, true, true);
        SoftDrink pepsi = new SoftDrink("pepsi", 300, true, true);
        LongDrink moscowMule = new LongDrink("Moscow mule", 150, 10);
        Bevanda teaNero = new Bevanda("Te nero");

        //bevandeDaControllare = {fanta, pepsi, moscowMule, teaNero};
        // NON SI PUO FARE PERCHE E' STATO CREATO UN RIFERIMETNO IMMUTABILE NELLA PRIMA INSTANZIAZIONE
        Bevanda[] bevandeDaControllare = {fanta, pepsi, moscowMule, teaNero};

        int bevandePadri = Bevanda.quantiPadri(bevandeDaControllare);
        System.out.println(bevandePadri); // NON CONTA QUELLI CHE SONO STATI INSTANZIATI CON IL METODO PADRE MA QUELLI OGGETTI CHE SONO ANCHE PADRI DUQNEU QUELLI OGGETTI IS-A

    }
}
