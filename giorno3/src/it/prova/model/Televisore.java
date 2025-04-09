package it.prova.model;

public class Televisore {
    private String marca;
    private float prezzo;
    private String modello;
    private int pollici;

    // Costruttore di default che permettere l'istanziazione con televisore = new Televisore();
    public Televisore() {

    }

    //Costruttore con parametri
    public Televisore( String marca, float prezzo, String modello, int pollici) {
        this.marca = marca;
        this.prezzo = prezzo;
        this.modello = modello;
        this.pollici = pollici;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getPollici() {
        return pollici;
    }

    public void setPollici(int pollici) {
        this.pollici = pollici;
    }

    public boolean costaMenoDelBudgetDisponibile(int budgetDisponibile) {
        return this.prezzo < budgetDisponibile;
    }

    public boolean stessaMarcaDi(Televisore altroTelevisore) {
        if (this.marca.equals(altroTelevisore.getMarca())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean piuGrandeDi(Televisore altroTelevisore) {
        if (this.pollici > altroTelevisore.getPollici())
            return true;
        else
            return false;
    }

    public boolean miglioreQualitaPrezzoDi(Televisore altroTelevisore) {
        float qualitaPrimo = (float) this.prezzo / this.pollici;
        float qualitaSecondo = (float) altroTelevisore.getPrezzo() / altroTelevisore.getPollici();

        return (qualitaPrimo> qualitaSecondo);
    }

    public boolean esisteAlmenoUnoPiuEconomico(Televisore[] catalogo) {
        for (int i= 0; i < catalogo.length; i++){
            return this.prezzo > catalogo[i].getPrezzo();
        }
        return false;
    }

    public int quantiSonoPiuGrandi(Televisore[] catalogo) {
        int counter = 0;
        for (int i = 0; i < catalogo.length; i++) {
            if (this.pollici < catalogo[i].getPollici())
                counter++;
        }
        return counter;
    }

    public int quantiSonoPiuCariAvendoStessaMarca(Televisore[] catalogo) {
        int counter = 0;
        for (int i = 0; i < catalogo.length; i++) {
            if (this.marca.equals(catalogo[i].getMarca()) && this.prezzo < catalogo[i].getPrezzo()) {
                counter++;
            }
        }
        return counter;
    }

    public boolean ePiuCaroDellaMedia(Televisore[] catalogo) {
        float somma = 0;
        for (Televisore televisore : catalogo) {
            somma += televisore.getPrezzo();
        }
        float media = somma / (float) catalogo.length;
        return (this.prezzo > media);
    }
}

