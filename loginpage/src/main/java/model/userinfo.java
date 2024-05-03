package model;

public class userinfo {
	private String recipename;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	private String mail;
	public String getRecipename() {
		return recipename;
	}
	public void setRecipename(String recipename) {
		this.recipename = recipename;
	}
	public String getRecipeing() {
		return recipeing;
	}
	public void setRecipeing(String recipeing) {
		this.recipeing = recipeing;
	}
	public String getRecipepro() {
		return recipepro;
	}
	public void setRecipepro(String recipepro) {
		this.recipepro = recipepro;
	}
	private String recipeing;
	@Override
	public String toString() {
		return "userinfo [recipename=" + recipename + ", mail=" + mail + ", recipeing=" + recipeing + ", recipepro="
				+ recipepro + "]";
	}
	private String recipepro;

}
