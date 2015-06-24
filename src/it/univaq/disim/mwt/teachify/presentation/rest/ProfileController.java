package it.univaq.disim.mwt.teachify.presentation.rest;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.AuthException;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.common.spring.Utility;
import it.univaq.disim.mwt.teachify.presentation.rest.model.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/profile")

public class ProfileController {
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse profile(){

		User user = service.findUserById(Utility.getUser().getId());
		return new UserResponse(user);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping( method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody User user){
		User current = Utility.getUser();
		
		user.setId(current.getId());
		user.setEmail(current.getEmail());
		user.setPassword(current.getPassword());
		user.setGroups(current.getGroups());
		
		service.updateUser(user);
				
	}
	
	
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({BusinessException.class})
    public void error(){}
    
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({AuthException.class})
    public void unauthorized(){}

}

