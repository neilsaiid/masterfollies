package edu.lcu.masterfollies.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

import edu.lcu.masterfollies.client.ui.ClubListView;
import edu.lcu.masterfollies.client.ui.LoginView;
import edu.lcu.masterfollies.client.ui.ResultsView;
import edu.lcu.masterfollies.client.ui.SuperView;

public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();

	LoginView getLoginView();
	GreetingServiceAsync getRpcService();
	PlaceHistoryHandler getHistoryHandler();
	ClubListView getClubListView();
	ResultsView getResultsView();
	SuperView getSuperView();
}
