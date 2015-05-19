package it.univaq.disim.mwt.teachify.business.model;

import java.util.List;

public class Lesson implements java.io.Serializable {
	private long id;
	private Subject subject;
	private TypeOfEducation typeOfEducation;
	private Tutor tutor;

	public Lesson() {
		super();
	}

	public Lesson(Subject subject, TypeOfEducation typeOfEducation,  List<Feedback> feedback) {
		super();
		this.subject = subject;
		this.typeOfEducation = typeOfEducation;
	}

	public Lesson(long id, Subject subject, TypeOfEducation typeOfEducation,  List<Feedback> feedback) {
		super();
		this.id = id;
		this.subject = subject;
		this.typeOfEducation = typeOfEducation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public TypeOfEducation getTypeOfEducation() {
		return typeOfEducation;
	}

	public void setTypeOfEducation(TypeOfEducation typeOfEducation) {
		this.typeOfEducation = typeOfEducation;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}



}
