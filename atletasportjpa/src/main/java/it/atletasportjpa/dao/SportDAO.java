package it.atletasportjpa.dao;

import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.Sport;

import java.util.List;

public interface SportDAO extends IBaseDAO<Sport>{

    public List<Sport> findByDescrizione(String descrizione) throws Exception;

    public void addSportToAthlete(Atleta atleta) throws Exception;

    public void removeSportFromAthlete(Atleta atleta) throws Exception;

    public void removeAthleteAfterRemovalFromSport(Atleta atleta) throws Exception;

    public List<Sport> findByIncoherentDates() throws Exception;

}
