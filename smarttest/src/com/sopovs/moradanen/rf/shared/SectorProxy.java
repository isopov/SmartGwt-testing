package com.sopovs.moradanen.rf.shared;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.sopovs.moradanen.server.domain.Sector;

@ProxyFor(Sector.class)
public interface SectorProxy extends EntityProxy {

	String getId();

	String getParentId();

	String getName();

	boolean isRoot();

	boolean isLeaf();
}