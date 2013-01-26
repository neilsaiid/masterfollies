package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class JudgesListPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public JudgesListPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<JudgesListPlace>
	{

		@Override
		public String getToken(JudgesListPlace place)
		{
			return "judgeslist";
		}

		@Override
		public JudgesListPlace getPlace(String token)
		{
			return new JudgesListPlace(token);
		}

	}
}
