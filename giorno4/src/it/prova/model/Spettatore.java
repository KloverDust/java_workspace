package it.prova.model;

public class Spettatore {
    private String nome;
    private String cognome;
    private String numeroCartaDiCredito;
    //private Biglietto biglietto = new Biglietto(); SBAGLIATO PERCHE' VA LASCIATO A NULLA, SI AMMETTE LA POSSIBILITA' CHE VENGA ISTANZIATO (CREATO)
    private Biglietto biglietto;

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito, Biglietto biglietto){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
        this.biglietto= biglietto;
    }

    public Spettatore(String nome, String cognome, String numeroCartaDiCredito){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public Spettatore(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroCartaDiCredito() {
        return numeroCartaDiCredito;
    }

    public void setNumeroCartaDiCredito(String numeroCartaDiCredito) {
        this.numeroCartaDiCredito = numeroCartaDiCredito;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }

    public void setBiglietto(Biglietto biglietto) {
        this.biglietto = biglietto;
    }

    public float incassoDeiPagantiNellaMiaFila(Spettatore[] elencoPagantiTotali) {
        char letteraFila = this.getBiglietto().getLetteraFila();
        float incassoMiaFila = 0;
        for (Spettatore s : elencoPagantiTotali) {
            if (letteraFila == s.getBiglietto().getLetteraFila())
                incassoMiaFila += s.getBiglietto().getPrezzo();
        }
        return (incassoMiaFila + this.getBiglietto().getPrezzo());
    }

    public int numeroSpettatoriDelMioStessoSpettacolo(Spettatore[] elentoPagantiTotali) {
        int spettatoriMioStessoSpettacoloCounter = 0;
        String mioSpettacolo = this.getBiglietto().getNomeSpettacolo();
        for (Spettatore s: elentoPagantiTotali){
            if(s.getBiglietto().getNomeSpettacolo().equals(mioSpettacolo))
                spettatoriMioStessoSpettacoloCounter++;
        }
        return spettatoriMioStessoSpettacoloCounter;
    }

    public boolean numeroSpettatoriMioSpettacoloSuperaAspettativa(Spettatore[] paganti, int aspettativa) {
        int numeroSpettatoriMioStessoSpettacolo= numeroSpettatoriDelMioStessoSpettacolo(paganti);
        return (numeroSpettatoriMioStessoSpettacolo> aspettativa);
    }

    public static int contaQuantiSenzaBiglietto(Spettatore[] elencoSpettatori) {
        int counter = 0;
        for(Spettatore s: elencoSpettatori) {
            Biglietto b = s.getBiglietto();
            if (b.getNomeSpettacolo() == null)
                counter++;
        }
        return counter;
    }

    public int contaQuantiNellaMiaStessaFila(Spettatore[] elencoSpettatori) {
        char filaMia = this.getBiglietto().getLetteraFila();
        int counter = 0;
        for (Spettatore s: elencoSpettatori) {
            if (s.getBiglietto().getLetteraFila() == filaMia){
                counter++;
            }
        }
        return counter;
    }




}
