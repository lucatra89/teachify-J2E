package it.univaq.disim.mwt.teachify.common.spring;

import it.univaq.disim.mwt.teachify.business.AuthException;
import it.univaq.disim.mwt.teachify.business.model.User;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utility {

	private static Logger logger = Logger.getLogger(Utility.class);
	
	public static User getUser() throws AuthException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		logger.info((authentication != null));
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof UserDetailsImpl) {
                UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
                return userDetailsImpl.getUser();
            }
        }
        
    	throw  new AuthException();

	}
		
	
}
