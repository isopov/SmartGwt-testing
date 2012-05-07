package com.sopovs.moradanen.rf.smartgwt.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

/**
 * RequestFactory interface. Instances created via {@link com.google.gwt.core.client.GWT#create} can insantiate RPC
 * request objects.
 */
public interface SmartRequestFactory extends RequestFactory {

	/**
	 * @return a request selector
	 */
	CompanyRequest companyRequest();

	/**
	 * @return a request selector
	 */
	SectorRequest sectorRequest();

	/**
	 * @return a request selector
	 */
	PersonRequest personRequest();
}