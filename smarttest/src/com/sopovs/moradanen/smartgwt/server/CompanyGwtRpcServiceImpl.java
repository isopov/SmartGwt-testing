package com.sopovs.moradanen.smartgwt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.server.DummyDao;
import com.sopovs.moradanen.server.domain.Company;
import com.sopovs.moradanen.smartgwt.client.CompanyDataSource;
import com.sopovs.moradanen.smartgwt.client.CompanyGwtRpcService;
import com.sopovs.moradanen.smartgwt.shared.CompanyDTO;

public class CompanyGwtRpcServiceImpl extends RemoteServiceServlet implements CompanyGwtRpcService {
	private static final long serialVersionUID = 1L;

	@Override
	public List<CompanyDTO> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		String sectorId = filterCriteria.get(CompanyDataSource.SECTOR_ID);
		List<CompanyDTO> result = new ArrayList<CompanyDTO>();
		for (Company com : DummyDao.COMPANIES) {
			if (com.getFocusedSectors().contains(DummyDao.SECTORS.get(Integer.valueOf(sectorId)))) {
				result.add(toDTO(com));
			}
		}

		//TODO if the requested range is bigger than result - return whole result without sublisting and creating new ArrayList
		return new ArrayList<CompanyDTO>(result.subList(startRow, Math.min(result.size(), endRow)));
	}

	@Override
	public CompanyDTO add(CompanyDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public CompanyDTO update(CompanyDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	@Override
	public void remove(CompanyDTO data) {
		throw new IllegalStateException("Not implemented");
	}

	private static CompanyDTO toDTO(Company company) {
		return new CompanyDTO(company.getId(), company.getName());
	}

}
