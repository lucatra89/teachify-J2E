package it.univaq.disim.mwt.teachify.business.model;


import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Tutor extends User implements java.io.Serializable {

	private float rating; 
	
	private Location location;
	
	private Price price;
	
	private String description;
	
	private Contact contact;
	
	private Set<Lesson> lessons;
	
	private Set<Availability> availabilities;
	
	private long distance;
	
	@JsonIgnore
	private Set<Feedback> feedbacks;
	
	private Set<Request> requests;

	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}


	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Set<Availability> getAvailabilities() {
		return availabilities;
	}

	public void setAvailabilities(Set<Availability> availabilities) {
		this.availabilities = availabilities;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}
