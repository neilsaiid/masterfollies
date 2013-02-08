package edu.lcu.masterfollies.client;

import java.util.Date;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.Navigator;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
	public static final MasterfolliesResources images = GWT
			.create(MasterfolliesResources.class);
	public static final AppConstants constants = GWT.create(AppConstants.class);
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	// private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final String version = masterfollies.constants.version();

		Log.debug("OML");
		clientFactory = GWT.create(ClientFactory.class);

		AsyncCallback<String> callback = new AsyncCallback<String>() {
			@Override
			public void onFailure(Throwable caught) {
				Log.debug("FAIL Initialize " + caught.getMessage());
				Window.alert(caught.getMessage());
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(String result) {

				String results[] = result.split("~");
				Log.debug("results[0] = '" + results[0] + "'");
				
				Log.debug("version = '" + version + "'");

				final String strInfo = Cookies
						.getCookie(constants.cookieName());
				Log.debug("get cookie " + constants.cookieName() + " is '"
						+ strInfo + "'");

				if (!results[0].equals(version.toString())) {
					Log.debug("NOT EQUAL");
					String cookieInfo = "strInstructor" + ":" + "name" + ":"
							+ results[0];
					Log.debug("cookie is '" + cookieInfo + "'");
					Date date = new Date();
					date.setTime(date.getTime() + 1000 * 60 * 60 * 24 * 120); // expire in 4 months (120 days)
					Cookies.setCookie(masterfollies.constants.cookieName(),
							cookieInfo, date);
					Window.Location.reload();
					// Window.open("http://127.0.0.1:8888/attendance.html?gwt.codesvr=127.0.0.1:9997",
					// "_self", "");
				} else {

					PlaceController placeController = clientFactory
							.getPlaceController();
					EventBus eventBus = clientFactory.getEventBus();

					// Start ActivityManager for the main widget with our
					// ActivityMapper
					ActivityMapper activityMapper = new AppActivityMapper(
							clientFactory);
					ActivityManager activityManager = new ActivityManager(
							activityMapper, eventBus);
					activityManager.setDisplay(appWidget);

					// Start PlaceHistoryHandler with our PlaceHistoryMapper
					AppPlaceHistoryMapper historyMapper = GWT
							.create(AppPlaceHistoryMapper.class);
					PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
							historyMapper);
					// Log.debug(message);
					Log.debug("clientFactory=" + clientFactory);
					Log.debug("HistoryHandler= "
							+ clientFactory.getHistoryHandler());
					clientFactory.getHistoryHandler().register(placeController,
							eventBus, defaultPlace);

					RootPanel.get("content").add(appWidget);
					String userAgent = Navigator.getUserAgent();
					boolean mobileApple = userAgent.contains("iPad;")
							|| userAgent.contains("iPhone;");

					MasterfolliesResources.INSTANCE.css().ensureInjected();
					// if (!mobileApple) {
					// MasterfolliesResources.INSTANCE.css().ensureInjected();
					// }
					// else {
					// MasterfolliesResources.INSTANCE.cssIpad().ensureInjected();
					// }
					LoginPlace defaultPlace = new LoginPlace("login");

					// clientFactory.getPlaceController().goTo(defaultPlace);
					clientFactory.getHistoryHandler().handleCurrentHistory();
				}
			}
		};
		clientFactory.getRpcService().getContext(new Date(), callback);

	};

}
