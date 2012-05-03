package com.sopovs.moradanen.shared;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Sector implements IsSerializable, Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String parentId;
	private String name;
	//TODO make this ManyToMany JPA relationship
	private List<Company> focusedCompanies;

	public Sector() {
	}

	public Sector(String id, String parentId, String name) {
		this.id = id;
		this.parentId = parentId;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Company> getFocusedCompanies() {
		return focusedCompanies;
	}

	public void setFocusedCompanies(List<Company> focusedCompanies) {
		this.focusedCompanies = focusedCompanies;
	}

}
