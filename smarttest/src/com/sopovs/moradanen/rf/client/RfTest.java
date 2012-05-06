package com.sopovs.moradanen.rf.client;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sopovs.moradanen.rf.shared.CompanyProxy;
import com.sopovs.moradanen.rf.shared.PersonProxy;
import com.sopovs.moradanen.rf.shared.SectorProxy;
import com.sopovs.moradanen.rf.shared.TestRequestFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RfTest implements EntryPoint {

	private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Maecenas non nisl neque. In hac habitasse platea dictumst. In sodales venenatis neque, sit "
			+ "amet sagittis libero semper sed. Pellentesque at ligula at mi placerat porttitor sed tempus "
			+ "odio. Phasellus congue, ipsum ut semper eleifend, odio eros facilisis odio, a tempus eros erat "
			+ "a odio. Pellentesque ultricies nisl id eros blandit aliquet. Praesent porta enim et dui feugiat "
			+ "ut imperdiet libero egestas. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec "
			+ "neque tortor, lacinia vitae laoreet eget, lacinia at diam.\n"
			+ "Phasellus ut convallis nibh. Duis sit amet consectetur ipsum. Curabitur cursus elit sed "
			+ "justo facilisis cursus. Vivamus sem nisl, convallis non dictum blandit, commodo ullamcorper "
			+ "mi. Donec euismod pellentesque nulla, auctor ultrices lacus scelerisque eu. Ut vitae viverra "
			+ "elit. Mauris at justo eget nulla porta hendrerit in id lacus.\n"
			+ "Etiam mauris nisi, malesuada id elementum id, iaculis eget nulla. Vestibulum magna nulla, "
			+ "porttitor non rhoncus sit amet, ultrices et augue. Mauris mi mi, consectetur id accumsan et, "
			+ "hendrerit eu urna. Duis suscipit adipiscing nisl, in vehicula sem vehicula at. Donec sit amet "
			+ "purus et mi mollis placerat facilisis a nulla. Pellentesque habitant morbi tristique senectus "
			+ "et netus et malesuada fames ac turpis egestas. Ut eros arcu, tincidunt ac eleifend sit amet, "
			+ "dictum mollis risus. Ut eros dui, adipiscing ut faucibus et, lacinia lacinia velit. Ut "
			+ "commodo sem et velit scelerisque adipiscing. Mauris sagittis lectus a dui consequat hendrerit.\n"
			+ "In quis felis dolor. Pellentesque mattis, diam euismod faucibus convallis, elit nisl "
			+ "porta dui, a facilisis nulla odio non est. Morbi mattis convallis risus vel tempus. "
			+ "Nulla iaculis pharetra dolor ullamcorper dapibus. Lorem ipsum dolor sit amet, consectetur "
			+ "adipiscing elit. Sed a ultricies turpis. Proin laoreet velit volutpat sem dapibus in "
			+ "placerat est semper. Nunc non erat lectus. Phasellus tempor neque a dolor tempus varius. "
			+ "Pellentesque tristique lacus non dolor imperdiet tristique. Proin ac tellus eget nisl "
			+ "aliquet lobortis. Morbi et eros velit.\n"
			+ "Cras a nulla lectus, ac auctor nibh. Mauris eget arcu eu risus viverra malesuada eu nec "
			+ "neque. Mauris pulvinar egestas augue, a malesuada ipsum ullamcorper at. Nunc laoreet tristique "
			+ "dictum. Curabitur non sollicitudin felis. Phasellus dictum metus sit amet neque lobortis "
			+ "dapibus. Praesent eu ligula ac lacus adipiscing convallis. Praesent risus odio, sodales ac "
			+ "tempor in, tristique in augue. Mauris ante massa, eleifend non vehicula a, cursus vel mauris. "
			+ "Nunc dignissim quam auctor mauris malesuada tincidunt. Aliquam erat volutpat. Integer eu "
			+ "tellus sapien, nec sagittis leo.";

	interface Binder extends UiBinder<Widget, RfTest> {
	}

	private final TestRequestFactory requestFactory = GWT
			.create(TestRequestFactory.class);

	@UiField(provided = true)
	CellTree leftPanel;

	@UiField(provided = true)
	CellTable<CompanyProxy> rightTopPanel;

	@UiField(provided = true)
	CellTable<PersonProxy> rightBottomPanel;

	final SingleSelectionModel<SectorProxy> sectorSelectionModel = new SingleSelectionModel<SectorProxy>();
	final SingleSelectionModel<CompanyProxy> companySelectionModel = new SingleSelectionModel<CompanyProxy>();
	private CompanyDataProvider companyDataProvider;

	private PersonDataProvider personDataProvider;

	public RfTest() {
		requestFactory.initialize(new SimpleEventBus());
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		leftPanel = new CellTree(new SectorTreeViewModel(), null);
		sectorSelectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						companyDataProvider.updateRowCount(0, false);
						companyDataProvider.onRangeChanged(rightTopPanel);
						
						personDataProvider.updateRowCount(0, true);
					}
				});

		companySelectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(SelectionChangeEvent event) {
						personDataProvider.updateRowCount(0, false);
						personDataProvider.onRangeChanged(rightBottomPanel);
					}
				});

		rightTopPanel = createCompanyTable();
		companyDataProvider = new CompanyDataProvider();
		companyDataProvider.addDataDisplay(rightTopPanel);

		rightBottomPanel = createPersonTable();
		personDataProvider = new PersonDataProvider();
		personDataProvider.addDataDisplay(rightBottomPanel);
		RootLayoutPanel.get().add(
				GWT.<Binder> create(Binder.class).createAndBindUi(this));

	}

	private CellTable<CompanyProxy> createCompanyTable() {
		CellTable<CompanyProxy> result = new CellTable<CompanyProxy>();
		// Create name column.
		TextColumn<CompanyProxy> nameColumn = new TextColumn<CompanyProxy>() {
			@Override
			public String getValue(CompanyProxy contact) {
				return contact.getName();
			}
		};

		// Make the name column sortable.
		nameColumn.setSortable(true);

		// Create id column.
		TextColumn<CompanyProxy> idColumn = new TextColumn<CompanyProxy>() {
			@Override
			public String getValue(CompanyProxy contact) {
				return contact.getId();
			}
		};

		// Make the id column sortable.
		idColumn.setSortable(true);

		// Add the columns.
		result.addColumn(idColumn, "Id");
		result.addColumn(nameColumn, "Name");

		result.setSelectionModel(companySelectionModel);
		return result;
	}

	private static CellTable<PersonProxy> createPersonTable() {
		CellTable<PersonProxy> result = new CellTable<PersonProxy>();
		// Create id column.
		TextColumn<PersonProxy> idColumn = new TextColumn<PersonProxy>() {
			@Override
			public String getValue(PersonProxy contact) {
				return contact.getId();
			}
		};

		// Make the id column sortable.
		idColumn.setSortable(true);

		// Create name column.
		TextColumn<PersonProxy> firstNameColumn = new TextColumn<PersonProxy>() {
			@Override
			public String getValue(PersonProxy contact) {
				return contact.getFirstName();
			}
		};

		// Make the name column sortable.
		firstNameColumn.setSortable(true);

		TextColumn<PersonProxy> secondNameColumn = new TextColumn<PersonProxy>() {
			@Override
			public String getValue(PersonProxy contact) {
				return contact.getSecondName();
			}
		};

		// Make the name column sortable.
		secondNameColumn.setSortable(true);

		TextColumn<PersonProxy> descriptionColumn = new TextColumn<PersonProxy>() {
			@Override
			public String getValue(PersonProxy contact) {
				return contact.getDescription();
			}
		};

		// Make the name column sortable.
		descriptionColumn.setSortable(true);

		// Add the columns.
		result.addColumn(idColumn, "Id");
		result.addColumn(firstNameColumn, "First Name");
		result.addColumn(secondNameColumn, "Second Name");
		result.addColumn(descriptionColumn, "Description");

		return result;
	}

	/**
	 * The {@link TreeViewModel} used to browse expense reports.
	 */
	private class SectorTreeViewModel implements TreeViewModel {

		/**
		 * The department cell singleton.
		 */
		private final Cell<SectorProxy> sectorCell = new AbstractCell<SectorProxy>() {

			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context,
					SectorProxy value, SafeHtmlBuilder sb) {
				if (value == null) {
					return;
				}

				sb.appendHtmlConstant("<h7>");
				sb.appendEscaped(value.getName());
				sb.appendHtmlConstant("</td></tr></h7>");

			}
		};

		@Override
		public <T> NodeInfo<SectorProxy> getNodeInfo(T value) {
			String sectorId = null;
			if (value != null) {
				sectorId = ((SectorProxy) value).getId();
			}

			return new DefaultNodeInfo<SectorProxy>(new SectorDataProvider(
					sectorId), sectorCell, sectorSelectionModel, null);

		}

		@Override
		public boolean isLeaf(Object value) {
			return value != null && ((SectorProxy) value).isLeaf();
		}
	}

	private class SectorDataProvider extends AsyncDataProvider<SectorProxy> {

		private final String parentId;

		public SectorDataProvider(String parentId) {
			super(null);
			this.parentId = parentId;
		}

		@Override
		public void addDataDisplay(HasData<SectorProxy> display) {
			super.addDataDisplay(display);

			// Request the count anytime a view is added.
			requestFactory.sectorRequest().findSectorsByParent(parentId)
					.fire(new Receiver<List<SectorProxy>>() {
						@Override
						public void onSuccess(List<SectorProxy> response) {
							updateRowCount(response.size(), true);
						}
					});
		}

		@Override
		protected void onRangeChanged(HasData<SectorProxy> view) {
			requestFactory.sectorRequest().findSectorsByParent(parentId)
					.fire(new Receiver<List<SectorProxy>>() {
						@Override
						public void onSuccess(List<SectorProxy> response) {
							updateRowData(0, response);
						}
					});
		}
	}

	private class CompanyDataProvider extends AsyncDataProvider<CompanyProxy> {

		@Override
		public void addDataDisplay(HasData<CompanyProxy> display) {
			super.addDataDisplay(display);
			if (sectorSelectionModel.getSelectedObject() == null) {
				updateRowCount(0, true);
				return;
			}

			// Request the count anytime a view is added.
			requestFactory
					.companyRequest()
					.findCompaniesBySector(
							sectorSelectionModel.getSelectedObject().getId())
					.fire(new Receiver<List<CompanyProxy>>() {
						@Override
						public void onSuccess(List<CompanyProxy> response) {
							updateRowCount(response.size(), true);
						}
					});
		}

		@Override
		protected void onRangeChanged(HasData<CompanyProxy> view) {
			if (sectorSelectionModel.getSelectedObject() == null) {
				return;
			}
			requestFactory
					.companyRequest()
					.findCompaniesBySector(
							sectorSelectionModel.getSelectedObject().getId())
					.fire(new Receiver<List<CompanyProxy>>() {
						@Override
						public void onSuccess(List<CompanyProxy> response) {
							updateRowData(0, response);
						}
					});
		}
	}

	private class PersonDataProvider extends AsyncDataProvider<PersonProxy> {

		@Override
		public void addDataDisplay(HasData<PersonProxy> display) {
			super.addDataDisplay(display);
			if (companySelectionModel.getSelectedObject() == null) {
				updateRowCount(0, true);
				return;
			}

			// Request the count anytime a view is added.
			requestFactory
					.personRequest()
					.findPersonsByCompany(
							companySelectionModel.getSelectedObject().getId())
					.fire(new Receiver<List<PersonProxy>>() {
						@Override
						public void onSuccess(List<PersonProxy> response) {
							updateRowCount(response.size(), true);
						}
					});
		}

		@Override
		protected void onRangeChanged(HasData<PersonProxy> view) {
			if (sectorSelectionModel.getSelectedObject() == null) {
				return;
			}
			requestFactory
					.personRequest()
					.findPersonsByCompany(
							companySelectionModel.getSelectedObject().getId())
					.fire(new Receiver<List<PersonProxy>>() {
						@Override
						public void onSuccess(List<PersonProxy> response) {
							updateRowData(0, response);
						}
					});
		}
	}

}
