package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;

public interface SlotCatenaDiMontaggioDAO {

    public SlotCatenaDiMontaggio getSlot(String brand);
    public void addAutomobileToSlot(Automobile automobile, SlotCatenaDiMontaggio slotCatenaDiMontaggio);
}
