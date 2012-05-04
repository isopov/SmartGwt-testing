package com.sopovs.moradanen.smartgwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Sector;
import com.sopovs.moradanen.smartgwt.client.SectorGwtRpcService;
import com.sopovs.moradanen.smartgwt.shared.SectorDTO;

public class SectorGwtRpcServiceImpl extends RemoteServiceServlet implements SectorGwtRpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<SectorDTO> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		if (startRow != null || endRow != null) {
			throw new IllegalStateException("It seems that for TreeGrid there should be no start and end rows in query");
		}
		List<SectorDTO> result = new ArrayList<SectorDTO>();
		for (Sector sector : DummyDao.SECTORS) {
			if (filterCriteria.get("parentId").equals(sector.getParentId())) {
				result.add(toDTO(sector));
			}
		}
		return result;
	}

	@Override
	public SectorDTO add(SectorDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public SectorDTO update(SectorDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public void remove(SectorDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	private static SectorDTO toDTO(Sector sector) {
		return new SectorDTO(sector.getId(), sector.getParentId(), sector.getName());
	}

}
