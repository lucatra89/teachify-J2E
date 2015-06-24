package it.univaq.disim.mwt.teachify.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.RequestTutors;
import it.univaq.disim.mwt.teachify.business.TutorInfo;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Feedback;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.ejb.ManagerException;
import it.univaq.disim.mwt.teachify.ejb.TutorManagerRemote;

@Service
public class RemoteTutorService implements TutorService {
	@Autowired
	private TutorManagerRemote tutorManager;
	@Override
	public void createTutor(Tutor tutor) throws BusinessException {
		try {
			Long id = tutorManager.createTutor(tutor);
			tutor.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateTutorDescription(Tutor tutor) throws BusinessException {
		try {
			tutorManager.updateTutorDescription(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateTutorLocation(Tutor tutor) throws BusinessException {
		try {
			tutorManager.updateTutorLocation(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void upgradeToTutor(Tutor tutor) throws BusinessException {
		try {
			tutorManager.upgradeToTutor(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateTutorPrice(Tutor tutor) throws BusinessException {
		try {
			tutorManager.updateTutorPrice(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<TutorInfo> searchTutors(RequestTutors request) throws BusinessException {
		try {
			return tutorManager.searchTutors(request);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Tutor findTutorByPk(Long id) throws BusinessException {
		try {
			return tutorManager.findTutorByPk(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createFeedback(Feedback feedback) throws BusinessException {
		try {
			Long id =tutorManager.createFeedback(feedback);
			feedback.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Long> findAllFeedbackPK(Tutor tutor) throws BusinessException {
		try {
			return tutorManager.findAllFeedbackId(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createRequest(Request request) throws BusinessException {
		try {
			Long id = tutorManager.createRequest(request);
			request.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateStatusRequest(Request request) throws BusinessException {
		try {
			tutorManager.updateStatusRequest(request);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public List<Request> findWaitingRequestsByTutor(Tutor tutor) throws BusinessException {
		try {
			return tutorManager.findWaitingRequestsByTutor(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Request> findRequestsByUser(User user) throws BusinessException {
		try {
			return tutorManager.findRequestsByUser(user);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public StatusRequest statusOfRequest(User user, Tutor tutor) throws BusinessException {
		try {
			return tutorManager.statusOfRequest(user ,tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void createLesson(Lesson lesson) throws BusinessException {
		try {
			Long id =tutorManager.createLesson(lesson);
			lesson.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteLesson(Lesson lesson) throws BusinessException {
		try {
			tutorManager.deleteLesson(lesson);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void createAvailability(Availability availability) throws BusinessException {
		try {
			Long id =tutorManager.createAvailability(availability);
			availability.setId(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void deleteAvailability(Availability availability) throws BusinessException {
		try {
			tutorManager.deleteAvailability(availability);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public void updateTutorContact(Tutor tutor) throws BusinessException {
		try {
			tutorManager.updateTutorContact(tutor);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}

	}

	@Override
	public Feedback findFeedbackById(Long id) throws BusinessException {
		try {
			return tutorManager.findFeedbackById(id);
		} catch (ManagerException e) {
			throw new BusinessException(e);
		}
	}

}
