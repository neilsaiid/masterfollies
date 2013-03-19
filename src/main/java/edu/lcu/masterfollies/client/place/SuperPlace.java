package edu.lcu.masterfollies.client.place;


import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.shared.Log;

public class SuperPlace extends Place
{
	private Judges judge;
	public SuperPlace(String token, Judges judge)
	{
		Log.debug("Judge is: " + judge + " inside of SuperPlace");
		this.judge = judge;
	}
	public SuperPlace(String token)
	{
		Log.debug("SuperPlace, how are we here?!");
		String[] tokens = token.split(":");
		judge = new Judges();
		judge.setFirstName(tokens[1]);
		judge.setLastName(tokens[2]);
		Integer intId= Integer.parseInt(tokens[0]);
		judge.setId(intId);
	}

	public static class Tokenizer implements PlaceTokenizer<SuperPlace>
	{

		@Override
		public String getToken(SuperPlace place)
		{
			Judges judge = place.getJudge();
			return  ((judge == null)?"":judge.getId()+":" + judge.getFirstName()
					+ ":" + judge.getLastName());
		}

		@Override
		public SuperPlace getPlace(String token)
		{
			return new SuperPlace(token);
		}

	}

	public Judges getJudge() {
		
		return judge;
	}
}
