package com.sopovs.moradanen.smartgwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.shared.Person;
import com.sopovs.moradanen.smartgwt.client.PersonDataSource;
import com.sopovs.moradanen.smartgwt.client.PersonGwtRpcService;

public class PersonGwtRpcServiceImpl extends RemoteServiceServlet implements PersonGwtRpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Person> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		String companyId = filterCriteria.get(PersonDataSource.COMPANY_ID);
		List<Person> result = new ArrayList<Person>();
		for (Person per : DummyDao.PERSONS) {
			if (per.getCompanies().contains(DummyDao.COMPANIES.get(Integer.valueOf(companyId)))) {
				result.add(per);
			}
		}

		//TODO if the requested range is bigger than result - return whole result without sublisting and creating new ArrayList
		return new ArrayList<Person>(result.subList(startRow, Math.min(result.size(), endRow)));
	}

	@Override
	public Person add(Person data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public Person update(Person data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public void remove(Person data) {
		throw new IllegalStateException("Not implemented");
	}

}
