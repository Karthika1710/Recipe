package com.gokul;

public class yourecipe {
	private String yourecipename;
	 @Override
	public String toString() {
		return "yourecipe [yourecipename=" + yourecipename + ", yourecipeing=" + yourecipeing + ", yourecipepro="
				+ yourecipepro + "]";
	}
	private String yourecipeing;
	 private String yourecipepro;
	 
	 public yourecipe() {
	        // Default constructor
	    }
	 public String getYourecipename() {
		return yourecipename;
	}
	public void setYourecipename(String yourecipename) {
		this.yourecipename = yourecipename;
	}
	public String getYourecipeing() {
		return yourecipeing;
	}
	public void setYourecipeing(String yourecipeing) {
		this.yourecipeing = yourecipeing;
	}
	public String getYourecipepro() {
		return yourecipepro;
	}
	public void setYourecipepro(String yourecipepro) {
		this.yourecipepro = yourecipepro;
	}
	   

		

}
