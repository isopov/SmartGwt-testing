package com.sopovs.moradanen.rf.smartgwt.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.Record;
import com.sopovs.moradanen.rf.smartgwt.shared.SmartRequestFactory;
import com.sopovs.moradanen.smartgwt.client.lib.GwtRpcDataSource;
import com.sopovs.moradanen.smartgwt.shared.lib.GenericGwtRpcList;

public abstract class GenericDataSource<R> extends GwtRpcDataSource {

	private final SmartRequestFactory rf;

	public GenericDataSource(SmartRequestFactory rf) {
		for (DataSourceField field : getDataSourceFields()) {
			addField(field);
		}
		this.rf = rf;
	}

	protected abstract List<DataSourceField> getDataSourceFields();

	protected abstract Request<List<R>> fetch(Integer startRow, Integer endRow, String sortBy,
			List<String> filterCriteria);

	protected abstract void copyValues(R from, Record to);

	private static String safeToString(Object obj) {
		return obj == null ? null : obj.toString();
	}

	@Override
	protected final void executeFetch(final String requestId, DSRequest request, final DSResponse response) {
		final Integer startRow = request.getStartRow();
		final Integer endRow = request.getEndRow();
		Criteria criteria = request.getCriteria();
		List<String> criterias = new ArrayList<String>();
		if (criteria != null) {
			for (Object entry : criteria.getValues().entrySet()) {
				@SuppressWarnings("unchecked")
				Entry<String, Object> rEntry = (Entry<String, Object>) entry;
				criterias.add(rEntry.getKey());
				criterias.add(safeToString(rEntry.getValue()));
			}
		}

		fetch(startRow,
				endRow,
				// we can't use request.getSortBy() here because it throws a ClassCastException (known bug).
				//TODO: replace with request.getSortBy() as soon as the bug is fixed.
				request.getAttribute("sortBy"),
				criterias).fire(new Receiver<List<R>>() {

			@Override
			public void onSuccess(List<R> result) {
				List<Record> records = new ArrayList<Record>();
				for (R data : result) {
					Record newRec = new Record();
					copyValues(data, newRec);
					records.add(newRec);
				}
				// if those are set, the client wants paging. you have to use GenericGwtRpcList
				if (startRow != null && endRow != null && result instanceof GenericGwtRpcList<?>) {
					Integer totalRows = ((GenericGwtRpcList<R>) result).getTotalRows();
					response.setStartRow(startRow);
					if (totalRows == null) {
						throw new NullPointerException("totalRows cannot be null when using GenericGwtRpcList");
					}
					// endRow can't be higher than totalRows
					response.setEndRow(endRow.intValue() < totalRows.intValue() ? endRow : totalRows);
					response.setTotalRows(totalRows);
				}
				response.setData(records.toArray(new Record[records.size()]));
				processResponse(requestId, response);
			}
		});
	}

	@Override
	protected final void executeAdd(String requestId, DSRequest request, DSResponse response) {
		throw new IllegalStateException();

	}

	@Override
	protected final void executeUpdate(String requestId, DSRequest request, DSResponse response) {
		throw new IllegalStateException();

	}

	@Override
	protected final void executeRemove(String requestId, DSRequest request, DSResponse response) {
		throw new IllegalStateException();
	}

	protected SmartRequestFactory getRf() {
		return rf;
	}
}
