package edu.lcu.masterfollies.domain;
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
public class QuestionsTest implements BeanFactoryAware {
	
	private static Log log = LogFactory.getLog(QuestionsTest.class);
	BeanFactory bf = null;
    
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		bf = beanFactory;
	}
	@Test
	public void testselectByPrimaryKey(){
		ClubNamesMapper c = (ClubNamesMapper) bf.getBean(ClubNamesMapper.class);
		ClubNames ret = c.selectByPrimaryKey(1);
		System.out.println("Club Name for id " + ret.getId() + "=" + ret.getClubName());
	}
	//will always pass.
	@Test
	public void testClubNameAddInsertandRemove(){
		ClubNamesMapper c = (ClubNamesMapper) bf.getBean(ClubNamesMapper.class);		//Judges judges = new Judges("Neil","Saiid","nsaiid","test");
		ClubNames cn = new ClubNames();
		cn.setClubName("CD's");
		System.out.println("Club Name to be added= " + cn.getClubName());
		c.insertSelective(cn);
		System.out.println("Club Name that was inserted= " + cn.getClubName());
		ClubNames p= c.selectByPrimaryKey(cn.getId());
		System.out.println(p.getClubName());
		//assertTrue(p.equals(judge));
		c.deleteByPrimaryKey(cn.getId());
		System.out.println("Club: " + cn.getClubName() +	" has been deleted successfully.");
	}
}
	