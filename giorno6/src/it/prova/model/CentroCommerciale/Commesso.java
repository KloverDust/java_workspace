package it.prova.model.CentroCommerciale;

public class Commesso extends Lavoratore{

    public Commesso(String nome, String cognome){
        super(nome, cognome);
    }

    public Commesso() {
        super();
    }

    @Override
    public boolean handleItemAdd(Item item) {
        if (this.negozioAppartenenza == null) {
            return false;
        }
        this.getNegozioAppartenenza().getItemsInNegozio().add(item);
        item.setNegozioAppartenza(this.getNegozioAppartenenza());
        return true;
    }

    @Override
    public boolean handleItemRemove(Item item) {
        if (this.negozioAppartenenza == null) {
            return false;
        }
        this.getNegozioAppartenenza().getItemsInNegozio().remove(item);
        item.setNegozioAppartenza(null);
        return true;
    }
}
