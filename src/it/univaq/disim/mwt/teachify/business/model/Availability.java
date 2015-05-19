package it.univaq.disim.mwt.teachify.business.model;

public class Availability implements java.io.Serializable{
	
	private long id;
	private Day day;
	private Hour from;
	private Hour to;
	private Tutor tutor;
	
	public Availability() {
		super();
	}
	
	public Availability(Day day, Hour from, Hour to) {
		super();
		this.day = day;
		this.from = from;
		this.to = to;
	}
	
	public Availability(long id, Day day, Hour from, Hour to) {
		super();
		this.id = id;
		this.day = day;
		this.from = from;
		this.to = to;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Hour getFrom() {
		return from;
	}

	public void setFrom(Hour from) {
		this.from = from;
	}

	public Hour getTo() {
		return to;
	}

	public void setTo(Hour to) {
		this.to = to;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}
	
	
}
