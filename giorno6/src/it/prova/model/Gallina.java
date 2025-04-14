package it.prova.model;

public class Gallina implements Volatile{
    private String piumaggio;

    public Gallina(String piumaggio){
        this.piumaggio = piumaggio;
    }

    public Gallina(){

    }

    @Override
    public String vola() {
        return "Io gallina so svolazzare";
    }

    @Override
    public String stampaProprieta() {
        return "Il colore del mio piumaggio è " + this.piumaggio;
    }

    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if(! (altroVolatile instanceof Gallina))
            return false;

        Gallina temp = (Gallina) altroVolatile;
        return this.piumaggio.equals(temp.getPiumaggio());
    }

    public String getPiumaggio() {
        return piumaggio;
    }

    public void setPiumaggio(String piumaggio) {
        this.piumaggio = piumaggio;
    }
}
