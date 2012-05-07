package com.sopovs.moradanen.rf.smartgwt.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sopovs.moradanen.rf.smartgwt.client.CompanyDataSource;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Company;

public class CompanyService {
	public static List<Company> fetchCompanies(Integer startRow, Integer endRow,
			@SuppressWarnings("unused") String sortBy,
			List<String> filterCriteria) {
		Map<String, String> realCriteria = new HashMap<String, String>();
		for (Iterator<String> it = filterCriteria.iterator(); it.hasNext();) {
			realCriteria.put(it.next(), it.next());
		}

		String sectorId = realCriteria.get(CompanyDataSource.SECTOR_ID);
		List<Company> result = new ArrayList<Company>();
		for (Company com : DummyDao.COMPANIES) {
			if (com.getFocusedSectors().contains(DummyDao.SECTORS.get(Integer.valueOf(sectorId)))) {
				result.add(com);
			}
		}

		//TODO if the requested range is bigger than result - return whole result without sublisting and creating new ArrayList
		return new ArrayList<Company>(result.subList(startRow, Math.min(result.size(), endRow)));
	}
}
