package it.univaq.disim.mwt.teachify.presentation.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.RequestTutors;
import it.univaq.disim.mwt.teachify.business.TutorInfo;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.AuthException;
import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Contact;
import it.univaq.disim.mwt.teachify.business.model.Feedback;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Location;
import it.univaq.disim.mwt.teachify.business.model.Price;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.common.spring.Utility;
import it.univaq.disim.mwt.teachify.presentation.VerifyUser;
import it.univaq.disim.mwt.teachify.presentation.rest.model.TutorInfoResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/rest/tutors")
public class TutorsController {
	
	@Autowired
	private TutorService service;
	
	private static Logger logger = Logger.getLogger(TutorsController.class);
	
	
	private List<TutorInfoResponse> findTutorsImpl(String uriRoot , RequestTutors request) {
		String uri = null;
		List<TutorInfoResponse> infos = new ArrayList<TutorInfoResponse>();
		
		for( TutorInfo tutorInfo : service.searchTutors(request)){
			uri = uriRoot + tutorInfo.getId();
			infos.add(new TutorInfoResponse(uri, tutorInfo.getDistance()));
		}

		return infos;
	}
	
	private List<String> findFeedbackImpl(String uriRoot , Tutor tutor) {
		List<Feedback> list = service.findAllFeedback(tutor);
		List<String> resources = new ArrayList<String>();
		URI location;
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(uriRoot).path("/{id}");
		
		
		for (Feedback feedback : list){
			location = uriBuilder.buildAndExpand(feedback.getId()).toUri();
			resources.add(location.toString());
		}
		
		return resources;
	}
	
	private ResponseEntity<String> createFeedbackImpl(URI uriRoot , Feedback feedback){
		service.createFeedback(feedback);
		
		String id = Long.toString(feedback.getId());
		
		URI location = UriComponentsBuilder.fromUri(uriRoot).path("/"+id).build().toUri();
		 
		return ResponseEntity.created(location).body(id);
	
	}
	
	
	private ResponseEntity<String> createRequestImpl(URI uriRoot, Request request) {
		service.createRequest(request);

		String id = Long.toString(request.getId());
		
	    URI location = 	UriComponentsBuilder.fromUri(uriRoot).path("/"+id).build().toUri();
	    
		return ResponseEntity.created(location).body(id);
	}
	
	private ResponseEntity<String> addLessonImpl(URI uri, Lesson lesson) {
		service.addLesson(lesson);
		
		String id = Long.toString(lesson.getId());
	    URI location = 	UriComponentsBuilder.fromUri(uri).path("/"+id).build().toUri();		
		
		return ResponseEntity.created(location).body(id);
	}

