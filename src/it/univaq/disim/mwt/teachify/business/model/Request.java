package it.univaq.disim.mwt.teachify.business.model;


import java.util.Date;


public class Request implements java.io.Serializable {

	private Long id;
	private Tutor tutor;
	private User user;
	private String description;
	private StatusRequest status;
	private Date createdAt;

	public Request() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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


	public StatusRequest getStatus() {
		return status;
	}


	public void setStatus(StatusRequest status) {
		this.status = status;
	}


	public Tutor getTutor() {
		return tutor;
	}


	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}



}
