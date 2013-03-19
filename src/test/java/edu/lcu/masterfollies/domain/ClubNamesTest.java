package edu.lcu.masterfollies.domain;
import java.util.List;

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
public class ClubNamesTest implements BeanFactoryAware {
	
	private static Log log = LogFactory.getLog(ClubNamesTest.class);
	BeanFactory bf = null;
    
	//@Override
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
		log.debug("Club Name to be added= " + cn.getClubName());
		c.insertSelective(cn);
		log.debug("Club Name that was inserted= " + cn.getClubName());
		ClubNames p= c.selectByPrimaryKey(cn.getId());
		log.debug(p.getClubName());
		//assertTrue(p.equals(judge));
		c.deleteByPrimaryKey(cn.getId());
		log.debug("Club: " + cn.getClubName() +	" has been deleted successfully.");
	}
	@Test
	public void testSelectClubNamesByCurrentClubOrder(){
		ClubNamesMapper c = (ClubNamesMapper) bf.getBean(ClubNamesMapper.class);
		List<ClubNames> x = c.selectClubNamesByCurrentClubOrder();
		for (ClubNames i: x){
		log.debug("club : " +  i);
		}
		ClubNames c1 = x.get(0);
		ClubNames c2 = x.get(1);
		
		log.debug("C1 is: " + c1.getClubOrder());
		int orderOfC1 = c1.getClubOrder();
		
		c1.setClubOrder(c2.getClubOrder());
		c2.setClubOrder(orderOfC1);
		
		//use myBatis to update by primary key
		c.updateByPrimaryKeySelective(c1);
		c.updateByPrimaryKeySelective(c2);
		
		List<ClubNames> y = c.selectClubNamesByCurrentClubOrder();
		for (ClubNames i: y){
		log.debug("club : " +  i);
		}	
	
	}
}
	