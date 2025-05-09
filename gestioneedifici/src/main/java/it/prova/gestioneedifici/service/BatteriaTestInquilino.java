package it.prova.gestioneedifici.service;

import it.prova.gestioneedifici.model.Edificio;
import it.prova.gestioneedifici.model.Inquilino;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class BatteriaTestInquilino {
    @Autowired
    EdificioService edificioService;

    @Autowired
    InquilinoService inquilinoService;

    private static void testInserisciInquilinoConControlli() {
        System.out.print("testInserimentoValido: ");
        Inquilino inquilino = new Inquilino("Mario", "Bianconi", LocalDate.of(2000,01,01));
        inquilino.setAffittoDovuto(300);

    }
}
