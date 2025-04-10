package it.prova.test.onetomany;

import it.prova.model.onetomany.Foglio;
import it.prova.model.onetomany.Raccoglitore;

public class RaccoglitoreTester {
    public static void main(String[] args) {
        Foglio foglio1 = new Foglio("nuovo", "ruvido");
        Foglio foglio2 = new Foglio("riciclato", "liscio");
        Foglio foglio3 = new Foglio("riciclato2", "ruvido");

        Foglio[] fogli = {foglio1, foglio2};
        Raccoglitore raccoglitore = new Raccoglitore("Rosso", 2, fogli);

        /// //////
        System.out.println(raccoglitore);

        raccoglitore.addToFogli(foglio3);

        System.out.println(raccoglitore);

        raccoglitore.removeFromFogli(1);

        System.out.println(raccoglitore);


    }
}
