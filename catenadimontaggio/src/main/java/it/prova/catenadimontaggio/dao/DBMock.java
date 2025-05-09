package it.prova.catenadimontaggio.dao;

import it.prova.catenadimontaggio.model.Automobile;
import it.prova.catenadimontaggio.model.SlotCatenaDiMontaggio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBMock {
    public static final List<Automobile> LISTA_AUTOMOBILI = new ArrayList<>();
    public static final SlotCatenaDiMontaggio CATENA_DI_MONTAGGIO_1 = new SlotCatenaDiMontaggio();
    public static final SlotCatenaDiMontaggio CATENA_DI_MONTAGGIO_2 = new SlotCatenaDiMontaggio();
    public static final List<SlotCatenaDiMontaggio> LISTA_SLOT_CATENA_DI_MONTAGGIO = new ArrayList<>();
    static{
        Automobile automobile1 = new Automobile("Fiat Panda", "12345678901234567", LocalDate.of(2023, 1, 1));
        Automobile automobile2 = new Automobile("Fiat Punto", "23456789012345678", LocalDate.of(2023, 2, 1));
        Automobile automobile3 = new Automobile("Fiat 500", "34567890123456789", LocalDate.of(2023, 3, 1));
        Automobile automobile4 = new Automobile("Fiat Tipo", "45678901234567890", LocalDate.of(2023, 4, 1));
        Automobile automobile5 = new Automobile("Fiat Bravo", "56789012345678901", LocalDate.of(2023, 5, 1));
        LISTA_AUTOMOBILI.add(automobile1);
        LISTA_AUTOMOBILI.add(automobile2);
        LISTA_AUTOMOBILI.add(automobile3);
        LISTA_AUTOMOBILI.add(automobile4);
        LISTA_AUTOMOBILI.add(automobile5);

        CATENA_DI_MONTAGGIO_1.addToAutomobileList(automobile1);
        CATENA_DI_MONTAGGIO_1.addToAutomobileList(automobile2);
        LISTA_SLOT_CATENA_DI_MONTAGGIO.add(CATENA_DI_MONTAGGIO_1);
        LISTA_SLOT_CATENA_DI_MONTAGGIO.add(CATENA_DI_MONTAGGIO_2);

        CATENA_DI_MONTAGGIO_2.addToAutomobileList(automobile3);
        CATENA_DI_MONTAGGIO_2.addToAutomobileList(automobile4);
        CATENA_DI_MONTAGGIO_2.addToAutomobileList(automobile5);



    }


}
