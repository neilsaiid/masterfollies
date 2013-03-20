package edu.lcu.masterfollies.service;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.ClubNames;
import edu.lcu.masterfollies.domain.ClubNamesMapper;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.JudgesMapper;
import edu.lcu.masterfollies.server.GreetingServiceImpl;

/**
 * The server side implementation of the RPC service.
 * @author Neil
 *
 */
@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml", 
"classpath:/META-INF/spring/applicationContext-datasource-test.xml"})
public class GreetingServiceImplTest implements BeanFactoryAware {

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

  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
    }
  /**
   * 
   */
  private static Log log = LogFactory.getLog(GreetingServiceImplTest.class);
	BeanFactory bf = null;
  /**
   * 
   */
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	// TODO Auto-generated method stub
	bf = beanFactory;
	}
  /**
   * 
   */
  @Test
  public void testUserAuthenticate(){
	  JudgesMapper jm = (JudgesMapper) bf.getBean(JudgesMapper.class);
	  Judges judge = new Judges();
	  Judges p= null;
		judge.setFirstName("neil");
		judge.setLastName("Saiid");
		judge.setUserName("nsaiid");
		judge.setPassword("test");
		log.debug("id= " + judge.getId());
		try{
		jm.insertSelective(judge);
		log.debug("id= " + judge.getId());
		p= jm.selectByPrimaryKey(judge.getId());
		log.debug(p.getFirstName() + ' ' + p.getLastName());
		//assertTrue(p.equals(judge));
		
		
		GreetingServiceImpl service= new GreetingServiceImpl();
		
		Judges myJudge = service.authenticate("nsaiid", "test", null);
		assertTrue(myJudge != null);
		Judges myJudgeBadPassword = service.authenticate("nsaiid", "notcorrect", null);
		assertTrue(myJudgeBadPassword == null);
		Judges myJudgeNullPassword = service.authenticate("nsaiid", null, null);
		assertTrue(myJudgeNullPassword == null);
		Judges myJudgeBadUsername = service.authenticate("nsaid", "test", null);
		assertTrue(myJudgeBadUsername == null);
		}
		catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
		finally{
	 
		jm.deleteByPrimaryKey(judge.getId());
		log.debug("Judge: " + judge.getFirstName() + ' ' + p.getLastName() +
				" has been deleted successfully.");
		}
		
    }
  @Test
	public void testChangeClubOrder() {
	  ClubNamesMapper c = (ClubNamesMapper) bf.getBean(ClubNamesMapper.class);
		GreetingServiceImpl service = new GreetingServiceImpl();
		List<ClubNames> order = service.getClubOrderList();
		ClubNames firstClub = order.get(0);
		String clubName = firstClub.getClubName();
		for (ClubNames i: order){
			log.debug("club : " +  i);
			}
		//TODO move club down
		List<ClubNames> clubReturn = service.changeClubOrder(clubName, false);
		for (ClubNames i: clubReturn){
			log.debug("club : " +  i);
			}
		assertTrue (!clubReturn.get(0).getClubName().equals(clubName));
		assertTrue (clubReturn.get(1).getClubName().equals(clubName));
		
		
		//TODO check that it moved the club up to start position
		clubReturn = service.changeClubOrder(clubName, true);
		for (ClubNames i: clubReturn){
			log.debug("club : " +  i);
			}
		assertTrue (clubReturn.get(0).getClubName().equals(clubName));
		assertTrue (!clubReturn.get(1).getClubName().equals(clubName));
		
  }
  
  
}
