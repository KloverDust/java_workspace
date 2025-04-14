package it.prova.model.CentroCommerciale;

import java.util.ArrayList;
import java.util.List;

public class CentroCommerciale {
    private String ragioneSociale;
    private String indirizzoPerEsteso;
    private List<Negozio> negoziInCC = new ArrayList<>();

    public CentroCommerciale(String ragioneSociale, String indirizzoPerEsteso) {
        this.ragioneSociale = ragioneSociale;
        this.indirizzoPerEsteso = indirizzoPerEsteso;
    }

    public CentroCommerciale() {
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzoPerEsteso() {
        return indirizzoPerEsteso;
    }

    public void setIndirizzoPerEsteso(String indirizzoPerEsteso) {
        this.indirizzoPerEsteso = indirizzoPerEsteso;
    }

    public List<Negozio> getNegoziInCC() {
        return negoziInCC;
    }

    public void setNegoziInCC(List<Negozio> negoziInCC) {
        this.negoziInCC = negoziInCC;
    }
}
