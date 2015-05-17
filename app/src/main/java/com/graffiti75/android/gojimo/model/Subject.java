package com.graffiti75.android.gojimo.model;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Subject {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String id;
	private String title;
	private String link;
	private String colour;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Subject() {}

	public Subject(String id, String title, String link, String colour) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.colour = colour;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Subject{" +
			"id='" + id + '\'' +
			", title='" + title + '\'' +
			", link='" + link + '\'' +
			", colour='" + colour + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
}