	private ResponseEntity<String> addAvailabilityImpl(URI uri, Availability availability) {
		service.addAvailability(availability);
		
		String id = Long.toString(availability.getId());
		URI location = UriComponentsBuilder.fromUri(uri).path("/" + id).build().toUri();
		
		return ResponseEntity.created(location).body(id);
	}

	
	@RequestMapping( value="/search" ,  method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TutorInfoResponse> findTutors(RequestEntity<RequestTutors>   requestEntity) {
		RequestTutors request = requestEntity.getBody();
		String uriRoot =requestEntity.getUrl().toString().replaceAll("search", "");	

		return findTutorsImpl(uriRoot, request);
	}
	
	@RequestMapping(value = ("/{id:[0-9]+}"), method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public  Tutor findTutor(@PathVariable("id") long id) {
		
		return service.findTutorByPk(id);
	}

	@RequestMapping(value = ("/{id:[0-9]+}/feedback"), method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public  ResponseEntity<String> createFeedback(@PathVariable("id") long tutorId ,RequestEntity<Feedback> request) {
		
		User user = Utility.getUser();
		Feedback feedback = request.getBody();
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		feedback.setUser(user);
		feedback.setTutor(tutor);
		URI uriRoot = request.getUrl();
		
		return createFeedbackImpl(uriRoot, feedback);
	}
	
	
	
	@RequestMapping(value = ("/{id:[0-9]+}/feedback"), method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> findFeedback(@PathVariable("id") long tutorId , HttpServletRequest request){
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		
		return findFeedbackImpl(request.getRequestURI(), tutor);
		
	}
	
	@RequestMapping(value = ("/{tutorId:[0-9]+}/feedback/{id:[0-9]+}"), method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public Feedback findFeedbackById(@PathVariable("id")long id) {
		return service.findFeedbackById(id);
	}
	
	
	@RequestMapping(value = ("/{id:[0-9]+}/request"), method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<String> createRequest(@PathVariable("id") long tutorId ,  RequestEntity<Request> requestEntity) {
		
		User user = Utility.getUser();
		Tutor tutor = new Tutor();
		URI uri = requestEntity.getUrl();
		Request request = requestEntity.getBody();
		request.setUser(user);
		request.setTutor(tutor);
				
		return createRequestImpl(uri, request);
		
	}
	

	@VerifyUser(pathVariable="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{id:[0-9]+}/description", method=RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateDescription(@RequestBody String description, @PathVariable("id") long id) {
				
		Tutor tutor = new Tutor();
		tutor.setId(id);
		
		tutor.setDescription(description);
		service.updateTutorDescription(tutor);
	}
	
	@VerifyUser(pathVariable="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{id:[0-9]+}/contact", method=RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateContact(@RequestBody Contact contact, @PathVariable("id") long id) {
		
		Tutor tutor = new Tutor();
		tutor.setId(id);
		
		tutor.setContact(contact);;
		service.updateTutorContact(tutor);
	}
	
	@VerifyUser(pathVariable="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{id:[0-9]+}/location", method=RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateLocation(@RequestBody Location location, @PathVariable("id") long id) {
		
		Tutor tutor = new Tutor();
		tutor.setId(id);
		
		tutor.setLocation(location);
		service.updateTutorLocation(tutor);
	}
	
	@VerifyUser(pathVariable="id")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{id:[0-9]+}/price", method=RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updatePrice(@RequestBody Price price, @PathVariable("id") long id) {

		Tutor tutor = new Tutor();
		tutor.setId(id);
		
		
		tutor.setPrice(price);
		service.updateTutorPrice(tutor);
	}
	
	
	@VerifyUser(pathVariable="id")
	@RequestMapping(value="/{id:[0-9]+}/lessons", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addLesson(RequestEntity<Lesson> requestEntity, @PathVariable("id") long tutorId) {
		
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		
		Lesson lesson = requestEntity.getBody();
		lesson.setTutor(tutor);
		
		URI uri = requestEntity.getUrl();
		
		
		return addLessonImpl(uri , lesson);
	}
	

	@VerifyUser(pathVariable="tutorId")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{tutorId:[0-9]+}/lessons/{id:[0-9]+}", method = RequestMethod.DELETE)
	public void deleteLesson(@PathVariable("id") long id , @PathVariable("tutorId") long tutorId) {
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		
		Lesson lesson = new Lesson();
		lesson.setId(id);
		lesson.setTutor(tutor);
		
		service.deleteLesson(lesson);
	}
	
	
	@VerifyUser(pathVariable="id")
	@RequestMapping(value="/{id:[0-9]+}/availabilities", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addAvailability(RequestEntity<Availability> requestEntity , @PathVariable("id") long tutorId) {
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		
		Availability availability = requestEntity.getBody();
		URI uri = requestEntity.getUrl();
		logger.info(availability);
		availability.setTutor(tutor);
		
		return addAvailabilityImpl(uri , availability);
		
	}
	

	@VerifyUser(pathVariable="tutorId")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/{tutorId:[0-9]+}/availabilities/{id:[0-9]+}", method = RequestMethod.DELETE)
	public void deleteAvailability(@PathVariable("tutorId") long tutorId , @PathVariable("id") long id) {
		Tutor tutor = new Tutor();
		tutor.setId(tutorId);
		
		Availability availability = new Availability();
		availability.setId(id);
		availability.setTutor(tutor);
		
		service.deleteAvailability(availability);
	}
	
		
	
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void handle(){}
    
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthException.class})
    public void unauthorized(){}

}
