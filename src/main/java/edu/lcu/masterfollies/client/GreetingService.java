package edu.lcu.masterfollies.client;

import java.util.List;
import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.ListCount;
import edu.lcu.masterfollies.domain.Results;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  Judges authenticate(String user, String password);
  ListCount<ClubNames> getClubList();
  Void batchInsert(Integer judgeId, Integer clubNameId);
  Void upadateLineScore(Integer judgeId, Integer clubNameId, Integer questionId, Integer points);
  Void updateRankScore(Integer judgeId, Integer clubNameId, Integer rank);
  Void updateNotes(Integer questionId, String notes);
  List<Map<String, String>> selectResultsByJudge(Integer judgeId, Integer clubId);
  
}
