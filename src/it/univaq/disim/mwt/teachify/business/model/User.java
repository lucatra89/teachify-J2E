package it.univaq.disim.mwt.teachify.business.model;

import java.util.Set;

public class User implements java.io.Serializable {

	private long id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private Set<Group> groups;
	private byte[] photo;

	public User() {
		super();
	}

	public User(String email, String password, String name, String surname, Set<Group> groups) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.groups = groups;
	}

	public User(long id, String email, String password, String name, String surname, Set<Group> groups) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.groups = groups;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}



}
