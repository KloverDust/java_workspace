package it.prova.model.Hotel;

import java.util.ArrayList;
import java.util.List;

public class Stanza {
    private int numeroStanza;
    private int quantoAPersona;
    private Hotel hotelAppartenenza;
    private List<Cliente> clientiStanza = new ArrayList<>();

    public Stanza(int numeroStanza, int quantoAPersona, Hotel hotelAppartenenza) {
        this.numeroStanza = numeroStanza;
        this.quantoAPersona = quantoAPersona;
        this.hotelAppartenenza = hotelAppartenenza;
    }

    public int getNumeroStanza() {
        return numeroStanza;
    }

    public void setNumeroStanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
    }

    public int getQuantoAPersona() {
        return quantoAPersona;
    }

    public void setQuantoAPersona(int quantoAPersona) {
        this.quantoAPersona = quantoAPersona;
    }

    public Hotel getHotelAppartenenza() {
        return hotelAppartenenza;
    }

    public void setHotelAppartenenza(Hotel hotelAppartenenza) {
        this.hotelAppartenenza = hotelAppartenenza;
    }

    public List<Cliente> getClientiStanza() {
        return clientiStanza;
    }

    public void setClientiStanza(List<Cliente> clientiStanza) {
        this.clientiStanza = clientiStanza;
    }
}
