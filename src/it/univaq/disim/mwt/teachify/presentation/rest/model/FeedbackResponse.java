package it.univaq.disim.mwt.teachify.presentation.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.media.jai.opimage.FFT;

import it.univaq.disim.mwt.teachify.business.model.Feedback;
import it.univaq.disim.mwt.teachify.business.model.Tutor;
import it.univaq.disim.mwt.teachify.business.model.User;

public class FeedbackResponse extends Feedback {
	@JsonIgnore
	private Tutor tutor;
	@JsonIgnore
	private User user;
	@JsonProperty("tutor")
	private TutorResponse tutorResponse;
	@JsonProperty("user")
	private UserResponse userResponse;
	
	public FeedbackResponse(Feedback feedback){
		this.setId(feedback.getId());
		this.setCreatedAt(feedback.getCreatedAt());
		this.setRating(feedback.getRating());
		this.setDescription(feedback.getDescription());
		this.setTutorResponse(new TutorResponse(feedback.getTutor()));
		this.setUserResponse(new UserResponse(feedback.getUser()));
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
