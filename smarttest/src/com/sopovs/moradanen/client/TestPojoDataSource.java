package com.sopovs.moradanen.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.client.lib.GenericGwtRpcDataSource;
import com.sopovs.moradanen.shared.TestPojo;

public class TestPojoDataSource extends GenericGwtRpcDataSource<TestPojo, Record, TestPojoGwtRpcServiceAsync> {

	private static final String DESCRIPTION = "description";
	private static final String SECOND_NAME = "secondName";
	private static final String FIRST_NAME = "firstName";
	private static final String ID = "id";

	@Override
	public List<DataSourceField> getDataSourceFields() {
		List<DataSourceField> result = new ArrayList<DataSourceField>();
		result.add(new DataSourceTextField(ID, "Id"));
		result.add(new DataSourceTextField(FIRST_NAME, "First Name"));
		result.add(new DataSourceTextField(SECOND_NAME, "Second Name"));
		result.add(new DataSourceTextField(DESCRIPTION, "Description Name"));
		return result;
	}

	@Override
	public void copyValues(Record from, TestPojo to) {
		to.setId(from.getAttribute(ID));
		to.setFirstName(from.getAttribute(FIRST_NAME));
		to.setSecondName(from.getAttribute(SECOND_NAME));
		to.setDescription(from.getAttribute(DESCRIPTION));
	}

	@Override
	public void copyValues(TestPojo from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(FIRST_NAME, from.getFirstName());
		to.setAttribute(SECOND_NAME, from.getSecondName());
		to.setAttribute(DESCRIPTION, from.getDescription());
	}

	@Override
	public TestPojoGwtRpcServiceAsync getServiceAsync() {
		return GWT.create(TestPojoGwtRpcService.class);
	}

	@Override
	public Record getNewRecordInstance() {
		return new Record();
	}

	@Override
	public TestPojo getNewDataObjectInstance() {
		return new TestPojo();
	}
}
