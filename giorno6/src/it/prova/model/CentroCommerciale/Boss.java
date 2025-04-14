package it.prova.model.CentroCommerciale;

public class Boss extends Lavoratore{

    public Boss(String nome, String cognome) {
        super(nome, cognome);
    }

    public Boss() {
    }

    @Override
    public boolean handleItemAdd(Item item) {
        return false;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        return false;
    }
}
