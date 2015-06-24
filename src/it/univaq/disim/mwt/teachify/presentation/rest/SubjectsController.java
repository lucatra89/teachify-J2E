package it.univaq.disim.mwt.teachify.presentation.rest;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.EducationService;
import it.univaq.disim.mwt.teachify.business.model.Subject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/rest/subjects")


public class SubjectsController {
	@Autowired
	private EducationService service;
		
	@RequestMapping (method = RequestMethod.GET, produces= "application/json")
	public List<Subject> findAll () {
		return service.findAllSubjects();
	}
	
	
	@RequestMapping (method = RequestMethod.POST , consumes="application/json", produces="text/plain")
	public ResponseEntity<String> create(RequestEntity<Subject> request ) {
		
		Subject subject = request.getBody();
		service.createSubject(subject);
	
		URI uri = request.getUrl();
	    String id = Long.toString(subject.getId());
	    
	    URI location = 	UriComponentsBuilder.fromUri(uri).path("/{id}").build().expand(id).toUri();
	    	    
	    return ResponseEntity.created(location).body(id);
	}
	
	@RequestMapping (value="/{id:[0-9]+}" , method = RequestMethod.PUT , consumes="application/json")
	public ResponseEntity<Void> update(@RequestBody Subject subject, @PathVariable("id")long id ) {
		subject.setId(id);
		System.out.println(subject.getName());
		service.updateSubject(subject);
	    	    	    
	    return ResponseEntity.noContent().build();
	}
	
	@RequestMapping (value="/{id:[0-9]+}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id) {
		
		Subject subject = new Subject();
		subject.setId(id);
		
		service.deleteSubject(subject);
	    	    	    
	    return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void handle(){}


}
