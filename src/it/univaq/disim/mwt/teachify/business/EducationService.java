package it.univaq.disim.mwt.teachify.business;

import it.univaq.disim.mwt.teachify.business.model.Hour;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Subject;
import it.univaq.disim.mwt.teachify.business.model.TypeOfEducation;

import java.util.List;

public interface EducationService {
	
	List<Subject> findAllSubjects() throws BusinessException;//
	
	void createSubject(Subject subject) throws BusinessException;

	void deleteSubject(Subject subject) throws BusinessException;

	void updateSubject(Subject subject) throws BusinessException;
	
	
	List<TypeOfEducation> findAllTypesOfEducation() throws BusinessException;

	void createTypeOfEducation(TypeOfEducation typeOfEducation);
	
	void updateTypeOfEducation(TypeOfEducation typeOfEducation);
	
	void deleteTypeOfEducation(TypeOfEducation typeOfEducation);
	
	
	List<Price> findAllPrices() throws BusinessException;

	void createPrice(Price price) throws BusinessException;
	
	void deletePrice(Price price) throws BusinessException;

	
	List<Hour> findAllHours() throws BusinessException;
	
	void createHour(Hour hour) throws BusinessException;
	
	void deleteHour(Hour hour) throws BusinessException;



	

}
