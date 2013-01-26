package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ReportsListPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public ReportsListPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<ReportsListPlace>
	{

		@Override
		public String getToken(ReportsListPlace place)
		{
			return "reportslist";
		}

		@Override
		public ReportsListPlace getPlace(String token)
		{
			return new ReportsListPlace(token);
		}

	}
}
