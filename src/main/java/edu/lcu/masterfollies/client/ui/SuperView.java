package edu.lcu.masterfollies.client.ui;


import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.lcu.masterfollies.client.activity.SuperActivity;
import edu.lcu.masterfollies.domain.ClubNames;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author drfibonacci
 */
public interface SuperView extends IsWidget {
	public interface Presenter {
		void goTo(Place place);
	}
	public Widget asWidget();
	public TabLayoutPanel getTabLayoutPanel();
	
	public void setOrder();	
	public void setEventBus(HandlerManager eventBus);
	public void setPresenter(SuperActivity superActivity);

	public void displayOrder(List<ClubNames> results);
	ListBox getListBox_2();
	FlexTable getFlexTable();
	HasClickHandlers getUpArrow();
	HasClickHandlers getDownArrow();

}