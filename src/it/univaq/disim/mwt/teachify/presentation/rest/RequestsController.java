package it.univaq.disim.mwt.teachify.presentation.rest;

import java.net.URI;
import java.util.List;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.AuthException;
import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.StatusRequest;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.common.spring.Utility;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/rest/requests")
public class RequestsController {
	@Autowired
	private TutorService service;
	
	private static Logger logger = Logger.getLogger(RequestsController.class);
	
	@RequestMapping(method=RequestMethod.GET, params="user", produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Request> findUserRequests(@RequestParam("user") Long userId) {
		User user= new User();
		user.setId(userId);
		return service.findRequestsByUser(user);
	}
    
	@RequestMapping(method=RequestMethod.GET, params={"tutor"},  produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Request> findTutorWaitingRequests(@RequestParam("tutor") Long tutorId ) {
			logger.info("Request received...");
			Tutor tutor = new Tutor();
			tutor.setId(tutorId);
			List<Request> list = service.findWaitingRequestsByTutor(tutor);
			logger.info("Sending response...");
			return list;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE , produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> create(RequestEntity<Request> requestEntity) {
		Request request = requestEntity.getBody();
		User user = Utility.getUser();
		request.setUser(user);
		
		service.createRequest(request);
		
		URI uri = requestEntity.getUrl();
	    String id = Long.toString(request.getId());
	    
	    URI location = 	UriComponentsBuilder.fromUri(uri).path("/{id}").build().expand(id).toUri();
	    	    
	    return ResponseEntity.created(location).body(id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping (value="/{id:[0-9]+}/status" , method = RequestMethod.PUT )
	public void updateStatus( @RequestBody String statusRequest, @PathVariable("id")long id) {
		
		StatusRequest status = StatusRequest.valueOf(statusRequest);

		Request request = new Request();
		request.setId(id);
		request.setStatus(status);
		Tutor tutor = new Tutor();
		tutor.setId(Utility.getUser().getId());
		request.setTutor(tutor);
		
		service.updateStatusRequest(request);
	}
	
	@RequestMapping(value="/isrequested", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusRequest> statusRequest(@RequestBody Tutor tutor) {
		
		User user = Utility.getUser();
		StatusRequest statusRequest = service.statusOfRequest(user, tutor);

		if (statusRequest != null)
			return ResponseEntity.ok().body(statusRequest);	
		else
			return new ResponseEntity<StatusRequest>(HttpStatus.NO_CONTENT);
			
	}
	

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void handle(){}
	
	
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthException.class})
    public void unauthorized(){}
}
