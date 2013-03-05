package edu.lcu.masterfollies.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.activity.ClubListActivity;
import edu.lcu.masterfollies.client.activity.LoginActivity;
import edu.lcu.masterfollies.client.activity.ResultsActivity;
import edu.lcu.masterfollies.client.activity.SuperActivity;
import edu.lcu.masterfollies.client.place.ClubListPlace;
import edu.lcu.masterfollies.client.place.LoginPlace;
import edu.lcu.masterfollies.client.place.ResultsPlace;
import edu.lcu.masterfollies.client.place.SuperPlace;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {

	    if (place instanceof LoginPlace)
			return new LoginActivity(clientFactory);
	    else if (place instanceof ClubListPlace)
	    	return new ClubListActivity(null, clientFactory);
	    else if (place instanceof ResultsPlace)
	    	return new ResultsActivity(clientFactory);
	    else if (place instanceof SuperPlace)
	    	return new SuperActivity(null, clientFactory);

		return null;
	}

}
