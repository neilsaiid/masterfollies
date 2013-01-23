package edu.lcu.masterfollies.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import edu.lcu.masterfollies.client.ClientFactory;
import edu.lcu.masterfollies.client.activity.LoginActivity;
import edu.lcu.masterfollies.client.place.LoginPlace;

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
	//@Override
	public Activity getActivity(Place place) {

		//Log.debug("Placd is a " + place.getClass().getName());
//		if (place instanceof AttendancePlace)
//			return new AttendanceActivity((AttendancePlace) place, clientFactory);
//		else if (place instanceof AttendanceCommentPlace)
//			return new AttendanceCommentActivity((AttendanceCommentPlace) place, clientFactory);
//		else if (place instanceof StudentPlace)
//			return new StudentActivity(clientFactory);
	    if (place instanceof LoginPlace)
			return new LoginActivity(clientFactory);

		return null;
	}

}
