package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import edu.lcu.masterfollies.domain.Judges;

public class ClubListPlace extends Place
{
	//private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	
	private Judges judge;


	public ClubListPlace(String token, Judges judge)
	{
		this.judge = judge;
	}
	public ClubListPlace(String token)
	{
		
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