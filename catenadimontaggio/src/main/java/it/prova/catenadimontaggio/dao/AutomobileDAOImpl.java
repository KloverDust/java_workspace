package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;

public class AutomobileDAOImpl implements AutomobileDAO{
    @Override
    public Automobile get(String modello) {
        for (Automobile automobileItem : DBMock.LISTA_AUTOMOBILI) {
            if(automobileItem.getModello().equals(modello))
                return automobileItem;
        }
        return null;
    }
}
