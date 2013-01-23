package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	public LoginPlace(String token)
	{
		//Log.debug("TOKEN = '" + token + "'");
	}

	public static class Tokenizer implements PlaceTokenizer<LoginPlace>
	{

		//@Override
		public String getToken(LoginPlace place)
		{
			return "login";
		}

		//@Override
		public LoginPlace getPlace(String token)
		{
			return new LoginPlace(token);
		}

	}
}
