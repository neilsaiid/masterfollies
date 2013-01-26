package edu.lcu.masterfollies.client.activity;


import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.GreetingServiceAsync;
import edu.lcu.masterfollies.client.place.ClubListPlace;
import edu.lcu.masterfollies.client.ui.ClubListView;
import edu.lcu.masterfollies.client.ui.LoginView;
import edu.lcu.masterfollies.domain.Judges;


public class ClubListActivity extends BasePresenter implements LoginView.Presenter {

	private int attempt = 0;

	private ClientFactory clientFactory;
	private String name;
	private final GreetingServiceAsync rpcService;
	private final EventBus eventBus;
	private final ClubListView display;

	public ClubListActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;	
		this.display = clientFactory.getClubListView();
		this.eventBus = clientFactory.getEventBus();
		this.rpcService = clientFactory.getRpcService();
	}
	
//	public void bind() {
//	    addHandler(this.display.getOKButton().addClickHandler(new ClickHandler() {   
//	        public void onClick(ClickEvent event) {
//	          authenticate();
//	        }
//	      }));
//	    
//		
//		addHandler(this.display.getBtnCancel().addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent event) {
//				cancel();
//			}
//			
//		}));
//	}
	
	public void cancel() {
		this.display.asDialog();
	}



	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		Log.debug("Starting Log Screen...");
		//Log.debug("LOGIN PRESENTER GO FROM");
		attempt = 0;
		//bind();
		DialogBox nextone = display.asDialog();
		nextone.center();
		//login.show();
		display.getTxtUserName().setFocus(true);
	}


	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}
}
