package it.prova.test.onetomany;

import it.prova.model.onetomany.Foglio;
import it.prova.model.onetomany.Raccoglitore;

public class RaccoglitoreTester {
    public static void main(String[] args) {
        Foglio foglio1 = new Foglio("nuovo", "righe");
        Foglio foglio2 = new Foglio("riciclato", "quadretti");
        Foglio foglio3 = new Foglio("riciclato2", "quadri");

        Foglio[] fogli1 = {foglio1, foglio2};
        Raccoglitore raccoglitore = new Raccoglitore("Rosso", 2, fogli1);

        System.out.println(raccoglitore);

        raccoglitore.addToFogli(foglio3);

        System.out.println(raccoglitore);

        //raccoglitore.removeFromFogli(1); commento

        System.out.println(raccoglitore);

        Foglio[] fogli2 = {foglio1, foglio2, foglio3};
        Raccoglitore raccoglitore1 = new Raccoglitore("blu", 2, fogli2);

        System.out.println("\nTest esisteAlmenoUnFoglioAQuadretti start");
        boolean esisteAQuadrettiCheck = raccoglitore1.esisteAlmenoUnFoglioAQuadretti();
        System.out.println("Esiste almeno un foglio a quadretti? " + esisteAQuadrettiCheck);
        System.out.println("Test esisteAlmenoUnFoglioAQuadretti end");


        // PREPRAZIONE TEST quantiFogliDiAltaQualita
        Foglio foglioAQRighe = new Foglio("alta", "righe");
        Foglio foglioBQQuadretti = new Foglio("bassa", "quadretti");
        Foglio foglioMQPentagramma = new Foglio("media", "pentagrammato");

        Foglio[] fogliTest3 = new Foglio[] {foglioAQRighe, foglioBQQuadretti, foglioMQPentagramma, new Foglio("alta", "righe")};
        Raccoglitore raccoglitoreTest3 = new Raccoglitore("blu", 2, fogliTest3);

        System.out.println("\nTest quantiFogliDiAltaQualita start");
        int numeroFogliDiAltaQualita = raccoglitoreTest3.quantiFogliDiAltaQualita();
        System.out.println("Quanti fogli di alta qualita ci sono in raccoglitoreTest3? " + numeroFogliDiAltaQualita);
        System.out.println("Test quantiFogliDiAltaQualita end");
        // FINE TEST quantiFogliDiAltaQualita


        // PREPARAZIONE TEST stessoColoreENumeroFogliDi
        Foglio foglioAltaRighe = new Foglio("alta", "righe");
        Foglio foglioBassaQuadretti = new Foglio("bassa", "quadretti");
        Foglio foglioMediaPentagramma = new Foglio("media", "pentagrammato");

        Foglio[] fogliRaccoglitoreRossoUno = new Foglio[] {foglioAltaRighe, foglioBassaQuadretti, foglioMediaPentagramma};
        Foglio[] fogliRaccoglitoreRossoDue = new Foglio[] {
                new Foglio("media", "righe"),
                new Foglio("alta", "quadretti"),
                new Foglio("bassa", "pentagrammato")
        };

        Raccoglitore raccoglitoreRossoUno = new Raccoglitore("rosso", 2, fogliRaccoglitoreRossoUno);
        Raccoglitore raccoglitoreRossoDue = new Raccoglitore("rosso", 5, fogliRaccoglitoreRossoDue); // stesso colore, stesso numero di fogli

        System.out.println("\nTest stessoColoreENumeroFogliDi start");
        boolean risultatoTest4 = raccoglitoreRossoUno.stessoColoreENumeroFogliDi(raccoglitoreRossoDue);
        System.out.println("I raccoglitori rossoOriginale e rossoClone hanno stesso colore e numero di fogli? " + risultatoTest4); // atteso: true
        System.out.println("Test stessoColoreENumeroFogliDi end");
        // FINE TEST stessoColoreENumeroFogliDi


    }
}
