package com.sopovs.moradanen.rf.smartgwt.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Sector;

public class SectorService {
	public static List<Sector> fetchSectors(Integer startRow, Integer endRow,
			@SuppressWarnings("unused") String sortBy,
			List<String> filterCriteria) {

		if (startRow != null || endRow != null) {
			throw new IllegalStateException("It seems that for TreeGrid there should be no start and end rows in query");
		}

		Map<String, String> realCriteria = new HashMap<String, String>();
		for (Iterator<String> it = filterCriteria.iterator(); it.hasNext();) {
			realCriteria.put(it.next(), it.next());
		}
		List<Sector> result = new ArrayList<Sector>();
		for (Sector sector : DummyDao.SECTORS) {
			if (equal(sector.getParentId(), realCriteria.get("parentId"))) {
				result.add(sector);
			}
		}
		return result;
	}

	private static boolean equal(String id1, String id2) {
		if (id1 == null && id2 == null) {
			return true;
		} else if (id1 == null || id2 == null) {
			return false;
		} else {
			return id1.equals(id2);
		}
	}

}
