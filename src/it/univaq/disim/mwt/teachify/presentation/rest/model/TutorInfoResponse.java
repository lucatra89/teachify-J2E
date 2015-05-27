package it.univaq.disim.mwt.teachify.presentation.rest.model;

public class TutorInfoResponse {
	
	private String uri;
	
	private long distance;

	public TutorInfoResponse() {
		super();
	}

	public TutorInfoResponse(String uri, long distance) {
		super();
		this.uri = uri;
		this.distance = distance;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public long getDistance() {
		return distance;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}

}
