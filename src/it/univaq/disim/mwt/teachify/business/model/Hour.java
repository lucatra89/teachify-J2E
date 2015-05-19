package it.univaq.disim.mwt.teachify.business.model;

public class Hour implements java.io.Serializable {
	private long id;
	private int value;

	public Hour() {
		super();
	}

	public Hour(int nome) {
		super();
		this.value = nome;
	}

	public Hour(long id, int nome) {
		super();
		this.id = id;
		this.value = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
