package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ResultsPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public ResultsPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<ResultsPlace>
	{

		@Override
		public String getToken(ResultsPlace place)
		{
			return "results";
		}

		@Override
		public ResultsPlace getPlace(String token)
		{
			return new ResultsPlace(token);
		}

	}
}
