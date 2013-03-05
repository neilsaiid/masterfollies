package edu.lcu.masterfollies.client.activity;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.place.SuperPlace;
import edu.lcu.masterfollies.client.ui.SuperView;
import edu.lcu.masterfollies.shared.Log;

public class SuperActivity extends BasePresenter implements
	SuperView.Presenter{

	private ClientFactory clientFactory;
	private SuperView superView;
	
	public SuperActivity(SuperPlace place, ClientFactory clientFactory) {
		Log.debug("SuperActivity Method in SuperActivity");
		this.clientFactory = clientFactory;
	}
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Log.debug("StartMethod in SuperActivity");
		panel.setWidget(superView.asWidget());
	}
	
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
		
	}

	
}