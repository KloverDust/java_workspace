package it.prova.gestioneordiniarticolicategorie.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "codice")
    private String codice;

    @ManyToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
    private Set<Articolo> articoli = new HashSet<>();

    public Categoria() { }

    public Categoria(String descrizione, String codice) {
        this.descrizione = descrizione;
        this.codice = codice;
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

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Set<Articolo> getArticoli() {
        return articoli;
    }

    public void setArticoli(Set<Articolo> articoli) {
        this.articoli = articoli;
    }

    public void addArticolo(Articolo articolo) {
        this.articoli.add(articolo);
        articolo.getCategorie().add(this); // Aggiorno anche le categorie in memoria
    }

    public void removeArticolo(Articolo articolo) {
        this.articoli.remove(articolo);
        articolo.getCategorie().remove(this);
    }

    @Override
    public String toString() {
        return "Categoria [id=" + id
                + ", descrizione=" + descrizione
                + ", codice=" + codice + "]";
    }
}