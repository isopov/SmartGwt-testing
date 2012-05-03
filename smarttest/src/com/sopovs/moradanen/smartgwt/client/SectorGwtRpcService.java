package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.shared.Sector;
import com.sopovs.moradanen.shared.smartgwt.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("sectorData")
public interface SectorGwtRpcService extends GenericGwtRpcService<Sector> {

}
