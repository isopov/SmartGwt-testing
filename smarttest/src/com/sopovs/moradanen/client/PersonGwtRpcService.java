package com.sopovs.moradanen.client;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sopovs.moradanen.shared.Person;
import com.sopovs.moradanen.shared.lib.GenericGwtRpcService;

@RemoteServiceRelativePath("data")
public interface PersonGwtRpcService extends GenericGwtRpcService<Person> {

}
