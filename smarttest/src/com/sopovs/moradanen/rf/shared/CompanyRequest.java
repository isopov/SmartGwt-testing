package com.sopovs.moradanen.rf.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.server.domain.Company;

/**
 * Builds requests for the Employee service.
 */
@Service(Company.class)
public interface CompanyRequest extends RequestContext {

	/**
	 * @return a request object
	 */
	Request<Long> countCompanies();

	/**
	 * @return a request object
	 */
	Request<List<CompanyProxy>> findAllCompanies();

	/**
	 * @return a request object
	 */
	Request<CompanyProxy> findCompany(String id);

	/**
	 * @return a request object
	 */
	Request<List<CompanyProxy>> findCompaniesBySector(String parentId);

}