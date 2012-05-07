package com.sopovs.moradanen.rf.smartgwt.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sopovs.moradanen.rf.smartgwt.client.PersonDataSource;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Person;

public class PersonService {
	public static List<Person> fetchPersons(Integer startRow, Integer endRow,
			@SuppressWarnings("unused") String sortBy,
			List<String> filterCriteria) {
		Map<String, String> realCriteria = new HashMap<String, String>();
		for (Iterator<String> it = filterCriteria.iterator(); it.hasNext();) {
			realCriteria.put(it.next(), it.next());
		}

		String companyId = realCriteria.get(PersonDataSource.COMPANY_ID);
		List<Person> result = new ArrayList<Person>();
		for (Person per : DummyDao.PERSONS) {
			if (per.getCompanies().contains(DummyDao.COMPANIES.get(Integer.valueOf(companyId)))) {
				result.add(per);
			}
		}

		//TODO if the requested range is bigger than result - return whole result without sublisting and creating new ArrayList
		return new ArrayList<Person>(result.subList(startRow, Math.min(result.size(), endRow)));
	}
}
