package it.univaq.disim.mwt.teachify.business.model;

public class Availability implements java.io.Serializable{
	private Long id;
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
	
	public Availability(Long id, Day day, Hour from, Hour to) {
		super();
		this.setId(id);
		this.day = day;
		this.from = from;
		this.to = to;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
