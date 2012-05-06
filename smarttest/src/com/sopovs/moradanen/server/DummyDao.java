package com.sopovs.moradanen.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.sopovs.moradanen.server.domain.Company;
import com.sopovs.moradanen.server.domain.Person;
import com.sopovs.moradanen.server.domain.Sector;

public class DummyDao {
	private static final Random r = new Random(228L);
	public final static List<Person> PERSONS = createPersons(r);
	public final static List<Company> COMPANIES = createCompanies(r);
	public final static List<Sector> SECTORS = createSectors(r);

	private static List<Person> createPersons(Random r) {
		List<Person> result = new ArrayList<Person>();
		String[] firstNames = new String[] { "Ivan", "Peter", "Sidor", "Vasil", "Urij", "Alex" };
		String[] secondNames = new String[] { "Ivanov", "Petrov", "Sidorov", "Vasiljev", "Urijev",
				"Alexandrov", "Shulc" };
		String[] descriptions = new String[] { "Student", "Professor", "Worker", "Driver", "Gardener" };
		for (int i = 0; i < 100; i++) {
			Person person = new Person(String.valueOf(i),
					firstNames[r.nextInt(firstNames.length)],
					secondNames[r.nextInt(secondNames.length)],
					descriptions[r.nextInt(descriptions.length)]);
			person.setCompanies(new ArrayList<Company>());
			result.add(person);
		}
		return result;
	}

	private static List<Company> createCompanies(Random r) {
		List<Company> result = new ArrayList<Company>();
		for (int i = 0; i < 50; i++) {
			Company com = new Company(String.valueOf(i), "Company " + (i + 1));
			com.setFocusedSectors(new ArrayList<Sector>());
			Set<Person> uniqueWorkers = new HashSet<Person>();
			for (int j = 0; j < r.nextInt(20); j++) {
				Person worker = PERSONS.get(r.nextInt(PERSONS.size()));
				worker.getCompanies().add(com);
				uniqueWorkers.add(worker);
			}
			com.setWorkers(new ArrayList<Person>(uniqueWorkers));
			result.add(com);
		}
		return result;
	}

	private static List<Sector> createSectors(Random r) {
		List<Sector> result = new ArrayList<Sector>();
		Sector root = new Sector(String.valueOf(0), null, "Root");
		result.add(root);
		for (int i = 1; i < 60; i++) {
			Sector sec = new Sector(String.valueOf(i), result.get(r.nextInt(result.size())).getId(), "Sector "
					+ (i + 1));
			result.get(Integer.valueOf(sec.getParentId())).getSubSectors().add(sec);
			Set<Company> uniqueCompaniess = new HashSet<Company>();
			for (int j = 0; j < r.nextInt(20); j++) {
				Company com = COMPANIES.get(r.nextInt(COMPANIES.size()));
				com.getFocusedSectors().add(sec);
				uniqueCompaniess.add(com);
			}
			sec.setFocusedCompanies(new ArrayList<Company>(uniqueCompaniess));
			result.add(sec);
		}
		return result;
	}

}
