package it.univaq.disim.mwt.teachify.business.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.EducationService;
import it.univaq.disim.mwt.teachify.business.model.Hour;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Subject;
import it.univaq.disim.mwt.teachify.business.model.TypeOfEducation;
import it.univaq.disim.mwt.teachify.ejb.EducationManagerRemote;
import it.univaq.disim.mwt.teachify.ejb.ManagerException;

@Service
public class RemoteEducationService implements EducationService {
	
	@Autowired
	private EducationManagerRemote educationManager;

	@Override
	public List<Subject> findAllSubjects() throws BusinessException {
		try {
			return educationManager.findAllSubjects();
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createSubject(Subject subject) throws BusinessException {
		try {
			Long id =educationManager.createSubject(subject);
			subject.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteSubject(Subject subject) throws BusinessException {
		try {
			educationManager.deleteSubject(subject);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateSubject(Subject subject) throws BusinessException {
		try {
			educationManager.updateSubject(subject);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<TypeOfEducation> findAllTypesOfEducation() throws BusinessException {
		try {
			return educationManager.findAllTypesOfEducation();
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void createTypeOfEducation(TypeOfEducation typeOfEducation) {
		try {
			Long id = educationManager.createTypeOfEducation(typeOfEducation);
			typeOfEducation.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateTypeOfEducation(TypeOfEducation typeOfEducation) {
		try {
			educationManager.updateTypeOfEducation(typeOfEducation);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteTypeOfEducation(TypeOfEducation typeOfEducation) {
		try {
			educationManager.deleteTypeOfEducation(typeOfEducation);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Price> findAllPrices() throws BusinessException {
		try {
			return educationManager.findAllPrices();
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createPrice(Price price) throws BusinessException {
		try {
			Long id =educationManager.createPrice(price);
			price.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deletePrice(Price price) throws BusinessException {
		try {
			educationManager.deletePrice(price);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Hour> findAllHours() throws BusinessException {
		try {
			return educationManager.findAllHours();
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createHour(Hour hour) throws BusinessException {
		try {
			Long id =educationManager.createHour(hour);
			hour.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteHour(Hour hour) throws BusinessException {
		try {
			educationManager.deleteHour(hour);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

}
