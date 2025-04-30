package it.prova.gestioneordiniarticolicategorie.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "articolo")
public class Articolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "numero_seriale")
    private String numeroSeriale;

    @Column(name = "prezzo_singolo")
    private Double prezzoSingolo;

    @Column(name = "data_inserimento")
    private LocalDate dataInserimento;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id", nullable = true)
    private Ordine ordine;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorie = new HashSet<>();

    public Articolo() {
    }

    public Articolo(String descrizione, String numeroSeriale) {
        this.descrizione = descrizione;
        this.numeroSeriale = numeroSeriale;
    }

    public Articolo(String descrizione, String numeroSeriale,
                    Double prezzoSingolo, LocalDate dataInserimento) {
        this.descrizione = descrizione;
        this.numeroSeriale = numeroSeriale;
        this.prezzoSingolo = prezzoSingolo;
        this.dataInserimento = dataInserimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getNumeroSeriale() {
        return numeroSeriale;
    }

    public void setNumeroSeriale(String numeroSeriale) {
        this.numeroSeriale = numeroSeriale;
    }

    public Double getPrezzoSingolo() {
        return prezzoSingolo;
    }

    public void setPrezzoSingolo(Double prezzoSingolo) {
        this.prezzoSingolo = prezzoSingolo;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public Set<Categoria> getCategorie() {
        return categorie;
    }

    public void setCategorie(Set<Categoria> categorie) {
        this.categorie = categorie;
    }

    public void addCategoria(Categoria categoria) {
        this.categorie.add(categoria);
        categoria.getArticoli().add(this); // Aggiorno anche gli articoli in memoria
    }

    public void removeCategoria(Categoria categoria) {
        this.categorie.remove(categoria);
        categoria.getArticoli().remove(this);
    }


    @Override
    public String toString() {
        return "Articolo [id=" + id
                + ", desc=" + descrizione
                + ", seriale=" + numeroSeriale
                + ", prezzo=" + prezzoSingolo + "]";
    }
}
