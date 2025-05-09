package com.example.gestionesatelliti.service;

import com.example.gestionesatelliti.model.Satellite;

import java.util.List;

public interface SatelliteService {

    public List<Satellite> listAllElements();

    public Satellite caricaSingoloElemento(Long id);

    public void aggiorna(Satellite satelliteInstance);

    public void inserisciNuovo(Satellite satelliteInstance);

    public void rimuovi(Long idSatellite);

    public List<Satellite> findByExample(Satellite example);

    public List<Satellite> cercaLanciatiDaPiuDi2Anni() throws Exception;

    public List<Satellite> cercaDisattivatiNonRientrati() throws Exception;

    public List<Satellite> cercaFissiConOrbitaSuperioreA10Anni() throws Exception;


}
