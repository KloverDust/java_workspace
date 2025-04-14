package it.prova.model.Hotel;

public class Premio extends Cliente{
    public Premio(String nome, String cognome) {
        super(nome, cognome);
    }

    @Override
    public int sommaRealeDaPagare() {
        return 0;
    }
}
