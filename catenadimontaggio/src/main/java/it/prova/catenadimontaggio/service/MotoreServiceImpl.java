package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class MotoreServiceImpl implements MotoreService{
    @Override
    public void avviaMotore(Automobile automobile) throws Exception {
        System.out.println("Avvio del motore per l'automobile: " + automobile);
    }
}
