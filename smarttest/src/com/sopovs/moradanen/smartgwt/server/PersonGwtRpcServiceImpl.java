package com.sopovs.moradanen.smartgwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Person;
import com.sopovs.moradanen.smartgwt.client.PersonDataSource;
import com.sopovs.moradanen.smartgwt.client.PersonGwtRpcService;
import com.sopovs.moradanen.smartgwt.shared.PersonDTO;

public class PersonGwtRpcServiceImpl extends RemoteServiceServlet implements PersonGwtRpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<PersonDTO> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		String companyId = filterCriteria.get(PersonDataSource.COMPANY_ID);
		List<PersonDTO> result = new ArrayList<PersonDTO>();
		for (Person per : DummyDao.PERSONS) {
			if (per.getCompanies().contains(DummyDao.COMPANIES.get(Integer.valueOf(companyId)))) {
				result.add(toDTO(per));
			}
		}

		//TODO if the requested range is bigger than result - return whole result without sublisting and creating new ArrayList
		return new ArrayList<PersonDTO>(result.subList(startRow, Math.min(result.size(), endRow)));
	}

	@Override
	public PersonDTO add(PersonDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public PersonDTO update(PersonDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public void remove(PersonDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	private static PersonDTO toDTO(Person person) {
		return new PersonDTO(person.getId(), person.getFirstName(), person.getSecondName(), person.getDescription());
	}

}
