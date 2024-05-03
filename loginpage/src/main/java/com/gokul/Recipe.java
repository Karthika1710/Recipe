package com.gokul;

import java.util.Arrays;

public class Recipe {
   


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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


    @Override
	public String toString() {
		return "Recipe [recipename=" + recipename + ", recipeing=" + recipeing + ", recipepro=" + recipepro
				+ ", username=" + username + "]";
	}
	private String recipename; 
	private String recipeing;
    private String recipepro;
    private String username;
    
 

	
    // Constructors, getters, and setters

    public Recipe() {
        // Default constructor
    }

    public Recipe(String recipename, String recipeing, String recipepro) {
        this.recipename = recipename;
        this.recipeing = recipeing;
        this.recipepro = recipepro;
    }

    
}