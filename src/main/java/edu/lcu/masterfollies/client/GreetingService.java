package edu.lcu.masterfollies.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.ListCount;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  Judges authenticate(String user, String password);
<<<<<<< HEAD

=======
  ListCount<ClubNames> getClubList();
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
  Void batchInsert(Integer judgeId, Integer clubNameId);
  Void upadateLineScore(Integer judgeId, Integer clubNameId, Integer questionId, Integer points);
  Void updateRankScore(Integer judgeId, Integer clubNameId, Integer rank);
  Void updateNotes(Integer questionId, String notes);
  List<Map<String, Object>> selectResultsByJudge(Integer judgeId, Integer clubId);

  Void updateResultsPoints(Integer resultsId, Integer value);
<<<<<<< HEAD


  List<Map<String, Object>> selectClubListandRankByJudgeID(Integer judgeId,
		Boolean girl);
List<Map<String, Object>> getClubListBoys(Integer judgeId);
List<Map<String, Object>> getClubListGirls(Integer judgeId);
Void updateRankPoints(Integer rankId, Integer rank);
=======
>>>>>>> 8878c4e4ca54b13003c87e3e558b1088325d36d1
  
}
