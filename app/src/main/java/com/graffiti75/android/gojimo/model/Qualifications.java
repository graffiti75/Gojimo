package com.graffiti75.android.gojimo.model;

import java.util.List;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Qualifications {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String id;
	private String name;
	private List<Country> country;
	private List<Subject> subjects;
	private String link;
	private List<DefaultProducts> default_products;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Qualifications() {}

	public Qualifications(String id, String name, List<Country> country, List<Subject> subjects,
		String link, List<DefaultProducts> default_products) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.subjects = subjects;
		this.link = link;
		this.default_products = default_products;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Qualifications{" +
			"id='" + id + '\'' +
			", name='" + name + '\'' +
			", country=" + country +
			", subjects=" + subjects +
			", link='" + link + '\'' +
			", default_products=" + default_products +
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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Country> getCountry() {
		return country;
	}
	public void setCountry(List<Country> country) {
		this.country = country;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public List<DefaultProducts> getDefaultProducts() {
		return default_products;
	}
	public void setDefaultProducts(List<DefaultProducts> default_products) {
		this.default_products = default_products;
	}
}