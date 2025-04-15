package it.prova.lavoratorejdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestContaQuantiLavoratoriConIlCognome {

    public static void main(String[] args) {
        System.out.println("Inizio....");

        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();
        String cognomeRicercato = "Rossi";

        System.out.println("################ TEST TestContaQuantiLavoratoriConIlCognome ################");
        int numeroLavConStessoCognome = lavoratoreDaoInstance.contaQuantiLavoratoriConIlCognome(cognomeRicercato);

        if (numeroLavConStessoCognome != 0) {

            if (numeroLavConStessoCognome >= 0){
                System.out.println("Il test è stato eseguito con successo e sono stati contati " + numeroLavConStessoCognome + " con il cognome " + cognomeRicercato );
            } else {
                throw new AssertionError("test di contaQuantiLavoratoriConIlCognome: FAILED");
            }

        } else
            throw new AssertionError("test di contaQuantiLavoratoriConIlCognome fallito");

        System.out.println("################### TEST contaQuantiLavoratoriConIlCognome :FINE #######");

    }
}
