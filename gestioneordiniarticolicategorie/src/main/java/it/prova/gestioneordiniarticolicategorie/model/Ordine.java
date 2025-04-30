package it.prova.gestioneordiniarticolicategorie.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_destinatario")
    private String nomeDestinatario;

    @Column(name = "indirizzo_spedizione")
    private String indirizzoSpedizione;

    @Column(name = "data_spedizione")
    private LocalDate dataSpedizione;

    @Column(name = "data_scadenza")
    private LocalDate dataScadenza;

    @OneToMany(mappedBy = "ordine", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Articolo> articoli = new HashSet<>();

    public Ordine() {
    }

    public Ordine(String nomeDestinatario, String indirizzoSpedizione) {
        this.nomeDestinatario = nomeDestinatario;
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public Ordine(String nomeDestinatario, String indirizzoSpedizione,
                  LocalDate dataSpedizione, LocalDate dataScadenza) {
        this.nomeDestinatario = nomeDestinatario;
        this.indirizzoSpedizione = indirizzoSpedizione;
        this.dataSpedizione = dataSpedizione;
        this.dataScadenza = dataScadenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getIndirizzoSpedizione() {
        return indirizzoSpedizione;
    }

    public void setIndirizzoSpedizione(String indirizzoSpedizione) {
        this.indirizzoSpedizione = indirizzoSpedizione;
    }

    public LocalDate getDataSpedizione() {
        return dataSpedizione;
    }

    public void setDataSpedizione(LocalDate dataSpedizione) {
        this.dataSpedizione = dataSpedizione;
    }

    public LocalDate getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(LocalDate dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public Set<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set<Articolo> articoli) {
        this.articoli = articoli;
    }

    public void addArticolo(Articolo a) {
        this.articoli.add(a);
        a.setOrdine(this);
    }

    public void removeArticolo(Articolo a) {
        this.articoli.remove(a);
        a.setOrdine(null);
    }

    @Override
    public String toString() {
        return "Ordine [id=" + id
                + ", destinatario=" + nomeDestinatario
                + ", spedizione=" + dataSpedizione
                + ", scadenza=" + dataScadenza
                + ", #articoli=" + articoli.size() + "]";
    }
}