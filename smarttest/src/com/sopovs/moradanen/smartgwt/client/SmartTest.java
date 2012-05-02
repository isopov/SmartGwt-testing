package com.sopovs.moradanen.smartgwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SmartTest implements EntryPoint {
	
	private static final String LOREM_IPSUM = 
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sapien mauris," +
			" rhoncus quis lobortis vitae, pretium quis nulla. Nunc elementum laoreet nibh ut" +
			" auctor. Pellentesque porttitor placerat erat tincidunt sollicitudin. Etiam" +
			" consectetur lacinia tempor. Sed sollicitudin odio eu odio lobortis ut pulvinar" +
			" neque scelerisque. Pellentesque nec dolor in velit pellentesque iaculis eu et" +
			" ligula. Nullam sit amet urna a quam posuere ullamcorper ut tempus mauris. Nunc" +
			" velit purus, feugiat ut fermentum lobortis, aliquet ac velit. Etiam eget mollis" +
			" sapien.";

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		HLayout rootLayout = new HLayout();
		rootLayout.setWidth100();
		rootLayout.setHeight100();
		
		DataSource dataSource = new PersonDataSource();
		ListGrid grid = new ListGrid();
		grid.setDataSource(dataSource);
		grid.setAutoFetchData(true);
		grid.setShowResizeBar(true);
		rootLayout.addMember(grid);

		VLayout rightLayout = new VLayout();
		Label label1 = new Label(LOREM_IPSUM);
		label1.setShowResizeBar(true);
		rightLayout.addMember(label1);
		
		Label label2 = new Label(LOREM_IPSUM);
		rightLayout.addMember(label2);
		
		rootLayout.addMember(rightLayout);
		
		
		rootLayout.draw();
	}
}
