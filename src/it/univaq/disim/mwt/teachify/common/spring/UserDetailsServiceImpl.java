package it.univaq.disim.mwt.teachify.common.spring;

import it.univaq.disim.mwt.teachify.business.UserService;
import it.univaq.disim.mwt.teachify.business.impl.JDBCUserService;
import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService service;
	private static final Logger logger = Logger.getLogger(JDBCUserService.class);
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= service.authenticate(username);
					
		if(user== null){
			throw new UsernameNotFoundException("");
		}
		for(Group g : user.getGroups()){
			logger.info(g.getName());
		}

		
		return new UserDetailsImpl(user);
	}

}
