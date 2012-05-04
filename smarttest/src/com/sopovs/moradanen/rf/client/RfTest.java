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
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.TreeViewModel;
import com.google.web.bindery.requestfactory.shared.Receiver;
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

	private final TestRequestFactory requestFactory = GWT.create(TestRequestFactory.class);

	@UiField(provided = true)
	CellTree leftPanel;

	@UiField
	Label rightTopPanel;

	@UiField
	Label rightBottomPanel;

	public RfTest() {
		requestFactory.initialize(new SimpleEventBus());
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		leftPanel = new CellTree(new SectorTreeViewModel(), null);
		RootLayoutPanel.get().add(GWT.<Binder> create(Binder.class).createAndBindUi(this));
		rightTopPanel.setText(LOREM_IPSUM);
		rightBottomPanel.setText(LOREM_IPSUM);

	}

//	private static class CustomTreeModel implements TreeViewModel {
//
//		/**
//		 * Get the {@link NodeInfo} that provides the children of the specified value.
//		 */
//		@Override
//		public <T> NodeInfo<?> getNodeInfo(T value) {
//			/*
//			 * Create some data in a data provider. Use the parent value as a prefix
//			 * for the next level.
//			 */
//			ListDataProvider<String> dataProvider = new ListDataProvider<String>();
//			for (int i = 0; i < 2; i++) {
//				dataProvider.getList().add(value + "." + String.valueOf(i));
//			}
//
//			// Return a node info that pairs the data with a cell.
//			return new DefaultNodeInfo<String>(dataProvider, new TextCell());
//		}
//
//		/**
//		 * Check if the specified value represents a leaf node. Leaf nodes cannot be opened.
//		 */
//		@Override
//		public boolean isLeaf(Object value) {
//			// The maximum length of a value is ten characters.
//			return value.toString().length() > 10;
//		}
//	}

	/**
	 * The {@link TreeViewModel} used to browse expense reports.
	 */
	private class SectorTreeViewModel implements TreeViewModel {

		/**
		 * The department cell singleton.
		 */
		private final Cell<SectorProxy> sectorCell = new AbstractCell<SectorProxy>() {

			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context, SectorProxy value, SafeHtmlBuilder sb) {
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

			return new DefaultNodeInfo<SectorProxy>(new SectorListDataProvider(sectorId), sectorCell);

		}

		@Override
		public boolean isLeaf(Object value) {
			return value != null && ((SectorProxy) value).isLeaf();
		}
	}

	/**
	 * The {@link ListDataProvider} used for Employee lists.
	 */
	private class SectorListDataProvider extends AsyncDataProvider<SectorProxy> {

		private final String parentId;

		public SectorListDataProvider(String parentId) {
			super(null);
			this.parentId = parentId;
		}

		@Override
		public void addDataDisplay(HasData<SectorProxy> display) {
			super.addDataDisplay(display);

			// Request the count anytime a view is added.
			requestFactory.sectorRequest().findSectorsByParent(parentId).fire(
					new Receiver<List<SectorProxy>>() {
						@Override
						public void onSuccess(List<SectorProxy> response) {
							updateRowCount(response.size(), true);
						}
					});
		}

		@Override
		protected void onRangeChanged(HasData<SectorProxy> view) {
			requestFactory.sectorRequest().findSectorsByParent(parentId).fire(
					new Receiver<List<SectorProxy>>() {
						@Override
						public void onSuccess(List<SectorProxy> response) {
							updateRowData(0, response);
						}
					});
		}
	}

}
