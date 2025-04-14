package it.prova.model.Hotel;

public class Rappresentante extends Cliente{
    public Rappresentante(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int sommaRealeDaPagare() {
        int totaleDovuto = this.getStanza().getQuantoAPersona();
        return (totaleDovuto - totaleDovuto * 20 / 100);
    }
}
