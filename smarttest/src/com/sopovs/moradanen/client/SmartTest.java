package com.sopovs.moradanen.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.grid.ListGrid;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartTest implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		DataSource dataSource = new TestPojoDataSource();
		ListGrid grid = new ListGrid();
		grid.setDataSource(dataSource);
		grid.setWidth100();
		grid.setHeight(600);
		grid.setAutoFetchData(true);
		grid.draw();
	}
}
