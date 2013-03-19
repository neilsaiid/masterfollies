package edu.lcu.masterfollies.client.ui;


import java.util.Map;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.HasData;

import edu.lcu.masterfollies.client.activity.ClubListActivity;

/**
 * View interface. Extends IsWidget so a view impl can easily provide
 * its container widget.
 *
 * @author drfibonacci
 */
public interface ClubListView extends IsWidget
{
	public interface Presenter
	{
		void goTo(Place place);
		void goToResults(String nameOfClub, Integer clubId);
		void updateRank(Integer rankId, Integer rank);

	}
	public CellTable<Map<String, Object>> getTblClubList();
	public HasData<Map<String, Object>> getTblClubListGirls();
	public Button getRefreshButton();
	public Panel getPanel();
	
	public void setEventBus(HandlerManager eventBus);
	public void setPresenter(ClubListActivity clubListActivity);
	public void setLblTitle(String string);
	public void setLoadtime(String loadtime);
}