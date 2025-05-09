package it.prova.gestioneedifici.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "dittaProprietaria")
    private String dittaProprietaria;

    @Column(name="dataCostruzione")
    private LocalDate dataCostruzione;

    @Column(name = "numeroPiani")
    private int numeroPiani;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "edificio")
    private List<Inquilino> inquilini = new ArrayList<>();

    public Edificio() {
    }

    public Edificio(LocalDate dataCostruzione, String indirizzo, int numeroPiani) {
        this.dataCostruzione = dataCostruzione;
        this.indirizzo = indirizzo;
        this.numeroPiani = numeroPiani;
    }

    public Edificio(String indirizzo, String dittaProprietaria, LocalDate dataCostruzione, int numeroPiani) {
        this.indirizzo = indirizzo;
        this.dittaProprietaria = dittaProprietaria;
        this.dataCostruzione = dataCostruzione;
        this.numeroPiani = numeroPiani;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDittaProprietaria() {
        return dittaProprietaria;
    }

    public void setDittaProprietaria(String dittaProprietaria) {
        this.dittaProprietaria = dittaProprietaria;
    }

    public LocalDate getDataCostruzione() {
        return dataCostruzione;
    }

    public void setDataCostruzione(LocalDate dataCostruzione) {
        this.dataCostruzione = dataCostruzione;
    }

    public int getNumeroPiani() {
        return numeroPiani;
    }

    public void setNumeroPiani(int numeroPiani) {
        this.numeroPiani = numeroPiani;
    }

    public List<Inquilino> getInquilini() {
        return inquilini;
    }

    public void setInquilini(List<Inquilino> inquilini) {
        this.inquilini = inquilini;
    }

    public void addInquilino(Inquilino inquilino) {
        if (inquilino != null) {
            this.inquilini.add(inquilino);
            inquilino.setEdificio(this);
        }
    }

    public void removeInquilino(Inquilino inquilino) {
        if (inquilino != null) {
            this.inquilini.remove(inquilino);
            if (inquilino.getEdificio() == this) {
                inquilino.setEdificio(null);
            }
        }
    }
}
