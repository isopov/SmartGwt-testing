package com.sopovs.moradanen.rf.smartgwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.rf.shared.CompanyProxy;
import com.sopovs.moradanen.rf.smartgwt.shared.SmartRequestFactory;

public class CompanyDataSource extends GenericDataSource<CompanyProxy> {

	public static final String ID = "id";
	private static final String NAME = "name";
	public static final String SECTOR_ID = "sectorId";

	public CompanyDataSource(SmartRequestFactory rf) {
		super(rf);
	}

	@Override
	protected List<DataSourceField> getDataSourceFields() {
		List<DataSourceField> result = new ArrayList<DataSourceField>();
		DataSourceTextField id = new DataSourceTextField(ID, "Id");
		id.setPrimaryKey(true);
		result.add(id);
		result.add(new DataSourceTextField(NAME, "Name"));
		return result;
	}

	@Override
	protected void copyValues(CompanyProxy from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(NAME, from.getName());
	}

	@Override
	protected Request<List<CompanyProxy>> fetch(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria) {
		return getRf().companyRequest().fetchCompanies(startRow, endRow, sortBy, filterCriteria);
	}

}
