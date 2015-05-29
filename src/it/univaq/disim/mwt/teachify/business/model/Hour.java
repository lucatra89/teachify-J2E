package it.univaq.disim.mwt.teachify.business.model;

public class Hour implements java.io.Serializable {
	private Long id;
	private int value;

	public Hour() {
		super();
	}

	public Hour(int nome) {
		super();
		this.value = nome;
	}

	public Hour(Long id, int nome) {
		super();
		this.id = id;
		this.value = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
