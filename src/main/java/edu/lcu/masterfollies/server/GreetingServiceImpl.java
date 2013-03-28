package edu.lcu.masterfollies.server;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.ClubNames;
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
	
	static Properties properties = new Properties();
	static {
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("edu/lcu/masterfollies/client/AppConstants.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public String getContext(Date date) {
		Log.debug("in server; properties = " + properties);
		String context  = properties.get("version") + "~" + ((this.getThreadLocalRequest()==null)?"null":this.getThreadLocalRequest().getRequestURL());
		Log.debug("contxt returning = " + context);
		return context;// this.getThreadLocalRequest().getQueryString();
	}
	
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
			Log.debug("(>^^)> from GreetingServiceImpl returning null <(^^<)");
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
	public List<ClubNames> changeClubOrder(String clubName, Boolean up) {
		
		List<ClubNames> x = clubNamesMapper.selectClubNamesByCurrentClubOrder();
		int counter = 0;
		for (ClubNames i: x){
			
			if (clubName.equals(i.getClubName())) {
				int place = i.getClubOrder();
				break;
			}
			counter ++;
			
		}
		if (!up || counter > x.size()) {
			//use this if the boolean is false and user is moving someone down
			ClubNames c1 = x.get(counter);
			ClubNames c2 = x.get(counter + 1);

			int orderOfC1 = c1.getClubOrder();
			
			c1.setClubOrder(c2.getClubOrder());
			c2.setClubOrder(orderOfC1);
			
			//use myBatis to update by primary key
			clubNamesMapper.updateByPrimaryKeySelective(c1);
			clubNamesMapper.updateByPrimaryKeySelective(c2);
			
			List<ClubNames> y = clubNamesMapper.selectClubNamesByCurrentClubOrder();
			return y;
		}
			
		
		ClubNames c1 = x.get(counter);
		ClubNames c2 = x.get(counter - 1);

		int orderOfC1 = c1.getClubOrder();
		
		c1.setClubOrder(c2.getClubOrder());
		c2.setClubOrder(orderOfC1);
		
		//use myBatis to update by primary key
		clubNamesMapper.updateByPrimaryKeySelective(c1);
		clubNamesMapper.updateByPrimaryKeySelective(c2);
		
		List<ClubNames> y = clubNamesMapper.selectClubNamesByCurrentClubOrder();
		return y;
		
	}
	@Override
	public List<ClubNames> getClubOrderList(){
		try {
			Log.debug("from GreetingServiceImpl getClubOrderList");
			List<ClubNames> x = selectClubNamesByCurrentClubOrder();
			return x;
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		Log.debug("GreetingServiceImpl should not see this");
		return null;
	}
	@Override

	public List<Map<String,Object>> getClubListBoys(Integer judgeId, Date timestamp){
		try {
			Log.debug("from GreetingServiceImpl GET CLUB LIST BOYS");
			List<Map<String, Object>> ret =  selectClubListandRankByJudgeID(judgeId, false, null);
			if(ret.size() == 0){
				
				for(ClubNames club:getClubOrderList()){
					Rank r = new Rank();
					r.setClubId(club.getId());
					r.setJudgeId(judgeId);
					r.setRank(0);
					rankMapper.insert(r);
				}
				ret =  selectClubListandRankByJudgeID(judgeId, false, null);
			}
			return ret;
		} catch (Exception e) {
			//  Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<Map<String,Object>> getClubListGirls(Integer judgeId, Date timestamp){
		try {
			Log.debug("from GreetingServiceImpl GET CLUB LIST GIRLS");
			List<Map<String, Object>> ret =  selectClubListandRankByJudgeID(judgeId, true, null);
			if(ret.size() == 0){
				
				for(ClubNames club:getClubOrderList()){
					Rank r = new Rank();
					r.setClubId(club.getId());
					r.setJudgeId(judgeId);
					r.setRank(0);
					rankMapper.insert(r);
				}
				ret =  selectClubListandRankByJudgeID(judgeId, false, null);
			}
		} catch (Exception e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Void batchInsert(Integer judgeId, Integer clubNameId, Date timestamp) {
		// Auto-generated method stub
		return null;
	}
	@Override
	public Void upadateLineScore(Integer judgeId, Integer clubNameId,
			Integer questionId, Integer points, Date timestamp) {
		// Auto-generated method stub
		return null;
	}
	@Override
	public Void updateRankScore(Integer judgeId, Integer clubNameId,
			Integer rank, Date timestamp) {
		// Auto-generated method stub
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
		Log.debug("from GreetingServiceImpl X is: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("from GreetingServiceImpl Returning x");
		if(x == null || x.size() == 0){
			resultsMapper.insertbatchResultsInsert(judgeId,clubId);
			x = resultsMapper.selectResultsByJudge(judgeId,clubId);
		}
		return x;
	}

	
	@Override
	public List<Map<String,Object>> selectClubListandRankByJudgeID(Integer judgeId, Boolean girl, Date timestamp) {
		Log.debug("from GreetingServiceImpl #4");
		List<Map<String, Object>> x = clubNamesMapper.selectClubListandRankByJudgeID(judgeId, girl);
		Log.debug("Clubs and ranks are: " + x);
		for(Map<String,Object> map:x){
			//Log.debug("map = " + map);
		}
		Log.debug("from GreetingServiceImpl Returning x");
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
	@Override
	public List<ClubNames> selectClubNamesByCurrentClubOrder(){
		List<ClubNames> cn = clubNamesMapper.selectClubNamesByCurrentClubOrder();
		for(ClubNames map:cn){
			
		}
		return cn;
	}


	
}
