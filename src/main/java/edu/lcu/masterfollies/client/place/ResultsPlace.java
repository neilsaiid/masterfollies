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
		String[] strings = token.split(":");
		judge = new Judges();
		Integer setId = Integer.parseInt(strings[0]);
		judge.setId(setId);
		judge.setFirstName(strings[3]);
		judge.setLastName(strings[4]);
		clubName = new ClubNames();
		clubName.setClubName(strings[2]);
		setId = Integer.parseInt(strings[1]);
		clubName.setId(setId);
		//this.results = new Results();
	}
	public ResultsPlace(String token,Judges judge, ClubNames clubName){
		this.judge = judge;
		this.clubName = clubName;
	}
	public ResultsPlace(String token,Judges judge, Integer clubId, String club_name){
		clubName = new ClubNames();
		clubName.setClubName(club_name);
		clubName.setId(clubId);
		this.judge = judge;
		this.clubName = clubName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<ResultsPlace>
	{
		@Override
		public String getToken(ResultsPlace place)
		{
			Judges judge = place.getJudge();
			ClubNames cn = place.getClubName();
			return  ((judge == null)?"":judge.getId() + ":" + cn.getId()+":"+ cn.getClubName()+":"+judge.getFirstName()+":"+judge.getLastName());
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
