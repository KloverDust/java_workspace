package it.prova.model.onetomany;

public class Raccoglitore {
    private String colore;
    private int spessore;
    private Foglio[] fogli;

    public Raccoglitore() {

    }

    public Raccoglitore(String colore, Foglio[] fogli) {
        this.colore = colore;
        this.fogli = fogli;
    }

    public Raccoglitore(String colore, int spessore, Foglio[] fogli) {
        this.colore = colore;
        this.spessore = spessore;
        this.fogli = fogli;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public int getSpessore() {
        return spessore;
    }

    public void setSpessore(int spessore) {
        this.spessore = spessore;
    }

    public Foglio[] getFogli() {
        return fogli;
    }

    public void setFogli(Foglio[] fogli) {
        this.fogli = fogli;
    }

    //NOTE: Capire come agiscono sulla memoria i setter e le assegnazioni con =
    public void addToFogli (Foglio foglioDaAggiungere) {
        Foglio[] fogliEsistenti = this.fogli;
        int dimensioneFogliEsistenti = fogliEsistenti.length;
        Foglio[] fogliCompleti = new Foglio[dimensioneFogliEsistenti+1];

        for (int i=0; i< dimensioneFogliEsistenti; i++) {
            fogliCompleti[i] = fogliEsistenti[i];
        }
        fogliCompleti[dimensioneFogliEsistenti] = foglioDaAggiungere;
        this.fogli=fogliCompleti;
    }

    public boolean removeFromFogli(int index) {
        if (this.fogli.length < index)
            return false;

        Foglio[] arrayCopy = new Foglio[this.fogli.length -1];
        int count = 0;
        for (int i = 0; i < this.fogli.length; i++) {
            if (i != index)
                arrayCopy[count++] = this.fogli[i];
        }
        this.fogli = arrayCopy;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Raccoglitore [colore=").append(colore).append(", spessore=").append(spessore).append(", fogli=\n");
        for (Foglio f : fogli) {
            sb.append(f).append(", \n");
        }
        sb.append("]");
        return sb.toString();
    }
}
