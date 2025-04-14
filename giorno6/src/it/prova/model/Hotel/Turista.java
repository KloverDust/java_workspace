package it.prova.model.Hotel;

public class Turista extends Cliente{
    public Turista(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int sommaRealeDaPagare() {
        return this.getStanza().getQuantoAPersona();
    }
}
