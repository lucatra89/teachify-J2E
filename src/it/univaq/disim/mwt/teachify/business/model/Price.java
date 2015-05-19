package it.univaq.disim.mwt.teachify.business.model;

public class Price  implements java.io.Serializable{
	private long id;
	private int value;
	
	
	public Price() {
		super();
	}


	public Price(int value) {
		super();
		this.value = value;
	}


	public Price(long id, int value) {
		super();
		this.id = id;
		this.value = value;
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
