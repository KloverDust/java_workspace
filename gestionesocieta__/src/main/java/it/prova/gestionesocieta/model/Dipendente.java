package it.prova.gestionesocieta.model;

import jakarta.persistence.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "dataAssunzione")
    private LocalDate dataAssunzione;

    @Column(name = "redditoAnnuoLordo")
    private Long redditoAnnuoLordo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "societa_id", nullable = false)
    private Societa societa;

    @ManyToMany(mappedBy = "dipendenti")
    private List<Progetto> progetti = new ArrayList<>();


    public Dipendente() {
    }

    public Dipendente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Dipendente(String nome, String cognome, LocalDate dataAssunzione) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
    }

    public Dipendente(String nome, String cognome, LocalDate dataAssunzione, Long redditoAnnuoLordo) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.redditoAnnuoLordo = redditoAnnuoLordo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(LocalDate dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    public Long getRedditoAnnuoLordo() {
        return redditoAnnuoLordo;
    }

    public void setRedditoAnnuoLordo(Long reditoAnnuoLordo) {
        this.redditoAnnuoLordo = redditoAnnuoLordo;
    }

    public Societa getSocieta() {
        return societa;
    }

    public void setSocieta(Societa societa) {
        this.societa = societa;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataAssunzione=" + dataAssunzione +
                ", redditoAnnuoLordo=" + redditoAnnuoLordo +
                '}';
    }
}
