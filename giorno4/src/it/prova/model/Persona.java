package it.prova.model;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private Indirizzo indirizzo;


    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }


    public Indirizzo getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo( Indirizzo indirizzo) {
         this.indirizzo = indirizzo;
    }

    public Persona () {

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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public boolean abitaA(String cittaInput){
       String cittaAbitazione = this.getIndirizzo().getCitta();
       return (cittaAbitazione.equals(cittaInput));
    }

    public boolean haAlmenoUnConcittadino(Persona[] elenco) {
        String cittaPersona = this.getIndirizzo().getCitta();
        for (int i=0; i< elenco.length; i++) {
            if (cittaPersona.equals(elenco[i].getIndirizzo().getCitta()))
                return true;
        }
        return false;

    }

    public boolean sonoTuttiPiuAnziani(Persona[] elenco){
        int etaPersona = this.eta;
        for (int i=0; i< elenco.length; i++) {
            if (etaPersona > elenco[i].getEta()){
                return false;
            }
        }
        return true;
    }

    public int quantiCoabitanoNelMioStessoPalazzo(Persona[] elencoInput) {
       String cittaPersona = this.getIndirizzo().getCitta();
       String viaPersona = this.getIndirizzo().getVia();
       String civicoPersona = this.getIndirizzo().getCivico();

       int counterCoabitanti = 0;
       for (int i=0; i< elencoInput.length; i++) {
           String cittaIndagato = elencoInput[i].getIndirizzo().getCitta();
           String viaIndagato = elencoInput[i].getIndirizzo().getVia();
           String civicoIndagato = elencoInput[i].getIndirizzo().getCivico();

           if (cittaPersona.equals(cittaIndagato) && viaPersona.equals(viaIndagato) && civicoPersona.equals(civicoIndagato))
               counterCoabitanti++;
       }
       return counterCoabitanti;

    }

//    public void assegnaCoinquilino(Persona nuovoCoinquilino){
//        String cittaA = this.getIndirizzo().getCitta();
//        String viaA = this.getIndirizzo().getVia();
//        String civicoA = this.getIndirizzo().getCivico();
//
//        String cittaCoinq = nuovoCoinquilino.getIndirizzo().getCitta();
//        String viaCoinq = nuovoCoinquilino.getIndirizzo().getVia();
//        String civicoCoinq = nuovoCoinquilino.getIndirizzo().getCivico();
//
//        if (cittaA.equals(cittaCoinq) && viaA.equals(viaCoinq) && civicoA.equals(civicoCoinq)){
//            System.out.println("Il coinquilino è già stato assegnato");
//        } else {
//            nuovoCoinquilino.setIndirizzo.(Indirizzo indirizzoNuovo{cittA, viaA, civicoA});
//            this.indirizzo.setCitta();
//            nuovoCoinquilino.getIndirizzo().setCitta(cittaA);
//            nuovoCoinquilino.getIndirizzo().setVia(viaA);
//            nuovoCoinquilino.getCivico().setCivico(cittaA);
//
//            System.out.println("Coinquilino assegnato con successo");
//        }
//    }

    public void assegnaCoinquilino(Persona nuovoCoinquilino){
        nuovoCoinquilino.getIndirizzo().setCitta(this.indirizzo.getCitta());
        nuovoCoinquilino.getIndirizzo().setVia(this.indirizzo.getVia());
        nuovoCoinquilino.getIndirizzo().setCivico(this.indirizzo.getCivico());
    }

    // se avessi fatto nuovoCoinquilino.setIndirizzo(this.indirizzo) quello che faccio è assegnare lo stesso puntatore all'oggetto indirizzo al nuovo coinquilino.
    // Di conseguenza qualunque modifica a quell'indirizzo avrà ripercursioni per entrambi dato che il loro oggetto indirizzo è condiviso
    // CODE KATA -> FILOSOFIA DI VITA

    public static Indirizzo[] listaIndirizziDegliOver60(Persona[] persone) {
        int numeroOver60=0;
        for (Persona persona : persone) {
            if (persona.getEta() > 60) {
                numeroOver60++;
            }
        }

        Indirizzo[] indirizziOver60 = new Indirizzo[numeroOver60];
        int j=0;
        for(int i=0; i<persone.length; i++){
            if (persone[i].getEta()> 60){
                //indirizziOver60[j].setCitta(persone[i].getIndirizzo().getCitta()); -> Metodo non proprio corretto perché voglio restituire indirizzi che gia ci sono, non ho bisogno di salvarne copie in memoria
                //indirizziOver60[j].setVia(persone[i].getIndirizzo().getVia());
                //indirizziOver60[j].setCivico(persone[i].getIndirizzo().getCivico());
                indirizziOver60[j]= persone[i].getIndirizzo();
                j++;
            }

        }
        return indirizziOver60;
    }

    // Ricordare analogia delle stanze per i pezzetti di memoria allocati per i dati
    // se mi trovo in una stanza e voglio accedere a un dato che si trova nell'altra stanza,
    // devo bussare (quindi invocare getIstanza) e accedere alle variabili con i rispettivi getter

    public int quantiMieiOmonimiNellaMiaStessaCitta(Persona[] elencoInput){
        String mioNome = this.nome;
        int mieiOmonimiCounter = 0;
        for (Persona p: elencoInput){
            if(mioNome.equals(p.getNome()) && this.getIndirizzo().getCitta().equals(p.getIndirizzo().getCitta()))
                mieiOmonimiCounter++;
        }
        return mieiOmonimiCounter;
    }



}
