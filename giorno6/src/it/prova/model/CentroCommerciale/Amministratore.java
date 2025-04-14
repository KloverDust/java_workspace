package it.prova.model.CentroCommerciale;

public class Amministratore extends Lavoratore{

    public Amministratore(String nome, String cognome) {
        super(nome, cognome);
    }

    public Amministratore() {
    }

    @Override
    public boolean handleItemAdd(Item item) {
        return true;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
