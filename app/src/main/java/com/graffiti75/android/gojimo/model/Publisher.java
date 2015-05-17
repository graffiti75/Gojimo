package com.graffiti75.android.gojimo.model;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Publisher {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String id;
	private String title;
	private String link;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Publisher() {}

	public Publisher(String id, String title, String link) {
		this.id = id;
		this.title = title;
		this.link = link;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Publisher{" +
			"id='" + id + '\'' +
			", title='" + title + '\'' +
			", link='" + link + '\'' +
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
}