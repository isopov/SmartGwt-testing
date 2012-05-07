package com.sopovs.moradanen.rf.smartgwt.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.rf.shared.SectorProxy;
import com.sopovs.moradanen.rf.smartgwt.server.SectorService;

/**
 * Builds requests for the Employee service.
 */
@Service(SectorService.class)
public interface SectorRequest extends RequestContext {

	Request<List<SectorProxy>> fetchSectors(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria);

}