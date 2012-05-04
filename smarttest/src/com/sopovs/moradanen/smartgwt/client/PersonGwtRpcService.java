package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.smartgwt.shared.PersonDTO;
import com.sopovs.moradanen.smartgwt.shared.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("personData")
public interface PersonGwtRpcService extends GenericGwtRpcService<PersonDTO> {

}
