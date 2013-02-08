package edu.lcu.masterfollies.client;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.lcu.masterfollies.domain.Judges;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  Judges authenticate(String user, String password, Date timestamp);



  Void batchInsert(Integer judgeId, Integer clubNameId, Date timestamp);
  Void upadateLineScore(Integer judgeId, Integer clubNameId, Integer questionId, Integer points, Date timestamp);
  Void updateRankScore(Integer judgeId, Integer clubNameId, Integer rank, Date timestamp);
  Void updateNotes(Integer questionId, String notes, Date timestamp);
  List<Map<String, Object>> selectResultsByJudge(Integer judgeId, Integer clubId, Date timestamp);

  Void updateResultsPoints(Integer resultsId, Integer value, Date timestamp);


  List<Map<String, Object>> selectClubListandRankByJudgeID(Integer judgeId, Boolean girl, Date timestamp);
List<Map<String, Object>> getClubListBoys(Integer judgeId, Date timestamp);
List<Map<String, Object>> getClubListGirls(Integer judgeId, Date timestamp);
Void updateRankPoints(Integer rankId, Integer rank, Date timestamp);
String getContext(Date date);

  
}
