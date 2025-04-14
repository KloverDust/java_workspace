package it.prova.model;

public interface Volatile {

    public String vola(); // abstract e public non sono necessari perché java lo sa già

    public String stampaProprieta();

    public boolean eUgualeA(Volatile altroVolatile);
}
