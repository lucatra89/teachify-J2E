package it.univaq.disim.mwt.teachify.business.model;

public class RequestTutors implements java.io.Serializable {
	private float latitude;
	private float longitude;
	private long subjectId;
	private long typeOfEducationId;

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getTypeOfEducationId() {
		return typeOfEducationId;
	}

	public void setTypeOfEducationId(long typeOfEducationId) {
		this.typeOfEducationId = typeOfEducationId;
	}

}
