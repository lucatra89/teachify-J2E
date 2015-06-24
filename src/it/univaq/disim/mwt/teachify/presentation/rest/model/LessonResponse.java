package it.univaq.disim.mwt.teachify.presentation.rest.model;

import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Tutor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class , property="id")
public class LessonResponse extends Lesson{
	@JsonIgnore
	private Tutor tutor;
	
	public LessonResponse() {
		super();
	}

	
	public LessonResponse(Lesson lesson){
		super();
		this.setId(lesson.getId());
		this.setSubject(lesson.getSubject());
		this.setTypeOfEducation(lesson.getTypeOfEducation());
	}	
	
}
