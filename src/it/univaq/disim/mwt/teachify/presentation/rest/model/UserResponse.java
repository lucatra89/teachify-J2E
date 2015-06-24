package it.univaq.disim.mwt.teachify.presentation.rest.model;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.User;

public class UserResponse extends User {
	@JsonIgnore
	private String password;
	@JsonIgnore
	private List<Group> groups;
	public UserResponse() {
		super();
	}
	public UserResponse(Long id, String email, String name, String surname) {
		super(id, email, null, name, surname, null);
	}
	public UserResponse(User user ) {
		this(user.getId(), user.getEmail(), user.getName(), user.getSurname());
	}
	
}
