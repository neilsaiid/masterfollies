package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SuperUserPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public SuperUserPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<SuperUserPlace>
	{

		@Override
		public String getToken(SuperUserPlace place)
		{
			return "superuser";
		}

		@Override
		public SuperUserPlace getPlace(String token)
		{
			return new SuperUserPlace(token);
		}

	}
}
