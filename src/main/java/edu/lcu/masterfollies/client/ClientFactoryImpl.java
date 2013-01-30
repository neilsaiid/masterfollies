package edu.lcu.masterfollies.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;

import edu.lcu.masterfollies.client.mvp.AppPlaceHistoryMapper;
import edu.lcu.masterfollies.client.ui.ClubListView;
import edu.lcu.masterfollies.client.ui.LoginView;
import edu.lcu.masterfollies.client.ui.ResultsView;

public class ClientFactoryImpl implements ClientFactory
{
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	
	private final AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
	private final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	
	private final LoginView loginView = GWT.create(LoginView.class);
	private final ClubListView clubListView = GWT.create(ClubListView.class);
	private final ResultsView resultsView = GWT.create(ResultsView.class);
	
	public ResultsView getResultsView() {
		return resultsView;
	}




	private GreetingServiceAsync rpcService = GWT.create(GreetingService.class);
	
	public ClientFactoryImpl() {
		System.err.println("NOT MOBILE");
	}




	@Override
	public GreetingServiceAsync getRpcService() {
		return rpcService;
	}

	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}


	@Override
	public LoginView getLoginView() {
		return loginView;
	}


	public PlaceHistoryHandler getHistoryHandler() {
		// TODO Auto-generated method stub
		return historyHandler;
	}




	@Override
	public ClubListView getClubListView() {		
		return clubListView;
	}


}
