package it.univaq.disim.mwt.teachify.business;

import java.util.List;

import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Feedback;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.RequestTutors;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;

public interface TutorService {
	public void createTutor(Tutor tutor) throws BusinessException;

	public void updateTutorDescription(Tutor tutor) throws BusinessException;

	public void updateTutorLocation(Tutor tutor) throws BusinessException;

	public void upgradeToTutor(Tutor tutor) throws BusinessException;

	public List<Tutor> searchTutors(RequestTutors request) throws BusinessException;

	public Tutor findTutorByPk(long id) throws BusinessException;

	public void createFeedback(Feedback feedback) throws BusinessException;

	public List<Feedback> findAllFeedback(Tutor tutor) throws BusinessException;

	public void createRequest(Request request) throws BusinessException;

	public void updateStatusRequest(Request request) throws BusinessException;

	public List<Request> findRequestsByTutor(Tutor tutor, StatusRequest status) throws BusinessException;

	public List<Request> findRequestsByUser(User user) throws BusinessException;

	public StatusRequest statusOfRequest(User user, Tutor tutor) throws BusinessException;

	public void updateTutorPrice(Tutor tutor) throws BusinessException;

	public void addLesson(Lesson lesson) throws BusinessException;

	public void deleteLesson(Lesson lesson) throws BusinessException;

	public void addAvailability(Availability availability) throws BusinessException;

	public void deleteAvailability(Availability availability) throws BusinessException;

	public void updateTutorContact(Tutor tutor) throws BusinessException;

	public Feedback findFeedbackById(long id) throws BusinessException;

}
