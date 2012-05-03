package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartTest implements EntryPoint {

//	private static final String LOREM_IPSUM =
//			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sapien mauris," +
//					" rhoncus quis lobortis vitae, pretium quis nulla. Nunc elementum laoreet nibh ut" +
//					" auctor. Pellentesque porttitor placerat erat tincidunt sollicitudin. Etiam" +
//					" consectetur lacinia tempor. Sed sollicitudin odio eu odio lobortis ut pulvinar" +
//					" neque scelerisque. Pellentesque nec dolor in velit pellentesque iaculis eu et" +
//					" ligula. Nullam sit amet urna a quam posuere ullamcorper ut tempus mauris. Nunc" +
//					" velit purus, feugiat ut fermentum lobortis, aliquet ac velit. Etiam eget mollis" +
//					" sapien.";

	private TreeGrid sectorGrid;
	private ListGrid companyGrid;
	private ListGrid workerGrid;

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		HLayout rootLayout = new HLayout();
		rootLayout.setWidth100();
		rootLayout.setHeight100();

		rootLayout.addMember(createLeftPanel());

		VLayout rightLayout = new VLayout();
		rightLayout.addMember(createRightUpperPanel());
		rightLayout.addMember(createRightLowerpanel());

		rootLayout.addMember(rightLayout);

		rootLayout.draw();
	}

	private Canvas createLeftPanel() {
		sectorGrid = new TreeGrid();
		sectorGrid.setDataSource(new SectorDataSource());
		sectorGrid.setAutoFetchData(true);
		sectorGrid.setShowResizeBar(true);
		sectorGrid.addSelectionChangedHandler(new SelectionChangedHandler() {
			@Override
			public void onSelectionChanged(SelectionEvent event) {
				//TODO after there is already some selection and it is changed three events are received by this handler
				//the first has selectedRecord == null.
				//It is not clear why - but from the two invocations of companyGrid.getchData only one result in server query
				//possibly it is because Criteria is the same and SmartGwt caches results for the same queries
				if (event.getSelectedRecord() != null) {
					companyGrid.fetchData(new Criteria(CompanyDataSource.SECTOR_ID, event.getSelectedRecord()
							.getAttribute(SectorDataSource.ID)));
					workerGrid.setData(new ListGridRecord[0]);
//					workerGrid.clearCriteria();
				}
			}
		});
		return sectorGrid;
	}

	private Canvas createRightUpperPanel() {
		companyGrid = new ListGrid();
		companyGrid.setDataSource(new CompanyDataSource());
		companyGrid.setAutoFetchData(false);
		companyGrid.setShowResizeBar(true);

		companyGrid.addSelectionChangedHandler(new SelectionChangedHandler() {

			@Override
			public void onSelectionChanged(SelectionEvent event) {
				if (event.getSelectedRecord() != null) {

					workerGrid.fetchData(new Criteria(PersonDataSource.COMPANY_ID, event.getSelectedRecord()
							.getAttribute(
									CompanyDataSource.ID)));
				} else {
					int a = 0;
					a += a;
				}
			}
		});

		return companyGrid;
	}

	private Canvas createRightLowerpanel() {
		workerGrid = new ListGrid();
		workerGrid.setDataSource(new PersonDataSource());
		workerGrid.setAutoFetchData(false);
//		grid.setShowResizeBar(true);
		return workerGrid;
	}

}
