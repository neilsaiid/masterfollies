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
		String[] tokens = token.split(":");
		judge = new Judges();
		judge.setFirstName(tokens[1]);
		judge.setLastName(tokens[2]);
		Integer intId= Integer.parseInt(tokens[0]);
		judge.setId(intId);
	}
	public static class Tokenizer implements PlaceTokenizer<ClubListPlace>
	{

		@Override
		public String getToken(ClubListPlace place)
		{
			Judges judge = place.getJudge();
			return  ((judge == null)?"":judge.getId()+":" + judge.getFirstName()
					+ ":" + judge.getLastName());
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