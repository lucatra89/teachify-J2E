package it.univaq.disim.mwt.teachify.common.jackson;

import it.univaq.disim.mwt.teachify.business.model.Group;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface UserMixIn {
	@JsonIgnore
	String getPassword();
	@JsonIgnore
	Collection<Group> getGroups();

}
