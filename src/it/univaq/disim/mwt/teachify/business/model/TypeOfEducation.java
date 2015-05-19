package it.univaq.disim.mwt.teachify.business.model;

public class TypeOfEducation implements java.io.Serializable {
	private long id;
	private String name;

	public TypeOfEducation() {
		super();
	}

	public TypeOfEducation(String name) {
		super();
		this.name = name;
	}

	public TypeOfEducation(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object object) {
		return (object == null) ? false : ((TypeOfEducation) object).id == this.id;

	}

}
