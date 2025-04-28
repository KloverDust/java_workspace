package it.prova.mtmsmartphoneappmaven.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import it.prova.mtmsmartphoneappmaven.model.App;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "smartphone")
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modello", nullable = false)
    private String modello;

    @Column(name = "prezzo")
    private Double prezzo;

    @Column(name = "versione_os")
    private String versioneOS;

    // campi per le time info del record
    @CreationTimestamp
    @Column(name = "createdatetime")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "updatedatetime")
    private LocalDateTime updateDateTime;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)

    @JoinTable(name = "smartphone_app",
            joinColumns = @JoinColumn(name = "smartphone_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "app_id", referencedColumnName = "id"))

    private Set<App> apps = new HashSet<>();

    public Smartphone() { }

    public Smartphone(String marca, String modello, Double prezzo, String versioneOS) {
        this.marca = marca;
        this.modello = modello;
        this.prezzo = prezzo;
        this.versioneOS = versioneOS;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModello() { return modello; }
    public void setModello(String modello) { this.modello = modello; }

    public Double getPrezzo() { return prezzo; }
    public void setPrezzo(Double prezzo) { this.prezzo = prezzo; }

    public String getVersioneOS() { return versioneOS; }
    public void setVersioneOS(String versioneOS) { this.versioneOS = versioneOS; }

    public LocalDateTime getCreateDateTime() { return createDateTime; }
    public void setCreateDateTime(LocalDateTime createDateTime) { this.createDateTime = createDateTime; }

    public LocalDateTime getUpdateDateTime() { return updateDateTime; }
    public void setUpdateDateTime(LocalDateTime updateDateTime) { this.updateDateTime = updateDateTime; }

    public Set<App> getApps() { return apps; }
    public void setApps(Set<App> apps) { this.apps = apps; }

    // helper methods per mantenere la relazione bidirezionale
    public void addApp(App app) {
        this.apps.add(app);
        app.getSmartphones().add(this);
    }

    public void removeApp(App app) {
        this.apps.remove(app);
        app.getSmartphones().remove(this);
    }

    @Override
    public String toString() {
        return "Smartphone [id=" + id + ", marca=" + marca + ", modello=" + modello +
                ", prezzo=" + prezzo + ", versioneOS=" + versioneOS + "]";
    }
}
