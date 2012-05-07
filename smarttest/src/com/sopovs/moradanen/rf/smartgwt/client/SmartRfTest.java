package com.sopovs.moradanen.rf.smartgwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.smartgwt.client.data.DataSource;
import com.sopovs.moradanen.rf.smartgwt.shared.SmartRequestFactory;
import com.sopovs.moradanen.smartgwt.client.lib.AbstractSmartTest;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartRfTest extends AbstractSmartTest {

	private final SmartRequestFactory rf = GWT.create(SmartRequestFactory.class);

	public SmartRfTest() {
		rf.initialize(new SimpleEventBus());
	}

	@Override
	protected DataSource createSectorDataSource() {
		return new SectorDataSource(rf);
	}

	@Override
	protected DataSource createCompanyDataSource() {
		return new CompanyDataSource(rf);
	}

	@Override
	protected DataSource createPersonDataSource() {
		return new PersonDataSource(rf);
	}
}
