package edu.lcu.masterfollies.client.activity;


import java.util.Date;

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
import edu.lcu.masterfollies.client.ui.LoginView;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.shared.Log;


public class LoginActivity extends BasePresenter implements LoginView.Presenter {
	//private static Log log = LogFactory.getLog(LoginActivity.class);
	private int attempt = 0;

	private ClientFactory clientFactory;
	private String name;
	private final GreetingServiceAsync rpcService;
	private final EventBus eventBus;
	private final LoginView display;

	public LoginActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;	
		this.display = clientFactory.getLoginView();
		this.eventBus = clientFactory.getEventBus();
		this.rpcService = clientFactory.getRpcService();
		bind();
	}
	
	public void bind() {
	    addHandler(this.display.getOKButton().addClickHandler(new ClickHandler() {   
	        public void onClick(ClickEvent event) {
	          authenticate();
	        }
	      }));
	    
		addHandler(this.display.getTxtUserName().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				int charCode = event.getNativeEvent().getCharCode();

				if (charCode == 0) {
				    // it's probably Firefox
				    charCode = event.getNativeEvent().getKeyCode();  
				}
				if (charCode == KeyCodes.KEY_ENTER) {
					authenticate();
				}
			}
		    }));
		
		addHandler(this.display.getTxtPassword().addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				int charCode = event.getNativeEvent().getCharCode();

				if (charCode == 0) {
				    // it's probably Firefox
				    charCode = event.getNativeEvent().getKeyCode();  
				}
				if (charCode == KeyCodes.KEY_ENTER) {
					authenticate();
				}
			}
		    }));
		
		addHandler(this.display.getBtnCancel().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				cancel();
			}
			
		}));
	}
	
	public void cancel() {
		this.display.asDialog().hide();
	}

	public void authenticate() {
		rpcService.authenticate(display.getTxtUserName().getText(), display
				.getTxtPassword().getText(), new Date(), new AsyncCallback<Judges>() {

					public void onFailure(Throwable arg0) {
						//  Auto-generated method stub
						
					}

					public void onSuccess(Judges arg0) {
						//  Auto-generated method stub
						if(arg0==null){
							Log.debug("don't Hide");
							if (arg0 == null) {
								display.getLblErrorMessage().setText(
									"Name or password is incorrect; attempt " + ++attempt);
							}return;
						}
						//  user has successfully logged on
						display.asDialog().hide();
						Log.debug("Judge is: "+arg0);
						ClubListPlace clubListPlace = new ClubListPlace("clublist",arg0);
						  
						 clientFactory.getPlaceController().goTo(clubListPlace);
						//goto new (ClubListPlace)
					}

			
			
					});
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
		DialogBox login = display.asDialog();
		login.center();
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
