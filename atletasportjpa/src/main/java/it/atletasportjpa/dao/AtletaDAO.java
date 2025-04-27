package it.atletasportjpa.dao;

import it.atletasportjpa.model.Atleta;
import it.atletasportjpa.model.Sport;

import java.util.List;

public interface AtletaDAO extends IBaseDAO<Atleta>{
    public List<Atleta> findAllBySport(Sport sport) throws Exception;
    public Long sumMedaglieAtletiSportFiniti() throws Exception;
}
