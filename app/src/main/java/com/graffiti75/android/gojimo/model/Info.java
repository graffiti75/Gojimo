package com.graffiti75.android.gojimo.model;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Info {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String meta;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Info() {}

	public Info(String meta) {
		this.meta = meta;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Info{" +
			"meta='" + meta +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}
}