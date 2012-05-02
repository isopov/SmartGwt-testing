package com.sopovs.moradanen.shared.smartgwt.lib;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;

/**
 * The client side stub for the RPC service.
 */
public interface GenericGwtRpcService<D> extends RemoteService {
	
    List<D> fetch (Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria);

    D add (D data);

    D update (D data);

    void remove (D data);
	
}
