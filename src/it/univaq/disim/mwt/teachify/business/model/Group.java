package it.univaq.disim.mwt.teachify.business.model;

import java.io.Serializable;

public class Group implements Serializable {
	
	private Long id;
	private String name;

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group(Long id, String name) {
		super();
		this.setId(id);
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
