package com.sopovs.moradanen.smartgwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.shared.Sector;
import com.sopovs.moradanen.smartgwt.client.SectorGwtRpcService;

public class SectorGwtRpcServiceImpl extends RemoteServiceServlet implements SectorGwtRpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Sector> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		if (startRow != null || endRow != null) {
			throw new IllegalStateException("It seems that for TreeGrid there should be no start and end rows in query");
		}
		List<Sector> result = new ArrayList<Sector>();
		for (Sector sector : DummyDao.SECTORS) {
			if (filterCriteria.get("parentId").equals(sector.getParentId())) {
				result.add(sector);
			}
		}
		return result;
	}

	@Override
	public Sector add(Sector data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public Sector update(Sector data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public void remove(Sector data) {
		throw new IllegalStateException("Not implemented");
	}

}
