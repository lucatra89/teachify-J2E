package it.univaq.disim.mwt.teachify.presentation.rest;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/rest/admins")


public class AdminsController {
	@Autowired
	private UserService service;
	
	@RequestMapping (method = RequestMethod.GET, produces= "application/json")
	public @ResponseBody List<User> findAll () {
		return service.findAll();
	}
	
	@RequestMapping (method = RequestMethod.POST , consumes="application/json", produces="text/plain")
	public ResponseEntity<String> create(RequestEntity<User> request ) {
		
		User user = request.getBody();
		service.createAdmin(user);;
	
		URI uri = request.getUrl();
	    String id = Long.toString(user.getId());
	    
	    URI location = 	UriComponentsBuilder.fromUri(uri).path("/{id}").build().expand(id).toUri();
	    	    
	    return ResponseEntity.created(location).body(id);
	}
	
	
	@RequestMapping (value="/{id:[0-9]+}" , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable long id) {
		
		User user = new User();
		user.setId(id);
		
		service.deleteAdmin(user);
	    	    	    
	    return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void handle(){}


}
