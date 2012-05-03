package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.shared.Company;
import com.sopovs.moradanen.shared.smartgwt.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("companyData")
public interface CompanyGwtRpcService extends GenericGwtRpcService<Company> {

}
