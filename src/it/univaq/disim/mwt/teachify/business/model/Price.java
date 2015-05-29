package it.univaq.disim.mwt.teachify.business.model;

public class Price  implements java.io.Serializable{
	private Long id;
	private int value;
	
	
	public Price() {
		super();
	}


	public Price(int value) {
		super();
		this.value = value;
	}


	public Price(Long id, int value) {
		super();
		this.id = id;
		this.value = value;
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
