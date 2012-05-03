package com.sopovs.moradanen.rf.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

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

	@UiField
	//(provided = true)
	Label leftPanel;

	@UiField
	Label rightTopPanel;

	@UiField
	Label rightBottomPanel;

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		//TODO
//		leftPanel = new CellTree();
		RootLayoutPanel.get().add(
				GWT.<Binder> create(Binder.class).createAndBindUi(this));
		leftPanel.setText(LOREM_IPSUM);
		rightTopPanel.setText(LOREM_IPSUM);
		rightBottomPanel.setText(LOREM_IPSUM);

	}

}
