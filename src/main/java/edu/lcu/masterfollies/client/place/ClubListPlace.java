package edu.lcu.masterfollies.client.place;




import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.shared.Log;

public class ClubListPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	private Judges judge;


	public ClubListPlace(String token, Judges judge)
	{
		Log.debug("Judge is: " + judge);
		this.judge = judge;
	}
	public ClubListPlace(String token)
	{
		Log.debug("clubListPalce, how are we here?!");
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

	/**
	 * use this method to get any information stored from the logon activity creation of 
	 * ClubListPlace
	 * @return
	 */
	public Judges getJudge() {
		return judge;
	}
}