package edu.lcu.masterfollies.domain;
import java.util.List;
import java.util.Map;

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




@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml", 
"classpath:/META-INF/spring/applicationContext-datasource-test.xml"})
public class ResultsTest implements BeanFactoryAware {
	
	private static Log log = LogFactory.getLog(ResultsTest.class);
	BeanFactory bf = null;
    
	//@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		bf = beanFactory;
	}
	//will always pass.
//	@Test
//	public void testResultsLoadandDelete(){
//		ResultsMapper rm = (ResultsMapper) bf.getBean(ResultsMapper.class);
//		JudgesMapper jm = (JudgesMapper) bf.getBean(JudgesMapper.class);//Judges judges = new Judges("Neil","Saiid","nsaiid","test");
//		Results rt = new Results();
//		//make a new data to be added to the table
//		rt.setJudgeId(1);
//		rt.setClubId(1);
//		rt.setQuestionId(1);
//		rt.setPoints(10);
//		rt.setRank(1);
//		rt.setNotes("This is a test input");
//		//insert the new data created into the table and print out a log report to show
//		//the changes applied to the table
//		rm.insertSelective(rt);
//		log.debug("Judge ID used: "+ rt.getJudgeId());
//		log.debug("Club Id used: " + rt.getClubId());
//		log.debug("Question ID used: " + rt.getQuestionId());
//		log.debug("Points given: " + rt.getPoints());
//		log.debug("Rank given: " + rt.getRank());
//		log.debug("Notes given: " + rt.getNotes());
//		//choose the line that was just entered and print out a report showing the club
//		//name that corresponds to that Judge, Club and Question ID
//		Judges j= jm.selectByPrimaryKey(rt.getJudgeId());
//		Results r= rm.selectByPrimaryKey(rt.getId());
//		log.debug("Judge Name: " + j.getFirstName() + ' ' + j.getLastName());
//		log.debug("Club Name: " + r.getClubId());
//		log.debug("Question: " + r.getQuestionId());
//		
//		//assertTrue(p.equals(judge));
//		rm.deleteByPrimaryKey(r.getId());
//		log.debug("This test has been deleted successfully.");
//	}
	@Test
	public void testSelectByJudgeId(){
		ResultsMapper rm = (ResultsMapper) bf.getBean(ResultsMapper.class);
//		Results r = new Results();
//		//call the Batch insert
//		r.setJudgeId(1);
//		r.setClubId(1);
	
		ResultsExample re = new ResultsExample();
		re.createCriteria().andClubIdEqualTo(1).andJudgeIdEqualTo(1);
		rm.deleteByExample(re);
		//rm.insertbatchResultsInsert(1, 1);
		
		List<Map<String, Object>> results = rm.selectResultsByJudge(1, 1);
		log.debug("resutl map=" + results);
		
		rm.deleteByExample(re);
	}
	@Test
	public void testupdateResults(){
		Integer value = 5;
		ResultsMapper rm = (ResultsMapper) bf.getBean(ResultsMapper.class);
		JudgesMapper jm = (JudgesMapper) bf.getBean(JudgesMapper.class);//Judges judges = new Judges("Neil","Saiid","nsaiid","test");
		Results rt = new Results();
		//make a new data to be added to the table
		rt.setJudgeId(1);
		rt.setClubId(1);
		rt.setQuestionId(1);
		rt.setPoints(0);
		//rt.setRank(1);
		rt.setNotes("This is a test input");
		//insert the new data created into the table and print out a log report to show
		//the changes applied to the table
		rm.insertSelective(rt);
		log.debug("Judge ID used: "+ rt.getJudgeId());
		log.debug("Club Id used: " + rt.getClubId());
		log.debug("Question ID used: " + rt.getQuestionId());
		log.debug("Points given: " + rt.getPoints());
	//	log.debug("Rank given: " + rt.getRank());
		log.debug("Notes given: " + rt.getNotes());
		//choose the line that was just entered and print out a report showing the club
		//name that corresponds to that Judge, Club and Question ID
		Judges j= jm.selectByPrimaryKey(rt.getJudgeId());
		Results r= rm.selectByPrimaryKey(rt.getId());
		log.debug("Judge Name: " + j.getFirstName() + ' ' + j.getLastName());
		log.debug("Club Name: " + r.getClubId());
		log.debug("Question: " + r.getQuestionId());
		

		rt.setPoints(value);
		log.debug("New Points value is: " + rt.getPoints());
		
		rm.updateByPrimaryKeySelective(rt);
		Results db = rm.selectByPrimaryKey(rt.getId());
		assert (db.getPoints() == 5);
		
		//assertTrue(p.equals(judge));
		rm.deleteByPrimaryKey(r.getId());
		log.debug("This test has been deleted successfully.");
	}
}
	







