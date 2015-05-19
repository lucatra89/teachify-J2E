package it.univaq.disim.mwt.teachify.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
@Controller
public class AccessDeniedController  {
	
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
	@RequestMapping(value="/accessdenied", method = RequestMethod.GET)
	public String accessdenied() {
		return "accessdenied";
	}
	
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
	@RequestMapping(value="/login")
	public String login() {
		return "layout";
	}

}
