package com.sopovs.moradanen.smartgwt.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.sopovs.moradanen.smartgwt.client.lib.GenericGwtRpcDataSource;
import com.sopovs.moradanen.smartgwt.shared.SectorDTO;

public class SectorDataSource extends GenericGwtRpcDataSource<SectorDTO, Record, SectorGwtRpcServiceAsync> {

	private static final String DATASOURCE_ID = "SectorDS";
	public static final String ID = "id";
	private static final String PARENT_ID = "parentId";
	private static final String NAME = "name";

	public SectorDataSource() {
		setID(DATASOURCE_ID);
	}

	@Override
	public List<DataSourceField> getDataSourceFields() {
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
	public void copyValues(Record from, SectorDTO to) {
		to.setId(from.getAttribute(ID));
		to.setParentId(from.getAttribute(PARENT_ID));
		to.setName(from.getAttribute(NAME));
	}

	@Override
	public void copyValues(SectorDTO from, Record to) {
		to.setAttribute(ID, from.getId());
		to.setAttribute(PARENT_ID, from.getParentId());
		to.setAttribute(NAME, from.getName());
	}

	@Override
	public SectorGwtRpcServiceAsync getServiceAsync() {
		return GWT.create(SectorGwtRpcService.class);
	}

	@Override
	public Record getNewRecordInstance() {
		return new Record();
	}

	@Override
	public SectorDTO getNewDataObjectInstance() {
		return new SectorDTO();
	}
}
