package it.prova.model;

public class Pinguino implements Volatile{
    private String continenteAppartenenza;

    public Pinguino(String continenteAppartenenza) {
        this.continenteAppartenenza = continenteAppartenenza;
    }

    public Pinguino(){

    }

    @Override
    public String vola() {
        return "Io pinguino non so volare";
    }

    @Override
    public String stampaProprieta() {
        return "Il mio continente di appartenenza è " + this.getContinenteAppartenenza();
    }

    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if(!(altroVolatile instanceof Pinguino))
            return false;

        Pinguino temp = (Pinguino) altroVolatile;
        return temp.getContinenteAppartenenza().equals(this.continenteAppartenenza);
    }

    public String getContinenteAppartenenza() {
        return continenteAppartenenza;
    }

    public void setContinenteAppartenenza(String continenteAppartenenza) {
        this.continenteAppartenenza = continenteAppartenenza;
    }
}
