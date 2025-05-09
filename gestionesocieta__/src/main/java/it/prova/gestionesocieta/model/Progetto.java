package it.prova.gestionesocieta.model;

import jakarta.persistence.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "progetto")
public class Progetto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cliente")
    private String cliente;

    @Column(name = "durataInMesi")
    private Integer durataInMesi;

    @ManyToMany
    @JoinTable(name = "progetto_dipendente", joinColumns = @JoinColumn(name = "progetto_id"), inverseJoinColumns = @JoinColumn(name = "dipendente_id"))
    private List<Dipendente> dipendenti = new ArrayList<>();

    public Progetto() {
    }
    

    public Progetto(String nome, String cliente, Integer durataInMesi) {
        this.nome = nome;
        this.cliente = cliente;
        this.durataInMesi = durataInMesi;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getDurataInMesi() {
        return durataInMesi;
    }

    public void setDurataInMesi(Integer durataInMesi) {
        this.durataInMesi = durataInMesi;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void addDipendente(Dipendente dipendente) {
        this.dipendenti.add(dipendente);
    }

    public void removeDipendente(Dipendente dipendente) {
        this.dipendenti.remove(dipendente);
    }

    @Override
    public String toString() {
        return "Progetto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cliente='" + cliente + '\'' +
                ", durataInMesi=" + durataInMesi +
                '}';
    }
}
