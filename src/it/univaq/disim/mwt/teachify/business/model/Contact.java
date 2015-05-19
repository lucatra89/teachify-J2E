package it.univaq.disim.mwt.teachify.business.model;

public class Contact implements java.io.Serializable{
	private String telephone;
	private String email;
	private String skype;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

}
