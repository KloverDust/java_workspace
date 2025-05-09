package it.prova.catenadimontaggio.service;

import it.prova.catenadimontaggio.model.Automobile;
import org.springframework.stereotype.Service;

@Service
public class CarrozzeriaServiceImpl implements CarrozzeriaService{
    @Override
    public void avviaCarrozzeria(Automobile automobile) throws Exception {
        System.out.println("Avvio della carrozzeria per l'automobile: " + automobile);
    }
}
