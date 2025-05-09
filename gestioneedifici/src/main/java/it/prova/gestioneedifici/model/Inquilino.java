package it.prova.gestioneedifici.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Inquilino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "dataNascita")
    private LocalDate dataNascita;

    @Column(name = "affittoDovuto")
    private int affittoDovuto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    public Inquilino() {
    }

    public Inquilino(String nome, String cognome, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
    }

    public Inquilino(String nome, String cognome, int affittoDovuto) {
        this.nome = nome;
        this.cognome = cognome;
        this.affittoDovuto = affittoDovuto;
    }

    public Inquilino(String nome, String cognome, int affittoDovuto, Edificio edificio) {
        this.nome = nome;
        this.cognome = cognome;
        this.affittoDovuto = affittoDovuto;
        this.edificio = edificio;
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public int getAffittoDovuto() {
        return affittoDovuto;
    }

    public void setAffittoDovuto(int affittoDovuto) {
        this.affittoDovuto = affittoDovuto;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
        if (!this.edificio.getInquilini().contains(this)) {
            this.edificio.getInquilini().add(this);
        }
    }
}
