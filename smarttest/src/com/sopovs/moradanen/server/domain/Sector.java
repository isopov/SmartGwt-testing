package com.sopovs.moradanen.server.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sopovs.moradanen.server.DummyDao;

public class Sector {
	private String id;
	private String parentId;
	private String name;
	//TODO make this ManyToMany JPA relationship
	private List<Company> focusedCompanies;

	private List<Sector> subSectors = new ArrayList<Sector>();

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

	public List<Sector> getSubSectors() {
		return subSectors;
	}

	public boolean isRoot() {
		return parentId == null;
	}

	public boolean isLeaf() {
		return subSectors.isEmpty();
	}

	public String getVersion() {
		//TODO
		return "0";
	}

	//TODO Move this all out of here to some services

	public static long countSectors() {
		return DummyDao.SECTORS.size();
	}

	public static List<Sector> findAllSectors() {
		return new ArrayList<Sector>(DummyDao.SECTORS);
	}

	public static Sector findSector(String id) {
		if (id == null) {
			return null;
		}
		return DummyDao.SECTORS.get(Integer.valueOf(id));
	}

	public static List<Sector> findSectorsByParent(String parentId) {
		if (parentId == null) {
			return new ArrayList<Sector>(Collections.singletonList(DummyDao.SECTORS.get(0)));
		} else {
			return new ArrayList<Sector>(DummyDao.SECTORS.get(Integer.valueOf(parentId)).getSubSectors());
		}
//		if (parentId == null) {
//			return Collections.singletonList(new Sector("0", null, "Sector 0"));
//		} else if (Integer.valueOf(parentId) < 30) {
//			return Collections.singletonList(new Sector(String.valueOf((Integer.valueOf(parentId) + 1)), parentId,
//					"SubSector"));
//		} else {
//			return Collections.emptyList();
//		}
	}
}
