package it.prova.mtmsmartphoneappmaven.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "app")
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_installazione")
    private LocalDate dataInstallazione;

    @Column(name = "data_ultimo_aggiornamento")
    private LocalDate dataUltimoAggiornamento;

    @Column(name = "versione")
    private String versione;

    @CreationTimestamp
    @Column(name = "createdatetime")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "updatedatetime")
    private LocalDateTime updateDateTime;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "apps")
    private Set<Smartphone> smartphones = new HashSet<>();

    public App() { }

    public App(String nome, LocalDate dataInstallazione) {
        this.nome = nome;
        this.dataInstallazione = dataInstallazione;
    }

    public App(String nome, LocalDate dataInstallazione, LocalDate dataUltimoAggiornamento, String versione) {
        this.nome = nome;
        this.dataInstallazione = dataInstallazione;
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
        this.versione = versione;
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

    public LocalDate getDataInstallazione() {
        return dataInstallazione;
    }
    public void setDataInstallazione(LocalDate dataInstallazione) {
        this.dataInstallazione = dataInstallazione;
    }

    public LocalDate getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }

    public void setDataUltimoAggiornamento(LocalDate dataUltimoAggiornamento) {
        this.dataUltimoAggiornamento = dataUltimoAggiornamento;
    }

    public String getVersione() {
        return versione;
    }

    public void setVersione(String versione) {
        this.versione = versione;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Set<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(Set<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public void addSmartphone(Smartphone smartphone) {
        this.smartphones.add(smartphone);
        smartphone.getApps().add(this);
    }

    public void removeSmartphone(Smartphone smartphone) {
        this.smartphones.remove(smartphone);
        smartphone.getApps().remove(this);
    }

    @Override
    public String toString() {
        return "App [id=" + id + ", nome=" + nome +
                ", dataInstallazione=" + dataInstallazione +
                ", dataUltimoAggiornamento=" + dataUltimoAggiornamento +
                ", versione=" + versione + "]";
    }
}
