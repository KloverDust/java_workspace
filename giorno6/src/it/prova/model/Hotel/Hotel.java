package it.prova.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String ragioneSociale;
    private int stelle;
    List<Stanza> stanzeHotel = new ArrayList<>(); //IMPORTANTE

    public Hotel(String ragioneSociale, int stelle){
        this.ragioneSociale = ragioneSociale;
        this.stelle = stelle;
    }

    public int calcolaConto(Stanza stanzaInput){
        int sommaDaPagare = 0;
        for(int i = 0; i< stanzaInput.getClientiStanza().size(); i++) {
            sommaDaPagare += stanzaInput.getClientiStanza().get(i).sommaRealeDaPagare();
        }

//        for (Cliente cliente: stanzaInput.getClientiStanza()){
//            sommaDaPagare += cliente.sommaRealeDaPagare();
//        }

        return sommaDaPagare;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    public List<Stanza> getStanzeHotel() {
        return stanzeHotel;
    }

    public void setStanzeHotel(List<Stanza> stanzeHotel) {
        this.stanzeHotel = stanzeHotel;
    }
}
