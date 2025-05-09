package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class ProvaSuStradaServiceImpl implements ProvaSuStradaService{
    @Override
    public void avviaProvaSuStrada(Automobile automobile) throws Exception {
        System.out.println("Avvio della prova su strada per l'automobile: " + automobile);
    }
}
