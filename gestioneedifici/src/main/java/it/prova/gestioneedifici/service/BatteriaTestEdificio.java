package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.model.Edificio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BatteriaTestEdificio {
    @Autowired
    EdificioService edificioService;

    public void testInserisciEdificioConControlli() throws Exception{
        System.out.println("INZIO TEST testInserisciEdificioConControlli");

        //Edificio costruito nel passato -> non valido
//        Edificio edificioProvaInsNO1 = new Edificio("Indirizzo dei cieli 1", "INTEGRABUILD", LocalDate.of(2020,2,2), 5);
//        edificioService.inserisciEdificioConControlli(edificioProvaInsNO1);

        //Edificio costruito nel futuro con 3 piani -> Non valido
//        Edificio edificioProvaInsNO2 = new Edificio("Indirizzo dei cieli 2", "INTEGRABUILD", LocalDate.of(2026,2,2), 3);
//        edificioService.inserisciEdificioConControlli(edificioProvaInsNO2);

        //Edificio costruito nel futuro con 7 piani -> Valido
        Edificio edificioProvaInsOK1 = new Edificio("Indirizzo dei cieli3 ", "INTEGRABUILD", LocalDate.of(2026,4,12), 7);
        edificioService.inserisciEdificioConControlli(edificioProvaInsOK1);

        System.out.println("FINE TEST testInserisciEdificioConControlli");
    }
}
