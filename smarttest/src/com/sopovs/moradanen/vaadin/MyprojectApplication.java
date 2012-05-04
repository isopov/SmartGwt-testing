package com.sopovs.moradanen.vaadin;

import java.util.Calendar;
import java.util.Date;

import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.TreeTable;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MyprojectApplication extends Application {
	private static final long serialVersionUID = 1L;

	private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Maecenas non nisl neque. In hac habitasse platea dictumst. In sodales venenatis neque, sit "
			+ "amet sagittis libero semper sed. Pellentesque at ligula at mi placerat porttitor sed tempus "
			+ "odio. Phasellus congue, ipsum ut semper eleifend, odio eros facilisis odio, a tempus eros erat "
			+ "a odio. Pellentesque ultricies nisl id eros blandit aliquet. Praesent porta enim et dui feugiat "
			+ "ut imperdiet libero egestas. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec "
			+ "neque tortor, lacinia vitae laoreet eget, lacinia at diam.\n";

	private static final String NAME_PROPERTY = "Name";
	private static final String HOURS_PROPERTY = "Hours done";
	private static final String MODIFIED_PROPERTY = "Last Modified";

	@Override
	public void init() {
		Window mainWindow = new Window("Vaadin tables sandbox");
		mainWindow.addComponent(createRootComponent());
		mainWindow.getContent().setSizeFull();
		setMainWindow(mainWindow);

	}

	private static Component createRootComponent() {
		VerticalLayout result = new VerticalLayout();
//		result.setHeight("100%");
		result.addComponent(createHeader());
		result.addComponent(createBodyPanel());
		return result;
	}

	private static Component createBodyPanel() {
		HorizontalSplitPanel result = new HorizontalSplitPanel();
//		result.setSplitPosition(50); // percent
		result.addComponent(createTreeTable());

//		VerticalSplitPanel rightPanel = new VerticalSplitPanel();
//		rightPanel.setSplitPosition(50);
//		rightPanel.addComponent(new Label(LOREM_IPSUM));
//		rightPanel.addComponent(new Label(LOREM_IPSUM));
//
//		result.addComponent(rightPanel);
		result.addComponent(new Label(LOREM_IPSUM));

		return result;
	}

	private static Component createHeader() {
		HorizontalLayout result = new HorizontalLayout();
		result.addComponent(new Link("RequestFactory", new ExternalResource(
				"/RfTest.html")));
		result.addComponent(new Link("SmartGwt", new ExternalResource(
				"/SmartTest.html")));
		result.addComponent(new Link("Vaadin", new ExternalResource("/VAADIN/")));
		return result;
	}

	private static TreeTable createTreeTable() {
		Calendar cal = Calendar.getInstance();
		cal.set(2011, 10, 30, 14, 40, 26);

		TreeTable treetable = new TreeTable();

		// Add Table columns
		treetable.addContainerProperty(NAME_PROPERTY, String.class, "");
		treetable.addContainerProperty(HOURS_PROPERTY, Integer.class, 0);
		treetable.addContainerProperty(MODIFIED_PROPERTY, Date.class,
				cal.getTime());

		// Populate table
		Object allProjects = treetable.addItem(new Object[] { "All Projects",
				18, cal.getTime() }, null);
		Object year2010 = treetable.addItem(
				new Object[] { "Year 2010", 18, cal.getTime() }, null);
		Object customerProject1 = treetable.addItem(new Object[] {
				"Customer Project 1", 13, cal.getTime() }, null);
		Object customerProject1Implementation = treetable.addItem(new Object[] {
				"Implementation", 5, cal.getTime() }, null);
		Object customerProject1Planning = treetable.addItem(new Object[] {
				"Planning", 2, cal.getTime() }, null);
		Object customerProject1Prototype = treetable.addItem(new Object[] {
				"Prototype", 5, cal.getTime() }, null);
		Object customerProject2 = treetable.addItem(new Object[] {
				"Customer Project 2", 5, cal.getTime() }, null);
		Object customerProject2Planning = treetable.addItem(new Object[] {
				"Planning", 5, cal.getTime() }, null);

		// Set hierarchy
		treetable.setParent(year2010, allProjects);
		treetable.setParent(customerProject1, year2010);
		treetable.setParent(customerProject1Implementation, customerProject1);
		treetable.setParent(customerProject1Planning, customerProject1);
		treetable.setParent(customerProject1Prototype, customerProject1);
		treetable.setParent(customerProject2, year2010);
		treetable.setParent(customerProject2Planning, customerProject2);

		// Disallow children from leaves
		treetable.setChildrenAllowed(customerProject1Implementation, false);
		treetable.setChildrenAllowed(customerProject1Planning, false);
		treetable.setChildrenAllowed(customerProject1Prototype, false);
		treetable.setChildrenAllowed(customerProject2Planning, false);

		// Expand all
		treetable.setCollapsed(allProjects, false);
		treetable.setCollapsed(year2010, false);
		treetable.setCollapsed(customerProject1, false);
		treetable.setCollapsed(customerProject2, false);

		return treetable;
	}
}