package it.univaq.disim.mwt.teachify.business.model;


import java.util.Date;

public class Feedback implements java.io.Serializable {
	
	private Long id;
	private String description;
	private int rating;
	private Date createdAt;
	private User user;
	private Tutor tutor;

	public Feedback() {
		super();
	}

	public Feedback(String description, int rating, Date createdAt, User user,Lesson lesson) {
		super();
		this.description = description;
		this.setRating(rating);
		this.createdAt = createdAt;
		this.user = user;
	}

	public Feedback(Long id, String description, int rating, Date createdAt, User user, Lesson lesson) {
		super();
		this.setId(id);
		this.description = description;
		this.setRating(rating);
		this.createdAt = createdAt;
		this.user = user;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


}
