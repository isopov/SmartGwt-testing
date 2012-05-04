package com.sopovs.moradanen.smartgwt.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class CompanyDTO implements IsSerializable, Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public CompanyDTO() {

	}

	public CompanyDTO(String id, String name) {
		this.id = id;
		this.name = name;
	}

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
}
