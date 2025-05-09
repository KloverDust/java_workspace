package it.prova.catenadimontaggio.model;

import java.util.ArrayList;
import java.util.List;

public class SlotCatenaDiMontaggio {
    private Long id;
    private String brand;
    private String country;
    private List<Automobile> automobileList = new ArrayList<Automobile>();


    public SlotCatenaDiMontaggio() {
    }

    public SlotCatenaDiMontaggio(String brand, String country) {
        this.brand = brand;
        this.country = country;
    }

    public SlotCatenaDiMontaggio(String brand, String country, List<Automobile> automobileList) {
        this.brand = brand;
        this.country = country;
        this.automobileList = automobileList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Automobile> getAutomobileList() {
        return automobileList;
    }

    public void setAutomobileList(List<Automobile> automobileList) {
        this.automobileList = automobileList;
    }

    public void addToAutomobileList(Automobile automobile) {
        this.automobileList.add(automobile);
    }

    public void removeFromAutomobileList(Automobile automobile) {
        this.automobileList.remove(automobile);
    }
}


