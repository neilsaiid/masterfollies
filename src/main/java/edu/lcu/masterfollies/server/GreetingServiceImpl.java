package edu.lcu.masterfollies.server;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;



import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.ClubNamesMapper;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.JudgesExample;
import edu.lcu.masterfollies.domain.JudgesMapper;
import edu.lcu.masterfollies.domain.Rank;
import edu.lcu.masterfollies.domain.RankMapper;
import edu.lcu.masterfollies.domain.Results;
import edu.lcu.masterfollies.domain.ResultsMapper;
import edu.lcu.masterfollies.shared.Log;

/**
 * The server side implementation of the RPC service.
 */
@Configurable
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {
	
	private JudgesMapper judgesMapper;
	private ClubNamesMapper clubNamesMapper;
	private ResultsMapper resultsMapper;
	private RankMapper rankMapper;


	@Autowired
	public void setPersonMapper(JudgesMapper judgesMapper) {
		new Exception("SET person MAPPER").printStackTrace();
		this.judgesMapper = judgesMapper;
	}
	@Autowired
	public void setClubNamesMapper(ClubNamesMapper clubNamesMapper) {
		this.clubNamesMapper = clubNamesMapper;
	}

	@Autowired
	public void setResultsMapper(ResultsMapper resultsMapper) {
		this.resultsMapper = resultsMapper;
	}

	@Autowired
	public void setRankMapper(RankMapper rankMapper) {
		this.rankMapper = rankMapper;
	}

	BeanFactory bf = null;
	
	/**
	 * Simple client side verification that the fields have been populated.
	 */
	public String greetServer(String input) throws IllegalArgumentException {
//	    // Verify that the input is valid.
//	    if (!FieldVerifier.isValidName(input)) {
//	      // If the input is not valid, throw an IllegalArgumentException back to
//	      // the client.
//	      throw new IllegalArgumentException(
//	          "Username and Password must be filled in");
//	    }
		return "Thank you. Please wait while we verifiy your information";
	}
	
	/**
	 *  Accepts user name and password and returns null if they do not authenticate against 
	 *  judges table
	 * @param user      - username given to user by super judge 
	 * @param password  - given to user by super judge
	 * @return
	 */
	@Override
	public Judges authenticate(String user, String password, Date timestamp) {
		Log.debug("Authenticate " + user);
		if ((user == null) || (password == null))
			return null;
		
		/**
		 * create the Judges table object
		 */
		
		JudgesExample je = new JudgesExample();
		je.createCriteria().andPasswordEqualTo(password).andUserNameEqualTo(user);
		//Judges j = (Judges) judgesMapper.selectByExample(je);
		
		List<Judges> result = (List<Judges>) judgesMapper.selectByExample(je);
		
			
		if ((result==null) || (result.size()==0)){
			Log.debug("(>^^)> returning null <(^^<)");
			return null;
		}
		for(Judges j:result){
			Log.debug(j.getLastName());
		}
		Judges j = result.get(0);
		Log.debug("username = " + j.getUserName());
		Log.debug("Password = " + j.getPassword());
		return j;
	}
	@Override

	public List<Map<String,Object>> getClubListBoys(Integer judgeId, Date timestamp){
		return selectClubListandRankByJudgeID(judgeId, false, null);
	}

	@Override
	public List<Map<String,Object>> getClubListGirls(Integer judgeId, Date timestamp){
		return selectClubListandRankByJudgeID(judgeId, true, null);

	}
	@Override
	public Void batchInsert(Integer judgeId, Integer clubNameId, Date timestamp) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void upadateLineScore(Integer judgeId, Integer clubNameId,
			Integer questionId, Integer points, Date timestamp) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void updateRankScore(Integer judgeId, Integer clubNameId,
			Integer rank, Date timestamp) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void updateNotes(Integer resultsId, String notes, Date timestamp) {
		Results rt = new Results();
		rt.setNotes(notes);
		rt.setId(resultsId);
		resultsMapper.updateByPrimaryKeySelective(rt);
		return null;
	}

	@Override
	public List<Map<String,Object>> selectResultsByJudge(Integer judgeId, Integer clubId, Date timestamp) {
		
		List<Map<String, Object>> x = resultsMapper.selectResultsByJudge(judgeId,clubId);
		Log.debug("X is: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("Returning x");
		return x;
	}

	
	@Override
	public List<Map<String,Object>> selectClubListandRankByJudgeID(Integer judgeId, Boolean girl, Date timestamp) {
		
		List<Map<String, Object>> x = clubNamesMapper.selectClubListandRankByJudgeID(judgeId, girl);
		Log.debug("Clubs and ranks are: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("Returning x");
		return x;
	}

	@Override
	public Void updateResultsPoints(Integer resultsId, Integer value, Date timestamp) {
		Results rt = new Results();
		rt.setId(resultsId);
		rt.setPoints(value);
		
		resultsMapper.updateByPrimaryKeySelective(rt);
		return null;
	}

	@Override
	public Void updateRankPoints(Integer rankId, Integer rank, Date timestamp){
		Rank rt = new Rank();
		rt.setId(rankId);
		rt.setRank(rank);
		
		rankMapper.updateByPrimaryKeySelective(rt);
		return null;
	}


	
}
