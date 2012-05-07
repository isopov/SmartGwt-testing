package com.sopovs.moradanen.smartgwt.client.lib;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.grid.events.SelectionChangedHandler;
import com.smartgwt.client.widgets.grid.events.SelectionEvent;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;
import com.sopovs.moradanen.smartgwt.client.CompanyDataSource;
import com.sopovs.moradanen.smartgwt.client.PersonDataSource;
import com.sopovs.moradanen.smartgwt.client.SectorDataSource;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public abstract class AbstractSmartTest implements EntryPoint {

	private TreeGrid sectorGrid;
	private ListGrid companyGrid;
	private ListGrid workerGrid;

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		VLayout rootLayout = new VLayout();
		rootLayout.setWidth100();
		rootLayout.setHeight100();
		{
			HLayout headerLayout = new HLayout();
			headerLayout.setHeight("10em");
			headerLayout.setMembersMargin(10);
			headerLayout.addMember(new Anchor("PureGWT(RequestFactory)", "RfTest.html"));
			headerLayout.addMember(new Anchor("SmartGwt(RequestFactory)", "SmartRfTest.html"));
			headerLayout.addMember(new Anchor("SmartGwt(GWT-RPC)", "SmartTest.html"));
			headerLayout.addMember(new Anchor("Vaaadin", "VAADIN"));
			rootLayout.addMember(headerLayout);
		}
		{
			HLayout mainLayout = new HLayout();

			mainLayout.addMember(createLeftPanel());

			VLayout rightLayout = new VLayout();
			rightLayout.addMember(createRightUpperPanel());
			rightLayout.addMember(createRightLowerpanel());

			mainLayout.addMember(rightLayout);
			rootLayout.addMember(mainLayout);
		}

		rootLayout.draw();
	}

	protected abstract DataSource createSectorDataSource();

	protected abstract DataSource createCompanyDataSource();

	protected abstract DataSource createPersonDataSource();

	private Canvas createLeftPanel() {
		sectorGrid = new TreeGrid();
		sectorGrid.setDataSource(createSectorDataSource());
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
		companyGrid.setDataSource(createCompanyDataSource());
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
		workerGrid.setDataSource(createPersonDataSource());
		workerGrid.setAutoFetchData(false);
//		grid.setShowResizeBar(true);
		return workerGrid;
	}

}
