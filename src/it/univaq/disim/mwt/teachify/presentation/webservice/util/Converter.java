package it.univaq.disim.mwt.teachify.presentation.webservice.util;

import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.univaq.disim.mwt.teachify.business.RequestTutors;
import it.univaq.disim.mwt.teachify.business.TutorInfo;
import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Contact;
import it.univaq.disim.mwt.teachify.business.model.Hour;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Location;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Subject;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.TypeOfEducation;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TAvailability;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TContact;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TDay;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.THour;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TLesson;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TLocation;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TPrice;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TRequestTutors;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TStatusRequest;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TSubject;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutor;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutorInfo;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTutorInfoList;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TTypeOfEducation;
import it.univaq.disim.mwt.teachify.presentation.webservice.common.TUser;

public class Converter {

	public static User toUser(TUser tUser) {
		User user = new User();
		user.setId(tUser.getId());
		user.setName(tUser.getName());
		user.setSurname(tUser.getSurname());
		user.setEmail(tUser.getEmail());
		user.setPassword(tUser.getPassword());
		return user;
	}

	public static TUser fromUser(User user) {
		TUser tUser = new TUser();
		tUser.setId(user.getId());
		tUser.setName(user.getName());
		tUser.setSurname(user.getSurname());
		return tUser;
	}

	public static Tutor toTutor(TTutor tTutor) {
		Tutor tutor = new Tutor();
		tutor.setId(tTutor.getId());
		tutor.setName(tTutor.getName());
		tutor.setSurname(tTutor.getSurname());
		tutor.setEmail(tTutor.getEmail());
		tutor.setPassword(tTutor.getPassword());
		tutor.setDescription(tTutor.getDescription());
		tutor.setLocation(toLocation(tTutor.getLocation()));
		tutor.setContact(toContact(tTutor.getContact()));
		tutor.setPrice(toPrice(tTutor.getPrice()));
		return tutor;
	}

	public static Price toPrice(TPrice tPrice) {
		if(tPrice == null){
			return null;
		}
		Price price = new Price();
		price.setId(tPrice.getId());
		price.setValue(tPrice.getValue());
		
		return price;
	}

	public static Contact toContact(TContact tContact) {
		if(tContact == null){
			return null;
		}
		Contact contact = new Contact();
		contact.setEmail(tContact.getEmail());
		contact.setSkype(tContact.getSkype());
		contact.setTelephone(tContact.getTelephone());
		
		return contact;
	}

	public static Location toLocation(TLocation tLocation) {
		if(tLocation == null){
			return null;
		}
		Location location = new Location();
		location.setLatitude(tLocation.getLatitude());
		location.setLongitude(tLocation.getLongitude());
		location.setName(tLocation.getName());
		return location;
	}

	public static TTutor fromTutor(Tutor tutor) {
		TTutor tTutor = new TTutor();
		tTutor.setId(tutor.getId());
		tTutor.setName(tutor.getName());
		tTutor.setSurname(tutor.getSurname());
		tTutor.setContact( fromContact(tutor.getContact()));
		tTutor.setPrice(fromPrice(tutor.getPrice()));
		tTutor.setLocation(fromLocation(tutor.getLocation()));
		tTutor.setRating(tutor.getRating());
		addAvailabilities(tTutor,tutor.getAvailabilities());
		addLessons(tTutor , tutor.getLessons());
		
		return tTutor;
	}
	
	private static void addLessons(TTutor tTutor, Collection<Lesson> lessons) {
		if(lessons == null){
			return;
		}
		for(Lesson lesson : lessons){
			tTutor.getLessons().add(fromLesson(lesson));
		}
		
	}

	public static TLesson fromLesson(Lesson lesson) {
		TLesson tLesson = new TLesson();
		tLesson.setId(lesson.getId());
		tLesson.setSubject(fromSubject(lesson.getSubject()));
		tLesson.setTypeOfEducation(fromTypeOfEducation(lesson.getTypeOfEducation()));
		
		return tLesson;
	}

	public static TTypeOfEducation fromTypeOfEducation(TypeOfEducation typeOfEducation) {
		TTypeOfEducation tTypeOfEducation = new TTypeOfEducation();
		tTypeOfEducation.setId(typeOfEducation.getId());
		tTypeOfEducation.setName(typeOfEducation.getName());
		return tTypeOfEducation;
	}

	public static TSubject fromSubject(Subject subject) {
		TSubject tSubject = new TSubject();
		tSubject.setId(subject.getId());
		tSubject.setName(subject.getName());
		return tSubject;
	}

