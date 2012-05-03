package com.sopovs.moradanen.smartgwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.shared.Company;
import com.sopovs.moradanen.smartgwt.client.lib.GenericGwtRpcDataSource;

public class CompanyDataSource extends GenericGwtRpcDataSource<Company, Record, CompanyGwtRpcServiceAsync> {

	public static final String ID = "id";
	private static final String NAME = "name";
	public static final String SECTOR_ID = "sectorId";

	@Override
	public List<DataSourceField> getDataSourceFields() {
		List<DataSourceField> result = new ArrayList<DataSourceField>();
		DataSourceTextField id = new DataSourceTextField(ID, "Id");
		id.setPrimaryKey(true);
		result.add(id);
		result.add(new DataSourceTextField(NAME, "Name"));
		return result;
	}

	@Override
	public void copyValues(Record from, Company to) {
		to.setId(from.getAttribute(ID));
		to.setName(from.getAttribute(NAME));
	}

	@Override
	public void copyValues(Company from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(NAME, from.getName());
	}

	@Override
	public CompanyGwtRpcServiceAsync getServiceAsync() {
		return GWT.create(CompanyGwtRpcService.class);
	}

	@Override
	public Record getNewRecordInstance() {
		return new Record();
	}

	@Override
	public Company getNewDataObjectInstance() {
		return new Company();
	}
}
