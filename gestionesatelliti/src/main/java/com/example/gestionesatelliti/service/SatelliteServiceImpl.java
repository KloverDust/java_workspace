package com.example.gestionesatelliti.service;

import com.example.gestionesatelliti.model.Satellite;
import com.example.gestionesatelliti.model.StatoSatellite;
import com.example.gestionesatelliti.repository.SatelliteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class SatelliteServiceImpl implements SatelliteService{
    @Autowired
    private SatelliteRepository repository;

    @Override
    public List<Satellite> listAllElements() {
        return (List<Satellite>) repository.findAll();
    }

    @Override
    public Satellite caricaSingoloElemento(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void aggiorna(Satellite satelliteInstance) {
        repository.save(satelliteInstance);
    }

    @Override
    public void inserisciNuovo(Satellite satelliteInstance) {
        if(satelliteInstance.getDataRientro() != null) {
            if (satelliteInstance.getDataRientro().isBefore(satelliteInstance.getDataLancio())){
                throw new RuntimeException("La data di rientro di un satellite non può essere antecedente la data del lancio");
            }
        }

        if ((satelliteInstance.getDataRientro() == null || satelliteInstance.getDataRientro().isBefore(LocalDate.now())) && satelliteInstance.getStato() == StatoSatellite.DISATTIVATO) {
            throw new RuntimeException("Non è possibile disattivare un satellite senza data di rientro o che non sia ancora rientrato");
        }

        // SE IL SATELLITE HA UNO STATO, LA DATA DI LANCIO DEVE ESSERE VALORIZZATA
        if(satelliteInstance.getStato() != null ){
            if (satelliteInstance.getDataLancio() == null) {
                throw new RuntimeException("Se si desidera inserire lo stato di un satellite, deve essere impostata anche la data di lancio");
            }
            if (satelliteInstance.getDataLancio().isAfter(LocalDate.now())) {
                throw new RuntimeException("Attenzione: Non posso impostare lo stato di un satellite che non è ancora stato lanciato");
            }
        }

        repository.save(satelliteInstance);
    }

    @Override
    public void rimuovi(Long idSatellite) {
        repository.deleteById(idSatellite);
    }

    @Override
    public List<Satellite> findByExample(Satellite example) {
        return List.of();
    }

    @Override
    public List<Satellite> cercaLanciatiDaPiuDi2Anni() throws Exception {
        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        return repository.findSatellitesWithOrbitalPeriodLongerThan2Years(twoYearsAgo);
    }

    @Override
    public List<Satellite> cercaDisattivatiNonRientrati() throws Exception {
        return repository.findDeactivatedSatellitesNotReturned();
    }

    @Override
    public List<Satellite> cercaFissiConOrbitaSuperioreA10Anni() throws Exception {
        return repository.findStationarySatellitesWithOrbitalPeriodGreaterThan10();
    }
}
