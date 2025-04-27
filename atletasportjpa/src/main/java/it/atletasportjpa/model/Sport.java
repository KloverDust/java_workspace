package it.atletasportjpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sport")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "descrizione", nullable = false)
    private NomiSport descrizione;

    @Column(name = "datainizio")
    private LocalDate dataInizio;

    @Column(name = "datafine")
    private LocalDate dataFine;

    public Sport() {
    }

    public Sport(NomiSport descrizione) {
        this.descrizione = descrizione;
    }

    public Sport(NomiSport descrizione, LocalDate dataInizio, LocalDate dataFine) {
        this.descrizione = descrizione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NomiSport getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(NomiSport descrizione) {
        this.descrizione = descrizione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", descrizione=" + descrizione +
                (dataInizio != null ? ", dataInizio=" + dataInizio : "") +
                (dataFine   != null ? ", dataFine="   + dataFine   : "") +
                '}';
    }
}
