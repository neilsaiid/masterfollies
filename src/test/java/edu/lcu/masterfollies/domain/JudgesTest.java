package edu.lcu.masterfollies.domain;

import static org.junit.Assert.assertTrue;

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
public class JudgesTest implements BeanFactoryAware {
	
	private static Log log = LogFactory.getLog(JudgesTest.class);
	BeanFactory bf = null;
    
	//@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		bf = beanFactory;
	}
	@Test
	public void testMarkerMethod(){
		
	}
	@Test
	public void testGetJudges(){
		
	}
	@Test
	public void testJudgeFind(){
		JudgesMapper j = (JudgesMapper) bf.getBean(JudgesMapper.class);
		Judges ret = j.selectByPrimaryKey(1);
		System.out.println("lastname= " + ret.getLastName());
	}
	//will always pass.
	@Test
	public void testJudgeAdd(){
		JudgesMapper j = (JudgesMapper) bf.getBean(JudgesMapper.class);
		//Judges judges = new Judges("Neil","Saiid","nsaiid","test");
		Judges judge = new Judges();
		judge.setFirstName("neil");
		judge.setLastName("Saiid");
		judge.setUserName("nsaiid");
		judge.setPassword("test");
		//judge.setIsSuper(true);
		System.out.println("id= " + judge.getId());
		j.insertSelective(judge);
		System.out.println("id= " + judge.getId());
		Judges p= j.selectByPrimaryKey(judge.getId());
		System.out.println(p.getFirstName() + ' ' + p.getLastName());
		//assertTrue(p.equals(judge));
		j.deleteByPrimaryKey(judge.getId());
		System.out.println("Judge: " + judge.getFirstName() + ' ' + p.getLastName() +
				" has been deleted successfully.");
	}
	
//	  public void testInsertPresent() {  
//	    	PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//	    	Course course = new Course("2005", "FALL", "01", "BIB1310", "LEC", "06");
//	    	int x = p.insertPresent(course);
//	    	System.err.println("insert present count x = " + x);

//	 @Test    
//	    public void testFindPerson() {  
//	    	
//			PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//			People ret = p.getPeople("000244930");
//
//	        //People ret = People.find("P000244930");
//	        System.err.println("ret = " + ret);
//	                 
//	    }
//	    
//	    //where ACADEMIC_YEAR = '2011' and ACADEMIC_TERM = 'FALL' and EVENT_ID = 'PHY1103' and EVENT_SUB_TYPE = 'LAB' and SECTION = '0B' " 
//	    @Test    
//	    public void testFindSectionPeople() {  
//	    	
//			PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//			List<People> ret = p.getSectionPeople("2011", "FALL", "01", "PHY1103", "LAB", "0B");
//
//	        System.err.println("ret = " + ret);
//	                 
//	    }
//	    
//	    @Test    
//	    public void testFindSectionPeopleByCourse() {  
//	    	
//			PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//			//Course course = new Course("2011", "FALL", "01", "PHY1103", "LAB", "0B");
//			Course course = new Course("2005", "FALL", "01", "BIB1310", "LEC", "06");
//			Date date = new Date();
//			Calendar cal = new GregorianCalendar();
//			cal.set(Calendar.YEAR, 2005);
//			cal.set(Calendar.MONTH, 8);
//			cal.set(Calendar.DATE, 16);
//			course.setDate(cal.getTime());
//			//List<People> ret = p.getSectionPeopleByCourse(course);
//			List<People> ret = p.getSectionPeopleAttendanceByCourse(course, false, false, new RowBounds(1,10));
//			
//
//	        System.err.println("ret Courses = " + ret);
//	                 
//	     }
//	    
//	    @Test    
//	    public void testFindSectionPeopleByCourseAth() {  
//	    	
//			PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//			//Course course = new Course("2011", "FALL", "01", "PHY1103", "LAB", "0B");
//			Course course = new Course("2005", "FALL", "01", "BIB1310", "LEC", "06");
//			Date date = new Date();
//			Calendar cal = new GregorianCalendar();
//			cal.set(Calendar.YEAR, 2005);
//			cal.set(Calendar.MONTH, 8);
//			cal.set(Calendar.DATE, 16);
//			course.setDate(cal.getTime());
//			//List<People> ret = p.getSectionPeopleByCourse(course);
//			List<People> ret = p.getSectionPeopleAttendanceByCourse(course, false, true, new RowBounds(1,10));
//			
//			int count = p.getSectionPeopleAttendanceByCourseCount(course, false, true);
//			
//
//	        System.err.println("ret Courses = " + ret);
//	        System.err.println("ret count = " + count);
//
//	                 
//	     }
//	    
//	    
//	    @Test    
//	    public void testGetHistory() {  
//	    	PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//	    	Course course = new Course("2005", "FALL", "01", "BIB1310", "LEC", "06");
//	    	Map<String, AttendanceSummary> x = p.getAttendanceHistory(course);
//	    	System.err.println("history map x = " + x);
//	    	
//	    }
//	    
//	    @Test    
//	    public void testInsertPresent() {  
//	    	PeopleMapper p = (PeopleMapper) bf.getBean("peopleMapper");
//	    	Course course = new Course("2005", "FALL", "01", "BIB1310", "LEC", "06");
//	    	int x = p.insertPresent(course);
//	    	System.err.println("insert present count x = " + x);
//	    	
//	    }
}
