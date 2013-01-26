package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ClubListPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public ClubListPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<ClubListPlace>
	{

		@Override
		public String getToken(ClubListPlace place)
		{
			return "clublist";
		}

		@Override
		public ClubListPlace getPlace(String token)
		{
			return new ClubListPlace(token);
		}

	}
}
