package com.sopovs.moradanen.rf.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.sopovs.moradanen.server.domain.Sector;

/**
 * Builds requests for the Employee service.
 */
@Service(Sector.class)
public interface SectorRequest extends RequestContext {

//	/**
//	 * @return a request object
//	 */
//	Request<Long> countSectors();
//
//	/**
//	 * @return a request object
//	 */
//	Request<List<SectorProxy>> findAllSectors();
//
//	/**
//	 * @return a request object
//	 */
//	Request<SectorProxy> findSector(String id);

	/**
	 * @return a request object
	 */
	Request<List<SectorProxy>> findSectorsByParent(String parentId);

}