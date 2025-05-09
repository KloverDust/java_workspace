package it.prova.gestionesocieta.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "societa")
public class Societa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "ragioneSociale")
    private String ragioneSociale;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "dataFondazione")
    private LocalDate dataFondazione;

    @Column(name = "dataChiusura")
    private LocalDate dataChiusura;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "societa")
    private List<Dipendente> dipendenti = new ArrayList<>();
    
    public Societa(){
    }
    
    public Societa(String ragioneSociale, LocalDate dataFondazione, LocalDate dataChiusura) {
        this.ragioneSociale = ragioneSociale;
        this.dataFondazione = dataFondazione;
        this.dataChiusura = dataChiusura;
    }
    
    public Societa(String ragioneSociale, String indirizzo, LocalDate dataFondazione, LocalDate dataChiusura) {
        this.ragioneSociale = ragioneSociale;
        this.indirizzo = indirizzo;
        this.dataFondazione = dataFondazione;
        this.dataChiusura = dataChiusura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public LocalDate getDataFondazione() {
        return dataFondazione;
    }

    public void setDataFondazione(LocalDate dataFondazione) {
        this.dataFondazione = dataFondazione;
    }

    public LocalDate getDataChiusura() {
        return dataChiusura;
    }

    public void setDataChiusura(LocalDate dataChiusura) {
        this.dataChiusura = dataChiusura;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void addDipendente(Dipendente dipendente){
        this.dipendenti.add(dipendente);
    }

    public void removeDipendente(Dipendente dipendente){
        this.dipendenti.remove(dipendente);
    }


    @Override
    public String toString() {
        return "Societa{" +
                "id=" + id +
                ", ragioneSociale='" + ragioneSociale + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataFondazione=" + dataFondazione +
                ", dataChiusura=" + dataChiusura +
                '}';
    }

}
