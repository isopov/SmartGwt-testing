package com.sopovs.moradanen.smartgwt.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SectorDTO implements IsSerializable, Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String parentId;
	private String name;

	public SectorDTO() {
	}

	public SectorDTO(String id, String parentId, String name) {
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
}
