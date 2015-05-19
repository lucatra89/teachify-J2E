package it.univaq.disim.mwt.teachify.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import it.univaq.disim.mwt.teachify.presentation.rest.TutorsController;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	private static Logger logger = Logger.getLogger(TutorsController.class);
	
	@RequestMapping(value={"/*","/tutor/{id:[\\d]}", "/dashboard/*"}, method=RequestMethod.GET)
	public String index (){
		return "layout";
	}
	
	@RequestMapping(value={"/backend" ,"/backend/*"} , method=RequestMethod.GET)
	public String backend(){
		return "layout-backend";
	}

}
