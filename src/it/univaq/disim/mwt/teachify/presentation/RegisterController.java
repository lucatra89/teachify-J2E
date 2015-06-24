package it.univaq.disim.mwt.teachify.presentation;

import it.univaq.disim.mwt.teachify.business.BusinessException;
import it.univaq.disim.mwt.teachify.business.TutorService;
import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;
import it.univaq.disim.mwt.teachify.common.spring.Utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private TutorService tutorService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired @Qualifier("manager")
	private AuthenticationManager manager;
	
	private static final Logger logger = Logger.getLogger(RegisterController.class);
	
	private boolean authenticate(User user){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());
		
		manager.authenticate(token);
		
		if(token.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(token);
			return true;
		}else
			return false;
		
	}
	
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute User user){


		try{
			userService.createUser(user);
			
		}catch(BusinessException e){
			
			return "redirect:/register";
		}

		
		if(authenticate(user))
			return "redirect:/";
		else
			return "redirect:/register";
	}
	
	
	
	@RequestMapping(value="/registertutor" , method = RequestMethod.POST)
	public String tutorRegistration(@ModelAttribute Tutor tutor){
		
		try{
			tutorService.createTutor(tutor);
			
		}catch(BusinessException e){
			
			return "redirect:/registertutor";
		}
						
		if(authenticate(tutor)){
			return "redirect:/dashboard/tutor";
		}
		else
			return "redirect:/registertutor";
		
	}
	
	@RequestMapping(value="/upgrade" , method = RequestMethod.POST)
	public String upgradeToTutor(@ModelAttribute Tutor tutor){
		
		User user = Utility.getUser();
		tutor.setId(user.getId());
		tutor.setEmail(user.getEmail());
		tutor.setPassword(user.getPassword());
		tutor.setName(user.getName());
		tutor.setSurname(user.getSurname());
		tutor.setGroups(user.getGroups());

		try{
			tutorService.upgradeToTutor(tutor);
			
		}catch(BusinessException e){
			
			return "redirect:/upgrade";
		}
		
		
		if(authenticate(tutor))
			return "redirect:/dashboardtutor";
		
		else
			return "redirect:/upgrade";
				
		
	}
	
	

}
