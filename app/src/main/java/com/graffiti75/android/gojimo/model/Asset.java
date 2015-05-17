package com.graffiti75.android.gojimo.model;

import java.util.List;

/**
 * Created by Rodrigo Cericatto on 17/05/2015.
 */
public class Asset {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------

	private String id;
	private String copyright;
	private String meta;
	private Long size;
	private String content_type;
	private String created_at;
	private String updated_at;
	private String path;
	private String unzipped_base_url;
	private List<Info> info;
	private String link;

	//--------------------------------------------------
	// Constructor
	//--------------------------------------------------

	public Asset() {}

	public Asset(String id, String copyright, String meta, Long size, String content_type,
		String created_at, String updated_at, String path, String unzipped_base_url,
		List<Info> info, String link) {
		this.id = id;
		this.copyright = copyright;
		this.meta = meta;
		this.size = size;
		this.content_type = content_type;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.path = path;
		this.unzipped_base_url = unzipped_base_url;
		this.info = info;
		this.link = link;
	}

	//--------------------------------------------------
	// To String
	//--------------------------------------------------

	@Override
	public String toString() {
		return "Asset{" +
			"id='" + id + '\'' +
			", copyright='" + copyright + '\'' +
			", meta='" + meta + '\'' +
			", size=" + size +
			", content_type='" + content_type + '\'' +
			", created_at='" + created_at + '\'' +
			", updated_at='" + updated_at + '\'' +
			", path='" + path + '\'' +
			", unzipped_base_url='" + unzipped_base_url + '\'' +
			", info=" + info +
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

	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getMeta() {
		return meta;
	}
	public void setMeta(String meta) {
		this.meta = meta;
	}

	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}

	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}

	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getUnzipped_base_url() {
		return unzipped_base_url;
	}
	public void setUnzipped_base_url(String unzipped_base_url) {
		this.unzipped_base_url = unzipped_base_url;
	}

	public List<Info> getInfo() {
		return info;
	}
	public void setInfo(List<Info> info) {
		this.info = info;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}