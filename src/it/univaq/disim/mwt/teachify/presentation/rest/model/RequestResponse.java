package it.univaq.disim.mwt.teachify.presentation.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.univaq.disim.mwt.teachify.business.model.Request;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;

public class RequestResponse extends Request {
	@JsonIgnore
	private Tutor tutor;
	@JsonIgnore
	private User user;
	@JsonProperty("tutor")
	private TutorResponse tutorResponse;
	@JsonProperty("user")
	private UserResponse userResponse;
	
	public RequestResponse() {
		super();
	}
	public RequestResponse(Request request) {
		super();
		this.setCreatedAt(request.getCreatedAt());
		this.setDescription(request.getDescription());
		this.setId(request.getId());
		this.setStatus(request.getStatus());
		this.setTutorResponse(new TutorResponse(request.getTutor()));
		this.setUserResponse(new UserResponse(request.getUser()));
	}
	
	
	
	public TutorResponse getTutorResponse() {
		return tutorResponse;
	}
	public void setTutorResponse(TutorResponse tutorResponse) {
		this.tutorResponse = tutorResponse;
	}
	public UserResponse getUserResponse() {
		return userResponse;
	}
	public void setUserResponse(UserResponse userResponse) {
		this.userResponse = userResponse;
	}
	
	
	
}
