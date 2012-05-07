package com.sopovs.moradanen.rf.smartgwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.rf.shared.SectorProxy;
import com.sopovs.moradanen.rf.smartgwt.shared.SmartRequestFactory;

public class SectorDataSource extends GenericDataSource<SectorProxy> {

	private static final String DATASOURCE_ID = "SectorDS";
	public static final String ID = "id";
	private static final String PARENT_ID = "parentId";
	private static final String NAME = "name";

	public SectorDataSource(SmartRequestFactory rf) {
		super(rf);
	}

	@Override
	protected Request<List<SectorProxy>> fetch(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria) {
		return getRf().sectorRequest().fetchSectors(startRow, endRow, sortBy, filterCriteria);
	}

	@Override
	protected List<DataSourceField> getDataSourceFields() {
		List<DataSourceField> result = new ArrayList<DataSourceField>();

		DataSourceTextField id = new DataSourceTextField(ID, "Id");
		id.setPrimaryKey(true);
		id.setRequired(true);
		result.add(id);

		DataSourceTextField parentId = new DataSourceTextField(PARENT_ID, "Parent Id");
		parentId.setForeignKey(DATASOURCE_ID + ".id");
		parentId.setRootValue("0");
		result.add(parentId);
		result.add(new DataSourceTextField(NAME, "Name"));
		return result;
	}

	@Override
	public void copyValues(SectorProxy from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(PARENT_ID, from.getParentId());
		to.setAttribute(NAME, from.getName());
	}
}
