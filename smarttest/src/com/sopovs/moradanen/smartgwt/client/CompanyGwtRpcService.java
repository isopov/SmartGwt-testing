package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.smartgwt.shared.CompanyDTO;
import com.sopovs.moradanen.smartgwt.shared.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("companyData")
public interface CompanyGwtRpcService extends GenericGwtRpcService<CompanyDTO> {

}
