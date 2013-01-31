package edu.lcu.masterfollies.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.ListCount;

/**
 * The server side implementation of the RPC service.
 */
@Configurable
@SuppressWarnings("serial")
@Service
public class GreetingServiceTestAsync extends RemoteServiceServlet implements GreetingServiceAsync {
	private static Log log = LogFactory.getLog(GreetingServiceTestAsync.class);

	Map parameters;

	private Judges authenticateResult;
	
	public Judges getAuthenticateResult() {
		return authenticateResult;
	}
	public void setAuthenticateResult(Judges authenticateResult) {
		this.authenticateResult = authenticateResult;
	}
	public Map getParameters() {
		return parameters;
	}
	@Override
	public void greetServer(String name, AsyncCallback<String> callback) {
		// TODO Auto-generated method stub
		// This will probably go away as code matures.
	}

	/**
	 * Simulate a call to authenticate.  Call setAuthenticateResult(judge) in your test harness before a 
	 * call to this to set the expected return value.  Your test harness can check the correctness of the 
	 * values passed in because they are stored in a hashmap retrievable with getParameters().
	 */
	@Override
	public void authenticate(String user, String password,
			AsyncCallback<Judges> callback) {
		log.debug("GreetingServiceTestAsync authenticate()");
		parameters = new HashMap();
		parameters.put("user", user);
		parameters.put("password", password);

		parameters.put("_result", authenticateResult);
		callback.onSuccess(authenticateResult);
		
	}
	@Override
	public void getClubList(AsyncCallback<ListCount<ClubNames>> callback) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void batchInsert(Integer judgeId, Integer clubNameId,
			AsyncCallback<Void> callback) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void upadateLineScore(Integer judgeId, Integer clubNameId,
			Integer questionId, Integer points, AsyncCallback<Void> callback) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateRankScore(Integer judgeId, Integer clubNameId,
			Integer rank, AsyncCallback<Void> callback) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateNotes(Integer questionId, String notes,
			AsyncCallback<Void> callback) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void selectResultsByJudge(Integer judgeId, Integer clubId,
			AsyncCallback<List<Map<String, String>>> callback) {
		// TODO Auto-generated method stub
		
	}



	
}