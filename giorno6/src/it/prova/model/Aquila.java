package it.prova.model;

public class Aquila implements Volatile{
    private String razzaAquila;

    public Aquila(String razzaAquila){
        this.razzaAquila = razzaAquila;
    }

    public Aquila(){

    }

    @Override
    public String vola() {
        return "I aquila so volare";
    }

    @Override
    public String stampaProprieta() {
        return "La razza dell'aquila è " + this.razzaAquila;
    }

    @Override
    public boolean eUgualeA(Volatile altroVolatile) {
        if(! (altroVolatile instanceof Aquila))
            return false;

        Aquila temp = (Aquila) altroVolatile;
        return(this.razzaAquila.equals(temp.getRazzaAquila()));
    }

    public String getRazzaAquila() {
        return razzaAquila;
    }

    public void setRazzaAquila(String razzaAquila) {
        this.razzaAquila = razzaAquila;
    }
}
