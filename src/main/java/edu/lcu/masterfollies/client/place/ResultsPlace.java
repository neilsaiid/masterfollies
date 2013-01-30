package edu.lcu.masterfollies.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.Results;
import edu.lcu.masterfollies.shared.Log;

public class ResultsPlace extends Place
{
	private Judges judge;
	private ClubNames clubName;
	private Results results;
	

	public ResultsPlace(String token)
	{

		//this.results = new Results();
	}
	public ResultsPlace(String token,Judges judge, ClubNames clubName){
		this.judge = judge;
		this.clubName = clubName;
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


	public Judges getJudge() {
		return judge;
	}
	public void setJudge(Judges judge) {
		this.judge = judge;
	}
	public ClubNames getClubName() {
		return clubName;
	}
	public void setClubName(ClubNames clubName) {
		this.clubName = clubName;
	}
	
}
