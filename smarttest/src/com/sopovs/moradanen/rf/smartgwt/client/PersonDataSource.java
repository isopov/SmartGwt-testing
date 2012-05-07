package com.sopovs.moradanen.rf.smartgwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.rf.shared.PersonProxy;
import com.sopovs.moradanen.rf.smartgwt.shared.SmartRequestFactory;

public class PersonDataSource extends GenericDataSource<PersonProxy> {

	private static final String DESCRIPTION = "description";
	private static final String SECOND_NAME = "secondName";
	private static final String FIRST_NAME = "firstName";
	private static final String ID = "id";
	public static final String COMPANY_ID = "companyId";

	public PersonDataSource(SmartRequestFactory rf) {
		super(rf);
	}

	@Override
	protected List<DataSourceField> getDataSourceFields() {
		List<DataSourceField> result = new ArrayList<DataSourceField>();
		DataSourceTextField id = new DataSourceTextField(ID, "Id");
		id.setPrimaryKey(true);
		result.add(id);
		result.add(new DataSourceTextField(FIRST_NAME, "First Name"));
		result.add(new DataSourceTextField(SECOND_NAME, "Second Name"));
		result.add(new DataSourceTextField(DESCRIPTION, "Description Name"));
		return result;
	}

	@Override
	protected void copyValues(PersonProxy from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(FIRST_NAME, from.getFirstName());
		to.setAttribute(SECOND_NAME, from.getSecondName());
		to.setAttribute(DESCRIPTION, from.getDescription());
	}

	@Override
	protected Request<List<PersonProxy>> fetch(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria) {
		return getRf().personRequest().fetchPersons(startRow, endRow, sortBy, filterCriteria);
	}

}
