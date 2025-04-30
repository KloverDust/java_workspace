package it.prova.test;

import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockData {
    public static final List<PostaDiPaese> POSTE_LIST = new ArrayList<>();
    public static final List<Destinatario> DESTINATARI_LIST = new ArrayList<>();
    static {
        PostaDiPaese postaDiPaese1 = new PostaDiPaese("Posta sul colle", "Roma 1 Centrale (MI)", LocalDate.of(2023, 1, 1));
        PostaDiPaese postaDiPaese2 = new PostaDiPaese("Posta sul mare", "Roma 2 (RM)", LocalDate.of(2022, 1, 1));
        PostaDiPaese postaDiPaese3 = new PostaDiPaese("Posta sul lago", "Roma 3 Centrale (TO)",80, LocalDate.of(1999,1,1));
        PostaDiPaese postaDiPaese4 = new PostaDiPaese("Posta in montagna", "Roma 4 (VT)", 120, LocalDate.of(1994,1,1));
        PostaDiPaese postaDiPaese5 = new PostaDiPaese("Posta in campagna", "Roma 5 (NA)",70, LocalDate.of(1980,1,1));
        PostaDiPaese postaDiPaese6 = new PostaDiPaese("Posta in città", "Roma 6 (RM)", LocalDate.of(1999,1,1));
        PostaDiPaese postaDiPaese7 = new PostaDiPaese("Posta in collina", "Roma 7 (RM)", LocalDate.of(1994,1,1));
        PostaDiPaese postaDiPaese8 = new PostaDiPaese("Posta in pianura", "Roma 8 (RM)", LocalDate.of(1980,1,1));
        POSTE_LIST.add(postaDiPaese1);
        POSTE_LIST.add(postaDiPaese2);
        POSTE_LIST.add(postaDiPaese3);
        POSTE_LIST.add(postaDiPaese4);
        POSTE_LIST.add(postaDiPaese5);
        POSTE_LIST.add(postaDiPaese6);
        POSTE_LIST.add(postaDiPaese7);
        POSTE_LIST.add(postaDiPaese8);

        Destinatario destinatario1 = new Destinatario("Mario", "Rossi", "Roma 1 (MI)", 18);
        Destinatario destinatario2 = new Destinatario("Luigi", "Verdi", "Roma 2 (RM)", 20);
        Destinatario destinatario3 = new Destinatario("Giovanni", "Bianchi", "Roma 3 (TO)", 16);
        Destinatario destinatario4 = new Destinatario("Antonio", "Neri", "Roma 4 (VT)", 25);
        Destinatario destinatario5 = new Destinatario("Francesco", "Gialli", "Roma 5 (NA)",70);
        DESTINATARI_LIST.add(destinatario1);
        DESTINATARI_LIST.add(destinatario2);
        DESTINATARI_LIST.add(destinatario3);
        DESTINATARI_LIST.add(destinatario4);
        DESTINATARI_LIST.add(destinatario5);

        destinatario1.setPostaDiPaese(postaDiPaese1);
        destinatario2.setPostaDiPaese(postaDiPaese2);
        destinatario3.setPostaDiPaese(postaDiPaese3);
        destinatario4.setPostaDiPaese(postaDiPaese4);
        destinatario5.setPostaDiPaese(postaDiPaese5);

        postaDiPaese1.getDestinatari().add(destinatario1);
        postaDiPaese2.getDestinatari().add(destinatario2);
        postaDiPaese3.getDestinatari().add(destinatario3);
        postaDiPaese4.getDestinatari().add(destinatario4);
        postaDiPaese5.getDestinatari().add(destinatario5);

    }

}
