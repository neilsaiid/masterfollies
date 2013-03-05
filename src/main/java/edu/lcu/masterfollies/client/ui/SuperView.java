package edu.lcu.masterfollies.client.ui;


import java.util.List;
import java.util.Map;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author drfibonacci
 */
public interface SuperView extends IsWidget {
	
	public void displayOrder(List<Map<String, Object>> results);
	public void setOrder();
	
	public interface Presenter {
		void goTo(Place place);
	}
}