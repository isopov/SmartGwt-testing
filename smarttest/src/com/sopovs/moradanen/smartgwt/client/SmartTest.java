package com.sopovs.moradanen.smartgwt.client;

import com.smartgwt.client.data.DataSource;
import com.sopovs.moradanen.smartgwt.client.lib.AbstractSmartTest;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartTest extends AbstractSmartTest {

	@Override
	protected DataSource createSectorDataSource() {
		return new SectorDataSource();
	}

	@Override
	protected DataSource createCompanyDataSource() {
		return new CompanyDataSource();
	}

	@Override
	protected DataSource createPersonDataSource() {
		return new PersonDataSource();
	}

}
