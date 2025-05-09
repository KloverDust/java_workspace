package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class ImpiantoElettricoServiceImpl implements  ImpiantoElettricoService{
    @Override
    public void avviaImpiantoElettrico(Automobile automobile) throws Exception {
        System.out.println("Avvio dell'impianto elettrico per l'automobile: " + automobile);
    }
}
