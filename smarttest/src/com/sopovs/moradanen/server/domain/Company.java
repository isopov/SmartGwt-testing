package com.sopovs.moradanen.server.domain;

import java.util.ArrayList;
import java.util.List;

import com.sopovs.moradanen.server.DummyDao;

public class Company {
	private String id;
	private String name;

	//TODO make this ManyToMany JPA relationship
	private List<Sector> focusedSectors;
	//TODO make this ManyToMany JPA relationship
	private List<Person> workers;

	public Company() {

	}

	public Company(String id, String name) {
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

	public List<Sector> getFocusedSectors() {
		return focusedSectors;
	}

	public void setFocusedSectors(List<Sector> focusedSectors) {
		this.focusedSectors = focusedSectors;
	}

	public List<Person> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Person> workers) {
		this.workers = workers;
	}

	public String getVersion() {
		//TODO
		return "0";
	}

	//TODO Move this all out of here to some services

	public static long countCompanies() {
		return DummyDao.COMPANIES.size();
	}

	public static List<Company> findAllCompanies() {
		return new ArrayList<Company>(DummyDao.COMPANIES);
	}

	public static Company findCompany(String id) {
		if (id == null) {
			return null;
		}
		return DummyDao.COMPANIES.get(Integer.valueOf(id));
	}

	public static List<Company> findCompaniesBySector(String sectorId) {
		return new ArrayList<Company>(DummyDao.SECTORS.get(Integer.valueOf(sectorId)).getFocusedCompanies());
	}
}
