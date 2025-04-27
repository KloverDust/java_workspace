package it.atletasportjpa.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "datanascita")
    private LocalDate dataDiNascita;

    @Column(name = "codice", unique = true)
    private String codice;

    @Column(name = "numeromedaglievinte")
    private Integer numeroMedaglieVinte;

    @ManyToMany
    @JoinTable(name = "atleta_sport",
            joinColumns = @JoinColumn(name = "atleta_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sport_id", referencedColumnName = "id"))
    private Set<Sport> sportPraticati = new HashSet<>(0);


    public Atleta() {
    }

    public Atleta(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Atleta(String nome, String cognome, LocalDate dataDiNascita, String codice, Integer numeroMedaglieVinte) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.codice = codice;
        this.numeroMedaglieVinte = numeroMedaglieVinte;
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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Integer getNumeroMedaglieVinte() {
        return numeroMedaglieVinte;
    }

    public void setNumeroMedaglieVinte(Integer numeroMedaglieVinte) {
        this.numeroMedaglieVinte = numeroMedaglieVinte;
    }

    public Set<Sport> getSportPraticati() {
        return sportPraticati;
    }

    public void setSportPraticati(Set<Sport> sportPraticati) {
        this.sportPraticati = sportPraticati;
    }

    public void addSport(Sport s) {
        this.sportPraticati.add(s);
    }

    public void removeSport(Sport s) {
        this.sportPraticati.remove(s);
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", codice='" + codice + '\'' +
                ", numeroMedaglieVinte=" + numeroMedaglieVinte +
                '}';
    }
}
