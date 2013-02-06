package edu.lcu.masterfollies.client;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import edu.lcu.masterfollies.client.mvp.AppActivityMapper;
import edu.lcu.masterfollies.client.mvp.AppPlaceHistoryMapper;
import edu.lcu.masterfollies.client.place.LoginPlace;
import edu.lcu.masterfollies.shared.Log;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class masterfollies implements EntryPoint {
	
	private Place defaultPlace = new LoginPlace("login");
	private SimplePanel appWidget = new SimplePanel();
	private ClientFactory clientFactory;
	/**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";
  public static final MasterfolliesResources images = GWT.create(
		  MasterfolliesResources.class);
  public static final AppConstants constants = GWT.create(AppConstants.class);
  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  //private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  
		Log.debug("OML");
		  clientFactory = GWT.create(ClientFactory.class);
		  EventBus eventBus = clientFactory.getEventBus();
			PlaceController placeController = clientFactory.getPlaceController();

			// Start ActivityManager for the main widget with our ActivityMapper
			ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
			ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
			activityManager.setDisplay(appWidget);

			// Start PlaceHistoryHandler with our PlaceHistoryMapper
			AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
			PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
			//Log.debug(message);
			Log.debug("clientFactory="+ clientFactory );
			Log.debug("HistoryHandler= " + clientFactory.getHistoryHandler());
			clientFactory.getHistoryHandler().register(placeController, eventBus, defaultPlace);

			RootPanel.get("content").add(appWidget);
			String userAgent = Navigator.getUserAgent();
			boolean mobileApple = userAgent.contains("iPad;") || userAgent.contains("iPhone;");
			
			if (!mobileApple) {
				MasterfolliesResources.INSTANCE.css().ensureInjected();
			}
			else {
				MasterfolliesResources.INSTANCE.cssIpad().ensureInjected();
			}
		  LoginPlace defaultPlace = new LoginPlace("login");
		  
		 // clientFactory.getPlaceController().goTo(defaultPlace);
		  clientFactory.getHistoryHandler().handleCurrentHistory();

    };


}
