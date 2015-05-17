package com.graffiti75.android.gojimo.model;

import java.util.List;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class DefaultProducts {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String id;
	private String title;
	private String link;
	private String ios_iap_id;
	private List<String> store_ids;
	private String type;
	private List<Asset> assets;
	private Publisher publisher;
	private String author;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public DefaultProducts() {}

	public DefaultProducts(String id, String title, String link, String ios_iap_id,
		List<String> store_ids, String type, List<Asset> assets, Publisher publisher,
		String author) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.ios_iap_id = ios_iap_id;
		this.store_ids = store_ids;
		this.type = type;
		this.assets = assets;
		this.publisher = publisher;
		this.author = author;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "DefaultProducts{" +
			"id='" + id + '\'' +
			", title='" + title + '\'' +
			", link='" + link + '\'' +
			", ios_iap_id='" + ios_iap_id + '\'' +
			", store_ids='" + store_ids + '\'' +
			", type='" + type + '\'' +
			", assets=" + assets +
			", publisher=" + publisher +
			", author='" + author + '\'' +
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

	public String getIosIapId() {
		return ios_iap_id;
	}
	public void setIosIapId(String ios_iap_id) {
		this.ios_iap_id = ios_iap_id;
	}

	public List<String> getStoreIds() {
		return store_ids;
	}
	public void setStoreIds(List<String> store_ids) {
		this.store_ids = store_ids;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}