package com.graffiti75.android.gojimo.model;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Country {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String code;
	private String name;
	private String created_at;
	private String updated_at;
	private String link;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Country() {}

	public Country(String code, String name, String created_at, String updated_at, String link) {
		this.code = code;
		this.name = name;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.link = link;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Country{" +
			"code='" + code + '\'' +
			", name='" + name + '\'' +
			", created_at='" + created_at + '\'' +
			", updated_at='" + updated_at + '\'' +
			", link='" + link + '\'' +
			'}';
	}

	//--------------------------------------------------
	// Getters and Setters
	//--------------------------------------------------

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return created_at;
	}
	public void setCreatedAt(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdatedAt() {
		return updated_at;
	}
	public void setUpdatedAt(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}