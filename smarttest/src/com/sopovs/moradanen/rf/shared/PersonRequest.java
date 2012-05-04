package com.sopovs.moradanen.rf.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.server.domain.Person;

/**
 * Builds requests for the Employee service.
 */
@Service(Person.class)
public interface PersonRequest extends RequestContext {

	/**
	 * @return a request object
	 */
	Request<Long> countPersons();

	/**
	 * @return a request object
	 */
	Request<List<PersonProxy>> findAllPersons();

	/**
	 * @return a request object
	 */
	Request<PersonProxy> findPerson(String id);

	/**
	 * @return a request object
	 */
	Request<List<PersonProxy>> findPersonsByCompany(String comapnyId);

}