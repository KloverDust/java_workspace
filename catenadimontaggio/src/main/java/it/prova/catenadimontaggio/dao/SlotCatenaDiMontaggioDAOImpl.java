package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;
import it.prova.catenadimontaggio.service.SlotCatenaDiMontaggioService;

public class SlotCatenaDiMontaggioDAOImpl implements SlotCatenaDiMontaggioDAO{

    @Override
    public SlotCatenaDiMontaggio getSlot(String brand) {
        for (SlotCatenaDiMontaggio slotCatenaDiMontaggioItem : DBMock.LISTA_SLOT_CATENA_DI_MONTAGGIO) {
            if(slotCatenaDiMontaggioItem.getBrand().equals(brand))
                return slotCatenaDiMontaggioItem;
        }
        return null;
    }

    @Override
    public void addAutomobileToSlot(Automobile automobileInput, SlotCatenaDiMontaggio slotCatenaDiMontaggioInput) {
        automobileInput.setSlotCatenaDiMontaggio(slotCatenaDiMontaggioInput);
        slotCatenaDiMontaggioInput.addToAutomobileList(automobileInput);
    }
}
