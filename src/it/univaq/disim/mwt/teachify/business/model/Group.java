package it.univaq.disim.mwt.teachify.business.model;

import java.io.Serializable;

public class Group implements Serializable {

	private long id;
	private String name;

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Group(long id, String name) {
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

}
