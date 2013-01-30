package edu.lcu.masterfollies.client.ui;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;

import edu.lcu.masterfollies.client.activity.ClubListActivity;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author drfibonacci
 */
public interface ClubListView extends IsWidget
{
	public void setEventBus(HandlerManager eventBus);
	public CellTable<ClubNames> getTblClubList();

	public interface Presenter
	{
		void goTo(Place place);

		void goToResults(ClubNames clubNames);
	}

	public void setPresenter(ClubListActivity clubListActivity);
	public void setLblTitle(String string);
	public void setLoadtime(String loadtime);
	public Button getRefreshButton();
	public Panel getPanel();
}