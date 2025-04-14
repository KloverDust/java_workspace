package it.prova.model.CentroCommerciale;

import java.util.ArrayList;
import java.util.List;

public class Negozio {
    private String ragioneSociale;
    private String partitaIva;
    List<Lavoratore> lavoratoriNegozio = new ArrayList<>();
    List<Item> itemsInNegozio = new ArrayList<>();
    CentroCommerciale centroDiAppartenenza;

    public Negozio(String ragioneSociale, String partitaIva, List<Lavoratore> lavoratoriNegozio, CentroCommerciale centroDiAppartenenza) {
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
        this.lavoratoriNegozio = lavoratoriNegozio;
        this.centroDiAppartenenza = centroDiAppartenenza;
    }

    public Negozio(String ragioneSociale, CentroCommerciale centroDiAppartenenza, String partitaIva) {
        this.ragioneSociale = ragioneSociale;
        this.centroDiAppartenenza = centroDiAppartenenza;
        this.partitaIva = partitaIva;
    }

    public Negozio(String ragioneSociale, String partitaIva) {
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public List<Lavoratore> getLavoratoriNegozio() {
        return lavoratoriNegozio;
    }

    public void setLavoratoriNegozio(List<Lavoratore> lavoratoriNegozio) {
        this.lavoratoriNegozio = lavoratoriNegozio;
    }

    public CentroCommerciale getCentroDiAppartenenza() {
        return centroDiAppartenenza;
    }

    public void setCentroDiAppartenenza(CentroCommerciale centroDiAppartenenza) {
        this.centroDiAppartenenza = centroDiAppartenenza;
    }

    public List<Item> getItemsInNegozio() {
        return itemsInNegozio;
    }

    public void setItemsInNegozio(List<Item> itemsInNegozio) {
        this.itemsInNegozio = itemsInNegozio;
    }

    public boolean addToItems(Lavoratore lavoratore, Item item) {
        if (!lavoratoriNegozio.contains(lavoratore)) {
            return false;
        }
        return lavoratore.handleItemAdd(item);
    }


    public boolean removeFromItems(Lavoratore lavoratore, Item item) {
        if (!lavoratoriNegozio.contains(lavoratore)) {
            return false;
        }
        return lavoratore.handleItemRemove(item);
    }
}
