package it.prova.test;

import it.prova.model.Aquila;
import it.prova.model.Gallina;
import it.prova.model.Pinguino;
import it.prova.model.Volatile;

public class VolatileTester {
    public static void main(String[] args){

        //        --------------------------------------------------------
        //        Volatile vAquila;
        //        Volatile vGallina;
        //        Volatile vPinguino;
        //        vAquila = new Aquila();
        //        vGallina = new Gallina();
        //        vPinguino = new Pinguino();
        //        --------------------------------------------------------
        //        Volatile vAquila = newAquila();  -> Posso fare anche così.
        //        Volatile vGallina = newGallina();
        //        Volatile vPinguino = newPinguino();
        //        --------------------------------------------------------

        // Con lo stesso riferimento:
        Volatile volatile1;

        volatile1 = new Aquila("Reale");
        System.out.println(volatile1.vola());
        System.out.println(volatile1.stampaProprieta());
        System.out.println("-------------------------");

        volatile1 = new Gallina("Rosso");
        System.out.println(volatile1.vola());
        System.out.println(volatile1.stampaProprieta());
        System.out.println("-------------------------");


        volatile1 = new Pinguino("Africa");
        System.out.println(volatile1.vola());
        System.out.println(volatile1.stampaProprieta());
        System.out.println("-------------------------");

        Volatile volatile2 = new Pinguino("Antartide");
        System.out.println(volatile1.eUgualeA(volatile2));


    }
}
