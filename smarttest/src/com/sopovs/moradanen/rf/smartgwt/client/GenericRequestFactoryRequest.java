package com.sopovs.moradanen.rf.smartgwt.client;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public interface GenericRequestFactoryRequest<E extends EntityProxy> extends RequestContext{
	Request<List<E>> fetch (Integer startRow, Integer endRow, String sortBy, List<String> filterCriteria);

	Request<E> add (E data);

	Request<E> update (E data);

	Request<E> remove (E data);
}
