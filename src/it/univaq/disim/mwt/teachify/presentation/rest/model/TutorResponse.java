package it.univaq.disim.mwt.teachify.presentation.rest.model;

import it.univaq.disim.mwt.teachify.business.model.Availability;
import it.univaq.disim.mwt.teachify.business.model.Group;
import it.univaq.disim.mwt.teachify.business.model.Lesson;
import it.univaq.disim.mwt.teachify.business.model.Tutor;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class , property="id")
public class TutorResponse extends Tutor {
	private static final long serialVersionUID = 1L;

	@JsonProperty("lessons")
	private Collection<LessonResponse> lessonResponses;
	@JsonProperty("availabilities")
	private Collection<AvailabilityResponse> availabilityResponses;

	@JsonIgnore
	private List<Group> groups;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private Collection<Lesson> lessons;
	@JsonIgnore
	private Collection<Availability> availabilities;
	

	public TutorResponse(Tutor tutor){
		
		super(tutor.getId());
		this.setContact(tutor.getContact());
		this.setEmail(tutor.getEmail());
		this.setDescription(tutor.getDescription());
		this.setRating(tutor.getRating());
		this.setPrice(tutor.getPrice());
		this.setPhoto(getPhoto());
		this.setLocation(tutor.getLocation());
		this.setName(tutor.getName());
		this.setSurname(tutor.getSurname());
		this.setContact(tutor.getContact());
		System.out.println(tutor.getContact());
		
		this.lessonResponses = new HashSet<LessonResponse>();
		this.availabilityResponses = new HashSet<AvailabilityResponse>();
		
		for (Lesson lesson : tutor.getLessons()) {
			this.lessonResponses.add(new LessonResponse(lesson));
		}
		
		for (Availability availability : tutor.getAvailabilities()) {
			this.availabilityResponses.add(new AvailabilityResponse(availability));
		}
	}
	

}
