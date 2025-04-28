package it.prova.manytomanybranogeneremaven.dao.genere;

import it.prova.manytomanybranogeneremaven.dao.IBaseDAO;
import it.prova.manytomanybranogeneremaven.model.Genere;

public interface GenereDAO extends IBaseDAO<Genere>{
	
	public Genere findByDescrizione(String descrizioneInput) throws Exception;

}
