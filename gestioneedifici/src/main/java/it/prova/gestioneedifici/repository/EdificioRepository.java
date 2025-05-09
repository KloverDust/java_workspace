package it.prova.gestioneedifici.repository;

import it.prova.gestioneedifici.model.Edificio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface EdificioRepository extends CrudRepository<Edificio, Long> {

    @Query("SELECT e, COUNT(i) FROM Edificio e LEFT JOIN e.inquilini i GROUP BY e")
    List<Object[]> findInquiliniCountPerEdificio();

    default Map<Edificio, Long> ottieniEdificioECountInquilini() {
        List<Object[]> risultati = findInquiliniCountPerEdificio();
        Map<Edificio, Long> mappa = new HashMap<>(risultati.size());
        for (Object[] o : risultati) {
            Edificio edificio = (Edificio) o[0];
            Long numeroInquilini = (Long) o[1];
            mappa.put(edificio,numeroInquilini);
        }
        return mappa;
    }


    @Query("SELECT e, COUNT(i)FROM Edificio e LEFT JOIN e.inquilini i WHERE e.id = :edificioId GROUP BY e")
    List<Object[]> findEdificioAndCountById(@Param("edificioId") Long edificioId);

    default Map<Edificio, Long> ottieniCountPerEdificio(Long edificioId) {
        List<Object[]> risultati = findEdificioAndCountById(edificioId);
        Map<Edificio, Long> mappa = new HashMap<>();

        if (!risultati.isEmpty()) {
            Object[] riga = risultati.get(0);
            Edificio e       = (Edificio) riga[0];
            Long     count   = (Long)      riga[1];
            mappa.put(e, count);
        }
        return mappa;
    }

}
