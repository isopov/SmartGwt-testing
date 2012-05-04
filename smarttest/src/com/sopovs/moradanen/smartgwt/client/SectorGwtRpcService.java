package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.smartgwt.shared.SectorDTO;
import com.sopovs.moradanen.smartgwt.shared.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("sectorData")
public interface SectorGwtRpcService extends GenericGwtRpcService<SectorDTO> {

}
