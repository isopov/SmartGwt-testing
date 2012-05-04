package com.sopovs.moradanen.rf.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.sopovs.moradanen.server.domain.Company;

@ProxyFor(Company.class)
public interface CompanyProxy extends EntityProxy {

	String getId();

	String getName();
}