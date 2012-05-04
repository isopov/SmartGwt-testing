package com.sopovs.moradanen.smartgwt.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PersonDTO implements IsSerializable, Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String firstName;
	private String secondName;
	private String description;

	public PersonDTO() {

	}

	public PersonDTO(String id, String firstName, String secondName, String description) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
