package com.sopovs.moradanen.rf.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.sopovs.moradanen.server.domain.Person;

@ProxyFor(Person.class)
public interface PersonProxy extends EntityProxy {

	String getId();

	String getFirstName();

	String getSecondName();

	String getDescription();
}