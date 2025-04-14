package it.prova.test.HotelTester;

import it.prova.model.Hotel.*;

import java.util.ArrayList;
import java.util.List;

public class HotelTester {
    public static void main (String[] args) {
        Hotel hotelZurigo = new Hotel("Zurigo SPA", 5);
        List <Stanza> stanzeHotelZurigo = new ArrayList<>();
        Stanza a400 = new Stanza(400, 250, hotelZurigo);
        Stanza a401 = new Stanza(401, 300, hotelZurigo);
        Stanza a402 = new Stanza(402, 350, hotelZurigo);
        stanzeHotelZurigo.add(a400);
        stanzeHotelZurigo.add(a401);
        stanzeHotelZurigo.add(a402);
        hotelZurigo.setStanzeHotel(stanzeHotelZurigo);

        Cliente marcoVip = new Premio("Marco", "Rossi");
        Cliente michelaTurista = new Turista("Michela", "Melchiorri");
        Cliente valerioRapp = new Rappresentante("Valerio", "Conti");
        List<Cliente> clientiStanza401 = new ArrayList<>();
        // E' IMPORTANTE STABILIRE ENTRAMBI I LATI DELLA RELAZIONE!!
        // NON basta aggiungere i clienti alle stanze, ma bisogna anche dire ai clienti qual è la loro stanza
        // marcoVip.setStanza(a401);
        // valerioRapp.setStanza(a401);
        clientiStanza401.add(marcoVip);
        clientiStanza401.add(valerioRapp);
        marcoVip.setStanza(a401);
        valerioRapp.setStanza(a401);
        a401.setClientiStanza(clientiStanza401);

        int importoStanza401 = hotelZurigo.calcolaConto(a401);
        System.out.println("L'importo che devono pagare i clienti è " + importoStanza401);
    }
}
