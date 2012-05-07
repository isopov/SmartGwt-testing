package com.sopovs.moradanen.rf.smartgwt.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.rf.shared.PersonProxy;
import com.sopovs.moradanen.rf.smartgwt.server.PersonService;

/**
 * Builds requests for the Employee service.
 */
@Service(PersonService.class)
public interface PersonRequest extends RequestContext {

	Request<List<PersonProxy>> fetchPersons(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria);

}