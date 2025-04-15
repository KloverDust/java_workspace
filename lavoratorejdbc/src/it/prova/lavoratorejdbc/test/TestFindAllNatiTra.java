package it.prova.lavoratorejdbc.test;

import it.prova.lavoratorejdbc.dao.LavoratoreDAO;
import it.prova.lavoratorejdbc.model.Lavoratore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestFindAllNatiTra {

    public static void main(String[] args) throws ParseException {
        System.out.println("Inizio....");

        LavoratoreDAO lavoratoreDaoInstance = new LavoratoreDAO();
        Date dataPrima = new SimpleDateFormat("dd/MM/yyyy").parse("20/10/1990");
        Date dataDopo = new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2090");

        System.out.println("################ TEST findAllNatiTra ################");

        List<Lavoratore> attualmentePresentiSullaBaseDati = lavoratoreDaoInstance.elencaTuttiQuelliAttualmenteSullaBaseDati();
        List<Lavoratore> lavoratoriRestituiti = new ArrayList<>();

        if (!attualmentePresentiSullaBaseDati.isEmpty()) {
            lavoratoriRestituiti = lavoratoreDaoInstance.findAllNatiTra(dataPrima, dataDopo);

            if (lavoratoriRestituiti.size() >= 0){
                System.out.println("Il test è stato eseguito con successo e sono stati restituiti i seguenti lavorati nati tra il " + dataPrima + " e " + dataDopo );
                for (Lavoratore lav: lavoratoriRestituiti){
                    System.out.println(lav.getNome() + " " + lav.getCognome());
                }
            } else {
                throw new AssertionError("test di findAllNatiTra: FAILED");
            }

        } else
            throw new AssertionError("test di rimozione: FAILED in quanto non c'è nulla da rimuovere");

        System.out.println("################### TEST deleteByCognome :FINE #######");

    }
}
