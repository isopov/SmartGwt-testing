package com.sopovs.moradanen.rf.smartgwt.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.rf.shared.CompanyProxy;
import com.sopovs.moradanen.rf.smartgwt.server.CompanyService;

/**
 * Builds requests for the Employee service.
 */
@Service(CompanyService.class)
public interface CompanyRequest extends RequestContext {

	Request<List<CompanyProxy>> fetchCompanies(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria);

}