package it.univaq.disim.mwt.teachify.common.spring;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.User;


public class UserDetailsImpl implements UserDetails{

	private User user;
	
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Group group : user.getGroups()){
			authorities.add(new GrantedAuthorityImpl(group.getName()));
			System.out.println(group.getName());
		}
		
		return authorities;
		
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
				return true;
	}
	
	@Override
	public String toString() {
		return "UserDetailsImpl [username=" + user.getEmail() + "]" ;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
