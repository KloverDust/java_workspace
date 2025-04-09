package it.prova.model;

public class Televisore {
    private String marca;
    private float prezzo;
    private String modello;
    private int pollici;

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
}
