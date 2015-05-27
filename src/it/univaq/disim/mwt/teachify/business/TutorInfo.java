package it.univaq.disim.mwt.teachify.business;

public class TutorInfo {
	
	private long id;
	private long distance;
	
	public TutorInfo() {
	}

	public TutorInfo(long id, long distance) {
		super();
		this.setId(id);
		this.distance = distance;
	}


	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
