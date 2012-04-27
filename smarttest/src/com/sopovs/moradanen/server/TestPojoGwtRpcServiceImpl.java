package com.sopovs.moradanen.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sopovs.moradanen.client.TestPojoGwtRpcService;
import com.sopovs.moradanen.shared.TestPojo;

public class TestPojoGwtRpcServiceImpl extends RemoteServiceServlet implements TestPojoGwtRpcService {
	private static final long serialVersionUID = 1L;
	private static final String[] FIRST_NAMES = new String[] { "Ivan", "Peter", "Sidor", "Vasil", "Urij", "Alex" };
	private static final String[] SECOND_NAMES = new String[] { "Ivanov", "Petrov", "Sidorov", "Vasiljev", "Urijev",
			"Alexandrov", "Shulc" };
	private static final String[] DESCRIPTIONS = new String[] { "Student", "Professor", "Worker", "Driver", "Gardener" };
	private List<TestPojo> pojos = new ArrayList<TestPojo>();

	public TestPojoGwtRpcServiceImpl() {
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			pojos.add(new TestPojo(String.valueOf(i + 1),
					FIRST_NAMES[r.nextInt(FIRST_NAMES.length)],
					SECOND_NAMES[r.nextInt(SECOND_NAMES.length)],
					DESCRIPTIONS[r.nextInt(DESCRIPTIONS.length)])
					);
		}
	}

	@Override
	public List<TestPojo> fetch(Integer startRow, Integer endRow, String sortBy, Map<String, String> filterCriteria) {
		return new ArrayList<TestPojo>(pojos.subList(startRow, endRow));
	}

	@Override
	public TestPojo add(TestPojo data) {
		data.setId(String.valueOf(pojos.size()));
		pojos.add(data);
		return data;
	}

	@Override
	public TestPojo update(TestPojo data) {
		pojos.set(Integer.valueOf(data.getId()), data);
		return data;
	}

	@Override
	public void remove(TestPojo data) {
		pojos.remove(Integer.valueOf(data.getId()));
	}

}
