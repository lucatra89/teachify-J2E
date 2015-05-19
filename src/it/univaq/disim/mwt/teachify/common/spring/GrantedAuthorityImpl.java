package it.univaq.disim.mwt.teachify.common.spring;


import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

	private String group;
		
	public GrantedAuthorityImpl(String group) {
		super();
		this.group = group;
	}


	@Override
	public String getAuthority() {
		return group;
	}
	

	@Override
	public String toString() {
		return "[autority=" + group + "]";
	}

}
