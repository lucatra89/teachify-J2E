package it.univaq.disim.mwt.teachify.common.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.univaq.disim.mwt.teachify.business.model.Tutor;

public interface LessonMixIn {
	@JsonIgnore
	public Tutor getTutor();

}
