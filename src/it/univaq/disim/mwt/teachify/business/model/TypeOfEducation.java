package it.univaq.disim.mwt.teachify.business.model;

public class TypeOfEducation implements java.io.Serializable {
	private Long id;
	private String name;

	public TypeOfEducation() {
		super();
	}

	public TypeOfEducation(String name) {
		super();
		this.name = name;
	}

	public TypeOfEducation(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