	private static void addAvailabilities(TTutor tTutor , Collection<Availability> availabilities){
		if(availabilities == null){
			return;
		}
		for(Availability availability : availabilities){
			tTutor.getAvailabilities().add(fromAvailability(availability));
		}
		
	}

	public static TAvailability fromAvailability(Availability availability) {
		TAvailability tAvailability = new TAvailability();
		tAvailability.setId(availability.getId());
		tAvailability.setDay(TDay.fromValue(availability.getDay().name()));
		tAvailability.setFrom(fromHour(availability.getFrom()));
		tAvailability.setTo(fromHour(availability.getTo()));
		
		return tAvailability;
	}

	public static THour fromHour(Hour hour) {
		
		THour tHour = new THour();
		tHour.setId(hour.getId());
		tHour.setValue(hour.getValue());
		
		return tHour;
		
	}

	public static TLocation fromLocation(Location location) {
		if(location == null){
			return null;
		}
		TLocation tLocation = new TLocation();
		tLocation.setLatitude(location.getLatitude());
		tLocation.setLongitude(location.getLongitude());
		tLocation.setName(location.getName());
		return tLocation;
	}

	public static TPrice fromPrice(Price price) {
		if(price == null){
			return null;
		}
		
		TPrice tPrice = new TPrice();
		tPrice.setId(price.getId());
		tPrice.setValue(price.getValue());
		return tPrice;
	}

	public static TContact fromContact(Contact contact) {
		if(contact == null){
			return null;
		}

		TContact tContact = new TContact();
		tContact.setEmail(contact.getEmail());
		tContact.setSkype(contact.getSkype());
		tContact.setTelephone(contact.getTelephone());
		return tContact;
	}

	public static TRequestList fromRequestList(List<Request> requests) {
		TRequestList tRequestList = new TRequestList();

		for (Request request : requests) {
			tRequestList.getRequests().add(fromRequest(request));
		}

		return tRequestList;
	}

	public static TRequest fromRequest(Request request) {
		TRequest tRequest = new TRequest();
		tRequest.setId(request.getId());
		tRequest.setStatus(TStatusRequest.fromValue(request.getStatus().name()));
		tRequest.setDescription(request.getDescription());
		Date date = request.getCreatedAt();
		tRequest.setCreatedAt(toXMLGregorianCalendar(date));
		tRequest.setUser(fromUser(request.getUser()));
		tRequest.setTutor(fromTutor(request.getTutor()));
		return tRequest;
	}

	private static XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
		if(date == null){
			return null;
		}
		GregorianCalendar gCalendar = new GregorianCalendar();
		gCalendar.setTime(date);
		XMLGregorianCalendar xmlCalendar = null;
		try {
			xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
		} catch (DatatypeConfigurationException ex) {
		}
		return xmlCalendar;
	}

	public static Request toRequest(TRequest tRequest) {
		Request request = new Request();
		request.setCreatedAt(tRequest.getCreatedAt().toGregorianCalendar().getTime());
		request.setDescription(tRequest.getDescription());
		request.setTutor(toTutor(tRequest.getTutor()));
		request.setUser(toUser(tRequest.getUser()));
		request.setId(tRequest.getId());
		request.setStatus(toStatusRequest(tRequest.getStatus()));
		
		return request;
	}

	public static RequestTutors toRequestTutors(TRequestTutors tRequestTutors) {
		RequestTutors requestTutors = new RequestTutors();
		requestTutors.setLatitude(tRequestTutors.getLatitude());
		requestTutors.setLongitude(tRequestTutors.getLongitude());
		requestTutors.setSubjectId(tRequestTutors.getSubjectId());
		requestTutors.setTypeOfEducationId(tRequestTutors.getTypeOfEducationId());
		
		return requestTutors;
	}

	public static TTutorInfoList fromTutorInfoList(List<TutorInfo> infos) {
		TTutorInfoList tInfoList = new TTutorInfoList();
		TTutorInfo tInfo = null;
		
		for(TutorInfo info : infos){
			tInfo = new TTutorInfo();
			tInfo.setDistance(info.getDistance());
			tInfo.setId(info.getId());
			tInfoList.getTutors().add(tInfo);
		}
				
		return tInfoList;
	}

	public static TStatusRequest fromStatusRequest(StatusRequest status) {
		return (status == null) ? null :  TStatusRequest.fromValue(status.name());
	}
	public static StatusRequest toStatusRequest(TStatusRequest tStatus) {
		return StatusRequest.valueOf(tStatus.value());
	}
}
