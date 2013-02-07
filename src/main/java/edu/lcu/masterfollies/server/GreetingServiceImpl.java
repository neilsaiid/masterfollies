package edu.lcu.masterfollies.server;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
<<<<<<< HEAD
=======
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.ClubNamesExample;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
import edu.lcu.masterfollies.domain.ClubNamesMapper;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.JudgesExample;
import edu.lcu.masterfollies.domain.JudgesMapper;
<<<<<<< HEAD
import edu.lcu.masterfollies.domain.Rank;
import edu.lcu.masterfollies.domain.RankMapper;
=======
import edu.lcu.masterfollies.domain.ListCount;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
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
<<<<<<< HEAD
	private RankMapper rankMapper;
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1

	@Autowired
	public void setPersonMapper(JudgesMapper judgesMapper) {
		new Exception("SET person MAPPER").printStackTrace();
		this.judgesMapper = judgesMapper;
	}
	@Autowired
	public void setClubNamesMapper(ClubNamesMapper clubNamesMapper) {
		this.clubNamesMapper = clubNamesMapper;
	}
<<<<<<< HEAD
=======
	
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1

	@Autowired
	public void setResultsMapper(ResultsMapper resultsMapper) {
		this.resultsMapper = resultsMapper;
	}
<<<<<<< HEAD
	@Autowired
	public void setRankMapper(RankMapper rankMapper) {
		this.rankMapper = rankMapper;
	}
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
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
	public Judges authenticate(String user, String password) {
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
<<<<<<< HEAD
	public List<Map<String,Object>> getClubListBoys(Integer judgeId){
		return selectClubListandRankByJudgeID(judgeId, false);
	}

	@Override
	public List<Map<String,Object>> getClubListGirls(Integer judgeId){
		return selectClubListandRankByJudgeID(judgeId, true);
=======
	public ListCount<ClubNames> getClubList(){
		try {
			ClubNamesExample ce = new ClubNamesExample();
			ce.createCriteria().andClubNameIsNotNull();
			List<ClubNames> result = (List<ClubNames>) clubNamesMapper.selectByExample(ce);
			Integer count = clubNamesMapper.countByExample(ce);
			ListCount<ClubNames> lc = new ListCount<ClubNames>(result,count);
			return lc;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
	}
	@Override
	public Void batchInsert(Integer judgeId, Integer clubNameId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void upadateLineScore(Integer judgeId, Integer clubNameId,
			Integer questionId, Integer points) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void updateRankScore(Integer judgeId, Integer clubNameId,
			Integer rank) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Void updateNotes(Integer resultsId, String notes) {
		Results rt = new Results();
		rt.setNotes(notes);
		rt.setId(resultsId);
		resultsMapper.updateByPrimaryKeySelective(rt);
		return null;
	}

	@Override
	public List<Map<String,Object>> selectResultsByJudge(Integer judgeId, Integer clubId) {
		
		List<Map<String, Object>> x = resultsMapper.selectResultsByJudge(judgeId,clubId);
		Log.debug("X is: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("Returning x");
		return x;
	}
<<<<<<< HEAD
	
	@Override
	public List<Map<String,Object>> selectClubListandRankByJudgeID(Integer judgeId, Boolean girl) {
		
		List<Map<String, Object>> x = clubNamesMapper.selectClubListandRankByJudgeID(judgeId, girl);
		Log.debug("Clubs and ranks are: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("Returning x");
		return x;
	}
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
	@Override
	public Void updateResultsPoints(Integer resultsId, Integer value) {
		Results rt = new Results();
		rt.setId(resultsId);
		rt.setPoints(value);
		
		resultsMapper.updateByPrimaryKeySelective(rt);
		return null;
	}
<<<<<<< HEAD
	@Override
	public Void updateRankPoints(Integer rankId, Integer rank){
		Rank rt = new Rank();
		rt.setId(rankId);
		rt.setRank(rank);
		
		rankMapper.updateByPrimaryKeySelective(rt);
		return null;
	}
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
	
}
