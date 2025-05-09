package com.example.gestionesatelliti.repository;

import com.example.gestionesatelliti.model.Satellite;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SatelliteRepository extends CrudRepository<Satellite, Long>, JpaSpecificationExecutor<Satellite> {

    @Query("SELECT s FROM Satellite s WHERE s.dataLancio < :twoYearsAgo AND (s.dataRientro IS NULL OR s.dataRientro > CURRENT_DATE)")
    List<Satellite> findSatellitesWithOrbitalPeriodLongerThan2Years(@Param("twoYearsAgo") LocalDate twoYearsAgo);
    
    @Query("SELECT s FROM Satellite s WHERE s.stato = 'DISATTIVATO' AND (s.dataRientro IS NULL OR s.dataRientro > CURRENT_DATE)")
    List<Satellite> findDeactivatedSatellitesNotReturned();

    @Query("SELECT s FROM Satellite s WHERE s.stato = 'FISSO' AND DATEDIFF(CURRENT_DATE, s.dataLancio) > 10")
    List<Satellite> findStationarySatellitesWithOrbitalPeriodGreaterThan10();
}
